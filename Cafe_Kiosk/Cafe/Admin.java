package Cafe;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Admin {
    Scanner scan = new Scanner(System.in);

    public Admin() throws Exception {
        menu_admin();
    }

    public int showMenu() {
        System.out.println("메뉴");
        System.out.println("1.연매출");
        System.out.println("2.월매출");
        System.out.println("3.일매출");
        System.out.println("4.로그아웃");
        System.out.println("선택>>>");
        return scan.nextInt();
    }

    public void menu_admin() throws Exception {
        int menu;
        for (;;) {
            menu = showMenu();
            if (menu == 1) {
                showSale(1);
            } else if (menu == 2) {
                showSale(2);
            } else if (menu == 3) {
                showSale(3);
            } else if (menu == 4) {
                System.out.println("로그아웃");
                return;
            } else {
                System.out.println("메뉴입력 오류");
            }
        }
    }

    public void showSale(int menu) throws Exception {
        CafeDB tm = new CafeDB();
        tm.connectDB();
        if(menu==1){
            
            tm.rs=tm.state.executeQuery("SELECT DATE_FORMAT(date,'%Y년') AS tdate, sum(price) as total FROM cafesale GROUP BY tdate ORDER BY tdate;");
            
            System.out.println("연별 매출 현황");
            
            while (tm.rs.next()) {
                System.out.print("날짜 : "+tm.rs.getString("tdate"));
                System.out.println("\t매출 : "+tm.rs.getInt("total"));
            }
           
        }
        else if(menu==2){
            tm.rs=tm.state.executeQuery("SELECT DATE_FORMAT(date,'%Y년 %m월') AS tdate, sum(price) as total FROM cafesale GROUP BY tdate ORDER BY tdate;");
            System.out.println("월별 매출 현황");
            while (tm.rs.next()) {
                System.out.print("날짜 : "+tm.rs.getString("tdate"));
                System.out.println("\t매출 : "+tm.rs.getInt("total"));
            }
        }
        else if(menu==3){
            tm.rs=tm.state.executeQuery("SELECT DATE_FORMAT(date,'%Y년 %m월 %d일') AS tdate, sum(price) as total FROM cafesale GROUP BY tdate ORDER BY tdate;");
            System.out.println("일별 매출 현황");
            while (tm.rs.next()) {
                System.out.print("날짜 : "+tm.rs.getString("tdate"));
                System.out.println("\t매출 : "+tm.rs.getInt("total"));
            }
        }        
        tm.disconnectDB();
    }
}