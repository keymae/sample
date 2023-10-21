// InventoryManagementSystem.java
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class InventoryManagementSystem {
    public static void main(String[] args) {
        // Example: Adding a product to the inventory
        Product newProduct = new Product(1, "Laptop", 999.99, 10);
        addProduct(newProduct);

        // Example: Retrieving and displaying all products in the inventory
        List<Product> products = getAllProducts();
        for (Product product : products) {
            System.out.println(product);
        }
    }

    public static void addProduct(Product product) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
            connection = DatabaseManager.getConnection();
            String sql = "INSERT INTO products (product_id, product_name, price, quantity) VALUES (?, ?, ?, ?)";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, product.getProductId());
            preparedStatement.setString(2, product.getProductName());
            preparedStatement.setDouble(3, product.getPrice());
            preparedStatement.setInt(4, product.getQuantity());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DatabaseManager.closeConnection(connection, preparedStatement, null);
        }
    }

    public static List<Product> getAllProducts() {
        List<Product> products = new ArrayList<>();
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;

        try {
            connection = DatabaseManager.getConnection();
            statement = connection.createStatement();
            String sql = "SELECT * FROM products";
            resultSet = statement.executeQuery(sql);

            while (resultSet.next()) {
                int productId = resultSet.getInt("product_id");
                String productName = resultSet.getString("product_name");
                double price = resultSet.getDouble("price");
                int quantity = resultSet.getInt("quantity");

                Product product = new Product(productId, productName, price, quantity);
                products.add(product);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DatabaseManager.closeConnection(connection, statement, resultSet);
        }

        return products;
    }
}
