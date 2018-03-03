package io.github.belachewhm.linkedin.resume.builder.model;

import java.io.Serializable;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class User implements Serializable {
	private static final long serialVersionUID = 1L;
	private String firstName;
	private String lastName;
	private String email;
	private String title;
	private String country;
	private String image;
}
