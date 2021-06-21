package Cafe;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class Cafe {
	String menu;
	int price;
	int count;

	Cafe() {

	}

	public Cafe(String menu, int price) {
		this.menu = menu;
		this.price = price;
	}

	void cafe_list() {
		ArrayList<Cafe> clist = new ArrayList<Cafe>();
	}

	void setTable(Statement state, ResultSet rs) throws SQLException {
		state.executeUpdate("drop table if exists CafeSale");
		state.executeUpdate("create table CafeSale " + "(date timestamp not null default "
				+ "current_timestamp,menu varchar(30) not null," + "price integer not null)");
		
		state.executeUpdate("insert into CafeSale value('2019-02-22 12:30:30','아메리카노_ice',4500)");
		state.executeUpdate("insert into CafeSale value('2020-02-15 12:30:30','초코라떼_ice',5500)");
		state.executeUpdate("insert into CafeSale value('2020-03-30 12:30:30','아메리카노_ice',4500)");
		state.executeUpdate("insert into CafeSale value('2020-11-30 12:30:30','아메리카노_ice',4500)");
		state.executeUpdate("insert into CafeSale value('2020-02-12 12:30:30','초코케잌',5500)");
		state.executeUpdate("insert into CafeSale value('2021-01-10 12:30:30','아메리카노_ice',4500)");
		state.executeUpdate("insert into CafeSale value('2021-02-15 12:30:30','아메리카노_ice',4500)");
		

	}
}