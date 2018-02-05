package io.github.belachewhm.linkedin.resume.builder.providers;

import org.springframework.context.annotation.Configuration;
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
@Configuration
@Scope(value = "request", proxyMode = ScopedProxyMode.TARGET_CLASS)
public class BaseProvider {
	private LinkedIn linkedIn;
	private ConnectionRepository connectionRepository;
}