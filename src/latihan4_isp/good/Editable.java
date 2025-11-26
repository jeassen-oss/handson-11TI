package latihan4_isp.good;

// Interface khusus untuk kemampuan EDIT
// Tidak semua dokumen bisa diedit — sesuai ISP
public interface Editable {

    // Method untuk mengubah isi dokumen
    // Hanya Word dan Spreadsheet yang mengimplementasikan ini
    // @param content = isi baru yang akan ditulis
    void edit(String content);
}
