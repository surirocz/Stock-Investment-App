import java.util.ArrayList;
import java.util.List;

public class Portfolio {
    private List<Investment> investments;

    public Portfolio() {
        investments = new ArrayList<Investment>();
    }

    public void addInvestment(Investment investment) {
        investments.add(investment);
    }

    public List<Investment> getInvestments() {
        return investments;
    }

    public double getTotalValue() {
        double totalValue = 0.0;
        for (Investment investment : investments) {
            totalValue += investment.getPrice() * investment.getQuantity();
        }
        return totalValue;
    }

    @Override
    public String toString() {
        return "Portfolio{" +
                "investments=" + investments +
                '}';
    }
}
