public class Customer {
    private Long id;
    private String name;
    private Integer tier;

    // Costruttore
    public Customer(Long id, String name, Integer tier) {
        this.id = id;
        this.name = name;
        this.tier = tier;
    }

    // Getters
    public Long getId() { return id; }
    public String getName() { return name; }
    public Integer getTier() { return tier; }

    @Override
    public String toString() {
        return String.format("Cliente: %s (Livello: %d)", name, tier);
    }
}
