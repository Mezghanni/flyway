package com.example.flyway;

import org.flywaydb.core.api.configuration.FluentConfiguration;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.flyway.FlywayConfigurationCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableTransactionManagement
public class FlywayApplication {

	@Configuration
	public class FlywayConfiguration {
		@Bean
		public FlywayConfigurationCustomizer customizeLicense(
				@Value("${my-app.flyway.license}") String license) {
			return new FlywayConfigurationCustomizer() {

				@Override
				public void customize(FluentConfiguration configuration) {
					configuration.licenseKey(license);
				}
			};
		}
	}

	public static void main(String[] args) {
		SpringApplication.run(FlywayApplication.class, args);
	}

}
