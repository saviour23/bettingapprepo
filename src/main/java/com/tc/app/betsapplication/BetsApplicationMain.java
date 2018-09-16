package com.tc.app.betsapplication;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import com.tc.app.betsapplication.service.BettingService;
import com.tc.app.betsapplication.util.DataProvisioner;

/**
 *Betting Application main class to start the application.
 *SpringBoot application will start the embedded tomcat server and will
 *expose all API's to port 8080
 *
 */

@SpringBootApplication
@ComponentScan("com.tc.app.betsapplication")
public class BetsApplicationMain implements CommandLineRunner {

	@Autowired
	BettingService bettingService;

	public static void main(String[] args) {
		SpringApplication.run(BetsApplicationMain.class, args);
	}

	/**
	 * Provisioning temporary test data for development
	 */
	@Override
	public void run(String... arg0) throws Exception {
		DataProvisioner.provisionInitialData(bettingService);
	}

}
