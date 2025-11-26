package latihan5_dip.bad;

// Concrete class (low-level module)
// High-level module tightly coupled dengan class ini
public class NotificationSender {

    // Kirim notifikasi ke customer
    public void sendNotification(String recipient, String message) {
        System.out.println("[NotificationSender] Sending notification to: " + recipient);
        System.out.println("[NotificationSender] Subject: " + message);
    }
}
