package io.github.belachewhm.linkedin.resume.builder.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import io.github.belachewhm.linkedin.resume.builder.model.UserBean;
import io.github.belachewhm.linkedin.resume.builder.service.LoginService;

@Controller
public class LoginController {
	@Autowired
	LoginService loginService;

	@RequestMapping(value = { "/", "/login" })
	public String login() {
		return "login";
	}

	@RequestMapping(value = "/linkedin", method = RequestMethod.GET)
	public String helloLinkedIn(Model model) {		
		return loginService.getUserData(model, new UserBean());
	}
}