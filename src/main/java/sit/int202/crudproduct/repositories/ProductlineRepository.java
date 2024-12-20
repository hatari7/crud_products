package sit.int202.crudproduct.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import sit.int202.crudproduct.entities.Productline;

public interface ProductlineRepository extends JpaRepository<Productline, String> {
}