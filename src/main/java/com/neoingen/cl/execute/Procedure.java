package com.neoingen.cl.execute;

import com.neoingen.cl.context.GlobalContext;
import com.neoingen.cl.file.FileStorage;
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

public class Procedure {

    private FileStorage fileStorage;
    private static final Logger LOGGER = LoggerFactory.getLogger(Procedure.class);

    public void process() {

        float version = 0.571f;
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        Date date = new Date();
        LOGGER.debug("\n\n\n\n##################################### INICIO INICIO INICIO INICIO\n"
                + "inicio de Spring Batch [FLAT] - ver " + version + " at " + date.toString()
                + "\n##################################### INICIO INICIO INICIO INICIO\n\n");

        setFileStorage(new FileStorage());
        
        if (getFileStorage().getData().isEmpty()){
            LOGGER.debug("No hay datos en data in");
        }
        
        GlobalContext context = new GlobalContext("job-hello-world");

        JobLauncher jobLauncher = (JobLauncher) context.getContext().getBean("jobLauncher");
        Job job = (Job) context.getContext().getBean("helloWorldJob");

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

        getFileStorage().moveFiles();
        
        date = new Date();
        LOGGER.debug("\n\n\n\n##################################### TERMINO TERMINO TERMINO TERMINO\n"
                + "termino de Spring Batch [FLAT] - ver " + version + " at " + date.toString()
                + "\n##################################### TERMINO TERMINO TERMINO TERMINO\n\n");
    }

    public FileStorage getFileStorage() {
        return fileStorage;
    }

    public void setFileStorage(FileStorage fileStorage) {
        this.fileStorage = fileStorage;
    }
}
