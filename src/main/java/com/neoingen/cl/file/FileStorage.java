package com.neoingen.cl.file;

import com.neoingen.cl.context.GlobalContext;
import com.neoingen.cl.pojo.file.data.Storage;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class FileStorage {

    private List<File> data = new ArrayList<File>();
    private Storage storage;
    private static final Logger LOGGER = LoggerFactory.getLogger(FileStorage.class);

    public FileStorage() {

        GlobalContext context = new GlobalContext("propertiesContext");
        this.storage = (Storage) context.getContext().getBean("storage");

        File[] files = new File(this.storage.getDataIn()).listFiles();

        if (files != null) {
            this.data.addAll(Arrays.asList(files));
        }

    }

    public void moveFiles() {

        for (File afile : getData()) {
            try {

                if (afile.renameTo(new File(getStorage().getDataOut() + afile.getName()))) {
                    LOGGER.debug("File is moved successful!");
                } else {
                    LOGGER.debug("File is failed to move!");
                }

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        
    }

    public Storage getStorage() {
        return storage;
    }

    public void setStorage(Storage storage) {
        this.storage = storage;
    }

    public List<File> getData() {
        return data;
    }

    public void setData(List<File> data) {
        this.data = data;
    }
}
