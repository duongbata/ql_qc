package com.ads.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ads.bean.UserBean;

@Controller
@RequestMapping("/user/info/pro")
public class UserController {
	@RequestMapping(method=RequestMethod.GET, params="id")
	public String init(@RequestParam("id") int id, Map<String, Object> model, HttpServletRequest request,
			HttpServletResponse response) {
		UserBean user = new UserBean();
		user.setId(id);
		model.put("user", user);
		return "USER";
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public String insert(@ModelAttribute("user") UserBean user) {
		int id = user.getId()+1;
		System.out.println(user.getName());
		return "redirect:/user?id="+id;
	}
	
	@RequestMapping(value="/user/add", method=RequestMethod.POST)
	public String addUser(@ModelAttribute("user") UserBean user) {
		int id = user.getId();
		System.out.println(user.getId() + ":" + user.getName());
		return "redirect:/user?id="+id;
	}
	
	@RequestMapping(value="/jsonUser", method=RequestMethod.GET)
	public @ResponseBody UserBean getUserJson() {
		UserBean user = new UserBean();
		user.setId(1);
		user.setName("quachgia");
		return user;
	}
}
