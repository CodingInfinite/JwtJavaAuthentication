package models;

public class Device {

    private String deviceName;
    private int id;
    private boolean electricable;

    public Device(String deviceName, int id, boolean electricable) {
        this.deviceName = deviceName;
        this.id = id;
        this.electricable = electricable;
    }

    public Device() {
    }

    public String getDeviceName() {
        return deviceName;
    }

    public void setDeviceName(String deviceName) {
        this.deviceName = deviceName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean isElectricable() {
        return electricable;
    }

    public void setElectricable(boolean electricable) {
        this.electricable = electricable;
    }

    @Override
    public String toString() {
        return "Device{" +
                "deviceName='" + deviceName + '\'' +
                ", id=" + id +
                ", electricable=" + electricable +
                '}';
    }
}
