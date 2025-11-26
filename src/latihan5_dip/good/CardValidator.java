package latihan5_dip.good;

// ABSTRACTION (Interface) - high-level module depend on this
// Tidak bergantung pada implementasi konkret
public interface CardValidator {

    /*
     * Validate credit card number
     * Implementasi bisa bermacam-macam:
     * - Luhn algorithm validation
     * - Mock validation (testing)
     * - Bank-specific validation
     *
     * @param cardNumber - Card number to validate
     * @return true if valid, false otherwise
     */
    boolean validate(String cardNumber);
}
