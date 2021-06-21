package Cafe;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Login {
    String id;
    String pw;

    void setTable(Statement state, ResultSet rs) throws SQLException {
        state.executeUpdate("drop table if exists login");
        state.executeUpdate("create table login (id varchar(20) not null primary key,pw varchar(20) not null,rt integer not null)");
        state.executeUpdate("insert into login values('eunhee','1234',2)");
        state.executeUpdate("insert into login values('daegyun','5678',2)");
        state.executeUpdate("insert into login values('dalhyun','4321',1)");
    }
}