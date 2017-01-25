package com.pluralsight;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

//public class WebAppInitializer implements WebApplicationInitializer{
//
//	@Override
//	public void onStartup(ServletContext servletContext) throws ServletException {
//		WebApplicationContext context = getContext(); 
//		servletContext.addListener(new ContextLoaderListener(context));
//		ServletRegistration.Dynamic dispatcher = servletContext.addServlet("DispatcherServlet", new DispatcherServlet(context));
//		dispatcher.setLoadOnStartup(1);
//		dispatcher.addMapping("*.html");
//	}
//
//	private AnnotationConfigWebApplicationContext getContext() {
//		AnnotationConfigWebApplicationContext context = new AnnotationConfigWebApplicationContext();
//		context.setConfigLocation("com.pluralsight.WebConfig");
//		return context;
//	}
//
//}

//This is needed to configure the DispatcherServlet with the WebConfig class
//This is the new way of defining the DispatcherServlet in java.
//This does the same as the commented out code above, but it is working for me.
public class WebAppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {
	 
    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class[] { WebConfig.class };
    }
  
    @Override
    protected Class<?>[] getServletConfigClasses() {
        return null;
    }
  
    @Override
    protected String[] getServletMappings() {
        return new String[] { "*.html" };
    }
 
}