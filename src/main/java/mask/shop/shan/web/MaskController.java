package mask.shop.shan.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import org.springframework.web.bind.annotation.ResponseBody;


import mask.shop.shan.domain.Mask;
import mask.shop.shan.domain.CategoryRepository;
import mask.shop.shan.domain.MaskRepository;
import mask.shop.shan.domain.OrderList;
import mask.shop.shan.domain.OrderRepository;

@Controller
public class MaskController {

	@Autowired
	private MaskRepository mrepository;
	
	@Autowired
	private CategoryRepository crepository;
	
	@Autowired
	private OrderRepository orepository;
	
	@RequestMapping(value="/login")
    public String login() {	
		orepository.deleteAll();
        return "login";
    }	
	
	//show all the products
	@RequestMapping(value="/masklist")
	public String Mask(Model model){
		
		model.addAttribute("masks", mrepository.findAll());
		return "masklist";
	}
	
    // RESTful service to get all masks
    @RequestMapping(value ="/masks")
    public @ResponseBody List<Mask> maskListRest(){
    	return (List<Mask>) mrepository.findAll();
    }
    
    //RESTful service to get mask by id
    @RequestMapping(value="/mask/{id}", method = RequestMethod.GET)
    public @ResponseBody Mask findBookRest(@PathVariable("id") Long maskId){
    	return mrepository.findOne(maskId);
    }
	
  //add new mask
    @RequestMapping(value = "/add")
    public String addStudent(Model model){
    	model.addAttribute("mask", new Mask());
    	model.addAttribute("categorys", crepository.findAll());
        return "addmask";
    }     
    
    //save new mask
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String save(Mask mask){
        mrepository.save(mask);
        return "redirect:masklist";
    }    
    
    //delete mask
    @PreAuthorize("hasAuthority('ADMIN')")
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    public String deleteMask(@PathVariable("id") Long maskId, Model model) {
    	mrepository.delete(maskId);
        return "redirect:../masklist";
    }   
    
    //add mask to cart
    @RequestMapping(value = "/cart/{id}")
    public String cart (@PathVariable("id") Long id,  Model model){
    	
    	Mask mask = mrepository.findById(id);
    	System.out.println(mask.getId());
    	System.out.println(mask.getName());
    	OrderList order = new OrderList();
    	order.setId(id);
    	order.setMask(mask);
    	order.setPrice(mask.getPrice());
    	
    	model.addAttribute("orders", order);
    	orepository.save(order);
    	System.out.println(order.toString());
    	
    	return "cart";
    }
	
}
