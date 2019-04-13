package app.model;

import app.entities.User;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
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

    public List<String> list() {
        return model.stream()
                .map(User::getName)
                .collect(Collectors.toList());
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
}