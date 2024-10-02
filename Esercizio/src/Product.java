public class Product {
    private Long id;
    private String name;
    private String category;
    private Double price;

    // Costruttore
    public Product(Long id, String name, String category, Double price) {
        this.id = id;
        this.name = name;
        this.category = category;
        this.price = price;
    }

    // Getters
    public Long getId() { return id; }
    public String getName() { return name; }
    public String getCategory() { return category; }
    public Double getPrice() { return price; }

    // Setters
    public void setPrice(Double price) { this.price = price; }

    @Override
    public String toString() {
        return String.format("Prodotto: %s (Categoria: %s, Prezzo: %.2f)", name, category, price);
    }
}
