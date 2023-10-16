//package com.example.demo;
//
//import org.springframework.batch.core.*;
//import org.springframework.batch.core.launch.JobLauncher;
//import org.springframework.batch.core.repository.JobExecutionAlreadyRunningException;
//import org.springframework.batch.core.repository.JobInstanceAlreadyCompleteException;
//import org.springframework.batch.core.repository.JobRestartException;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.scheduling.annotation.Scheduled;
//
//import java.util.Date;
//
//@Configuration
//public class AppConfig {
//
//    @Autowired
//    private Job myJob;
//
//    @Autowired
//    private Step myStep;
//
//    @Autowired
//    private JobLauncher jobLauncher;
//
//
////    @Scheduled(cron = "0 0/1 * 1/1 *  *")
//    public void run() throws JobInstanceAlreadyCompleteException, JobExecutionAlreadyRunningException, JobParametersInvalidException, JobRestartException {
//        System.out.println("Job Started at :" + new Date());
//        JobParameters jobParameters = new JobParametersBuilder()
//                .addLong("time", System.currentTimeMillis())
//                .toJobParameters();
//        JobExecution jobExecution = jobLauncher.run(myJob,jobParameters);
//        System.out.println("Job Status :" + jobExecution.getStatus());
//    }
//}
