package sit.int202.crudproduct.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import sit.int202.crudproduct.entities.Product;

public interface ProductRepository extends JpaRepository<Product, String> {
}
