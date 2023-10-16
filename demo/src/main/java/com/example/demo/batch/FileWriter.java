package com.example.demo.batch;

import org.springframework.batch.item.Chunk;
import org.springframework.batch.item.ItemWriter;
import org.springframework.stereotype.Component;

import java.io.File;

@Component
public class FileWriter implements ItemWriter<File> {

    @Override
    public void write(Chunk<? extends File> chunk) throws Exception {

    }
}
