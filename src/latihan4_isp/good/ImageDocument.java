package latihan4_isp.good;

// ImageDocument hanya implement Readable + Resizable
// TIDAK ada UnsupportedOperationException — sesuai ISP
public class ImageDocument implements Readable, Resizable {

    // Menyimpan nama file Image
    private String filename;

    // Constructor untuk inisialisasi nama file
    public ImageDocument(String filename) {
        this.filename = filename;
    }

    // Implementasi kemampuan READ (menampilkan gambar)
    @Override
    public void read() {
        System.out.println("[ImageDocument] Reading Image: " + filename);
    }

    // Implementasi kemampuan RESIZE (khusus image)
    @Override
    public void resize(int width, int height) {
        System.out.println("[ImageDocument] Resizing Image: " + filename + " to " + width + "x" + height);
    }
}
