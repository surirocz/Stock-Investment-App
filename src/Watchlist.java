import java.util.ArrayList;
import java.util.List;

public class Watchlist {
    private List<String> symbols;
    private Investment investment;



    public Watchlist() {
        symbols = new ArrayList<String>();
        investment = new Investment();
    }

    public void addSymbol(String symbol) {
        symbols.add(symbol);
    }

    public void addSymbols(List<String> symbols) {
        this.symbols.addAll(symbols);
    }

    public List<String> getSymbols() {
        return symbols;
    }

    public void addInvestment(Investment investment) {
        this.investment = investment;
    }

    @Override
    public String toString() {
        return "Watchlist{" +
                "symbols=" + symbols +
                ", investment=" + investment +
                '}';
    }
}
