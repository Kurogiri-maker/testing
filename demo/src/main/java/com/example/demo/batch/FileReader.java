package com.example.demo.batch;

import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.NonTransientResourceException;
import org.springframework.batch.item.ParseException;
import org.springframework.batch.item.UnexpectedInputException;
import org.springframework.batch.item.support.IteratorItemReader;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@Slf4j
public class FileReader implements ItemReader<Product> {

    private IteratorItemReader reader ;


    @Override
    public Product read() throws Exception, UnexpectedInputException, ParseException, NonTransientResourceException {
        log.info("Reading");
        List<Product> products = new ArrayList<>();
        Product p = new Product(1L,"pen","you can use it to write",33);
        products.add(p);
        reader = new IteratorItemReader<>(products);
//        reader = new FlatFileItemReader<>();
//        reader.setResource(new ClassPathResource("input.txt"));
//        reader.setLinesToSkip(1);
//
//        DefaultLineMapper<Product> lineMapper = new DefaultLineMapper<>();
//        DelimitedLineTokenizer lineTokenizer = new DelimitedLineTokenizer();
//        lineTokenizer.setNames(new String[]{"PRODUCT_ID", "NAME", "DESCRIPTION", "PRICE"});
//
//        lineMapper.setLineTokenizer(lineTokenizer);
//        lineMapper.setFieldSetMapper(new ProductFieldSetMapper());
//
//        reader.setLineMapper(lineMapper);

        return (Product) reader.read();
    }
}
