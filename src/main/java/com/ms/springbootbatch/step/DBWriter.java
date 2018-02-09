package com.ms.springbootbatch.step;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.batch.item.ItemWriter;
import org.springframework.batch.item.database.BeanPropertyItemSqlParameterSourceProvider;
import org.springframework.batch.item.database.JdbcBatchItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;

import com.ms.springbootbatch.model.Customer;

public class DBWriter implements ItemWriter<Customer> {
	
	 @Autowired
	 public DataSource dataSource;


	@Override
	public void write(List<? extends Customer> messages) throws Exception {
		for (Customer msg : messages) {
			System.out.println("We have installed "+msg.getDcNum()+" Datacenters at " 
					+ msg.getCunstomerLocation() + " location for our loyal customer ::: "+ msg.getCustomerName());
		}
	}
	
	
	@Bean
    public JdbcBatchItemWriter<Customer> writer() {
        JdbcBatchItemWriter<Customer> writer = new JdbcBatchItemWriter<Customer>();
        writer.setItemSqlParameterSourceProvider(new BeanPropertyItemSqlParameterSourceProvider<Customer>());
        writer.setSql("INSERT INTO people (first_name, last_name) VALUES (:firstName, :lastName)");
        writer.setDataSource(dataSource);
        return writer;
    }

}