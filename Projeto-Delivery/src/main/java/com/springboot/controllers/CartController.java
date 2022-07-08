package com.springboot.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.springboot.entities.Order;
import com.springboot.services.CartService;
import com.springboot.services.OrderService;

@Controller
public class CartController {

	@Autowired
	private CartService cartService;

	@Autowired
	private OrderService orderService;
	
	@GetMapping(value = "/cart")
	public ModelAndView cart() {
		ModelAndView mav = new ModelAndView("user/cart");
		mav.addObject("items", cartService.getItems());
		mav.addObject("totalValue", cartService.totalValue());
		return mav;
	}
	
	@GetMapping(value = "/finishOrder")
	public ModelAndView finishOrder() {
		ModelAndView mav = new ModelAndView("user/finishOrder");
		mav.addObject("items", cartService.getItems());
		mav.addObject("totalValue", cartService.totalValue());
		return mav;
	}
	
	@PostMapping(value = "/finalizingOrder")
	public ModelAndView finishOrderConfirm(Order order) {
		ModelAndView mav = new ModelAndView("index");
		orderService.save(order);
		mav.addObject("msg", "Pedido efetuado com sucesso, aguarde até a entrega!");
		return mav;
	}
	
	@GetMapping(value = "/addInCart/{id_food}")
	public String addItem(@PathVariable Long id_food) {
		cartService.addItem(id_food);
		return "redirect:/cart";
	}
	
	@GetMapping(value = "/deleteItem/{id_food}")
	public String deleteItem(@PathVariable Long id_food) {
		cartService.deleteItem(id_food);
		return "redirect:/cart";
	}	
	
	@GetMapping(value = "/updateQuantity/{id_food}/{action}")
	public String updateQuantity(@PathVariable Long id_food, @PathVariable Integer action) {
		cartService.updateQuantity(id_food, action);
		return "redirect:/cart";
	}
	
}
