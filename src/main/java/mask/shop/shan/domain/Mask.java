package mask.shop.shan.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "Masks")
public class Mask {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	private String name, description;
	private int quantity;
	private double price;
	@ManyToOne
	@JsonIgnore
	@JoinColumn(name = "categoryId")
	private Category category;

	public Mask() {
	}

	public Mask(String name, String description, int quantity, double price, Category category) {
		this.name = name;
		this.description = description;
		this.quantity = quantity;
		this.price = price;
		this.category = category;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
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

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

}
