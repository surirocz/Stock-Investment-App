import java.util.Date;

public class Investment {
    private String symbol;
    private double price;
    private int quantity;
    private Date datePurchased;

    public Investment() {
    }

    public Investment(String symbol, double price, int quantity, Date datePurchased) {
        this.symbol = symbol;
        this.price = price;
        this.quantity = quantity;
        this.datePurchased = datePurchased;
    }

    public String getSymbol() {
        return symbol;
    }

    public double getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }

    public Date getDatePurchased() {
        return datePurchased;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void updateStockPrice(double currentPrice) {
        this.price = currentPrice;
    }

    public double getProfitLoss() {
        return 0;
    }

    @Override
    public String toString() {
        return "Investment{" +
                "symbol='" + symbol + '\'' +
                ", price=" + price +
                ", quantity=" + quantity +
                ", datePurchased=" + datePurchased +
                '}';
    }
}
