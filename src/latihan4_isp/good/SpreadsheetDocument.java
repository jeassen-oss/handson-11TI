package latihan4_isp.good;

// SpreadsheetDocument adalah dokumen dengan fitur lengkap
// Implement 4 capability: Readable, Editable, Printable, Calculable
// TIDAK implement Resizable karena tidak relevan — sesuai ISP
public class SpreadsheetDocument implements Readable, Editable, Printable, Calculable {

    // Menyimpan nama file Spreadsheet
    private String filename;

    // Constructor untuk menginisialisasi nama file
    public SpreadsheetDocument(String filename) {
        this.filename = filename;
    }

    // Implementasi kemampuan READ
    // Semua dokumen harus bisa dibaca
    @Override
    public void read() {
        System.out.println("[SpreadsheetDocument] Reading Spreadsheet: " + filename);
    }

    // Implementasi kemampuan EDIT
    // Spreadsheet bisa mengubah isi sel
    @Override
    public void edit(String content) {
        System.out.println("[SpreadsheetDocument] Editing Spreadsheet: " + filename + " with content: " + content);
    }

    // Implementasi kemampuan PRINT
    // Spreadsheet bisa dicetak seperti Word dan PDF
    @Override
    public void print() {
        System.out.println("[SpreadsheetDocument] Printing Spreadsheet: " + filename);
    }

    // Implementasi kemampuan CALCULATE
    // Fitur unik Spreadsheet — dokumen lain tidak punya
    @Override
    public void calculate(String formula) {
        System.out.println("[SpreadsheetDocument] Calculating formula: " + formula + " = 5500");
    }
}
