package com.example.demo.batch;

import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.stereotype.Component;

import java.io.File;


@Component
@Slf4j
public class FileProcessor implements ItemProcessor<Product, File> {
    @Override
    public File process(Product item) throws Exception {
        log.info("Product :"+item);
        return null;
    }
}
