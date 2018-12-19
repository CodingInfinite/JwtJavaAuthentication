package response;

import models.Device;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.List;


@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class DeviceCollectionResponse {

    @XmlElement
    private List<Device> devices;

    public DeviceCollectionResponse(List<Device> devices) {
        this.devices = devices;
    }

    public DeviceCollectionResponse() {
    }

    public List<Device> getDevices() {
        return devices;
    }

    public void setDevices(ArrayList<Device> devices) {
        this.devices = devices;
    }

    @Override
    public String toString() {
        return "DeviceCollectionResponse{" +
                "devices=" + devices +
                '}';
    }
}
