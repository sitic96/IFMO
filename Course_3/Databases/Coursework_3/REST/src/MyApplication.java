import org.glassfish.jersey.server.ResourceConfig;
import rest.AirportResource;
import rest.ConnectionsResource;
import rest.METARResource;
import rest.WorkersResource;
import rest.exceptions.mappers.CodeNotFoundMapper;

import javax.ws.rs.ApplicationPath;

/**
 * Created by sitora on 12.05.17.
 */
@ApplicationPath("rest")
public class MyApplication extends ResourceConfig {

    public MyApplication() {
        register(METARResource.class).register(CodeNotFoundMapper.class).
                register(ConnectionsResource.class).register(AirportResource.class)
                .register(WorkersResource.class);
    }
}