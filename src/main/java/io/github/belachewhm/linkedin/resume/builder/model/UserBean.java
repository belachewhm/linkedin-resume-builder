package io.github.belachewhm.linkedin.resume.builder.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;

import lombok.Data;

@Data
@Entity(name = "user")
@Table(name = "user")
public class UserBean implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@NotNull(message = "Email  cannot be empty")
	@Email(message = "Email Format is not valid")
	@Size(min = 3, max = 30, message = "Email can not be empty")
	private String email;

	@NotNull(message = "First Name cannot be empty")
	@Size(min = 3, max = 30, message = "First Name cannot be less than 3 characters")
	private String firstName;

	@NotNull(message = "Last Name cannot be empty")
	@Size(min = 3, max = 30, message = "Last Name cannot be less than 3 characters")
	private String lastName;

	private String title;
	private String country;
	private String password;
	
	@Transient
	private String passwordConfirm;
	private String provider;
	private String image;

	// private Location location;
	//
	// private String headline;
	//
	// private String industry;
	//
	// private String publicProfileUrl;
	//
	// private String profilePictureUrl;
	//
	// private String summary;
	//
	// private List<Position> positions;
	//
	// private List<String> skills;
	//
	// private List<Education> educations;
	//
	// private String interests;
	//
	// private String honors;
}
