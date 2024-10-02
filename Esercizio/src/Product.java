import java.time.LocalDate;

public class Product {
    private Long id;
    private String name;
    private String category;
    private Double price;
    private LocalDate date; // Aggiunta della data

    // Costruttore con data
    public Product(Long id, String name, String category, Double price, LocalDate date) {
        this.id = id;
        this.name = name;
        this.category = category;
        this.price = price;
        this.date = date; // Assegna la data
    }

    // Getter e setter per la data
    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    // Altri getter e setter
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Product{id=" + id + ", name='" + name + "', category='" + category + "', price=" + price + ", date=" + date + "}";
    }
}
