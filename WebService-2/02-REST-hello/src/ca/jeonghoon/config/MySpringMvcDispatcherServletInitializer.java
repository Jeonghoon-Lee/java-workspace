package ca.jeonghoon.config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class MySpringMvcDispatcherServletInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {
	
	// Introduce Configuration class
	@Override
	protected Class<?>[] getRootConfigClasses() {
		return new Class[] { Config.class };
	}

	@Override
	protected Class<?>[] getServletConfigClasses() {
		return null;
	}
	
	// Define Servlet mapping
	@Override
	protected String[] getServletMappings() {
		return new String[] { "/" };
	}
}