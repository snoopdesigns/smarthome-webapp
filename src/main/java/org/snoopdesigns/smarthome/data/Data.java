package org.snoopdesigns.smarthome.data;

public class Data {

    String timestamp;
    String voltage1;
    String voltage2;
    String temperature;
    String humidity;

    public Data() {
    }

    public Data(String timestamp, String voltage1, String voltage2, String temperature, String humidity) {
        this.timestamp = timestamp;
        this.voltage1 = voltage1;
        this.voltage2 = voltage2;
        this.temperature = temperature;
        this.humidity = humidity;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public String getVoltage1() {
        return voltage1;
    }

    public void setVoltage1(String voltage1) {
        this.voltage1 = voltage1;
    }

    public String getVoltage2() {
        return voltage2;
    }

    public void setVoltage2(String voltage2) {
        this.voltage2 = voltage2;
    }

    public String getTemperature() {
        return temperature;
    }

    public void setTemperature(String temperature) {
        this.temperature = temperature;
    }

    public String getHumidity() {
        return humidity;
    }

    public void setHumidity(String humidity) {
        this.humidity = humidity;
    }

    @Override
    public String toString() {
        return "Data{" +
                "timestamp='" + timestamp + '\'' +
                ", voltage1='" + voltage1 + '\'' +
                ", voltage2='" + voltage2 + '\'' +
                ", temperature='" + temperature + '\'' +
                ", humidity='" + humidity + '\'' +
                '}';
    }
}
