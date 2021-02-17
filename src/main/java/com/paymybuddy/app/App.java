package com.paymybuddy.app;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.paymybuddy.app.service.LaunchingService;

@SpringBootApplication
public class App {

    private static final Logger logger = LogManager.getLogger("AlertsApplication");
	private static LaunchingService launchingService = new LaunchingService();;
	
    public static void main( String[] args ) {

		SpringApplication.run(App.class, args);

        logger.info("Initializing app");
		launchingService.LaunchApplication();
    }
}
