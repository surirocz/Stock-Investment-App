import java.util.Arrays;
import java.util.Date;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        // Create a new user
        User user = new User("John", "Doe", "johndoe@example.com", "password");

        // Create dummy symbols
        List<String> symbols = Arrays.asList("AAPL", "GOOGL", "AMZN", "FB", "NFLX");

        // Create a new investment
        Investment investment = new Investment("AAPL", 100, 135, new Date());

        // Create a new market data provider
        MarketDataProvider marketDataProvider = new MarketDataProvider();

        // Get the current stock info for the investment
        StockInfo stockInfo = marketDataProvider.getStockInfo("AAPL");

        if (stockInfo != null) {
            // Update the investment with the current stock price
            investment.updateStockPrice(stockInfo.getCurrentPrice());
        }else {
            //creating dummy stock info
            stockInfo = new StockInfo("AAPL", "Apple Inc.", 137.21, 138.06, 135.39, 139.17, 135.18, 9876543);

        }

        // Update the investment with the current stock price
        investment.updateStockPrice(stockInfo.getCurrentPrice());

        // Add the investment to the user's portfolio
        Portfolio portfolio = user.getPortfolio();
        if (portfolio != null){
            portfolio.addInvestment(investment);
        }else{
            //creating dummy portfolio
            portfolio = new Portfolio();
            portfolio.addInvestment(investment);
            user.setPortfolio(portfolio);
        }


        // Add the investment to the user's watchlist
        Watchlist watchlist = user.getWatchlist();
        if (watchlist != null){
            watchlist.addInvestment(investment);
        }else{
            //creating dummy portfolio
            watchlist = new Watchlist();
            watchlist.addInvestment(investment);
            user.setWatchlist(watchlist);
        }

        //add symbols to watch list
        if (watchlist.getSymbols().size() < 1){
            watchlist.addSymbols(symbols);
        }

        // Check if the investment has increased in value
        if (investment.getProfitLoss() > 0) {
            // Send a notification to the user
            Notification notification = new Notification(user, "AAPL has increased in value.", new Date());
            notification.send();
        }

        // Print the user's portfolio and watchlist
        System.out.println("Portfolio:");
        System.out.println(portfolio);
        System.out.println("Watchlist:");
        System.out.println(watchlist);

    }

}
