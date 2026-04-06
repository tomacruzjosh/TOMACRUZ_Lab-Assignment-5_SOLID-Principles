public class OrderTest {
    public static void main(String[] args) {
        Order order = new Order(10.0, 2, "John Doe", "123 Main St", "johndoe@example.com");

        // Set up dependencies
        OrderCalculator calculator = new StandardOrderCalculator();
        OrderRepository repository = new DatabaseOrderRepository();
        InvoiceGenerator pdfGenerator = new PdfInvoiceGenerator();
        NotificationService emailNotifier = new EmailNotificationService();

        // 1. Process a full online order (Needs everything)
        System.out.println("--- Online Order ---");
        OrderProcessor onlineProcessor = new OrderProcessor(calculator, repository, pdfGenerator, emailNotifier);
        onlineProcessor.processOrder(order, "order_123.pdf");

        // 2. Process an in-store order (No email, no digital invoice needed)
        System.out.println("\n--- In-Store Order ---");
        OrderProcessor inStoreProcessor = new OrderProcessor(calculator, repository, null, null);
        inStoreProcessor.processOrder(order, null);
    }
}
