package com.tabcorp.app.betsapplication;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import com.tabcorp.app.betsapplication.service.BettingService;
import com.tabcorp.app.betsapplication.util.DataProvisioner;

@SpringBootApplication
@ComponentScan("com.tabcorp.app.betsapplication")
public class BetsApplicationMain implements CommandLineRunner {

	@Autowired
	BettingService bettingService;

	public static void main(String[] args) {
		SpringApplication.run(BetsApplicationMain.class, args);
	}

	/**
	 * Provisioning temporary test date for development
	 */
	@Override
	public void run(String... arg0) throws Exception {
		DataProvisioner.provisionInitialData(bettingService);
	}

}
