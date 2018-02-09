package com.ms.springbootbatch.config;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobExecutionListener;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.ms.springbootbatch.listener.JobCompletionListener;
import com.ms.springbootbatch.model.Customer;
import com.ms.springbootbatch.step.BatchProcessor;
import com.ms.springbootbatch.step.FileReader;
import com.ms.springbootbatch.step.DBWriter;

@Configuration
public class BatchConfig {

	@Autowired
	public JobBuilderFactory jobBuilderFactory;

	@Autowired
	public StepBuilderFactory stepBuilderFactory;

	@Bean
	public JobExecutionListener listener() {
		return new JobCompletionListener();
	}
	
	
	@Bean
	public Job importUserJob(JobCompletionListener listener) {
	        return jobBuilderFactory.get("importUserJob")
	                .incrementer(new RunIdIncrementer())
	                .listener(listener)
	                .flow(step1())
	                .end()
	                .build();
	    }
	  
	  @Bean
	    public BatchProcessor processor() {
	        return new BatchProcessor();
	    }
	  
	  @Bean
		public Job processJob() {
			return jobBuilderFactory.get("processJob")
					.incrementer(new RunIdIncrementer()).listener(listener())
					.flow(step1()).end().build();
		}

	    @Bean
	    public Step step1() {
	        return stepBuilderFactory.get("step1")
	                .<Customer, Customer> chunk(5)
	                .reader(new FileReader().read())
	                .processor(new BatchProcessor())
	                .writer(new DBWriter())
	                .build();
	    }


}