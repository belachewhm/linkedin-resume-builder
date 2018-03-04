package io.github.belachewhm.linkedin.resume.builder.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.social.connect.ConnectionKey;
import org.springframework.social.connect.ConnectionRepository;
import org.springframework.social.linkedin.api.LinkedIn;
import org.springframework.social.linkedin.api.LinkedInProfileFull;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import io.github.belachewhm.linkedin.resume.builder.model.Connection;
import io.github.belachewhm.linkedin.resume.builder.model.UserBean;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class ConnectionService
{
	private static final String REDIRECT_LOGIN = "redirect:/login";

	@Autowired
	Connection connection;

	public String getUserData(Model model, UserBean userBean)
	{
		ConnectionRepository connectionRepository = connection.getConnectionRepository();
		if (connectionRepository.findPrimaryConnection(LinkedIn.class) == null) {
			return REDIRECT_LOGIN;
		}

		LinkedInProfileFull fullProfile = connection.getLinkedIn().profileOperations().getUserProfileFull();

		
		
		
		userBean = new UserBean()
		{{
			this.setFirstName(fullProfile.getFirstName());
			this.setLastName(fullProfile.getLastName());
			this.setEmail(fullProfile.getEmailAddress());
			this.setTitle(fullProfile.getHeadline());
			this.setImage(fullProfile.getProfilePictureUrl());
		}};
		
		model.addAttribute("loggedInUser", userBean);
		return "main";
	}
	
	public String disconnect()
	{
		ConnectionKey key = connection.getConnectionRepository().findPrimaryConnection(LinkedIn.class).getKey();
		connection.getConnectionRepository().removeConnection(key);
		return "index";
	}
}