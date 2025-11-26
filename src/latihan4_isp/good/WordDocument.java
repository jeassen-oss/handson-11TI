package latihan4_isp.good;

// WordDocument implement 3 capability:
// Readable + Editable + Printable
// TIDAK mengimplementasikan capability yang tidak relevan
public class WordDocument implements Readable, Editable, Printable {

    // Menyimpan nama file Word
    private String filename;

    // Constructor untuk inisialisasi nama file
    public WordDocument(String filename) {
        this.filename = filename;
    }

    // Implementasi kemampuan READ
    @Override
    public void read() {
        System.out.println("[WordDocument] Reading Word: " + filename);
    }

    // Implementasi kemampuan EDIT
    // Hanya Word dan Spreadsheet punya fitur ini
    @Override
    public void edit(String content) {
        System.out.println("[WordDocument] Editing Word: " + filename + " with content: " + content);
    }

    // Implementasi kemampuan PRINT
    @Override
    public void print() {
        System.out.println("[WordDocument] Printing Word: " + filename);
    }
}
