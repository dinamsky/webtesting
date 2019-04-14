package app.model;


import app.entities.User;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Model {
    private static Model instance = new Model();

    private List<User> model;

    public static Model getInstance() {
        return instance;
    }

    private Model() {
        model = new ArrayList<>();
    }

    public void add(User user) {
        model.add(user);
    }


    public List<String> listDatabase() {

        try {
            Class.forName("org.postgresql.Driver");
            String url = "jdbc:postgresql://localhost:5432/contactdb";
            String login = "postgres";
            String password = "bestpass";
            Connection con = DriverManager.getConnection(url, login, password);
            List<String> result = new ArrayList<>();

            try {
                Statement stmt = con.createStatement();
                ResultSet rs = stmt.executeQuery("SELECT * FROM JC_CONTACT");
                while (rs.next()) {
                    result.add(rs.getString(2));
                }
                rs.close();
                stmt.close();
                System.out.println(result.toString());
                return result;
            } finally {
                con.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
return model.stream()
        .map(User::getName)
        .collect(Collectors.toList());
    }
    public void addDatabase(User user) {

        try {
            Class.forName("org.postgresql.Driver");
            String url = "jdbc:postgresql://localhost:5432/contactdb";
            String login = "postgres";
            String password = "bestpass";
            Connection con = DriverManager.getConnection(url, login, password);
            String query = "INSERT INTO JC_CONTACT ("
                    + " contact_id,"
                    + " first_name,"
                    + " last_name,"
                    + " phone,"
                    + " email,"
                    + " password ) VALUES ("
                    + "null, ?, ?, ?, ?, ?, ?)";

            try {
                PreparedStatement stmt =  con.prepareStatement(query);
                stmt.setString(1, user.getName());
                stmt.setString(3, user.getLastName());
                stmt.setString(4, user.getPhone());
                stmt.setString(5, user.getEmail());
                stmt.setString(6, user.getPassword());

                int i = stmt.executeUpdate();

            } finally {
                con.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}