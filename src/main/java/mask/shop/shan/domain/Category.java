package mask.shop.shan.domain;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import mask.shop.shan.domain.Mask;

@Entity
public class Category {
	
	@Id	
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long categoryId;
	private String name;
	
	@OneToMany (cascade = CascadeType.ALL, mappedBy = "category")
	private List<Mask> masks;
	
	public Category(){}
	public Category(String name){
		this.name=name;
		
	}
	public long getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(long categoryId) {
		this.categoryId = categoryId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<Mask> getBooks() {
		return masks;
	}
	public void setBooks(List<Mask> masks) {
		this.masks = masks;
	}



}
