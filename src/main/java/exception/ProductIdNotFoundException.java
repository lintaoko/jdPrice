package exception;

public class ProductIdNotFoundException
        extends RuntimeException {
    private String productId;

    public ProductIdNotFoundException(String productId) {
        this.productId = productId;
    }

    public String getProductId() {
        return productId;
    }
}
