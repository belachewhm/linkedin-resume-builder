package io.github.belachewhm.linkedin.resume.builder.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import io.github.belachewhm.linkedin.resume.builder.model.User;
import io.github.belachewhm.linkedin.resume.builder.service.ConnectionService;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class ConnectionController {
	@Autowired
	ConnectionService connectionService;

	@RequestMapping(value = { "/", "/login" })
	public String login() {
		return "index";
	}
	
	@RequestMapping(value = "/linkedin", method = RequestMethod.GET)
	public String helloLinkedIn(Model model)
	{
		return connectionService.getUserData(model, new User());
	}
	
	@RequestMapping(value = "/logout")
	public String logout()
	{
		return connectionService.disconnect();
	}
}