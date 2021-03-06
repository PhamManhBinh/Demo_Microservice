package product;
/**
 * 
 */


import java.io.Serializable;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;  
import javax.persistence.Table;  

@Entity  
@Table(name="product")  
public class Product implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -5986383191302107334L;
	/**
	 * 
	 */
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private String _id;
	
	@Basic
	@Column(name="product_name")
	private String productName;
	
	@Basic
	@Column(name="product_price")
	private Integer productPrice;
	
	@Basic
	@Column(name="product_description")
	private String productDescription;
	
	@Basic
	@Column(name="product_image")
	private String productImage;
	public Product() {}
	public Product(String _id, String productName, Integer productPrice, String productDescription,
			String productImage) {
		super();
		this._id = _id;
		this.productName = productName;
		this.productPrice = productPrice;
		this.productDescription = productDescription;
		this.productImage = productImage;
	}
	public String get_id() {
		return _id;
	}
	public void set_id(String _id) {
		this._id = _id;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public Integer getProductPrice() {
		return productPrice;
	}
	public void setProductPrice(Integer productPrice) {
		this.productPrice = productPrice;
	}
	public String getProductDescription() {
		return productDescription;
	}
	public void setProductDescription(String productDescription) {
		this.productDescription = productDescription;
	}
	public String getProductImage() {
		return productImage;
	}
	public void setProductImage(String productImage) {
		this.productImage = productImage;
	}
	
	
}
