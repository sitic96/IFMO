import org.glassfish.jersey.server.ResourceConfig;
import rest.METARResource;
import rest.exceptions.mappers.CodeNotFoundMapper;

import javax.ws.rs.ApplicationPath;

/**
 * Created by sitora on 12.05.17.
 */
@ApplicationPath("rest")
public class MyApplication extends ResourceConfig {

    public MyApplication() {
        register(METARResource.class).register(CodeNotFoundMapper.class);
    }
}