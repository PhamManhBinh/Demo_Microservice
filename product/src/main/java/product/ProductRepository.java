package product;
/**
 * 
 */


import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

/**
 * @author Dinesh.Rajput
 *
 */
public interface ProductRepository extends CrudRepository<Product, String>{
	
	@Query(value="SELECT * FROM product", nativeQuery=true)
	List<Product> findAll();
	
	Product getProductBy_id(String _id);
}
