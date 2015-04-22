package com.ads.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/customer")
public class CustomerController {
	@RequestMapping("/{name}/view.htm")
	public ModelAndView getView(@PathVariable String name, HttpServletRequest request, HttpServletResponse response){
		return new ModelAndView("CUSTOMER", "msg", "Hello" + name);
	}
}
