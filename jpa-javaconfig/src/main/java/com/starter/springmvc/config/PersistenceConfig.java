package com.starter.springmvc.config;

import java.util.Properties;

import javax.persistence.EntityManagerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@PropertySource("classpath:jdbc.properties")
@EnableTransactionManagement
@EnableJpaRepositories(basePackages = { "com.starter.springmvc.persistence.repository" })
public class PersistenceConfig {

	@Autowired
	Environment env;

	@Bean(name = "dataSource")
	public DriverManagerDataSource dataSource() {
		DriverManagerDataSource ds = new DriverManagerDataSource();
		ds.setDriverClassName(env.getProperty("jdbc.driverClassName"));
		ds.setUrl(env.getProperty("jdbc.url"));
		ds.setUsername(env.getProperty("jdbc.username"));
		ds.setPassword(env.getProperty("jdbc.password"));
		return ds;
	}

	@Bean
	public EntityManagerFactory entityManagerFactory() {		
		
		LocalContainerEntityManagerFactoryBean factory = new LocalContainerEntityManagerFactoryBean();
		factory.setDataSource(dataSource());
		factory.setJpaVendorAdapter(jpaAdapter());
		factory.setPackagesToScan("com.starter.springmvc.persistence.domain");
		factory.setJpaProperties(jpaProperties());
		factory.afterPropertiesSet();

		return factory.getObject();
	}

	@Bean
	public PlatformTransactionManager transactionManager() {

		JpaTransactionManager txManager = new JpaTransactionManager();
		txManager.setEntityManagerFactory(entityManagerFactory());
		return txManager;
	}
	
	 @Bean
	 public JpaVendorAdapter jpaAdapter() {
		 HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
		 vendorAdapter.setGenerateDdl(true);
		 vendorAdapter.setShowSql(true);
		 return vendorAdapter;
	 }
	 
	 public Properties jpaProperties() {
		 Properties properties = new Properties();
		 properties.put("hibernate.hbm2ddl.auto", env.getProperty("hibernate.hbm2ddl.auto"));
		 return properties;
	 }

}
