public class Order {
    private double price;
    private int quantity;
    private String customerName;
    private String address;
    private String email;

    public Order(double price, int quantity, String customerName, String address, String email) {
        this.price = price;
        this.quantity = quantity;
        this.customerName = customerName;
        this.address = address;
        this.email = email;
    }

    public double getPrice() { return price; }
    public int getQuantity() { return quantity; }
    public String getCustomerName() { return customerName; }
    public String getAddress() { return address; }
    public String getEmail() { return email; }
}
