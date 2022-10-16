package config.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.Lazy;
import org.springframework.format.FormatterRegistry;
import org.springframework.format.datetime.DateFormatter;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@Import({ ThymeleafConfig.class })
public class DispatcherConfig implements WebMvcConfigurer {

    @Override
    public void addResourceHandlers(@Lazy ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/js/**").addResourceLocations("/js/");
        registry.addResourceHandler("/css/**").addResourceLocations("/css/");
        registry.addResourceHandler("/html/**").addResourceLocations("/html/");
        registry.addResourceHandler("/images/**").addResourceLocations("/images/");
    }

    @Override
    public void addFormatters(FormatterRegistry registry) {
        registry.addFormatter(dateFormatter);
    }

    @Autowired
    private MessageSource messageSource;

    @Autowired
    private DateFormatter dateFormatter;

    @Bean
    public DateFormatter dateFormatter() {
        return new DateFormatter("MM/dd/yyyy");
    }

}
