package com.example.demo.batch;

import org.springframework.batch.item.file.mapping.FieldSetMapper;
import org.springframework.batch.item.file.transform.FieldSet;

import java.net.BindException;

public class ProductFieldSetMapper implements FieldSetMapper<Product> {

    @Override
    public Product mapFieldSet(FieldSet fieldSet){
//        Product product = new Product();
//        product.setId(fieldSet.readString("PRODUCT_ID"));
//        product.setName(fieldSet.readString("NAME"));
//        product.setDescription(fieldSet.readString("DESCRIPTION"));
//        product.setPrice(fieldSet.readBigDecimal("PRICE"));
        return null;
    }
}