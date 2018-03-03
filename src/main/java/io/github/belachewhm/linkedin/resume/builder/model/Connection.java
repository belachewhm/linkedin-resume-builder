package io.github.belachewhm.linkedin.resume.builder.model;

import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.social.connect.ConnectionRepository;
import org.springframework.social.linkedin.api.LinkedIn;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@Scope(value = "request", proxyMode = ScopedProxyMode.TARGET_CLASS)
public class Connection {
	private LinkedIn linkedIn;
	private ConnectionRepository connectionRepository;
}