package Cafe;

import java.sql.SQLException;
import java.util.Scanner;

public class Cafedriver {
    Scanner scan = new Scanner(System.in);

    Cafedriver() throws Exception {
        run();
    }

    public int loginCafe() throws Exception {
        CafeDB lg = new CafeDB();

        Login log = new Login();
        int lm;
        int cnt = 0;
        for (;;) {
            System.out.println("1.로그인");
            System.out.println("2.종료");
            System.out.println("선택>>>");
            lm = scan.nextInt();

            if (lm == 1) {
                System.out.print("ID:");
                log.id = scan.next();
                System.out.println();
                System.out.print("PW:");
                log.pw = scan.next();
                lg.connectDB();
                lg.rs = lg.state
                        .executeQuery("select * from login where id= '" + log.id + "' AND pw= '" + log.pw + "' ");
                if (lg.rs.next()) {
                    if (lg.rs.getInt("rt") == 1) {
                        System.out.println("관리자로 로그인");
                        lg.disconnectDB();
                        return 1;
                    } else if (lg.rs.getInt("rt") == 2) {
                        System.out.println("일반 로그인");
                        lg.disconnectDB();
                        return 2;
                    }
                } else {
                    System.out.println("아이디나 비밀번호 오류");
                }
                System.out.println();
                cnt++;
                if (cnt == 5) {
                    System.out.println("비밀번호 5회오류로 프로그램 종료 합니다.");
                    lg.disconnectDB();
                    return 0;
                }
            } else {
                return 0;
            }

        }

    }

    public void run() throws Exception {
        int mainmenu;
        for (;;) {// 프로그램 시작
            mainmenu = loginCafe();
            if (mainmenu == 1) {
                new Admin();
            } else if (mainmenu == 2) {
                new Employee();
            } else {
                System.out.println("프로그램종료");
                break;
            }
        }
    }

    public static void main(String[] args) {
        try {
            new Cafedriver();
        } catch (ClassNotFoundException e) {
            System.out.println("ClassNotFoundException : " + e.getMessage());
        } catch (SQLException e2) {
            System.out.println("SQL EXCEPTION");
        } catch (Exception e3) {
            System.out.println("오류");
        }
    }
}