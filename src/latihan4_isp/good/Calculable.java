package latihan4_isp.good;

// Interface khusus untuk kemampuan perhitungan
// Hanya Spreadsheet yang membutuhkan ini
public interface Calculable {

    // Method untuk melakukan kalkulasi formula
    // Contoh formula: "SUM(A1:A10)"
    // Tidak relevan untuk PDF, Word, atau Image
    void calculate(String formula);
}
