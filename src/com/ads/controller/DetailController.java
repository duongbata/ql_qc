package com.ads.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

public class DetailController extends AbstractController{
	@Override
	protected ModelAndView handleRequestInternal(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
			ModelAndView model = new ModelAndView("DETAIL");
			model.addObject("msg", "Hello Detail");
		return model;
	}
}
