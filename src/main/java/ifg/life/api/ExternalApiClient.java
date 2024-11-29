package ifg.life.api;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

@RegisterRestClient(configKey = "indodax-api")
@Path("/api/tickers")
public interface ExternalApiClient {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    String getTickers();
}
