package com.neoingen.cl.processor;

import com.neoingen.cl.model.Report;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.item.ItemProcessor;

public class CustomItemProcessor implements ItemProcessor<Report, Report> {
    
    private static final Logger LOGGER = LoggerFactory.getLogger(CustomItemProcessor.class);

    @Override
    public Report process(Report item) throws Exception {

        LOGGER.debug("Processing..." + item);
        return item;
    }
}
