package org.unc.lms.codes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.thymeleaf.spring6.SpringTemplateEngine;
import org.thymeleaf.spring6.templateresolver.SpringResourceTemplateResolver;
import org.thymeleaf.spring6.view.ThymeleafViewResolver;
import org.thymeleaf.templatemode.TemplateMode;

@EnableWebMvc
@Configuration
@ComponentScan(basePackages = "org.unc.lms.codes")
public class SpringMVContainerConfig implements WebMvcConfigurer{
	
	@Autowired
	public ApplicationContext applicationContext; // non-MVC
    
	@Bean
	public SpringResourceTemplateResolver templateViewResolver() {
		SpringResourceTemplateResolver templateViewResolver = 
				new SpringResourceTemplateResolver();
		templateViewResolver.setApplicationContext(applicationContext);
		templateViewResolver.setPrefix("/WEB-INF/views/");
		templateViewResolver.setSuffix(".html");
		templateViewResolver.setTemplateMode(TemplateMode.HTML);
		templateViewResolver.setCacheable(true);
		return templateViewResolver;
	}
	
	@Bean
	public SpringTemplateEngine templateEngine() {
		SpringTemplateEngine templateEngine = new  SpringTemplateEngine();
		templateEngine.setTemplateResolver(templateViewResolver());
		templateEngine.setEnableSpringELCompiler(true);
		return templateEngine;
	}
	
	@Bean
	public ThymeleafViewResolver thymeleafResolver() {
		ThymeleafViewResolver thymeleafResolver = new ThymeleafViewResolver();
		thymeleafResolver.setTemplateEngine(templateEngine());
		return thymeleafResolver;
	}
	
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		
		registry.addResourceHandler(
									"/css/**",
									"/files/**",
									"/img/**", 
									"/js/**",
									"/views/**")
		.addResourceLocations(
							  "classpath:/static/css/",
							  "classpath:/static/files/",
							  "classpath:/static/img/",
							  "classpath:/static/js/",
							  "classpath:/webapp/WEB-INF/views"); 
		        
	}
	
}
