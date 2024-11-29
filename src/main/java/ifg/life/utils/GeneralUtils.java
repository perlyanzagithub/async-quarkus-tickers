package ifg.life.utils;

import ifg.life.dtos.ResponseTickers;
import jakarta.json.Json;
import jakarta.json.JsonObject;
import jakarta.json.JsonReader;

import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;

public class GeneralUtils {

    public static List<ResponseTickers> parseApiResponse(String jsonResponse) {
        List<ResponseTickers> listTicker = new ArrayList<>();

        try (JsonReader reader = Json.createReader(new StringReader(jsonResponse))) {
            JsonObject jsonObject = reader.readObject();
            JsonObject tickers = jsonObject.getJsonObject("tickers");
            tickers.forEach((key, value) -> {
                JsonObject tickerDetails = value.asJsonObject();
                ResponseTickers ticker = new ResponseTickers();
                ticker.setBuy(Double.valueOf(tickerDetails.getString("buy", "0")));
                ticker.setSell(Double.valueOf(tickerDetails.getString("sell", "0")));
                ticker.setCurrency(key);
                listTicker.add(ticker);
            });
        }
        return listTicker;
    }
}
