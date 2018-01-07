package com.dbproject5.cloud;

import java.util.Properties;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate4.HibernateTransactionManager;
import org.springframework.orm.hibernate4.LocalSessionFactoryBean;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
@Configuration
@EnableTransactionManagement
public class SpringBootHibernateConfig {
	
	  	@Value("${spring.datasource.driver-class-name}")
	    private String DRIVER;
	 
	    @Value("${spring.datasource.password}")
	    private String PASSWORD;
	 
	    @Value("${spring.datasource.url}")
	    private String URL;
	 
	    @Value("${spring.datasource.username}")
	    private String USERNAME;
	 
	    @Value("${spring.jpa.properties.hibernate.dialect}")
	    private String DIALECT;
	 
	    @Value("${hibernate.show_sql}")
	    private String SHOW_SQL;
	 
	    @Value("${hibernate.hbm2ddl.auto}")
	    private String HBM2DDL_AUTO;
	 
	    @Value("${entitymanager.packagesToScan}")
	    private String PACKAGES_TO_SCAN;
	 
	    @Bean
	    public DataSource dataSource() {
	        DriverManagerDataSource dataSource = new DriverManagerDataSource();
	        dataSource.setDriverClassName(DRIVER);
	        dataSource.setUrl(URL);
	        dataSource.setUsername(USERNAME);
	        dataSource.setPassword(PASSWORD);
	        return dataSource;
	    }
	 
	    @Bean
	    public LocalSessionFactoryBean sessionFactory() {
	        LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
	        sessionFactory.setDataSource(dataSource());
	        sessionFactory.setPackagesToScan(PACKAGES_TO_SCAN);
	        Properties hibernateProperties = new Properties();
	        hibernateProperties.put("hibernate.dialect", DIALECT);
	        hibernateProperties.put("hibernate.show_sql", SHOW_SQL);
	        hibernateProperties.put("hibernate.hbm2ddl.auto", HBM2DDL_AUTO); //hibernate.default_schema
	        hibernateProperties.put("hibernate.default_schema", "DBMS_FINAL_PROJV1");
	        sessionFactory.setHibernateProperties(hibernateProperties);
	 
	        return sessionFactory;
	    }
	   @Bean
	    public EntityManagerFactory entityManagerFactory() {

	      HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
	      vendorAdapter.setGenerateDdl(true);

	      LocalContainerEntityManagerFactoryBean factory = new LocalContainerEntityManagerFactoryBean();
	      factory.setJpaVendorAdapter(vendorAdapter);
	      factory.setPackagesToScan("com");
	      factory.setDataSource(dataSource());
	      factory.afterPropertiesSet();

	      return factory.getObject();
	    }
	    @Bean
	    public PlatformTransactionManager transactionManager() {

	      JpaTransactionManager txManager = new JpaTransactionManager();
	      txManager.setEntityManagerFactory(entityManagerFactory());
	      return txManager;
	    } 
	 
//	    @Bean
//	    public HibernateTransactionManager transactionManager() {
//	        HibernateTransactionManager transactionManager = new HibernateTransactionManager();
//	        transactionManager.setSessionFactory(sessionFactory().getObject());
//	        return transactionManager;
	//    }	
}