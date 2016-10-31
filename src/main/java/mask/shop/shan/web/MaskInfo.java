package mask.shop.shan.web;

import org.springframework.web.multipart.commons.CommonsMultipartFile;

import mask.shop.shan.domain.Mask;

public class MaskInfo {
	
	 	private long id;
	    private String name;
	    private double price;
	 
	    private boolean newProduct=false;
	 
	    // Upload file.
	    private CommonsMultipartFile fileData;
	 
	    public MaskInfo() {
	    }
	 
	    public MaskInfo(Mask mask) {
	        this.id = mask.getId();
	        this.name = mask.getName();
	        this.price = mask.getPrice();
	    }
	 
	    
	    public MaskInfo(long id, String name, double price) {
	        this.id = id;
	        this.name = name;
	        this.price = price;
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
	 
	    public double getPrice() {
	        return price;
	    }
	 
	    public void setPrice(double price) {
	        this.price = price;
	    }
	 
	    public CommonsMultipartFile getFileData() {
	        return fileData;
	    }
	 
	    public void setFileData(CommonsMultipartFile fileData) {
	        this.fileData = fileData;
	    }
	 
	    public boolean isNewProduct() {
	        return newProduct;
	    }
	 
	    public void setNewProduct(boolean newProduct) {
	        this.newProduct = newProduct;
	    }

}
