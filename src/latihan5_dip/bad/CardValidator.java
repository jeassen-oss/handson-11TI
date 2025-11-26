package latihan5_dip.bad;

// Concrete class (low-level module)
// High-level module tightly coupled dengan class ini
public class CardValidator {

    // Validasi kartu kredit sederhana
    public boolean validate(String cardNumber) {
        System.out.println("[CardValidator] Validating card: " + cardNumber);

        // Validasi sederhana: cek null dan panjang 16 digit
        if (cardNumber == null || cardNumber.replace("-", "").length() != 16) {
            System.out.println("[CardValidator] Card is invalid");
            return false;
        }

        System.out.println("[CardValidator] Card is valid");
        return true;
    }
}
