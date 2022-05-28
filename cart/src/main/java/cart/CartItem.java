package cart;

import java.io.Serializable;

import org.springframework.data.mongodb.core.mapping.Field;

public class CartItem implements Serializable{
	
	@Field(value = "productId")
	private String productId;
	
	@Field(value = "quantity")
	private Integer quantity;
	public CartItem(String productId, Integer quantity) {
		super();
		this.productId = productId;
		this.quantity = quantity;
	}
	public CartItem() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getProductId() {
		return productId;
	}
	public void setProductId(String productId) {
		this.productId = productId;
	}
	public Integer getQuantity() {
		return quantity;
	}
	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
	
}
