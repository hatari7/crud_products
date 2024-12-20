package sit.int202.crudproduct.services;

import org.springframework.stereotype.Service;
import sit.int202.crudproduct.entities.Product;
import sit.int202.crudproduct.entities.Productline;
import sit.int202.crudproduct.repositories.ProductRepository;
import sit.int202.crudproduct.repositories.ProductlineRepository;

import java.util.List;

@Service
public class ProductlineService  {
    private final ProductlineRepository productlineRepository;

    public ProductlineService(ProductlineRepository productlineRepository) {
        this.productlineRepository = productlineRepository;
    }
    public List<Productline> findAll() {
        return productlineRepository.findAll();
    }
}
