package com.springboot.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.springboot.entities.Food;
import com.springboot.services.CategoryService;
import com.springboot.services.FoodService;

@Controller
public class FoodController {

	@Autowired
	private CategoryService categoryService;
	
	@Autowired
	private FoodService foodService;
	
	@PostMapping(value = "/deleteFood")
	public ModelAndView deleteFood(@RequestParam Long id_food) {
		ModelAndView mav = new ModelAndView("index");
		foodService.deleteById(id_food);
		mav.addObject("foods", foodService.findAll());
		mav.addObject("msg","Alimento excluido com sucesso!");
		return mav;
	}
	
	@PostMapping(value = "/saveFood")
	public ModelAndView saveFood(Food food, @RequestParam Long id_category) {
		ModelAndView mav = new ModelAndView("index");
		food.setCategory(categoryService.findById(id_category));
		foodService.save(food);
		mav.addObject("msg","Alimento cadastrado com sucesso!");
		return mav;
	}
	
}