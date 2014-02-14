package com.neoingen.cl.context;

import java.nio.file.FileSystems;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class GlobalContext {
    
    private ApplicationContext context;

    public GlobalContext(String contextName) {
       this.context = new ClassPathXmlApplicationContext("spring"
                + FileSystems.getDefault().getSeparator()
                + contextName + ".xml");
    }

    public ApplicationContext getContext() {
        return context;
    }
    
}
