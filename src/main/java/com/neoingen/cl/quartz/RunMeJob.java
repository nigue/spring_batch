package com.neoingen.cl.quartz;

import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.quartz.StatefulJob;
import org.springframework.scheduling.quartz.QuartzJobBean;

public class RunMeJob extends QuartzJobBean implements StatefulJob{

    private RunMeTask runMeTask;

    public void setRunMeTask(RunMeTask runMeTask) {
        this.runMeTask = runMeTask;
    }

    @Override
    protected void executeInternal(JobExecutionContext context)
            throws JobExecutionException {

        runMeTask.execute();

    }
}