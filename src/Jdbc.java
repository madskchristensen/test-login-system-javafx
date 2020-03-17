import java.sql.*;

public class Jdbc {
    private static final String USERNAME = "root";
    private static final String PASSWORD = "root";
    private static final String URL = "jdbc:mysql://localhost/login?serverTimezone=UTC";

    // Til at teste
    public static void printDatabase() {
        try {
            Connection con = null;
            Statement stmt = null;
            ResultSet rs = null;

            con = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            stmt = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery("SELECT * FROM users");

            while (rs.next()) {
                for (int i = 1; i <= rs.getMetaData().getColumnCount(); i++) {
                    if (i > 1) System.out.print("|-  ");
                    String columnvalue = rs.getString(i);
                    System.out.println(rs.getMetaData().getColumnName(i) + ": " + columnvalue);
                }
                System.out.println();
            }
        } catch(SQLException e) {
            e.printStackTrace();
        }
    }

    // Test metode til at teste queries/update af databasen
    public static void connect() throws SQLException {
        // Connection repræsenterer en forbindelse til en database.
        // En forbindelse skal åbnes før der kan læses/skrives til databasen.
        Connection con = null;
        // Statement bruges til at eksekvere SQL statements mod en database.
        // Man får statements fra en JDBC Connection.
        // Når man har en statement instans kan man udføre et query eller update.
        Statement stmt = null;
        // Resultset repræsenterer resultatet af et database query.
        ResultSet rs = null;

        try {
            con = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            stmt = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);

            System.out.println("Connected to database with \n" + "URL: " + URL + "\n" + "Username: " + USERNAME + "\n" + "Password: " + PASSWORD);

        } catch(SQLException e) {
            System.out.println("Catch error: " + e + "\n");
            e.printStackTrace();
        }
        finally {
            if(rs != null) {
                    con.close();
            }

            if(stmt != null) {
                stmt.close();
            }

            if(con != null) {
                con.close();
            }
        }
    }

    public static void createUser(String username, String password, String email) throws SQLException {
        Connection con = null;
        Statement stmt = null;

        username = "'" + username + "'";
        password = "'" + password + "'";
        email = "'" + email + "'";

        try {
                con = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            stmt = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            stmt.executeUpdate("INSERT INTO `users` (`username`, `password`, `email`, `rank`) VALUES (" + username + ", " + password + ", " + email + ", 'user');");

        } catch(SQLException e) {
            System.out.println("Caught error: " + e + "\n");
            e.printStackTrace();
        }
        finally {
            if(stmt != null) {
                stmt.close();
            }

            if(con != null) {
                con.close();
            }
        }
    }

    public static boolean validateLogin(String username, String password)  throws SQLException {
        Connection con = null;
        Statement stmt = null;
        ResultSet rs = null;

        try {
            con = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            stmt = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery("SELECT * FROM users");

            while(rs.next()) {
                if(username.equals(rs.getString("username")) && password.equals(rs.getString("password"))) {
                    return true;
                }
            } return false;

        } catch(SQLException e) {
            System.out.println("Caught error: " + e + "\n");
            e.printStackTrace();
        }
        finally {
            if(stmt != null) {
                stmt.close();
            }

            if(con != null) {
                con.close();
            }
            if(rs != null) {
                rs.close();
            }
        }
        return false;
    }
}
