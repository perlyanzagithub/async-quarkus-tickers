package ifg.life.repositories;

import ifg.life.models.Tickers;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class TickerRepository implements PanacheRepository<Tickers> {

}