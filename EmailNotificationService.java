public class EmailNotificationService implements NotificationService {
    @Override
    public void sendNotification(Order order) {
        System.out.println("Email notification sent to: " + order.getEmail());
    }
}
