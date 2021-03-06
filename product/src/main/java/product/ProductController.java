package product;
/**
 * 
 */


import java.util.List;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
public class ProductController {

	protected Logger logger = Logger
			.getLogger(ProductController.class.getName());
	
	@Autowired
	ProductRepository productRepository;
	
	@GetMapping("/products")
	public ResponseEntity<Product[]> all() {
		logger.info("products-microservice all() invoked");
		List<Product> products = productRepository.findAll();
		logger.info("products-microservice all() found: " + products.size());
		return new ResponseEntity<Product[]>(products.toArray(new Product[products.size()]), HttpStatus.OK);
	}
	
	@GetMapping("/product/{id}")
	public ResponseEntity<Product> byId(@PathVariable("id") String id) {
		logger.info("products-microservice byId() invoked: " + id);
		Product product = productRepository.getProductBy_id(id);
		logger.info("products-microservice byId() found: " + product);
		if(product != null)
			return new ResponseEntity<Product>(product, HttpStatus.OK);
		else 
			return new ResponseEntity<Product>(new Product(),HttpStatus.NOT_FOUND);
	}
}
