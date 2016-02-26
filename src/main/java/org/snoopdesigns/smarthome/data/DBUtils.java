package org.snoopdesigns.smarthome.data;

import java.util.ArrayList;
import java.util.List;

public class DBUtils {

    private List<Data> data = new ArrayList<Data>();

    public List<Data> getData() {
        return data;
    }

    public void addNewData(
            String timestamp,
            String voltage1,
            String voltage2,
            String temp, String hum) {
        Data toAdd = new Data(timestamp, voltage1, voltage2, temp, hum);
        this.data.add(toAdd);
        System.out.println("New data added: " + toAdd);
    }

    public void destroy() {
        this.data.clear();
    }
}
