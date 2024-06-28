package org.koreait;

import java.util.Scanner;

public class App {

    private Scanner sc;

    public App(Scanner sc) {
        this.sc = sc;
    }

    //    == motivation execution ==
//    command) add
//    motivation : 123
//    source : qwe
//1번 motivation이 등록되었습니다
//    command) add
//    motivation : 456
//    source : asd
//2번 motivation이 등록되었습니다
//    command) list
//== motivation list ==
//    id   //   motivation   //  source
//  2   //     456        //    asd
//          1   //     123        //    qwe
//    command) exit
//== motivation end ==
    public void run() {
        System.out.println("== motivation execution ==");

        int lastId = 1;

        while (true) {
            System.out.print("command) ");
            String cmd = sc.nextLine().trim();

            if (cmd.equals("exit")) {
                System.out.println("== motivation end ==");
                break;
            } else if (cmd.length() == 0) {
                System.out.println("명령어 입력해");
                continue;
            }

            if (cmd.equals("add")) {
                System.out.print("motivation : ");
                String motivation = sc.nextLine();
                System.out.print("source : ");
                String source = sc.nextLine();
                System.out.printf("%d번 motivation이 등록 되었습니다\n", lastId);
                lastId++;
            } else if (cmd.equals("list")) {
                System.out.println("== motivation list ==");
                System.out.printf("  id   //   motivation   //  source   \n");
                System.out.println("=".repeat(35));
            }
        }


    }
}
