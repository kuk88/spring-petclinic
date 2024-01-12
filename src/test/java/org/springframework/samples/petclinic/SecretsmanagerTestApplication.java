package org.springframework.samples.petclinic;

import org.springframework.boot.SpringApplication;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SecretsmanagerTestApplication {

	public static void main(String args[]) {
		SpringApplication.run(PetClinicApplication.class, "--spring.profiles.active=secretsmanager-mysql",
				"--SECRET_ID=arn:aws:secretsmanager:eu-central-1:133566492045:secret:mysql_1234567785-1232131");
	}

}
