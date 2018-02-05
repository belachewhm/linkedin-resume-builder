package io.github.belachewhm.linkedin.resume.builder.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.social.connect.ConnectionRepository;
import org.springframework.social.linkedin.api.LinkedIn;
import org.springframework.social.linkedin.api.LinkedInProfileFull;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import io.github.belachewhm.linkedin.resume.builder.model.ConnectionBean;
import io.github.belachewhm.linkedin.resume.builder.model.UserBean;

@Service
public class LoginService {
	private static final String LINKED_IN = "linkedIn";

	private static final String REDIRECT_LOGIN = "redirect:/login";

	@Autowired
	ConnectionBean loginBean;

	public String getUserData(Model model, UserBean userForm) {
		ConnectionRepository connectionRepository = loginBean.getConnectionRepository();
		if (connectionRepository.findPrimaryConnection(LinkedIn.class) == null) {
			return REDIRECT_LOGIN;
		}
		populateUserDetailsFromLinkedIn(userForm);
		model.addAttribute("loggedInUser", userForm);
		return "user";
	}

	private void populateUserDetailsFromLinkedIn(UserBean userForm) {
		LinkedIn linkedIn = loginBean.getLinkedIn();
		LinkedInProfileFull linkedInUser = linkedIn.profileOperations().getUserProfileFull();
		userForm.setEmail(linkedInUser.getEmailAddress());
		userForm.setFirstName(linkedInUser.getFirstName());
		userForm.setLastName(linkedInUser.getLastName());
		userForm.setImage(linkedInUser.getProfilePictureUrl());
		userForm.setProvider(LINKED_IN);
	}
}