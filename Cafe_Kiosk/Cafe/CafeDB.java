package Cafe;

import java.sql.*;
public class CafeDB {
    String url = "jdbc:mysql://localhost/cafe";
    String id = "root";
    String password = "123456789";

    ResultSet rs = null;
    Connection con = null;
    Statement state = null;
    public void connectDB() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("드라이버 적재 성공");
            con = DriverManager.getConnection(url, id, password);
            System.out.println("데이터베이스 연결 성공");
            state = con.createStatement();
        } catch (ClassNotFoundException e) {
            System.out.println("드라이버 로드 실패");
        } catch (SQLException e) {
            System.out.println("연결에 실패하였습니다.");
        }
    }

    public void disconnectDB() {
        try {
            if(rs!=null) rs.close();
            state.close();
            con.close();
            System.out.println("데이터베이스 연결종료 성공");
        } catch (Exception e) {
            System.out.println("데이터베이스 연결종료 실패");
        }
    }
}