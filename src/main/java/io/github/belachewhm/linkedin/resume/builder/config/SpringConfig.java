package io.github.belachewhm.linkedin.resume.builder.config;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.social.connect.ConnectionRepository;
import org.springframework.social.linkedin.api.LinkedIn;
import org.springframework.web.client.RestTemplate;

import io.github.belachewhm.linkedin.resume.builder.model.LoginBean;

@Configuration
public class SpringConfig
{
	@Bean
	public LoginBean loginBean(LinkedIn linkedIn, ConnectionRepository connectionRepository)
	{
		return new LoginBean(linkedIn, connectionRepository);
	}
	
	@Bean
	public RestTemplate restTemplate(RestTemplateBuilder builder) {
		return builder.build();
	}	
}