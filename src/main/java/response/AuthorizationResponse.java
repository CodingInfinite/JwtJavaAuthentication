package response;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class AuthorizationResponse extends BaseResponse {

    private String privateKey;

    public AuthorizationResponse() {
    }

    public AuthorizationResponse(int status, String message, String privateKey) {
        super(message, status);
        this.privateKey = privateKey;
    }

    public String getPrivateKey() {
        return privateKey;
    }

    public void setPrivateKey(String privateKey) {
        this.privateKey = privateKey;
    }

    @Override
    public String toString() {
        return "AuthorizationResponse{" +
                super.toString() +
                "privateKey='" + privateKey + '\'' +
                '}';
    }
}
