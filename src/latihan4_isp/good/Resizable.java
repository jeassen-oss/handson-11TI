package latihan4_isp.good;

// Interface khusus untuk kemampuan resize
// Hanya relevan untuk Image
public interface Resizable {

    // Method untuk mengubah ukuran gambar
    // @param width  = lebar baru
    // @param height = tinggi baru
    void resize(int width, int height);
}
