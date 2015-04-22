package com.ads.controller;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.ads.bean.UserBean;

@Controller
@RequestMapping("/user")
public class UserController {
	@RequestMapping(method=RequestMethod.GET, params="id")
	public String init(@RequestParam("id") int id, Map<String, Object> model) {
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
}
