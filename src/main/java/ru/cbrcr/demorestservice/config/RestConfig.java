package ru.cbrcr.demorestservice.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurer;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import ru.cbrcr.demorestservice.domain.model.projection.DepartmentProjection;

@Configuration
public class RestConfig implements RepositoryRestConfigurer {

    @Override
    public void configureRepositoryRestConfiguration(
            RepositoryRestConfiguration repositoryRestConfiguration, CorsRegistry cors) {
        repositoryRestConfiguration.getProjectionConfiguration()
                .addProjection(DepartmentProjection.class);
    }
}
