package io.github.belachewhm.linkedin.resume.builder.model;

import java.io.Serializable;
import java.util.List;

import org.springframework.social.linkedin.api.Education;
import org.springframework.social.linkedin.api.Location;
import org.springframework.social.linkedin.api.Position;

import lombok.Data;

@Data
public class User implements Serializable
{
	private static final long serialVersionUID = 1L;
	
	private String firstName;
	
	private String lastName;
	
	private Location location;
	
	private String headline;
	
	private String industry;
	
	private String emailAddress;
	
	private String publicProfileUrl;
	
	private String profilePictureUrl;
	
	private String summary;
	
	private List<Position> positions;
	
	private List<String> skills;
	
	private List<Education> educations;
	
	private String interests;
	
	private String honors;
}
