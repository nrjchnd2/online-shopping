package com.neeraj.shoppingbackend.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;
import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBuilder;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.neeraj.shoppingbackend.dto.Category;
import com.neeraj.shoppingbackend.dto.Product;

@Configuration
@ComponentScan(basePackages={"com.neeraj.shoppingBackend.dto"})
@EnableTransactionManagement
public class HibernateConfig {

	private final static String DATABASE_URL="jdbc:mysql://localhost:3306/online_shopping";
	private final static String DATABASE_DRIVER="com.mysql.jdbc.Driver";
	private final static String DATABASE_DIALECT="org.hibernate.dialect.MySQLDialect";
	private final static String DATABASE_USERNAME="root";
	private final static String DATABASE_PASSWORD="naxi";

	@Bean
	public  DataSource getDataSource(){
		BasicDataSource dataSource=new BasicDataSource();
		dataSource.setDriverClassName(DATABASE_DRIVER);
		dataSource.setUrl(DATABASE_URL);
		dataSource.setUsername(DATABASE_USERNAME);
		dataSource.setPassword(DATABASE_PASSWORD);
		return dataSource;
	}
	
	@Bean(name="sessionFactory")
	public SessionFactory getSessionFactory (DataSource dataSource){
		System.out.println(dataSource);
		LocalSessionFactoryBuilder builder=new LocalSessionFactoryBuilder(dataSource);
		System.out.println("1");
		builder.addProperties(getHibernateProperties());
//		builder.setProperty("hibernate.dialect", DATABASE_DIALECT);
//		builder.setProperty("hibernate.show_sql", "true");
//		builder.setProperty("hibernate.format_sql", "true");
		System.out.println("2");
		//builder.scanPackages("com.neeraj.shoppingBackend.dto");
		builder.addAnnotatedClasses(Category.class,Product.class);
		System.out.println("3");
		System.out.println(builder);
		try{
		return builder.buildSessionFactory();
		}
		catch(Exception e){
			e.printStackTrace();
			return null;
		}
	}

	private Properties getHibernateProperties() {
		Properties properties=new Properties();
		properties.put("hibernate.dialect",DATABASE_DIALECT);
		properties.put("hibernate.show_sql","true");
		properties.put("hibernate.format_sql","true");
		
		
		
		return properties;
	}
	
	@Bean
	public HibernateTransactionManager getTransactionManager(SessionFactory sessionFactory){
		HibernateTransactionManager transactionManager=new HibernateTransactionManager(sessionFactory);
		return transactionManager;
	}
	
}
