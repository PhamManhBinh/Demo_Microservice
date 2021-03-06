package cart;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document(collection = "cart")
public class Cart implements Serializable{
	
	@Id
	private String id;
	
	@Field(value = "listItem")
	private List<CartItem> listItem = new ArrayList<CartItem>();

	public Cart() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Cart(List<CartItem> listItem) {
		super();
		this.listItem = listItem;
	}
	
	
	public Cart(String id, List<CartItem> listItem) {
		super();
		this.id = id;
		this.listItem = listItem;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public List<CartItem> getListItem() {
		return listItem;
	}

	public void setListItem(List<CartItem> listItem) {
		this.listItem = listItem;
	}

	public void addItem(CartItem item) {
		for(int i=0;i<listItem.size(); i++) {
			CartItem temp = listItem.get(i);
			if(temp.getProductId().equals(item.getProductId())) {
				temp.setQuantity(temp.getQuantity()+item.getQuantity());
				if(temp.getQuantity() < 1) {
					listItem.remove(i);
				}else {
					listItem.set(i, temp);
				}
				return;
			}
		}
		if(item.getQuantity()>0)
			listItem.add(item);
	}
	
}
