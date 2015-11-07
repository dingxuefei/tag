package com.hummingbird.tag.web.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class InitDataListener implements ServletContextListener {

	private static final Logger logger = LoggerFactory.getLogger(InitDataListener.class);
	
	
	@Override
    public void contextInitialized(ServletContextEvent sce) {
        logger.debug("Initializing context...");
    }


	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		// TODO Auto-generated method stub
		
	}

}
