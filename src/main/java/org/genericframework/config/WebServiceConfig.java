package org.genericframework.config;

import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.ws.config.annotation.EnableWs;
import org.springframework.ws.config.annotation.WsConfigurerAdapter;
import org.springframework.ws.transport.http.MessageDispatcherServlet;
import org.springframework.ws.wsdl.wsdl11.DefaultWsdl11Definition;
import org.springframework.xml.xsd.SimpleXsdSchema;
import org.springframework.xml.xsd.XsdSchema;

@EnableWs
@Configuration
public class WebServiceConfig extends WsConfigurerAdapter {
	
	@Bean
	public ServletRegistrationBean messageDispatcherServlet(ApplicationContext applicationContext) {
		MessageDispatcherServlet servlet = new MessageDispatcherServlet();
		servlet.setApplicationContext(applicationContext);
		servlet.setTransformWsdlLocations(true);
		return new ServletRegistrationBean(servlet, "/soap/*");
	}

	@Bean(name = "reportes")
	public DefaultWsdl11Definition reportesWsdl11Definition(XsdSchema reportesSchema) {
		DefaultWsdl11Definition wsdl11Definition = new DefaultWsdl11Definition();
		wsdl11Definition.setPortTypeName("ReportesPort");
		wsdl11Definition.setLocationUri("/soap");
		wsdl11Definition.setTargetNamespace("http://genericframework.org/schemas/reportes");
		wsdl11Definition.setSchema(reportesSchema);
		return wsdl11Definition;
	}

	@Bean
	public XsdSchema reportesSchema() {
		return new SimpleXsdSchema(new ClassPathResource("schemas/reportes.xsd"));
	}

}
