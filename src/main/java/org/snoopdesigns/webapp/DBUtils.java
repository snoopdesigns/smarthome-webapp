package org.snoopdesigns.webapp;

import java.util.ArrayList;
import java.util.List;

public class DBUtils {

    private List<String> data = new ArrayList<String>();

    public List<String> getData() {
        return data;
    }

    public void addNewData(String data) {
        this.data.add(data);
        System.out.println("New data added: " + data);
    }

    public void destroy() {
        this.data.clear();
    }
}
