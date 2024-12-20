package sit.int202.crudproduct.services;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import sit.int202.crudproduct.entities.Product;
import sit.int202.crudproduct.repositories.ProductRepository;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<Product> findAll() {
        return productRepository.findAll();
    }

    public Product getProduct(String productCode) {
        return productRepository.findById(productCode).orElse(null);
    }

    public Product findById() {
        return productRepository.findById("S10_1678").orElse(null);
    }

    //add
    public Product createProduct(Product product) {
        if (product == null) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Product cannot be null");
        }
        if (product.getProductCode() == null || productRepository.existsById(product.getProductCode())) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, String.format("Product ID %s already exists", product.getProductCode()));
        }
        Optional.ofNullable(product.getQuantityInStock())
                .orElse((short) 0);
        return productRepository.save(product);
    }

    //delete
    public void deleteProduct(String id) {
        productRepository.deleteById(id);
    }

    //update
    public Product updateProduct(Product product) {
        if (!productRepository.existsById(product.getProductCode())) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Product ID not found");
        }
        return productRepository.save(product);
    }


}
