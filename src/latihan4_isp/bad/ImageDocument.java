package latihan4_isp.bad;

/*
 * ImageDocument hanya butuh:
 * - read()
 * - resize()
 *
 * Tapi interface memaksa implement:
 * - edit()
 * - print()
 * - calculate()
 *
 * Ini menghasilkan class yang penuh method yang sama sekali tidak relevan
 * dan semuanya hanya melempar exception.
 *
 * Ini contoh extrem dari ISP violation.
 */
public class ImageDocument implements Document {
    private String filename;

    public ImageDocument(String filename) {
        this.filename = filename;
    }

    @Override
    public void read() {
        System.out.println("[IMAGE] Reading image: " + filename);
    }

    @Override
    public void resize(int width, int height) {
        System.out.println("[IMAGE] Resizing image: " + filename +
                " to " + width + "x" + height);
    }

    @Override
    public void edit(String content) {
        // Image tidak bisa di-edit dengan text
        throw new UnsupportedOperationException("Image documents cannot be edited with text");
    }

    @Override
    public void print() {
        // Image bukan dokumen yang bisa diprint melalui system yang sama
        throw new UnsupportedOperationException("Image documents cannot be printed");
    }

    @Override
    public void calculate(String formula) {
        // Image tidak bisa melakukan perhitungan
        throw new UnsupportedOperationException("Image documents cannot calculate");
    }
}
