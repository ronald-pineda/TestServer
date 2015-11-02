package org.portalapps.webapp.config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;


public class AppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer  {

	@Override
	protected Class<?>[] getRootConfigClasses() {
				 return new Class[] {
//						 AppControllerConfig.class 
						 };
//		return null;
	}

	@Override
	protected Class<?>[] getServletConfigClasses() {
		return new Class[] { 
				AppControllerConfig.class 
				};
//		return null;
	}

	@Override
	protected String[] getServletMappings() {
//				return new String[] {"*.jsp"}; 
		return new String[] {"/"};
	}
	
//	@Override
//	protected Filter[] getServletFilters() {
//		return new Filter[] { new HiddenHttpMethodFilter() };
//	}


}