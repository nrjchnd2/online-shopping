package com.neeraj.onlineShopping.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

import com.neeraj.onlineShopping.controller.MyController;
import com.neeraj.shoppingbackend.dao.CategoryDAO;
import com.neeraj.shoppingbackend.daoimpl.CategoryDAOImpl;

@Configuration
@ComponentScan(basePackageClasses={MyController.class,CategoryDAOImpl.class})
@EnableWebMvc
public class Conf extends WebMvcConfigurerAdapter{

	
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/static/**").addResourceLocations("/assets/");
	}
	@Bean
	public ViewResolver getViewResolver(){
		InternalResourceViewResolver i=new InternalResourceViewResolver();
		i.setViewClass(JstlView.class);
		i.setPrefix("/WEB-INF/views/");
		i.setSuffix(".jsp");
		return i;
	}
}