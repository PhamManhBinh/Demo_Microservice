package cart;
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
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

@RestController
@CrossOrigin
public class CartController {

	protected Logger logger = Logger
			.getLogger(CartController.class.getName());
	
	@Autowired
	CartRepository cartRepository;
	
	RestTemplate restTemplate = new RestTemplate();
	
	String API_GATEWAY = "http://localhost:4444";
	
	@GetMapping("/cart")
	public ResponseEntity<Cart> all() {
		logger.info("cart-microservice all() invoked");
		Cart cart = cartRepository.findAll().get(0);
		logger.info("cart-microservice all() found: " + cart.getListItem().size());
		return new ResponseEntity<Cart>(cart, HttpStatus.OK);
	}
	
	
	@PostMapping("/cart")
	public ResponseEntity<Cart> add(@RequestBody CartItem cartItem) {
		logger.info("cart-microservice byId() invoked: " + cartItem.getProductId());
		Cart cart = cartRepository.findAll().get(0);
		
		try {
			String productRes = restTemplate.getForObject(API_GATEWAY +"/product/"+cartItem.getProductId(), String.class);
			logger.info(productRes);
			
			cart.addItem(cartItem);
			cart = cartRepository.save(cart);
			
		}catch(HttpClientErrorException ex) {
			if (ex.getStatusCode() != HttpStatus.NOT_FOUND) {
				logger.info(ex.getMessage());
			}
		}
		
		logger.info("cart-microservice byId() found: " + + cart.getListItem().size());
		return new ResponseEntity<Cart>(cart, HttpStatus.OK);
	}
}
