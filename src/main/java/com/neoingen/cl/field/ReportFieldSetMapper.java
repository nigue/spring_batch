package com.neoingen.cl.field;

import com.neoingen.cl.model.Report;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.item.file.mapping.FieldSetMapper;
import org.springframework.batch.item.file.transform.FieldSet;
import org.springframework.validation.BindException;

public class ReportFieldSetMapper implements FieldSetMapper<Report> {
    
    private SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
    private static final Logger LOGGER = LoggerFactory.getLogger(ReportFieldSetMapper.class);
    
    @Override
    public Report mapFieldSet(FieldSet fieldSet) throws BindException {
        
        Report report = new Report();
        report.setIsin(fieldSet.readString("ISIN"));
        report.setQuantity(fieldSet.readInt("Quantity"));
        report.setPrice(fieldSet.readLong("Price"));
        report.setCustomer(fieldSet.readString("Customer"));
        return report;
        
    }
}
