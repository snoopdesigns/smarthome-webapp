package org.snoopdesigns.smarthome.data;

import java.util.List;

public class DBUtils {

    private PostgresUtils postgresUtils;

    public DBUtils() {
        this.postgresUtils = new PostgresUtils();
        this.postgresUtils.initTables();
    }

    public List<Data> getData() {
        return postgresUtils.getAllData();
    }

    public void addNewData(
            String voltage1,
            String voltage2,
            String temp, String hum) {
        Data toAdd = new Data("", voltage1, voltage2, temp, hum);
        this.postgresUtils.insertNewData(toAdd);
        System.out.println("New data added: " + toAdd);
    }

    public void destroy() {
        //this.data.clear();
    }
}
