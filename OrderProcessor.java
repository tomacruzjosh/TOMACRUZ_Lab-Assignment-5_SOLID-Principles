public class OrderProcessor {
    private final OrderCalculator calculator;
    private final OrderRepository repository;
    private final InvoiceGenerator invoiceGenerator;
    private final NotificationService notificationService;

    // Constructor Injection
    public OrderProcessor(OrderCalculator calculator, 
                          OrderRepository repository, 
                          InvoiceGenerator invoiceGenerator, 
                          NotificationService notificationService) {
        this.calculator = calculator;
        this.repository = repository;
        this.invoiceGenerator = invoiceGenerator;
        this.notificationService = notificationService;
    }

    public void processOrder(Order order, String invoiceFileName) {
        calculator.calculateTotal(order);
        repository.save(order);
        
        // We now have the flexibility to trigger these conditionally or omit them safely
        if (invoiceGenerator != null) {
            invoiceGenerator.generateInvoice(order, invoiceFileName);
        }
        
        if (notificationService != null) {
            notificationService.sendNotification(order);
        }
    }
}
