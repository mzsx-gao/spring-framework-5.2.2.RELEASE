package com.gao.controller.beanName;

import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@Controller("/order/index")
public class BeanNameController extends AbstractController {

	@Override
	protected ModelAndView handleRequestInternal(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("====/order/index");
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("ok");
		return modelAndView;
	}
}
