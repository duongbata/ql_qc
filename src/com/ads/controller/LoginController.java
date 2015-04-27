package com.ads.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.ads.bean.InfoValue;
import com.ads.bean.UserBean;

@Controller
@SessionAttributes("infoValue")
public class LoginController {
	
	@RequestMapping("/login")
	public String login(Model model) {
		UserBean user = new UserBean();
		model.addAttribute("user", user);
		return "LOGIN";
	}
	
	@RequestMapping("/logon")
	public String logon(@ModelAttribute("user") UserBean user, Model model) {
		InfoValue info = new InfoValue();
		info.setUserBean(user);
		model.addAttribute("infoValue", info);
		return "redirect:/welcome/"+user.getId()+"/";
	}
}
