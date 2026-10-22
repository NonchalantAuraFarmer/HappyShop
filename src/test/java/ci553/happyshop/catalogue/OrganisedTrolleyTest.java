package ci553.happyshop.catalogue;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class OrganisedTrolleyTest {

    @Test
    void addSameProductThrice_mergeToOneLine() {
        // create object
        Trolley trolley = new OrganisedTrolley();
        Product toast = new Product("0001", "toast", "0003.jpg", 15.19, 100);

        // add object thrice
        trolley.addProduct(toast);
        trolley.addProduct(toast);
        trolley.addProduct(toast);

        // getProducts returns a list, size() should be 1, 3 products = 1 object, 3 quantity
        assertEquals(1, trolley.getProducts().size());
        assertEquals(3, trolley.getProducts().getFirst().getOrderedQuantity());
    }
}