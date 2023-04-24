package com.dbms.project1.v1.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.dbms.project1.v1.dao.DbmsDaoImplememts;
import com.dbms.project1.v1.dao.DbmsDaoInterface;
import com.dbms.project1.v1.repository.StudentRepository;

@Configuration
public class MyConfiguration {
    
    @Bean
    public StudentRepository studentRepository() {
        return new StudentRepositoryImpl(); // replace with your implementation class
    }
    
    @Bean
    public DbmsDaoInterface dbmsdaointerface() {
        return new DbmsDaoImplememts(); // replace with your implementation class
    }
    
}	
