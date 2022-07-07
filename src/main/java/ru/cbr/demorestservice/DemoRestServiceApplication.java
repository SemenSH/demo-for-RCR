package ru.cbr.demorestservice;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.data.rest.webmvc.config.RepositoryRestMvcConfiguration;
import org.springframework.stereotype.Component;

@Configuration
@SpringBootApplication
@Import(RepositoryRestMvcConfiguration.class)
public class DemoRestServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoRestServiceApplication.class, args);
    }

    @Component
    @Slf4j
    @RequiredArgsConstructor
    static class ApplicationStartup implements ApplicationListener<ApplicationReadyEvent> {

        @Override
        public void onApplicationEvent(ApplicationReadyEvent event) {
            log.debug(">>>>> ready >>>>>>>>>>>");
        }
    }
}
