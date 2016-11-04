package mask.shop.shan.web;

import java.util.List;

import javax.validation.Valid;

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
	
	@RequestMapping(value="/cart")
	public String Order(Model model){
		model.addAttribute("orders", orepository.findAll());
		return "cart";
	}
	
 	@RequestMapping(value ="/orders")
    public @ResponseBody List<OrderList> orderListRest(){
    	return (List<OrderList>) orepository.findAll();
    }
 	@RequestMapping(value ="/update/{id}", method = RequestMethod.GET)
    public String UpdateOrder(@PathVariable("id") Long id,@RequestParam(name = "amount") String amount, Model model){
 		System.out.println("TESTING");
 		System.out.println(amount);
 		int quantity = Integer.parseInt(amount);
 		System.out.println("ID: " + id);
 		List<OrderList> orders = (List<OrderList>) orepository.findAll();
 		System.out.println(orders);
 		
 		System.out.println(orders.get(1));
 		System.out.println(orepository.findOne(id).getAmount());
 		
 		
 		orepository.findOne(id).setAmount(quantity);
 		System.out.println(quantity);
 	
 		System.out.println(orepository.findOne(id).toString());
    	return "redirect:../cart";
    }
 	
	@RequestMapping(value="/order/{id}", method = RequestMethod.GET)
    public @ResponseBody OrderList findBookRest(@PathVariable("id") Long id){
    	return orepository.findOne(id);
    }
	
	@RequestMapping(value = "/delete1/{id}", method = RequestMethod.GET)
    public String deleteOrder(@PathVariable("id") Long id, Model model) {
		//System.out.println(id);		
		orepository.delete(id);    	
        return "redirect:../cart";
    }   
	
	@RequestMapping(value="/finish")
	public String FinishOrder(Model model){
		model.addAttribute("orders", orepository.findAll());
		return "finish";
	}
	

}
