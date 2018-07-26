package restServiceLibrary.service;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

public class TestWebApplicationInitializer implements WebApplicationInitializer{

	public void onStartup(ServletContext servletContext) throws ServletException {
		// TODO Auto-generated method stub
		AnnotationConfigWebApplicationContext ac=new AnnotationConfigWebApplicationContext();
		ac.register(restServiceLibrary.config.Config.class);
		ac.setServletContext(servletContext);
		
		//Gelen requesti kar��lar hhttp request gibi davranmasini saglar
		DispatcherServlet servlet=new DispatcherServlet(ac);
		ServletRegistration.Dynamic registration=servletContext.addServlet("app", servlet);
		registration.setLoadOnStartup(1);
		registration.addMapping("/");
		
		
	}

}
