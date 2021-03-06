package com.mn.eshoppingbackend.config;

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

@Configuration
@ComponentScan(basePackages= {"com.mn.eshoppingbackend.dto"})
@EnableTransactionManagement
public class HibernateConfig {

	//change the below based on the DBMS you choose
	private final String DATABASE_URL = "jdbc:h2:tcp://localhost/~/eshopping";
	private final String DATABASE_DRIVER ="org.h2.Driver";
	private final String DATABASE_DIALECT ="org.hibernate.dialect.H2Dialect";
	private final String DATABASE_USERNAME ="sa";
	private final String DATABASE_PASSWORD ="";
	
	//dataSource bean will be available
	@Bean("dataSource")
	public DataSource getDataSource() {
		
		BasicDataSource dataSource = new BasicDataSource();
		
		//Providing the Database Connection Information
		dataSource.setDriverClassName(DATABASE_DRIVER);
		dataSource.setUrl(DATABASE_URL);
		dataSource.setUsername(DATABASE_USERNAME);
		dataSource.setPassword(DATABASE_PASSWORD);
		
		return dataSource;
	}
	
	//sessionFactory bean will be available
	
	@Bean
	public SessionFactory getSessionFactory(DataSource dataSource) {
		
		LocalSessionFactoryBuilder builder = new LocalSessionFactoryBuilder(dataSource);
		builder.addProperties(getHibernateProperties());
		builder.scanPackages("com.mn.eshoppingbackend.dto");
		return builder.buildSessionFactory();
	}
	
	// All the hibernate properties will be returned in this method
	private Properties getHibernateProperties() {
		
		Properties properties = new Properties();
		
		properties.put("hibernate.dialect", DATABASE_DIALECT);
		properties.put("hibernate.show_sql", "true");
		properties.put("hibernate.format_sql", "true");
		
		/* To understand the mapping and let the hibernate create the tables for us
		* values :- update - create table if not exist or update if any changes are there to existing one.
		* 			create - drop the existing tables and re-create it.
		*/
		properties.put("hibernate.hbm2ddl.auto", "update");
		
		return properties;
	}
	
	// TransactionManager bean
	
	@Bean
	public HibernateTransactionManager getTransactionManager(SessionFactory sessionFactory) {
		
		HibernateTransactionManager txManager = new HibernateTransactionManager(sessionFactory);
		return txManager;
	}
}
