package latihan5_dip.bad;

// Concrete class (low-level module)
// High-level module tightly coupled dengan class ini
public class FraudDetector {

    // Cek fraud sederhana
    public boolean checkFraud(String cardNumber, double amount) {
        System.out.println("[FraudDetector] Checking fraud for amount: " + amount);

        // Rule: flag jika amount > 1.000.000
        if (amount > 1000000.0) {
            System.out.println("[FraudDetector] FRAUD DETECTED - Amount too high!");
            return true;
        }

        System.out.println("[FraudDetector] No fraud detected");
        return false;
    }
}
