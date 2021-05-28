package mvc.server.dataBaseConnection;

import java.io.FileInputStream;
import java.sql.*;
import java.util.Properties;

public class DataSource  {

    private static DataSource dataSource = null;
    private Connection con;
    private String url="jdbc:postgresql://172.17.0.2:5432/celulares";
    private String user = "postgres";
    private String password ="postgres";


    public Connection getCnn()
    {
        return con;
    }
    public void setCnn(Connection con)
    {
        this.con=con;
    }

    private DataSource() {
       /* Properties conProperties = new Properties();

        try {
            conProperties.load(new FileInputStream("src/main/java/mvc/server/data/connection.properties"));

            String url = conProperties.getProperty("url");
            String user = conProperties.getProperty("user");
            String password = conProperties.getProperty("password");

            con = DriverManager.getConnection(url.trim(), user.trim(), password.trim());

            System.out.println("Successful connection");

        } catch (Exception e) {
            e.printStackTrace();
        }*/

        class.forname("con.postgresql.jdbc.driver");
        con = DriverManager.getConnection(url.trim(), user.trim(), password.trim());
    }

    public static DataSource getInstance(){
        if (dataSource == null){
            dataSource = new DataSource();
        }
        return dataSource;
    }
    public ResultSet runQuery(String sql){
        ResultSet resultSet = null;
        try {
            Statement statement = con.createStatement();
            resultSet = statement.executeQuery(sql);
            System.out.println("Successful query: "+sql);
        } catch (SQLException e) {
            System.out.println("Query error: "+e.getMessage());
        }
        return resultSet;
    }

    public int runUpdateQuery(String sql){
        int rows=0;
        try {
            Statement statement = con.createStatement();
            rows = statement.executeUpdate(sql);
            System.out.println("Successful query: "+sql);

        } catch (SQLException e) {
            System.out.println("Query error: " + e.getMessage());

        }
        return rows;

    }

}

