package ifg.life.dtos;

public class ResponseTickers {
    private String currency;
    private Double sell;
    private Double buy;

    public String getCurrency(){
        return currency;
    }
    public void setCurrency(String currency){
        this.currency = currency;
    }

    public Double getSell() {
        return sell;
    }
    public void setSell(Double sell){
        this.sell = sell;
    }
    public Double getBuy() {
        return buy;
    }
    public void setBuy(Double buy){
        this.buy = buy;
    }

}
