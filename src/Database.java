import java.sql.Connection;
import java.sql.DriverManager;
import javax.swing.JOptionPane;

public class Database {

    private static final String URL =
            "jdbc:mysql://localhost:3306/resume_screening";

    private static final String USER = "root";
    private static final String PASSWORD = "Venkat@2008";

    public static Connection getConnection() {

        try {

            Class.forName("com.mysql.cj.jdbc.Driver");

            Connection con = DriverManager.getConnection(URL, USER, PASSWORD);

            System.out.println("Connected Successfully!");

            return con;

        } catch (Exception ex) {

            ex.printStackTrace();

            JOptionPane.showMessageDialog(null, ex.toString());

        }

        return null;
    }
}