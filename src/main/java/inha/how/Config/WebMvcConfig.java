package inha.how.Config;

import inha.how.Controller.Interceptor.LoginInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebMvcConfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry){
        registry.addMapping("/**")
                .allowedOrigins("*")
                .allowedMethods("OPTIONS", "GET", "POST", "PUT", "DELETE");
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry){
        registry.addInterceptor(new LoginInterceptor())
                .excludePathPatterns("/swagger/swagger-ui/index.html")
                .excludePathPatterns("/swagger/**")
                .excludePathPatterns("/v3/api-docs")
                .excludePathPatterns("/v3/api-docs/swagger-config")
                .excludePathPatterns("/swagger/how")
                .excludePathPatterns("/swagger/swagger-ui/swagger-ui-standalone-preset.js")
                .excludePathPatterns("/swagger/swagger-ui/swagger-ui-bundle.js")
                .excludePathPatterns("/swagger/swagger-ui/swagger-initializer.js")
                .excludePathPatterns("/api/users/login")
                .excludePathPatterns("/api/ex-routines")
                .excludePathPatterns("/api/ex-routines/{id}")
                .excludePathPatterns("/hello")
                .excludePathPatterns("/api/lives")
                .excludePathPatterns("/api/lives/*")
                .excludePathPatterns("/.well-known/**")
        ;
    }
}
