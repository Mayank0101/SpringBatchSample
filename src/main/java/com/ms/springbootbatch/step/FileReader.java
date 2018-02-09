package com.ms.springbootbatch.step;

import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.mapping.BeanWrapperFieldSetMapper;
import org.springframework.batch.item.file.mapping.DefaultLineMapper;
import org.springframework.batch.item.file.transform.DelimitedLineTokenizer;
import org.springframework.context.annotation.Bean;
import org.springframework.core.io.ClassPathResource;

import com.ms.springbootbatch.model.Customer;

public class FileReader {

	 @Bean
	 public FlatFileItemReader<Customer> read() {
	        FlatFileItemReader<Customer> reader = new FlatFileItemReader<Customer>();
	        reader.setResource(new ClassPathResource("sample-data.csv"));
	        reader.setLineMapper(new DefaultLineMapper<Customer>() {{
	            setLineTokenizer(new DelimitedLineTokenizer() {{
	                setNames(new String[] { "customerName", "customerLocation" });
	            }});
	            setFieldSetMapper(new BeanWrapperFieldSetMapper<Customer>() {{
	                setTargetType(Customer.class);
	            }});
	        }});
	        return reader;
	    }

}