package com.philomath.security.vault;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

import org.slf4j.Logger;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableConfigurationProperties({CredentialsConfig.class,ConsulConfig.class})
public class VaultApplication implements CommandLineRunner {

	private final CredentialsConfig credentialsConfig;
	private final ConsulConfig consulConfig;
	private final String maxconns;
	private final String maxconnsDefault;

	public VaultApplication(CredentialsConfig credentialsConfig
			,ConsulConfig consulConfig
							,@Value("${redis.maxconns}") String maxconns,
							@Value("${maxconns}") String maxconnsDefault
							){
		this.credentialsConfig = credentialsConfig;
		this.consulConfig = consulConfig;
		this.maxconns = maxconns;
		this.maxconnsDefault = maxconnsDefault;
	}

	public static void main(String[] args) {
		SpringApplication.run(VaultApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Logger logger = LoggerFactory.getLogger(VaultApplication.class);

		logger.info("----------------------------------------");
		logger.info("Configuration properties");
		logger.info("   example.username is {}", credentialsConfig.getUsername());
		logger.info("   example.password is {}", credentialsConfig.getPassword());
		logger.info("   Value at Consul Path: config/vault-app/example.name is {}", consulConfig.getName());
		logger.info("   Value at Consul Path: config/vault-app/redis/maxconn is {}", maxconns);
		logger.info("   Value at Consul Path: config/vault-app/maxconn is {}", maxconnsDefault);
		logger.info("----------------------------------------");
	}
}
