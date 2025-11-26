package latihan5_dip.bad;

// Concrete class (low-level module)
// High-level module tightly coupled dengan class ini
public class TransactionLogger {

    // Logging transaksi
    public void log(String transactionId, double amount, String status) {
        System.out.println("[TransactionLogger] Logging transaction: " + transactionId +
                ", Amount: " + amount + ", Status: " + status);
    }
}
