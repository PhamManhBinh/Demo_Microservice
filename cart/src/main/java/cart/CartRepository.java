package cart;
/**
 * 
 */


import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Dinesh.Rajput
 *
 */
@Repository
public interface CartRepository extends MongoRepository<Cart, String>{
	
}
