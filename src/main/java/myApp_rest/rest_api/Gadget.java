package myApp_rest.rest_api;

import javax.xml.bind.annotation.XmlRootElement;
@XmlRootElement
public class Gadget implements java.io.Serializable {


	private static final long serialVersionUID = -1173187143974267673L;
	private int id;
	private String brand;
	private String product;
	private String description;
    private double price;
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}

    
    
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public String getProduct() {
		return product;
	}
	public void setProduct(String product) {
		this.product = product;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	@Override
	public String toString() {
		return "Gadget [id=" + id + ", brand=" + brand + ", product=" + product
				+ ", description=" + description + ", price=" + price + "]";
	}
	
	
	
}
