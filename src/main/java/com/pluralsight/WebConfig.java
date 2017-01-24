package com.pluralsight;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

//during spring load this configuration will be read
@Configuration	//use this annotation(plus other config annotations) instead of web.xml, if I want I can still create web.xml, but the Servlet 3+ specification negates it.
@EnableWebMvc //it is in place of the servlet-config.xml in MVC 3, In that file we had the component scanner and beans e.g: for Internal view resolvers
public class WebConfig {

}
