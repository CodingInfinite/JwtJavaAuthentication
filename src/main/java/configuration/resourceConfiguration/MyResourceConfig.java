package configuration.resourceConfiguration;

import com.sun.jersey.api.core.DefaultResourceConfig;
import com.sun.jersey.api.core.ResourceConfig;
import configuration.jerseyConfiguration.CORSFilter;
import configuration.jwtConfiguration.JsTokenFilterNeeded;
import restServices.HomeApiService;

import java.util.HashMap;
import java.util.Map;

public class MyResourceConfig extends DefaultResourceConfig {

    public MyResourceConfig() {
        super(HomeApiService.class);
        Map<String, Object> maps = new HashMap<String, Object>();
        maps.put(ResourceConfig.PROPERTY_CONTAINER_RESPONSE_FILTERS, CORSFilter.class);
        maps.put(ResourceConfig.PROPERTY_CONTAINER_REQUEST_FILTERS, JsTokenFilterNeeded.class);
        setPropertiesAndFeatures(maps);
    }
}
