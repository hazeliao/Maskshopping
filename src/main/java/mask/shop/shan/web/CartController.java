package mask.shop.shan.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RequestParam;

import mask.shop.shan.domain.MaskRepository;
import mask.shop.shan.domain.OrderList;
import mask.shop.shan.domain.OrderRepository;

@Controller
public class CartController {
	
	@Autowired
	private MaskRepository mrepository;
	
	@Autowired
	private OrderRepository orepository;
	
	//show all the products in the order	
	@RequestMapping(value="/cart")
	public String Order(Model model){
		model.addAttribute("orders", orepository.findAll());
		return "cart";
	}
	
	//RESTful service to get order product by id
	@RequestMapping(value="/orders/{id}", method = RequestMethod.GET)
    public @ResponseBody OrderList finOrderRest(@PathVariable("id") Long Id){
    	return orepository.findOne(Id);
    }	
	
	//RESTful service to get all orders
 	@RequestMapping(value ="/orders")
    public @ResponseBody List<OrderList> orderListRest(){
    	return (List<OrderList>) orepository.findAll();
    }
 	
 	//Update the orders by change amount of the product
 	@RequestMapping(value ="/update/{id}", method = RequestMethod.GET)
    public String UpdateOrder(@PathVariable("id") Long id,@RequestParam(name = "amount") String amount,@RequestParam(name = "total") double total, Model model){
 		//System.out.println("TESTING");
 		System.out.println(amount);
 		int quantity = Integer.parseInt(amount);
 		System.out.println("ID: " + id); 	
 		System.out.println("Mask:" + orepository.findOne(id).toString()); 
 		System.out.println("Amount:" + orepository.findOne(id).getAmount());	
 		orepository.findOne(id).setAmount(quantity);
 		double price = orepository.findOne(id).getPrice();
 		total = price * quantity;
 		orepository.findOne(id).setTotal(total);
 		orepository.save(orepository.findOne(id));	
 		/* System.out.println(quantity); */	
 		System.out.println(orepository.findOne(id).toString()); 		
    	return "redirect:../cart";
    }
 	 	
	//delete one of the orders
	@RequestMapping(value = "/delete1/{id}", method = RequestMethod.GET)
    public String deleteOrder(@PathVariable("id") Long id, Model model) {
		//System.out.println(id);		
		orepository.delete(id);    	
        return "redirect:../cart";
    }   
	
	//finish the shopping
	@RequestMapping(value="/finish")
	public String FinishOrder(Model model){
		List<OrderList> orders= (List<OrderList>) orepository.findAll();
		model.addAttribute("orders", orepository.findAll());
		double sum = 0;
		for (int i = 0; i < orders.size(); i++){
			sum += orders.get(i).getTotal();
		}
		model.addAttribute("sum", sum);
		return "finish";
	}
	
	

}
