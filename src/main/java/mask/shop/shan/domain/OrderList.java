package mask.shop.shan.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "OrderList")
public class OrderList {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false, updatable = false)
    private Long id;	
	
	@ManyToOne
	@JsonIgnore
    @JoinColumn(name = "mask", nullable = false )
	private Mask mask;
	@Column(name = "amount", nullable = false)
	private int amount = 1;
	@Column(name = "price", nullable = false)
	private double price;
	@Column(name = "total", nullable = false)
	private double total;
	
	public OrderList(){}
	
	public OrderList (Mask mask){
		this.mask = mask;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Mask getMask() {
		return mask;
	}

	public void setMask(Mask mask) {
		this.mask = mask;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public double getTotal() {
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
	}

	@Override
	public String toString() {
		return "OrderList [id=" + id + ", mask=" + mask + ", amount=" + amount + ", price=" + price + ", total=" + total
				+ "]";
	}
	
	

	
}
