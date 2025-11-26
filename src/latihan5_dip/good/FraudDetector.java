package latihan5_dip.good;

// ABSTRACTION (Interface)
// High-level module depend on interface, bukan concrete class
public interface FraudDetector {

    /*
     * Check for fraudulent transaction
     * Implementasi bisa bermacam-macam:
     * - Rule-based fraud detection
     * - Machine learning fraud detection
     * - Third-party fraud detection service
     * - Mock detector for testing
     *
     * @param cardNumber - Card number
     * @param amount - Transaction amount
     * @return true if fraud detected, false otherwise
     */
    boolean checkFraud(String cardNumber, double amount);
}
