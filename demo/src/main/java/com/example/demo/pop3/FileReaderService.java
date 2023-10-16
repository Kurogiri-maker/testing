package com.example.demo.pop3;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.apache.pdfbox.pdfparser.PDFParser;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.util.PDFTextStripper;
import org.springframework.batch.item.file.LineMapper;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileReaderService {

    public static List<Partner> readCSV(InputStream is) throws IOException {

        BufferedReader fileReader = new BufferedReader(new InputStreamReader(is));
        CSVParser csvParser = new CSVParser(fileReader,CSVFormat.DEFAULT.withFirstRecordAsHeader().withIgnoreHeaderCase().withTrim());
        List<Partner> partners = new ArrayList<>();
        for(CSVRecord record: csvParser.getRecords()){
            Partner partner = new Partner(
                    null,
                    record.get("name"),
                    record.get("email"),
                    record.get("date")
            );

            partners.add(partner);
        }

        return partners;
    }

    public static Partner processPDFAsCSV(InputStream is) throws Exception {
        PDDocument pdf = PDDocument.load(is);
        PDFTextStripper textStripper = new PDFTextStripper();
        String content = textStripper.getText(pdf);
        pdf.close();

        BufferedReader reader = new BufferedReader(new StringReader(content));
        String  line = reader.readLine();
        LineMapper<Partner> lineMapper = CSVLineTokenizer.createLineMapper();

        return lineMapper.mapLine(reader.readLine(), 0);

    }
}
