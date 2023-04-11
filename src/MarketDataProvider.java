import java.util.ArrayList;
import java.util.List;

public class MarketDataProvider {

    StockInfo stockInfo;

    public MarketDataProvider() {
    }

    public MarketDataProvider(StockInfo stockInfo) {
        this.stockInfo = stockInfo;
    }

    public double getPrice(String symbol) {
        // implementation for retrieving stock price from market data provider using API
        return 0.0;
    }

    public List<String> getSymbols() {
        // implementation for retrieving list of stock symbols from market data provider using API
        return new ArrayList<String>();
    }

    public StockInfo getStockInfo(String symbol) {
        return stockInfo;
    }
}
