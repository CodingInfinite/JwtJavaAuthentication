package restServices;

import models.Device;
import response.AuthorizationResponse;
import response.BaseResponse;
import response.DeviceCollectionResponse;
import util.JwTokenHelper;

import javax.ws.rs.HeaderParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.Arrays;

@Path("/")
public class HomeApiService extends BaseApiService {

    private static final String USERNAME = "username";
    private static final String PASSWORD = "password";

    @POST
    @Path(value = "authorization_service")
    @Produces(MediaType.APPLICATION_JSON)
    public Response authorizationService(@HeaderParam(USERNAME) String userName, @HeaderParam(PASSWORD) String password) {
        if (userName.isEmpty())
            return getResponse(new BaseResponse(USERNAME + " field cannot be empty", BaseResponse.FAILURE));
        else if (password.isEmpty())
            return getResponse(new BaseResponse(PASSWORD + " field cannot be empty", BaseResponse.FAILURE));
        String privateKey = JwTokenHelper.getInstance().generatePrivateKey(userName, password);
        return getResponse(new AuthorizationResponse(BaseResponse.SUCCESS, "You're authenticated successfully. Private key will be valid for 30 mins", privateKey));
    }

    @POST
    @Path("allDevices")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllDevices() {
        System.out.println("Method called");
        return getResponse(new DeviceCollectionResponse(Arrays.asList(new Device("Electric Kettle", 1, true), new Device("Computer", 2, true), new Device("Motorcycle", 3, false), new Device("Sandwich Maker", 4, true))));
    }
}
