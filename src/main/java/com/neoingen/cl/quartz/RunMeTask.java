package com.neoingen.cl.quartz;

import com.neoingen.cl.execute.Procedure;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class RunMeTask {
    private static final Logger LOGGER = LoggerFactory.getLogger(RunMeTask.class);

    public void execute() {
        Procedure procedure = new Procedure();
        procedure.process();
    }
}
