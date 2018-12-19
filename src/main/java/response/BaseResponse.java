package response;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class BaseResponse {

    public static final int FAILURE = 0;
    public static final int SUCCESS = 1;

    private String message;
    private int status;

    public BaseResponse(String message, int status) {
        this.message = message;
        this.status = status;
    }

    public BaseResponse() {
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "BaseResponse{" +
                "message='" + message + '\'' +
                ", status=" + status +
                '}';
    }
}
