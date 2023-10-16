package com.example.demo.pop3;

import org.springframework.batch.item.file.LineMapper;
import org.springframework.batch.item.file.mapping.DefaultLineMapper;
import org.springframework.batch.item.file.transform.DelimitedLineTokenizer;

public class CSVLineTokenizer {

    public static LineMapper<Partner> createLineMapper(){
        DefaultLineMapper<Partner> lineMapper = new DefaultLineMapper<>();
        DelimitedLineTokenizer lineTokenizer = new DelimitedLineTokenizer();
        lineTokenizer.setDelimiter(",");
        lineTokenizer.setNames("name","email","date");
        lineMapper.setLineTokenizer(lineTokenizer);
        lineMapper.setFieldSetMapper(new OffreFieldSetMapper());

        return lineMapper;
    }
}
