package latihan4_isp.good;

// PdfDocument hanya implement interface yang dibutuhkan
// Readable + Printable — sesuai prinsip ISP
public class PdfDocument implements Readable, Printable {

    // Menyimpan nama file PDF
    private String filename;

    // Constructor untuk inisialisasi nama file
    public PdfDocument(String filename) {
        this.filename = filename;
    }

    // Implementasi kemampuan READ
    @Override
    public void read() {
        System.out.println("[PdfDocument] Reading PDF: " + filename);
    }

    // Implementasi kemampuan PRINT
    @Override
    public void print() {
        System.out.println("[PdfDocument] Printing PDF: " + filename);
    }
}
