package ci553.happyshop.catalogue;

public class OrganisedTrolley extends Trolley {
    @Override
    public void addProduct(Product product) {
        for (Product item : getProducts()) {
            if(item.getProductId().equals(product.getProductId())) {
                int newQuantity = item.getOrderedQuantity() + product.getOrderedQuantity();
                item.setOrderedQuantity(newQuantity);
                return;
            }
        }
        Product copy = new Product(product.getProductId(), product.getProductDescription(),
                product.getProductImageName(), product.getUnitPrice(), product.getOrderedQuantity(),
                product.getStockQuantity()); /* Solved bug #1 */
        super.addProduct(copy); /* product -> copy */
    }
}
