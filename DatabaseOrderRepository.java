public class DatabaseOrderRepository implements OrderRepository {
    @Override
    public void save(Order order) {
        System.out.println("Order placed for " + order.getCustomerName() + " at " + order.getAddress());
    }
}
