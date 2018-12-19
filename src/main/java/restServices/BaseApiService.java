package restServices;

import javax.ws.rs.core.Response;

public class BaseApiService {

    protected Response getResponse(Object o) {
        return Response.ok(o)
                .build();
    }
}
