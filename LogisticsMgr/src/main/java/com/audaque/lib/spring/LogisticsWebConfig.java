/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.audaque.lib.spring;

import com.audaque.lib.spring.security.LmgrSecurityInterceptor;
import java.util.List;
import org.springframework.context.annotation.Configuration;
import org.springframework.format.FormatterRegistry;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.ContentNegotiationConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;
import org.springframework.web.servlet.theme.ThemeChangeInterceptor;

/**
 *
 * @author [*田园间*]
 */
@Configuration
@EnableWebMvc
public class LogisticsWebConfig extends WebMvcConfigurerAdapter {

    /***********************************************
    |             C O N S T A N T S             |
    ***********************************************/

    /***********************************************
    |    I N S T A N C E   V A R I A B L E S    |
    ***********************************************/

    /***********************************************
    |         C O N S T R U C T O R S           |
    ***********************************************/

    /***********************************************
    |  A C C E S S O R S / M O D I F I E R S    |
    ***********************************************/

    /***********************************************
    |               M E T H O D S               |
    ***********************************************/

    @Override
    public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
        super.configureMessageConverters(converters); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void addFormatters(FormatterRegistry registry) {
        super.addFormatters(registry); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new LocaleChangeInterceptor());
        registry.addInterceptor(new ThemeChangeInterceptor()).addPathPatterns("/**").excludePathPatterns("/admin/**");
        registry.addInterceptor(new LmgrSecurityInterceptor()).addPathPatterns("/security/*");
    }

    @Override
    public void configureContentNegotiation(ContentNegotiationConfigurer configurer) {
        configurer.favorPathExtension(false).favorParameter(true);
        configurer.mediaType("json", MediaType.APPLICATION_JSON);
        configurer.mediaType("xml", MediaType.APPLICATION_XML);
    }
    
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/").setViewName("home");
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/resources/**").addResourceLocations("/public-resources/");
    }
}
