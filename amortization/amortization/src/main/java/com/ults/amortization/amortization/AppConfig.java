package com.ults.amortization.amortization;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import config.config.DispatcherConfig;
import config.config.ThymeleafConfig;
import config.config.WebInitializerConfig;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "com.ults.amortization.amortization")
@Import({ WebInitializerConfig.class, DispatcherConfig.class, ThymeleafConfig.class })
public class AppConfig {

}
