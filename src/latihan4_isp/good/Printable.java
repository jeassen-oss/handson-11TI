package latihan4_isp.good;

// Interface untuk kemampuan PRINTING
// Hanya dokumen tertentu yang bisa dicetak
public interface Printable {

    // Method untuk mencetak dokumen
    // PDF, Word, Spreadsheet implement ini — Image tidak
    void print();
}
