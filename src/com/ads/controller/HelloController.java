package com.ads.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.ads.bean.InfoValue;
import com.ads.bean.UserBean;

@Controller
@RequestMapping("/welcome/{id}")
@SessionAttributes("infoValue")
public class HelloController {
	
	@RequestMapping(value={"/","/all"},method=RequestMethod.GET)
	public String printWelcome(@ModelAttribute InfoValue infoValue, Map<String,Object> model){
		UserBean user = infoValue.getUserBean();
		model.put("message", "Welcome to my life, " + user.getName());
		return "HELLO";
	}
	
	@RequestMapping(value="/{name}",method=RequestMethod.GET)
	public String welcomeUser(@PathVariable("id") String userId, @PathVariable("name") String userName,
							  @ModelAttribute InfoValue info,	ModelMap model) {
		model.addAttribute("message",userName + userId);
		List<UserBean> listUser = new ArrayList<UserBean>();
		UserBean u1 = new UserBean(1, "truongphi");
		UserBean u2 = new UserBean(2, "quachgia");
		UserBean u3 = new UserBean(3, "tonsach");
		listUser.add(u1);
		listUser.add(u2);
		listUser.add(u3);
		model.addAttribute("listUser", listUser);
		return "HELLO";
	}
	
	@RequestMapping(value="/listUser", method=RequestMethod.GET)
	public String getUser(HttpServletRequest request, ModelMap model) {
		String userId = request.getParameter("userId");
		System.out.println(userId);
		return "HELLO";
	}
	
	
}
