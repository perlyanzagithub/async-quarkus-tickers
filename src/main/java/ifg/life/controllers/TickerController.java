package ifg.life.controllers;

import ifg.life.api.ExternalApiClient;
import ifg.life.dtos.ResponseTickers;
import ifg.life.services.TickerService;
import ifg.life.utils.GeneralUtils;
import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import org.eclipse.microprofile.rest.client.inject.RestClient;

import java.util.List;
import java.util.concurrent.CompletableFuture;

@Path("/tickers")
public class TickerController {

    @Inject
    @RestClient
    ExternalApiClient apiClient;

    @Inject
    TickerService service;

    @GET
    @Path("/sync-async")
    @Produces(MediaType.APPLICATION_JSON)
    public CompletableFuture<String> syncTickersAsync() {
        String jsonResponse = apiClient.getTickers();
        List<ResponseTickers> apiResponse = GeneralUtils.parseApiResponse(jsonResponse);
        return service.saveTickersAsync(apiResponse)
                .thenApply(v -> "Tickers synchronized successfully!");
    }
}