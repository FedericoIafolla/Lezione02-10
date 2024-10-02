import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        // Creazione dei prodotti con le date
        Product book1 = new Product(1L, "Il conte Draaaacula, minghia che pauuura", "Books", 120.0, LocalDate.of(2020, 12, 15));
        Product book2 = new Product(2L, "Pdor, figlio di Kmer", "Books", 105.0, LocalDate.of(2021, 1, 10));
        Product book3 = new Product(3L, "La Subaru Baracca", "Books", 50.0, LocalDate.of(2021, 2, 5));
        Product book4 = new Product(4L, "La Subaru Baracca 2: modello banana", "Baby", 80.0, LocalDate.of(2021, 2, 20));
        Product book5 = new Product(5L, "Il dottor Helmut Alzhaimer", "Books", 150.0, LocalDate.of(2021, 3, 15));
        Product book6 = new Product(6L, "Che fa'? Mi guarda con quegli occhi da cernia? Mi vuole cernire il codice segreto?", "Books", 90.0, LocalDate.of(2021, 2, 25));
        Product book7 = new Product(7L, "La battaglia di Magenta", "Boys", 110.0, LocalDate.of(2021, 3, 1));
        Product book8 = new Product(8L, "I Maratoneti", "Books", 75.0, LocalDate.of(2021, 3, 5));
        Product book9 = new Product(9L, "Sugar e le sue avventure poliziesche", "Boys", 95.0, LocalDate.of(2021, 2, 28));

        // Creazione dei clienti
        Customer customer1 = new Customer(1L, "Giacomino Poretti", 1);
        Customer customer2 = new Customer(2L, "Giovanni Storti", 2);
        Customer customer3 = new Customer(3L, "Aldo Baglio", 3);

        // Creazione degli ordini
        List<Order> orders = new ArrayList<>();
        orders.add(new Order(1L, "Completed", LocalDate.of(2021, 2, 15), LocalDate.of(2021, 2, 20), List.of(book1, book2), customer2));
        orders.add(new Order(2L, "Completed", LocalDate.of(2021, 3, 5), LocalDate.of(2021, 3, 10), List.of(book5, book6), customer1));
        orders.add(new Order(3L, "Completed", LocalDate.of(2021, 2, 25), LocalDate.of(2021, 3, 1), List.of(book3), customer3));
        orders.add(new Order(4L, "Completed", LocalDate.of(2021, 2, 20), LocalDate.of(2021, 2, 25), List.of(book4), customer2));
        orders.add(new Order(5L, "Completed", LocalDate.of(2021, 3, 10), LocalDate.of(2021, 3, 15), List.of(book7, book9), customer3));
        orders.add(new Order(6L, "Completed", LocalDate.of(2021, 3, 15), LocalDate.of(2021, 3, 20), List.of(book8), customer2));

        // Esercizio 1
        List<Product> booksOver100 = orders.stream()
                .flatMap(order -> order.getProducts().stream())
                .filter(product -> "Books".equals(product.getCategory()) && product.getPrice() > 100)
                .collect(Collectors.toList());
        System.out.println("Esercizio 1: Prodotti 'Books' > 100:");
        for (Product product : booksOver100) {
            System.out.printf(" - Prodotto: %s | Prezzo: %.2f | Data: %s%n",
                    product.getName(), product.getPrice(),
                    orders.stream()
                            .filter(order -> order.getProducts().contains(product))
                            .map(Order::getOrderDate)
                            .findFirst()
                            .orElse(null));
        }

        // Esercizio 2
        List<Order> babyOrders = orders.stream()
                .filter(order -> order.getProducts().stream()
                        .anyMatch(product -> "Baby".equals(product.getCategory())))
                .collect(Collectors.toList());
        System.out.println("\nEsercizio 2: Ordini con prodotti 'Baby':");
        for (Order order : babyOrders) {
            System.out.printf("Ordine ID: %d | Cliente: %s | Data ordine: %s%n",
                    order.getId(), order.getCustomer().getName(), order.getOrderDate());
            for (Product product : order.getProducts()) {
                System.out.printf(" - Prodotto: %s | Prezzo: %.2f%n", product.getName(), product.getPrice());
            }
        }

        // Esercizio 3
        System.out.println("\nEsercizio 3: Prodotti 'Boys' con sconto:");
        orders.stream()
                .flatMap(order -> order.getProducts().stream())
                .filter(product -> "Boys".equals(product.getCategory()))
                .forEach(product -> {
                    double originalPrice = product.getPrice();
                    double discountedPrice = originalPrice * 0.9; // Sconto del 10%
                    product.setPrice(discountedPrice); // Aggiorna il prezzo
                    System.out.printf("Prodotto: %s | Prezzo originale: %.2f | Prezzo scontato: %.2f (Sconto: 10%%) | Data ordine: %s%n",
                            product.getName(), originalPrice, discountedPrice,
                            orders.stream()
                                    .filter(order -> order.getProducts().contains(product))
                                    .map(Order::getOrderDate)
                                    .findFirst()
                                    .orElse(null));
                });

        // Esercizio 4
        List<Order> tier2Orders = orders.stream()
                .filter(order -> order.getCustomer().getTier() == 2)
                .filter(order -> order.getOrderDate().isAfter(LocalDate.of(2021, 2, 1)) &&
                        order.getOrderDate().isBefore(LocalDate.of(2021, 4, 1)))
                .collect(Collectors.toList());

        System.out.println("\nEsercizio 4: Prodotti ordinati da clienti di livello 2:");
        tier2Orders.forEach(order -> {
            order.getProducts().forEach(product -> {
                System.out.printf("Prodotto: %s | Prezzo: %.2f | Data ordine: %s%n",
                        product.getName(), product.getPrice(), order.getOrderDate());
            });
        });
    }
}
