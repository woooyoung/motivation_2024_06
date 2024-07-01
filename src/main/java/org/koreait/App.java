package org.koreait;

import org.koreait.motivation.controller.MotivationController;
import org.koreait.system.controller.SystemController;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class App {

    public void run() {
        System.out.println("== motivation execution ==");

        SystemController systemController = new SystemController();
        MotivationController motivationController = new MotivationController();

        while (true) {
            System.out.print("command) ");
            String cmd = Container.getScanner().nextLine().trim();

            if (cmd.equals("exit")) {
                systemController.exit();
                break;
            } else if (cmd.length() == 0) {
                System.out.println("명령어 입력해");
                continue;
            }

            if (cmd.equals("add")) {
                motivationController.add();
            } else if (cmd.equals("list")) {
                motivationController.list();
            } else if (cmd.startsWith("delete")) {

                Rq rq = new Rq(cmd);

                System.out.println(rq.getActionMethod());
                System.out.println(rq.getParams("id"));
                System.out.println(rq.getParams("source"));
                System.out.println(rq.getParams("motivation"));

//                motivationController.delete();
            } else {
                System.out.println("사용할 수 없는 명령어입니다");
            }
        }
    }
}

