package com.ads.controller;

import java.io.IOException;
import java.util.Enumeration;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.stereotype.Controller;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.ads.bean.InfoValue;
import com.ads.bean.UserBean;

@Controller
@RequestMapping("/user")
@SessionAttributes("infoObject")
public class UserController {
	
	@ModelAttribute("infoObject")
	public InfoValue addInfo() {
		UserBean user = new UserBean(1, "ctb");
		InfoValue info = new InfoValue();
		info.setUserBean(user);
		return info;
	}
	
	@RequestMapping(method=RequestMethod.GET, params="id")
	public String init(@RequestParam("id") int id, Map<String, Object> model, HttpServletRequest request,
			HttpServletResponse response) {
		System.out.println("===============================================================GET===========================================================");
		InfoValue info = (InfoValue) model.get("infoObject");
		UserBean user = info.getUserBean();
		user.setId(user.getId()+1);
		System.out.println("-----Map-----");
		for (String key : model.keySet()) {
			System.out.println(key + " : "+ model.get(key).toString());
		}
		System.out.println("----Request----");
		Enumeration<String> enumration = request.getParameterNames();
		while (enumration.hasMoreElements()) {
			String e = enumration.nextElement();
			System.out.println(e);
			if ("infoObject".equals(e)) {
				InfoValue infoValue = (InfoValue) request.getAttribute(e);
				System.out.println("====>"+infoValue.getUserBean().getId());
			} else {
				System.out.println(request.getAttribute(e));
			}
			
		}
		System.out.println("-----Session-----");
		Enumeration<String> eSession = request.getSession().getAttributeNames();
		while (eSession.hasMoreElements()) {
			String e = eSession.nextElement();
			System.out.println(e);
			if ("infoObject".equals(e)) {
				InfoValue infoValue = (InfoValue) request.getSession().getAttribute(e);
				System.out.println("====>"+infoValue.getUserBean().getId());
			} else {
				System.out.println(request.getAttribute(e));
			}
		}
		return "USER";
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public String insert(@ModelAttribute("infoObject") InfoValue info, Map<String, Object> model, HttpServletRequest request,
			HttpServletResponse response) {
		System.out.println("===============================================================POST===========================================================");
		int id = info.getUserBean().getId() + 1;
		System.out.println(id);
		
		System.out.println("-----Map-----");
		for (String key : model.keySet()) {
			System.out.println(key + " : "+ model.get(key).toString());
		}
		System.out.println("----Request----");
		Enumeration<String> enumration = request.getParameterNames();
		while (enumration.hasMoreElements()) {
			String e = enumration.nextElement();
			System.out.println(e);
			if ("infoObject".equals(e)) {
				InfoValue infoValue = (InfoValue) request.getAttribute(e);
				System.out.println("====>"+infoValue.getUserBean().getId());
			} else {
				System.out.println(request.getAttribute(e));
			}
			
		}
		System.out.println("-----Session-----");
		Enumeration<String> eSession = request.getSession().getAttributeNames();
		while (eSession.hasMoreElements()) {
			String e = eSession.nextElement();
			System.out.println(e);
			if ("infoObject".equals(e)) {
				InfoValue infoValue = (InfoValue) request.getSession().getAttribute(e);
				System.out.println("====>"+infoValue.getUserBean().getId());
			} else {
				System.out.println(request.getAttribute(e));
			}
		}
		return "redirect:/user?id="+id;
	}
	
/*	@RequestMapping(method=RequestMethod.POST)
	public String addUser(@ModelAttribute("user") UserBean user) {
		int id = user.getId();
		System.out.println(user.getId() + ":" + user.getName());
		return "redirect:/user?id="+id;
	}*/
	
	@RequestMapping(value="/jsonUser", method=RequestMethod.GET,produces="application/json")
	public @ResponseBody String getUserJson() throws JsonGenerationException, JsonMappingException, IOException {
		UserBean user = new UserBean();
		user.setId(1);
		user.setName("quachgia");
		String json = new ObjectMapper().writeValueAsString(user);
		return json;
	}
	
	@RequestMapping(value="/jsonPostUser",method=RequestMethod.POST,produces="application/json")
	public @ResponseBody String getUserPostJson(@RequestBody String  json) throws JsonGenerationException, JsonMappingException, IOException {
		ObjectMapper mapper = new ObjectMapper();
		UserBean user = mapper.readValue(json, UserBean.class);
		user.setId(user.getId()+1);
		user.setName(user.getName()+"234");
		return mapper.writeValueAsString(user);
	}
	
	@RequestMapping(value="/jsonPostUser2",method=RequestMethod.POST)
	public @ResponseBody String getUserPostJson2(@RequestParam Map<String, String> params) 
												throws JsonGenerationException, JsonMappingException, IOException {
		String id = params.get("id");
		String name = params.get("name");
		ObjectMapper mapper = new ObjectMapper();
		UserBean user = new UserBean();
		user.setId(Integer.parseInt(id));
		user.setName(name);
		return mapper.writeValueAsString(user);
	}
}
