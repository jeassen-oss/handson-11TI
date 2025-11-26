package latihan5_dip.good;

// Concrete implementation of FraudDetector
// Bisa diganti rule lain tanpa ubah PaymentService
public class RuleBasedFraudDetector implements FraudDetector {

    @Override
    public boolean checkFraud(String cardNumber, double amount) {
        System.out.println("[RuleBasedFraudDetector] Checking fraud with rules for amount: " + amount);

        // Rule 1: Flag if amount > 1,000,000
        if (amount > 1000000.0) {
            System.out.println("[RuleBasedFraudDetector] FRAUD DETECTED ✗ - Amount too high!");
            return true;
        }

        System.out.println("[RuleBasedFraudDetector] No fraud detected ✓");
        return false;
    }
}
