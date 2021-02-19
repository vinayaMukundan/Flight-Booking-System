package com.aitrich.services.flightBookingSystem;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;


@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(basePackages = {"com.aitrich.services.flightBookingSystem.domain.repo"})
public class JpaConfiguration {

}
