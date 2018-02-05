package io.github.belachewhm.linkedin.resume.builder.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.social.connect.ConnectionKey;
import org.springframework.social.linkedin.api.LinkedIn;
import org.springframework.stereotype.Service;

import io.github.belachewhm.linkedin.resume.builder.model.ConnectionBean;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class LogoutService
{
	@Autowired
	ConnectionBean connectionBean;
	
	public void disconnect()
	{
		ConnectionKey key = connectionBean.getConnectionRepository().findPrimaryConnection(LinkedIn.class).getKey();
		log.info("*** Disconnecting from Connection Repository ***");
		connectionBean.getConnectionRepository().removeConnection(key);
	}
}
