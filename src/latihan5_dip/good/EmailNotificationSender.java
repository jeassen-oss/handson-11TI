package latihan5_dip.good;

// Concrete implementation of NotificationSender
// Bisa diganti SMS / WhatsApp / Push
public class EmailNotificationSender implements NotificationSender {

    @Override
    public void sendNotification(String recipient, String message) {
        System.out.println("[EmailNotificationSender] Sending email to: " + recipient);
        System.out.println("[EmailNotificationSender] Message: " + message);

        // Real use-case using SendGrid / Mailgun / SES
    }
}
