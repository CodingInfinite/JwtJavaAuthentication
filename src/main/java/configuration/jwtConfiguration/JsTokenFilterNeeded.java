package configuration.jwtConfiguration;

import com.sun.jersey.core.util.Priority;
import com.sun.jersey.spi.container.ContainerRequest;
import com.sun.jersey.spi.container.ContainerRequestFilter;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.MalformedJwtException;
import response.BaseResponse;
import util.JwTokenHelper;

import javax.ws.rs.Priorities;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.Provider;

@Provider
@JsonTokenNeeded
@Priority(Priorities.AUTHENTICATION)
public class JsTokenFilterNeeded implements ContainerRequestFilter {

    private static final String AUTHORIZATION_SERVICE_PATH = "authorization_service";
    private static final String PRIVATE_KEY = "privateKey";
    private JwTokenHelper jwTokenHelper = JwTokenHelper.getInstance();

    public ContainerRequest filter(ContainerRequest request) {
        String path = request.getPath();
        if (path.equals(AUTHORIZATION_SERVICE_PATH))
            return request;
        String privateKeyHeaderValue = request.getHeaderValue(PRIVATE_KEY);
        if (privateKeyHeaderValue == null || privateKeyHeaderValue.isEmpty())
            throw new WebApplicationException(getUnAuthorizeResponse(PRIVATE_KEY + " is missing inside the header"));
        try {
            jwTokenHelper.claimKey(privateKeyHeaderValue);
        } catch (Exception e) {
            if (e instanceof ExpiredJwtException)
                throw new WebApplicationException(getUnAuthorizeResponse(PRIVATE_KEY + " is expired."));
            else if (e instanceof MalformedJwtException)
                throw new WebApplicationException(getUnAuthorizeResponse(PRIVATE_KEY + " is not correct."));
        }
        return request;
    }

    private Response getUnAuthorizeResponse(String message) {
        return Response.ok(new BaseResponse(message, BaseResponse.FAILURE))
                .status(Response.Status.UNAUTHORIZED)
                .type(MediaType.APPLICATION_JSON)
                .build();
    }
}
