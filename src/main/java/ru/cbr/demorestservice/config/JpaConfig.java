package ru.cbr.demorestservice.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.envers.repository.config.EnableEnversRepositories;
import org.springframework.data.envers.repository.support.EnversRevisionRepositoryFactoryBean;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.persistence.EntityManagerFactory;

@Slf4j
@Configuration(proxyBeanMethods = false)
@EnableTransactionManagement
@EnableEnversRepositories
@EnableJpaAuditing
@EntityScan(basePackages = {"ru.cbr.demorestservice.domain.model"})
@EnableJpaRepositories(
        basePackages = {"ru.cbr.demorestservice.domain.repository"},
        repositoryFactoryBeanClass = EnversRevisionRepositoryFactoryBean.class)
public class JpaConfig {

    @Primary
    @Bean(name = "transactionManager")
    protected PlatformTransactionManager transactionManager(
            @Qualifier("entityManagerFactory") EntityManagerFactory entityManagerFactory) {
        return new JpaTransactionManager(entityManagerFactory);
    }

//    @Bean
//    protected AuditorAware<String> auditorAware() {
//        log.debug(">>> configure auditor aware");
//        return () -> {
//            Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
//            return Optional.of(authentication.getName());
//        };
//    }
}
