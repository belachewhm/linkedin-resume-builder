package io.github.belachewhm.linkedin.resume.builder.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import io.github.belachewhm.linkedin.resume.builder.model.UserBean;
import io.github.belachewhm.linkedin.resume.builder.providers.LinkedInProvider;

@Controller
public class LoginController {
	@Autowired
	LinkedInProvider linkedInProvider;

	@RequestMapping(value = { "/", "/login" })
	public String login() {
		return "login";
	}

	@RequestMapping(value = "/linkedin", method = RequestMethod.GET)
	public String helloFacebook(Model model) {
		return linkedInProvider.getLinkedInUserData(model, new UserBean());
	}
}