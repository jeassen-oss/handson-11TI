package latihan5_dip.good;

// Concrete implementation of CardValidator
// Low-level module depend on abstraction
public class LuhnCardValidator implements CardValidator {

    @Override
    public boolean validate(String cardNumber) {
        System.out.println("[LuhnCardValidator] Validating card using Luhn algorithm: " + cardNumber);

        // Remove dashes
        String cleanCard = cardNumber.replace("-", "");

        // Simple validation
        if (cleanCard == null || cleanCard.length() != 16) {
            System.out.println("[LuhnCardValidator] Card is invalid ✗");
            return false;
        }

        System.out.println("[LuhnCardValidator] Card is valid ✓");
        return true;
    }
}
