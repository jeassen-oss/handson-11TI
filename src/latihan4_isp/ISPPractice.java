package latihan4_isp;

// import latihan4_isp.good.*; // Uncomment setelah refactoring selesai

public class ISPPractice {
    public static void main(String[] args) {
        /*
         * LATIHAN 4: INTERFACE SEGREGATION PRINCIPLE (ISP)
         *
         * Definisi:
         * "A client should not be forced to depend on methods it does not use."
         *
         * Makna sederhana:
         * Jangan buat 1 interface gede (FAT interface) yang isinya 10 fitur berbeda.
         * Karena setiap class yang pakai interface itu akan DIPAKSA implement
         * method-method yang tidak relevan untuknya → ini melanggar ISP.
         *
         * Kasus Studi:
         * Document Management System
         * Ada 4 jenis dokumen:
         * 1. PDF         → read, print
         * 2. Word        → read, edit, print
         * 3. Spreadsheet → read, edit, print, calculate
         * 4. Image       → read, resize
         *
         * Tujuan latihan:
         * 1. Melihat masalah FAT INTERFACE (BAD)
         * 2. Melihat efek buruk ketika class dipaksa implement method tidak relevan
         * 3. Melakukan refactor menjadi interface kecil berbasis capability (GOOD)
         * 4. Merasakan manfaat ISP setelah refactoring
         */


        // =====================================================================
        // ==========  PART 1: BAD PRACTICE - Melanggar ISP  ====================
        // =====================================================================

        System.out.println("=== BAD PRACTICE: Melanggar ISP ===\n");

        /*
         * Pada versi BAD, semua dokumen menggunakan 1 interface besar:
         *
         * interface Document {
         *     read();
         *     edit();
         *     print();
         *     calculate();
         *     resize();
         * }
         *
         * → PDF dipaksa punya edit(), calculate(), resize()
         * → Image dipaksa punya edit(), print(), calculate()
         *
         * Semuanya harus diimplementasikan, dan akhirnya hanya melempar
         * UnsupportedOperationException.
         *
         * Ini contoh nyata pelanggaran ISP.
         */

        System.out.println("--- Testing PDF Document ---");

        // Object PDF mengikuti interface Document yang GEMUK (Bad)
        latihan4_isp.bad.Document pdf =
                new latihan4_isp.bad.PdfDocument("Contract.pdf");

        pdf.read();  // PDF memang bisa dibaca → OK
        pdf.print(); // PDF memang bisa diprint → OK

        System.out.println("\nTrying to edit PDF (not supported):");
        try {
            pdf.edit("New content"); // PDF tidak punya fungsi edit
        } catch (UnsupportedOperationException e) {
            // Karena PDF tidak bisa edit, maka BAD implementation melempar Exception
            System.out.println("ERROR: " + e.getMessage());
        }


        System.out.println("\n--- Testing Image Document ---");

        latihan4_isp.bad.Document image =
                new latihan4_isp.bad.ImageDocument("Photo.jpg");

        image.read(); // Image bisa dibaca → OK

        System.out.println("\nTrying to print image (not supported):");
        try {
            image.print(); // Image tidak bisa print
        } catch (UnsupportedOperationException e) {
            System.out.println("ERROR: " + e.getMessage());
        }


        // ==================== ANALISIS PROBLEM ======================
        System.out.println("\n--- Analisis Masalah ---");
        System.out.println("Document interface terlalu BESAR (FAT INTERFACE):");
        System.out.println("1. read()      → semua dokumen butuh ✓");
        System.out.println("2. edit()      → hanya Word & Spreadsheet butuh ✗");
        System.out.println("3. print()     → PDF, Word, Spreadsheet (Image tidak) ✗");
        System.out.println("4. calculate() → hanya Spreadsheet butuh ✗");
        System.out.println("5. resize()    → hanya Image butuh ✗");
        System.out.println("\nPDF & Image dipaksa implement method yang tidak digunakan!");
        System.out.println("Banyak method yang hanya throw UnsupportedOperationException!");
        System.out.println("Interface tidak fleksibel = MELANGGAR ISP!");

        System.out.println("\n" + "=".repeat(70));


        // =====================================================================
        // ==========  PART 2: GOOD PRACTICE - Mengikuti ISP  ==================
        // =====================================================================

        System.out.println("\n=== GOOD PRACTICE: Mengikuti ISP ===\n");

        /*
         * Di versi GOOD, interface dipecah berdasarkan CAPABILITY:
         *
         * - Readable   → hanya fitur read()
         * - Editable   → hanya fitur edit()
         * - Printable  → hanya fitur print()
         * - Calculable → hanya fitur calculate()
         * - Resizable  → hanya fitur resize()
         *
         * Setiap class dokumen cukup implement interface yang memang ia butuhkan.
         *
         * Misal:
         * - PDF: Readable + Printable
         * - Word: Readable + Editable + Printable
         * - Spreadsheet: Readable + Editable + Printable + Calculable
         * - Image: Readable + Resizable
         *
         * Hasilnya:
         * ✓ Tidak ada method yang throw UnsupportedOperationException
         * ✓ Lebih aman, lebih rapi, lebih extensible
         * ✓ Jika membuat dokumen baru, tinggal pilih capability mana yang cocok
         */

        // ========== INSTRUKSI ==========
        // Setelah kamu buat semua file di folder good/,
        // tinggal uncomment code di bawah agar bisa dijalankan.


        /*
        // ===================== PDF TEST =====================
        System.out.println("--- Testing PDF Document ---");
        PdfDocument goodPdf = new PdfDocument("Contract.pdf");
        goodPdf.read();
        goodPdf.print();
        // goodPdf.edit();  // COMPILE ERROR → bagus, PDF memang tidak punya edit()


        // ===================== WORD TEST =====================
        System.out.println("\n--- Testing Word Document ---");
        WordDocument word = new WordDocument("Report.docx");
        word.read();
        word.edit("Updated content for report");
        word.print();


        // =================== SPREADSHEET TEST ==================
        System.out.println("\n--- Testing Spreadsheet Document ---");
        SpreadsheetDocument spreadsheet = new SpreadsheetDocument("Budget.xlsx");
        spreadsheet.read();
        spreadsheet.edit("A1: 1000");
        spreadsheet.calculate("SUM(A1:A10)");
        spreadsheet.print();


        // ===================== IMAGE TEST =====================
        System.out.println("\n--- Testing Image Document ---");
        ImageDocument goodImage = new ImageDocument("Photo.jpg");
        goodImage.read();
        goodImage.resize(800, 600);


        // =================== POLYMORPHIC USAGE ==================
        System.out.println("\n--- Polymorphic Usage ---");

        // Polymorphism berdasarkan capability Readable
        Readable readable1 = new PdfDocument("Doc1.pdf");
        Readable readable2 = new ImageDocument("Image1.jpg");
        readable1.read();
        readable2.read();


        // Daftar dokumen yang bisa diprint
        List<Printable> printableDocuments = new ArrayList<>();
        printableDocuments.add(new PdfDocument("Doc.pdf"));
        printableDocuments.add(new WordDocument("Report.docx"));
        printableDocuments.add(new SpreadsheetDocument("Data.xlsx"));
        // printableDocuments.add(new ImageDocument("Photo.jpg")); // COMPILE ERROR → bagus

        System.out.println("\nPrinting all printable documents:");
        for (Printable doc : printableDocuments) {
            doc.print();
        }


        // ===================== BENEFITS =====================
        System.out.println("\n--- Keuntungan Setelah Refactoring ---");
        System.out.println("✓ Focused - Tiap interface punya tanggung jawab kecil & jelas");
        System.out.println("✓ Flexible - Class hanya implement method yang benar-benar ia butuhkan");
        System.out.println("✓ Type-safe - Kesalahan terdeteksi saat compile, bukan runtime");
        System.out.println("✓ Clean - Tidak ada UnsupportedOperationException");
        System.out.println("✓ Extensible - Mudah menambah jenis dokumen baru");
        */
    }
}
