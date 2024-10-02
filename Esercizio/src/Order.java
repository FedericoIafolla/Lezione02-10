import java.time.LocalDate;
import java.util.List;

public class Order {
    private Long id;
    private String status;
    private LocalDate orderDate;
    private LocalDate deliveryDate;
    private List<Product> products;
    private Customer customer;

    // Costruttore
    public Order(Long id, String status, LocalDate orderDate, LocalDate deliveryDate, List<Product> products, Customer customer) {
        this.id = id;
        this.status = status;
        this.orderDate = orderDate;
        this.deliveryDate = deliveryDate;
        this.products = products;
        this.customer = customer;
    }

    // Getters
    public Long getId() { return id; }
    public String getStatus() { return status; }
    public LocalDate getOrderDate() { return orderDate; }
    public LocalDate getDeliveryDate() { return deliveryDate; }
    public List<Product> getProducts() { return products; }
    public Customer getCustomer() { return customer; }

    @Override
    public String toString() {
        return String.format("Ordine ID: %d, Stato: %s, Data Ordine: %s, Cliente: %s", id, status, orderDate, customer.getName());
    }
}
