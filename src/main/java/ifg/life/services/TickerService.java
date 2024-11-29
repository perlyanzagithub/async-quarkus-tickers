package ifg.life.services;

import ifg.life.dtos.ResponseTickers;
import ifg.life.models.Tickers;
import ifg.life.repositories.TickerRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@ApplicationScoped
public class TickerService implements TickerInterface {
    @Inject
    TickerRepository tickerRepository;

    private final ExecutorService executorService = Executors.newFixedThreadPool(10);

    @Override
    public CompletableFuture<Void> saveTickersAsync(List<ResponseTickers> apiResponse) {
        return CompletableFuture.runAsync(() -> saveTickers(apiResponse), executorService);
    }

    private void saveTickers(List<ResponseTickers> apiResponse) {
        apiResponse.forEach(ticker-> {
            Tickers entity = new Tickers();
            entity.setCurrency(ticker.getCurrency());
            entity.setSell(ticker.getSell());
            entity.setBuy(ticker.getBuy());
            tickerRepository.persist(entity);
        });
    }

}