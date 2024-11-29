package ifg.life.services;

import ifg.life.dtos.ResponseTickers;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public interface TickerInterface {
    CompletableFuture<Void> saveTickersAsync(List<ResponseTickers> apiResponse);
}
