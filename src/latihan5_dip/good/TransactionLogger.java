package latihan5_dip.good;

// ABSTRACTION (Interface)
// Logging bisa diganti tanpa ubah PaymentService
public interface TransactionLogger {

    /*
     * Log transaction
     * Implementasi bisa bermacam-macam:
     * - Database logger
     * - File logger
     * - Cloud logger (AWS CloudWatch, Google Cloud Logging)
     * - Mock logger for testing
     *
     * @param transactionId - Transaction ID
     * @param amount - Transaction amount
     * @param status - Transaction status (SUCCESS/FAILED)
     */
    void log(String transactionId, double amount, String status);
}
