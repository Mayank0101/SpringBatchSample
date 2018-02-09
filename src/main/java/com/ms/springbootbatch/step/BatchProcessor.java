package com.ms.springbootbatch.step;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.item.ItemProcessor;

import com.ms.springbootbatch.model.Customer;

public class BatchProcessor implements ItemProcessor<Customer, Customer> {
	 private static final Logger log = LoggerFactory.getLogger(BatchProcessor.class);

	@Override
	public Customer process(Customer data) throws Exception {
		log.info("Data transofrmation. Appending number of datacenters at the customer location.");
		Customer newData = new Customer();
		newData.setDcNum("#"+data.getCunstomerLocation().length()+"#");
		newData.setCunstomerLocation(data.getCunstomerLocation().toUpperCase());
		newData.setCustomerName(data.getCustomerName().toUpperCase());
		
		return newData;
	}

}