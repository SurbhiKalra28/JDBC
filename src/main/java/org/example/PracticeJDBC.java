package org.example;

import java.sql.*;
//https://github.com/RaheemAbol/perscholas_jdbc_day_one/blob/main/abol/SqlQuries.java
public class PracticeJDBC {
    public static void main(String[] args) throws SQLException {
        Connection conn = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        String url = "jdbc:mysql://localhost:3306/RealEstateDB?serverTimezone=UTC";
        String usr ="root" ;
        String password = "LovePapa@2801";
        try{
            conn = DriverManager.getConnection(url, usr, password);
            String sqlQuery ="INSERT INTO Clients " +
                    "(ClientID,firstName, lastName, email, PhoneNumber" +
                    ") VALUES(?,?,?,?,?)";
            stm = conn.prepareStatement(sqlQuery);
            stm.setInt(1,106);
            stm.setString(2,"Surbhi");
            stm.setString(3,"Kalra");
            stm.setString(4,"skalra@gmail.com");
            stm.setString(5,"470-88-9245");
            int rows = stm.executeUpdate();
            System.out.println("Number of rows Added :"+rows);
            stm = conn.prepareStatement("Select * from Clients");
            rs = stm.executeQuery();
            while(rs.next()){
                System.out.println(rs.getInt("ClientID"));
                System.out.println(rs.getString("FirstName"));
                System.out.println(rs.getString("LastName"));
                System.out.println(rs.getString("Email"));
                System.out.println(rs.getString("PhoneNumber"));
            }
        }catch (SQLException se){
            se.printStackTrace();
        }
try{
    stm.close();
    conn.close();
}catch (Exception e){
    e.printStackTrace();
}



    }
}
