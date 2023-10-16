package com.example.demo.pop3;

import org.springframework.batch.item.file.mapping.FieldSetMapper;
import org.springframework.batch.item.file.transform.FieldSet;

public class OffreFieldSetMapper implements FieldSetMapper<Partner> {
    @Override
    public Partner mapFieldSet(FieldSet fieldSet){
        Partner p = new Partner();
        p.setName(fieldSet.readString("name"));
        p.setEmail(fieldSet.readString("email"));
        p.setDate(fieldSet.readString("date"));
        return p;
    }
}
