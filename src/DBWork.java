import java.sql.*;

public class DBWork {
    private final String url = "jdbc:postgresql://localhost:5432/";
    private final String user = "postgres";
    private final String password = "bambuchok1902";

    public Connection connect() {
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(url, user, password);
            System.out.println("Connected to the PostgreSQL server successfully.");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return conn;
    }


    public void createNewNews(String news_headline, String news_text) {
        String SQL = "insert into news(news_headline,news_text) values( ?, ?)";
        try (Connection conn = connect();
             PreparedStatement preparedStatement = conn.prepareStatement(SQL)) {
            preparedStatement.setString(1, news_headline);
            preparedStatement.setString(2, news_text);
            preparedStatement.execute();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }


    public int displayNews() {
        String SQL = "SELECT* news WHERE news_headline = * AND news_text = *";
        int count = 0;

        try (Connection conn = connect();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(SQL)) {
            rs.next();
            count = rs.getInt(1);
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return count;
    }


    public int removalNews() {
        String SQL = "SELECT* news WHERE news_headline = * AND news_text = *";
        int count = 0;

        try (Connection conn = connect();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(SQL)) {
            rs.next();
            count = rs.getInt(1);
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return count;
    }



    public void removalNews(int id_news) {
        String SQL = "DELETE FROM news WHERE id_news = (?)";
        try (Connection conn = connect();
             PreparedStatement preparedStatement = conn.prepareStatement(SQL)) {
            preparedStatement.setInt(1, id_news);
            preparedStatement.execute();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }



    public void changeTheTextAndHeadlineOfTheNews(int id_news, String news_headline, String news_text) {
        String SQL = "UPDATE news SET news_headline = '(?)', news_text = '(?)' where id = (?)";
        try (Connection conn = connect();
             PreparedStatement preparedStatement = conn.prepareStatement(SQL)) {
            preparedStatement.setInt(1, id_news);
            preparedStatement.execute();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }
}
