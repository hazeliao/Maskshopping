package mask.shop.shan.web;

public class CartLineInfo {
	 
    private MaskInfo maskInfo;
    private int quantity;
 
    public CartLineInfo() {
        this.quantity = 0;
    }
 
    public MaskInfo getMaskInfo() {
        return maskInfo;
    }
 
    public void setProductInfo(MaskInfo maskInfo) {
        this.maskInfo = maskInfo;
    }
 
    public int getQuantity() {
        return quantity;
    }
 
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
 
    public double getAmount() {
        return this.maskInfo.getPrice() * this.quantity;
    }
    

}
