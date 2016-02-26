package org.snoopdesigns.smarthome.data;

import java.util.ArrayList;
import java.util.List;

public class DBUtils {

    private List<String> voltageData = new ArrayList<String>();

    public List<String> getVoltageData() {
        return voltageData;
    }

    public void addNewVoltageData(String voltage1, String voltage2) {
        this.voltageData.add(voltage1 + ":" + voltage2);
        System.out.println("New data added: V1=" + voltage1 + ", V2=" + voltage2);
    }

    public void destroy() {
        this.voltageData.clear();
    }
}
