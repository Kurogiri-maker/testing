package com.example.demo.batch;

import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.HashMap;
import java.util.Map;

@CrossOrigin("*")
@RestController
@Slf4j
public class UploadFileController {




    private static final Logger logger = LoggerFactory.getLogger(UploadFileController.class);

    @PostMapping("/upload")
    public ResponseEntity<Map<String,String>> uploadFile(@RequestParam("file")MultipartFile file){
        Map<String,String> response = new HashMap<>();
        response.put("message","success");
        logger.info(String.valueOf(file.getSize())); ;
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }


    @GetMapping
    public Map<String,String> getFile() throws JsonProcessingException {
        Map<String,String> response =  new HashMap<>();
        response.put("file","file.txt");
        return response;

    }
}
