package com.neoingen.cl.execute;

import java.nio.file.FileSystems;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersInvalidException;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.batch.core.repository.JobExecutionAlreadyRunningException;
import org.springframework.batch.core.repository.JobInstanceAlreadyCompleteException;
import org.springframework.batch.core.repository.JobRestartException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Procedure {

    private static final Logger LOGGER = LoggerFactory.getLogger(Procedure.class);
    private ApplicationContext context;

    public void process() {
//        FixedLengthTokenizer fixedLengthTokenizer = new FixedLengthTokenizer();

        float version = 0.52f;
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        Date date = new Date();
        LOGGER.debug("\n\n\n\n##################################### INICIO INICIO INICIO INICIO\n"
                + "inicio de Spring Batch [FLAT] - ver " + version + " at " + date.toString()
                + "\n##################################### INICIO INICIO INICIO INICIO\n\n");

        context = new ClassPathXmlApplicationContext("spring"
                + FileSystems.getDefault().getSeparator()
                + "job-hello-world.xml");

        JobLauncher jobLauncher = (JobLauncher) context.getBean("jobLauncher");
        Job job = (Job) context.getBean("helloWorldJob");

        try {

            JobExecution execution = jobLauncher.run(job, new JobParameters());
            System.out.println("Exit Status : " + execution.getStatus());

        } catch (JobParametersInvalidException e) {
            LOGGER.debug(e.getLocalizedMessage());
        } catch (JobExecutionAlreadyRunningException e) {
            LOGGER.debug(e.getLocalizedMessage());
        } catch (JobInstanceAlreadyCompleteException e) {
            LOGGER.debug(e.getLocalizedMessage());
        } catch (JobRestartException e) {
            LOGGER.debug(e.getLocalizedMessage());
        }

        date = new Date();
        LOGGER.debug("\n\n\n\n##################################### TERMINO TERMINO TERMINO TERMINO\n"
                + "termino de Spring Batch [FLAT] - ver " + version + " at " + date.toString()
                + "\n##################################### TERMINO TERMINO TERMINO TERMINO\n\n");
    }
}
