package ci553.happyshop.catalogue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TrolleyTest {
    Trolley trolley;

    @BeforeEach
    void setUp() {
        trolley = new Trolley(); // fresh, empty plain trolley before every test
    }

    @Test
    void removeProductRemovesAllMatchingEntries() {
        trolley.addProduct(new Product("0001", "40 inch TV", "0001.jpg", 269.00, 1, 100));
        trolley.addProduct(new Product("0001", "40 inch TV", "0001.jpg", 269.00, 1, 100));
        trolley.addProduct(new Product("0002", "Radio", "0002.jpg", 29.99, 1, 100));

        trolley.removeProduct("0001");

        assertEquals(1, trolley.getProducts().size());
        assertEquals("0002", trolley.getProducts().get(0).getProductId());
    }

    @Test
    void changeQuantityIncreasesQuantity() {
        trolley.addProduct(new Product("0003", "Toaster", "0003.jpg", 19.99, 2, 100));

        trolley.changeQuantity("0003", 1);

        assertEquals(3, trolley.getProducts().get(0).getOrderedQuantity());
    }

    @Test
    void changeQuantityDoesNotGoBelowZero() {
        trolley.addProduct(new Product("0003", "Toaster", "0003.jpg", 19.99, 1, 100));

        trolley.changeQuantity("0003", -1);
        assertEquals(1, trolley.getProducts().get(0).getOrderedQuantity());
        assertEquals(1, trolley.getProducts().size());
    }
}