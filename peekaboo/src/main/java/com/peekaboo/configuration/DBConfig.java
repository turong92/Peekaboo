package com.peekaboo.configuration;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

@Configuration
public class DBConfig {
	
	@Autowired
	GlobalPropertySource globalPropertySource;
	
	@Autowired
	private ApplicationContext applicationContext;
	
	@Bean
	public HikariConfig hikariConfig() {
		HikariConfig hikariConfig = new HikariConfig();
		hikariConfig.setDriverClassName(globalPropertySource.getDriverClassName());
		hikariConfig.setJdbcUrl(globalPropertySource.getUrl());
		hikariConfig.setUsername(globalPropertySource.getUsername());
		hikariConfig.setPassword(globalPropertySource.getPassword());
		return hikariConfig;
	}
	
	@Bean
	@Primary
	public DataSource customDataSource() {
		return new HikariDataSource(hikariConfig());
	}
	
	@Bean
	public SqlSessionFactory sqlSessionFactory() throws Exception {
		SqlSessionFactoryBean factoryBean = new SqlSessionFactoryBean();
		factoryBean.setDataSource(customDataSource());
		factoryBean.setMapperLocations(applicationContext.getResources("classpath:/mappers/**/*Mapper.xml"));
		factoryBean.setTypeAliasesPackage("com.peekaboo.domain");
		factoryBean.setConfiguration(mybatisConfig());
		return factoryBean.getObject();
	}

	

	@Bean
	public SqlSessionTemplate sqlSession() throws Exception {
		return new SqlSessionTemplate(sqlSessionFactory());
	}
	
	@Bean
	@ConfigurationProperties(prefix = "mybatis.configuration")
	public org.apache.ibatis.session.Configuration mybatisConfig() {
		return new org.apache.ibatis.session.Configuration();
	}
	
	/*
	 * public DataSource dataSource(){ HikariConfig hikariConfig = new
	 * HikariConfig();
	 * hikariConfig.setDriverClassName("oracle.jdbc.driver.OracleDriver");
	 * hikariConfig.setJdbcUrl("jdbc:oracle:thin:@ip:port:SID");
	 * hikariConfig.setUsername("id"); hikariConfig.setPassword("password");
	 * //hikariConfig.setMaximumPoolSize(5);
	 * //hikariConfig.setConnectionTestQuery("SELECT 1");
	 * //hikariConfig.setPoolName("springHikariCP"); HikariDataSource dataSource =
	 * new HikariDataSource(hikariConfig); return dataSource; }
	 */

	
//	@Bean
//	@ConfigurationProperties(prefix = "spring.datasource.hikari")
//	public HikariConfig hikariConfig() {
//		return new HikariConfig();
//	}
//	
//	@Bean
//	public DataSource dataSource() {
//		return new HikariDataSource(hikariConfig());
//	}
//	
//	@Bean
//	public SqlSessionFactory sqlSessionFactory() throws Exception {
//		SqlSessionFactoryBean factoryBean = new SqlSessionFactoryBean();
//		factoryBean.setDataSource(dataSource());
//		
//		return factoryBean.getObject();
//	}
//	
//	@Bean
//	public SqlSessionTemplate sqlSession() throws Exception {
//		return new SqlSessionTemplate(sqlSessionFactory());
//	}
	
// 이거 참조함
//	@Bean
//    public SqlSessionFactory sqlSessionFactory(DataSource customDataSource) throws Exception {
//        final SqlSessionFactoryBean sessionFactory = new SqlSessionFactoryBean();
//        sessionFactory.setDataSource(customDataSource);
//        PathMatchingResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
//        sessionFactory.setMapperLocations(resolver.getResources("classpath:mybatis/mapper/*.xml"));
//        return sessionFactory.getObject();
//    }
//    
//    @Bean
//    public SqlSessionTemplate sqlSessionTemplate(SqlSessionFactory sqlSessionFactory) throws Exception {
//      final SqlSessionTemplate sqlSessionTemplate = new SqlSessionTemplate(sqlSessionFactory);
//      return sqlSessionTemplate;
//    }

}
