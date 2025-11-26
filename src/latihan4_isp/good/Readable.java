package latihan4_isp.good;

// Interface kecil dan fokus hanya untuk kemampuan READ
// Sesuai ISP, interface jangan terlalu besar
public interface Readable {

    // Method untuk membaca dokumen
    // Semua jenis dokumen wajib bisa dibaca
    void read();
}
