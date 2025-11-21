package latihan4_isp.bad;

/*
 * FAT INTERFACE = Interface yang terlalu besar
 *
 * Interface ini adalah contoh klasik pelanggaran ISP, karena:
 * - Semua document type dipaksa memiliki semua kemampuan
 * - Padahal tidak semua jenis dokumen butuh semua method
 *
 * ISP (Interface Segregation Principle):
 * "Client tidak boleh dipaksa bergantung pada method yang tidak digunakannya."
 *
 * Jadi interface ini salah karena menggabungkan 5 capability berbeda
 * menjadi satu interface raksasa.
 */
public interface Document {

    // Capability 1: Reading
    // Semua dokumen memang butuh membaca → OK
    void read();

    // Capability 2: Editing
    // Hanya Word & Spreadsheet yang butuh edit → PDF & Image dipaksa implement
    void edit(String content);

    // Capability 3: Printing
    // PDF, Word, Spreadsheet bisa print
    // Image TIDAK bisa print → tapi tetap dipaksa implement
    void print();

    // Capability 4: Calculation
    // Hanya Spreadsheet yang punya fitur calculation → yang lain dipaksa implement
    void calculate(String formula);

    // Capability 5: Resize
    // Image butuh resize, tapi PDF/Word/Spreadsheet tidak bisa resize
    void resize(int width, int height);
}
