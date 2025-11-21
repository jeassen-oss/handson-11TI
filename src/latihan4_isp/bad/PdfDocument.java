package latihan4_isp.bad;

/*
 * PdfDocument hanya butuh:
 * - read()
 * - print()
 *
 * Tapi karena menggunakan FAT INTERFACE Document,
 * class ini TERPAKSA implement:
 * - edit()
 * - calculate()
 * - resize()
 *
 * Semua method itu TIDAK RELEVAN untuk PDF → terpaksa THROW EXCEPTION.
 *
 * Inilah contoh kuat ISP violation.
 */
public class PdfDocument implements Document {
    private String filename;

    public PdfDocument(String filename) {
        this.filename = filename;
    }

    @Override
    public void read() {
        System.out.println("[PDF] Reading document: " + filename);
    }

    @Override
    public void print() {
        System.out.println("[PDF] Printing document: " + filename);
    }

    @Override
    public void edit(String content) {
        // PDF tidak bisa di-edit, tapi dipaksa implement
        throw new UnsupportedOperationException("PDF documents cannot be edited");
    }

    @Override
    public void calculate(String formula) {
        // PDF tidak punya fitur calculation
        throw new UnsupportedOperationException("PDF documents cannot calculate");
    }

    @Override
    public void resize(int width, int height) {
        // PDF tidak bisa diresize, tapi interface memaksa implement
        throw new UnsupportedOperationException("PDF documents cannot be resized");
    }
}
