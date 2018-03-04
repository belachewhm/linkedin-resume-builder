package io.github.belachewhm.linkedin.resume.builder.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.social.connect.ConnectionKey;
import org.springframework.social.connect.ConnectionRepository;
import org.springframework.social.linkedin.api.LinkedIn;
import org.springframework.social.linkedin.api.LinkedInProfileFull;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import io.github.belachewhm.linkedin.resume.builder.model.Connection;
import io.github.belachewhm.linkedin.resume.builder.model.User;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class ConnectionService
{
	private static final String REDIRECT_LOGIN = "redirect:/login";

	@Autowired
	Connection connection;

	public String getUserData(Model model, User userBean)
	{
		ConnectionRepository connectionRepository = connection.getConnectionRepository();
		if (connectionRepository.findPrimaryConnection(LinkedIn.class) == null) {
			return REDIRECT_LOGIN;
		}

		LinkedInProfileFull fullProfile = connection.getLinkedIn().profileOperations().getUserProfileFull();

		
		
		
		userBean = new User()
		{{
			this.setFirstName(fullProfile.getFirstName());
			this.setLastName(fullProfile.getLastName());
			this.setEmailAddress(fullProfile.getEmailAddress());
			this.setHeadline(fullProfile.getHeadline());
			this.setPublicProfileUrl(fullProfile.getProfilePictureUrl());
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