//package com.example.demo;
//
//import com.example.demo.batch.FileProcessor;
//import com.example.demo.batch.FileReader;
//import com.example.demo.batch.FileWriter;
//import com.example.demo.batch.Product;
//import org.springframework.batch.core.Job;
//import org.springframework.batch.core.Step;
//import org.springframework.batch.core.job.builder.JobBuilder;
//import org.springframework.batch.core.launch.support.RunIdIncrementer;
//import org.springframework.batch.core.repository.JobRepository;
//import org.springframework.batch.core.repository.support.JobRepositoryFactoryBean;
//import org.springframework.batch.core.step.builder.StepBuilder;
//import org.springframework.batch.support.transaction.ResourcelessTransactionManager;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.jdbc.datasource.DataSourceTransactionManager;
//import org.springframework.transaction.PlatformTransactionManager;
//
//import javax.sql.DataSource;
//import java.io.File;
//
//@Configuration
//public class BatchConfig {
//
//
//    @Autowired
//    private FileReader reader;
//
//    @Autowired
//    private FileProcessor processor;
//
//    @Autowired
//    private FileWriter writer;
//
//    @Autowired
//    private DataSource dataSource;
//
//    @Bean
//    public PlatformTransactionManager transactionManager(){
//        return new DataSourceTransactionManager(dataSource);
//    }
//
//    @Bean
//    public JobRepository jobRepository() throws Exception {
//        JobRepositoryFactoryBean factory = new JobRepositoryFactoryBean();
//        factory.setDataSource(dataSource);
//        factory.setTransactionManager(transactionManager());
//        factory.setIsolationLevelForCreate("ISOLATION_DEFAULT");
//        factory.afterPropertiesSet();
//        return factory.getObject();
//    }
//
//    @Bean
//    public Job myJob() throws Exception {
//        return new JobBuilder("myJob",jobRepository())
//                .start(myStep())
//                .build();
//    }
//
//    @Bean
//    public Step myStep() throws Exception {
//        return new StepBuilder("myStep",jobRepository())
//                .<Product, File>chunk(1,transactionManager())
//                .reader(reader)
//                .processor(processor)
//                .writer(writer)
//                .build();
//    }
//
//}
