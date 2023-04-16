
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DatabaseConnectionDao {
    private final Connection connection;

    public DatabaseConnectionDao() throws SQLException {
        String url = "jdbc:mysql://localhost:3306/stock_investment_db";
        String username = "root";
        String password = "root@987";

        connection = DriverManager.getConnection(url, username, password);
    }

    public void createStockInfo(StockInfo stockInfo) throws SQLException {
        String sql = "INSERT INTO stock_info (symbol, company_name, current_price, opening_price, closing_price, high_price, low_price, volume) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        PreparedStatement statement = connection.prepareStatement(sql);

        statement.setString(1, stockInfo.getSymbol());
        statement.setString(2, stockInfo.getCompanyName());
        statement.setDouble(3, stockInfo.getCurrentPrice());
        statement.setDouble(4, stockInfo.getOpeningPrice());
        statement.setDouble(5, stockInfo.getClosingPrice());
        statement.setDouble(6, stockInfo.getHighPrice());
        statement.setDouble(7, stockInfo.getLowPrice());
        statement.setInt(8, stockInfo.getVolume());

        statement.executeUpdate();
    }

    public List<StockInfo> getStockInfoList() throws SQLException {
        String sql = "SELECT * FROM stock_info";
        PreparedStatement statement = connection.prepareStatement(sql);

        ResultSet result = statement.executeQuery();

        List<StockInfo> stockInfoList = new ArrayList<>();
        while (result.next()) {
            String symbol = result.getString("symbol");
            String companyName = result.getString("company_name");
            double currentPrice = result.getDouble("current_price");
            double openingPrice = result.getDouble("opening_price");
            double closingPrice = result.getDouble("closing_price");
            double highPrice = result.getDouble("high_price");
            double lowPrice = result.getDouble("low_price");
            int volume = result.getInt("volume");

            StockInfo stockInfo = new StockInfo(symbol, companyName, currentPrice, openingPrice, closingPrice, highPrice, lowPrice, volume);
            stockInfoList.add(stockInfo);
        }

        return stockInfoList;
    }

    public void updateStockInfo(StockInfo stockInfo) throws SQLException {
        String sql = "UPDATE stock_info SET company_name = ?, current_price = ?, opening_price = ?, closing_price = ?, high_price = ?, low_price = ?, volume = ? WHERE symbol = ?";
        PreparedStatement statement = connection.prepareStatement(sql);

        statement.setString(1, stockInfo.getCompanyName());
        statement.setDouble(2, stockInfo.getCurrentPrice());
        statement.setDouble(3, stockInfo.getOpeningPrice());
        statement.setDouble(4, stockInfo.getClosingPrice());
        statement.setDouble(5, stockInfo.getHighPrice());
        statement.setDouble(6, stockInfo.getLowPrice());
        statement.setInt(7, stockInfo.getVolume());
        statement.setString(8, stockInfo.getSymbol());

        statement.executeUpdate();
    }

    public void deleteStockInfo(String symbol) throws SQLException {
        String sql = "DELETE FROM stock_info WHERE symbol = ?";
        PreparedStatement statement = connection.prepareStatement(sql);

        statement.setString(1, symbol);

        statement.executeUpdate();
    }

    public void closeConnection() throws SQLException {
        if (connection != null && !connection.isClosed()) {
            connection.close();
        }
    }
}
