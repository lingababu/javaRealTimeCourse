package com.loggerDemo.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class UserService {

	private Logger logger = LoggerFactory.getLogger(UserService.class);

	public void checkLoggersLevel() {

		logger.info("Info :: msg");
		logger.trace("trace :: msg");
		logger.debug("debug :: msg");
		logger.warn("warn :: msg");
		logger.error("Error :: msg");
	}

}
