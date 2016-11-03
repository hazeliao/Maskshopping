package mask.shop.shan.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import mask.shop.shan.domain.CategoryRepository;
import mask.shop.shan.domain.Mask;
import mask.shop.shan.domain.MaskRepository;
import mask.shop.shan.domain.OrderRepository;

@Controller
public class CartController {
	
	@Autowired
	private MaskRepository mrepository;
	
	@Autowired
	private OrderRepository orepository;
	
	@RequestMapping(value="/cart")
	public String Mask(Model model){
		model.addAttribute("orders", orepository.findAll());
		return "cart";
	}

}
