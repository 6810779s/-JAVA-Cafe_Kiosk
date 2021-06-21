package Cafe;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Scanner;

public class Employee {

   public Employee() throws Exception {
      run();
   }

   void run() throws Exception  {
      ArrayList<Cafe> clist = new ArrayList<Cafe>();
      

      int temp, select;
      int cnt = 0; // 구매 취소시 데이터 취소할때 구별용도
      
      int price = 0;

      Login log = new Login();

      

      Scanner scan = new Scanner(System.in);

      back: for (;;) {
    	 Cafe cafe = new Cafe();
         System.out.println("---------------------------");
         System.out.println("구매하실 품목을 모두 선택하시오.");
         menu_employee();
         System.out.println();
         while (!scan.hasNextInt()) {
            scan.next();
            System.err.println("숫자만 입력하세요.");
            System.out.print("선택>>>>");

         }
         select = scan.nextInt();
         if (select == 1) {
            System.out.println("1. Hot   2. Ice");
            temp = scan.nextInt();
            if (temp == 1) {
               cafe.menu = "아메리카노_hot";
               cafe.price = 4000;
               clist.add(cafe);
               price += 4000;
               cnt++;
            }
            if (temp == 2) {
               cafe.menu = "아메리카노_ice";
               cafe.price = 4500;
               clist.add(cafe);
               price += 4500;
               cnt++;
            }
         }

         else if (select == 2) {
            System.out.println("1. Hot   2. Ice");
            temp = scan.nextInt();
            if (temp == 1) {
               cafe.menu = "녹차라떼_hot";
               cafe.price = 5500;
               clist.add(cafe);
               price += 5500;
               cnt++;
            }
            if (temp == 2) {
               cafe.menu = "녹차라떼_ice";
               cafe.price = 5500;
               clist.add(cafe);
               price += 5500;
               cnt++;
            }

         } else if (select == 3) {
            System.out.println("1. Hot   2. Ice");
            temp = scan.nextInt();
            if (temp == 1) {
               cafe.menu = "초코라떼_hot";
               cafe.price = 5500;
               clist.add(cafe);
               price += 5500;
               cnt++;
            }
            if (temp == 2) {
               cafe.menu = "초코라떼_ice";
               cafe.price = 5500;
               clist.add(cafe);
               price += 5500;
               cnt++;
            }
         }

         else if (select == 4) {
            System.out.println("1. Hot   2. Ice");
            temp = scan.nextInt();
            if (temp == 1) {
               cafe.menu = "카페라떼_hot";
               cafe.price = 5000;
               clist.add(cafe);
               price += 5000;
               cnt++;
            }
            if (temp == 2) {
               cafe.menu = "카페라떼_ice";
               cafe.price = 5000;
               clist.add(cafe);
               price += 5000;
               cnt++;
            }
         }

         else if (select == 5) {
            System.out.println("1. Hot   2. Ice");
            temp = scan.nextInt();
            if (temp == 1) {
               cafe.menu = "에스프레소_hot";
               cafe.price = 3000;
               clist.add(cafe);
               price += 3000;
               cnt++;
            }
            if (temp == 2) {
               cafe.menu = "에스프레소_ice";
               cafe.price = 3500;
               clist.add(cafe);
               price += 3500;
               cnt++;
            }
         }

         else if (select == 6) {
            cafe.menu = "초코케잌";
            cafe.price = 5500;
            clist.add(cafe);
            price += 5500;
            cnt++;
         }

         else if (select == 7) {
            cafe.menu = "치즈케잌";
            cafe.price = 5500;
            clist.add(cafe);
            price += 5500;
            cnt++;
         }

         else if (select == 8) {
            CafeDB db = new CafeDB();
            for (;;) {
               if (cnt == 0) {
                  System.out.println("상품을 골라주세요.");
                  break;
               }
               System.out.printf("총 %d개의 상품을 구매합니다. 가격은 총 %d원입니다. 구매하시겠습니까?(Y/N)\n", cnt, price);
               cnt = 0;
               String ans = scan.next();
               if (ans.equalsIgnoreCase("y")) {
                  System.out.printf("총 %d원이 결제되었습니다.\n", price);
                  price=0;
                  db.connectDB();
                  for (int i = 0; i < clist.size(); i++) {
                     db.state.executeUpdate("insert into cafesale value(now(),'" + clist.get(i).menu + "',"
                           + clist.get(i).price + ")");                     
                  }
                  db.disconnectDB();
                  clist.clear();
                  break;

               } else if (ans.equalsIgnoreCase("n")) {
                  System.out.println("결제를 취소하였습니다.");
                  price=0;
                  clist.clear();
                  break;
               }

            }

         }

         else if (select == 9) {
            break back;
         }

         else {
            System.out.println("1~9까지만 입력이 가능합니다.");

         }
      }

   }

   void menu_employee() {
      System.out.println("-------大銀月 카페 메뉴-------");
      System.out.println("              Hot    Ice");
      System.out.println("1.아메리카노    4000    4500");
      System.out.println("2.녹차라떼     5500    5500");
      System.out.println("3.초코라떼     5500    5500");
      System.out.println("4.카페라떼     5500    5500");
      System.out.println("5.에스프레소    3000    3500");
      System.out.println("6.초코케잌             5500");
      System.out.println("7.치즈케잌             5500");
      System.out.println("-----------------------------");
      System.out.println("8.구매하기");
      System.out.println("9.로그아웃");
      System.out.print("선택>>>>");
   }

}