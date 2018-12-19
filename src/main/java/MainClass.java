import com.sun.jersey.api.container.grizzly2.GrizzlyServerFactory;
import com.sun.jersey.api.core.ResourceConfig;
import configuration.resourceConfiguration.MyResourceConfig;

import java.net.URI;

public class MainClass {

    private static final URI _URI = URI.create("http://192.200.222.22:5555");   // change with your own ip address.

    public static void main(String[] args) {
        ResourceConfig resourceConfig = new MyResourceConfig();
        try {
            GrizzlyServerFactory.createHttpServer(_URI, resourceConfig);
            System.in.read();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
