package org.springframework.samples.petclinic.secretdatasource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.*;

import javax.sql.DataSource;

@Configuration(proxyBeanMethods = false)
@Profile("secretsmanager-mysql")
@ConfigurationProperties(prefix = "spring.datasource")
public class MyDataSourceConfiguration {

	@Bean
	@ConfigurationProperties("spring.datasource")
	public DataSource dataSource() {

		return DataSourceBuilder.create()
			.driverClassName("com.amazonaws.secretsmanager.sql.AWSSecretsManagerMySQLDriver")
			.build();
	}

}
