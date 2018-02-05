package io.github.belachewhm.linkedin.resume.builder.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import io.github.belachewhm.linkedin.resume.builder.service.LogoutService;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class LogoutController {
	@Autowired
	LogoutService logoutService;

	@RequestMapping(value = "/logout")
	public String logout()
	{
		log.info("*** Disconnecting from Social Media Account ***");
		logoutService.disconnect();
		return "login";
	}
}
