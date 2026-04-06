public class PdfInvoiceGenerator implements InvoiceGenerator {
    @Override
    public void generateInvoice(Order order, String fileName) {
        System.out.println("PDF Invoice generated: " + fileName + " for " + order.getCustomerName());
    }
}
