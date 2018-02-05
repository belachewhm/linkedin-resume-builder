package io.github.belachewhm.linkedin.resume.builder.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
public class WebConfig extends WebMvcConfigurerAdapter {
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		if(!registry.hasMappingForPattern("/webjars/**"))
		{
			registry.addResourceHandler("/webjars/**").addResourceLocations("classpath:/META-INF/resources/webjars/");
		}
		
		if(!registry.hasMappingForPattern("/images/**"))
		{
			registry.addResourceHandler("/images/**").addResourceLocations("classpath:/images/");
		}
	}
}