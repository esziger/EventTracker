package com.pluralsight;

import java.util.Locale;

import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
//import org.springframework.web.servlet.view.JstlView;

//during spring load this configuration will be read
@Configuration	//use this annotation(plus other config annotations) instead of web.xml, if I want I can still create web.xml, but the Servlet 3+ specification negates it.
@EnableWebMvc //it is in place of the servlet-config.xml in MVC 3, In that file we had the component scanner and beans e.g: for Internal view resolvers
@ComponentScan(basePackages = "com.pluralsight")
public class WebConfig  //WebConfig contains all the info which was previoudly in the webConfig.xml 
extends WebMvcConfigurerAdapter //extends from WebMvcConfigurerAdapter if I want to resolve static files
{
	@Bean
	public MessageSource messageSource(){	//this Bean looks for _en and _sw properties.
		ResourceBundleMessageSource messageSource = new ResourceBundleMessageSource();
		messageSource.setBasename("messages");
		return messageSource;
	}
	
	@Bean
	public LocaleResolver localeResolver(){//this sets our default locale, and store it in our session for the duration of our application
		SessionLocaleResolver resolver = new SessionLocaleResolver();
		resolver.setDefaultLocale(Locale.ENGLISH);
		return resolver;
	}
	
	@Override
	public void addInterceptors(InterceptorRegistry registry) {//this is what interceps out URLs.
		LocaleChangeInterceptor changeInterceptor = new LocaleChangeInterceptor();
		changeInterceptor.setParamName("language");
		registry.addInterceptor(changeInterceptor);
	}
		
	@Bean
	public InternalResourceViewResolver getInternalResourceViewResolver(){
		 InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
	        //viewResolver.setViewClass(JstlView.class);
	        viewResolver.setPrefix("/WEB-INF/jsp/");	//webapp the root
	        viewResolver.setSuffix(".jsp");
	 
	        return viewResolver;
	}
	
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/pdfs/**").addResourceLocations("/WEB-INF/pdf/");
		registry.addResourceHandler("/css/**").addResourceLocations("/WEB-INF/css/");
	}

}
