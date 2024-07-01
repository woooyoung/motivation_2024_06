package org.koreait.motivation.service;

import org.koreait.Container;
import org.koreait.Rq;
import org.koreait.motivation.entity.Motivation;

import java.util.ArrayList;
import java.util.List;

public class MotivationService {

    private int lastId;
    private List<Motivation> motivations;

    public MotivationService() {
        lastId = 0;
        motivations = new ArrayList<>();
    }

    // 입력된 id와 일치하는 motivation 찾기
    private Motivation findById(int id) {
        for (Motivation motivation : motivations) {
            if (motivation.getId() == id) {
                return motivation;
            }
        }
        return null;
    }

    public int doAdd(String body, String source) {
        int id = lastId + 1;

        Motivation motivation = new Motivation(id, body, source);
        motivations.add(motivation);

        lastId = id; // 방금 만들어진 새 motivation의 id로 갱신

        return id;
    }

    public void showList() {
        if (motivations.size() == 0) {
            System.out.println("등록된 motivation 없음");
            return;
        }
        System.out.println("== motivation list ==");
        System.out.printf("  id   //   source   //   body  \n");
        System.out.println("=".repeat(35));

        for (int i = motivations.size() - 1; i >= 0; i--) {
            Motivation motivation = motivations.get(i);

            if (motivation.getSource().length() > 7) {
                System.out.printf("   %d  //    %s    //    %s  \n", motivation.getId(), motivation.getSource().substring(0, 5) + "...", motivation.getBody());
                continue;
            }

            System.out.printf("   %d  //    %s     //    %s  \n", motivation.getId(), motivation.getSource(), motivation.getBody());
        }
    }

    public int doDelete(Rq rq) {
        int id;

        try {
            id = Integer.parseInt(rq.getParams("id"));
        } catch (NumberFormatException e) {
            return -1;
        }

        Motivation motivation = findById(id);

        if (motivation == null) {
            return -2;
        }

        motivations.remove(motivation);

        return id;
    }

    public int doEdit(Rq rq) {
        int id;

        try {
            id = Integer.parseInt(rq.getParams("id"));
        } catch (NumberFormatException e) {
            return -1;
        }

        Motivation motivation = findById(id);

        if (motivation == null) {
            return -2;
        }

        // 불러온 motivation의 인스턴스변수에 접근
        System.out.println("body(기존) : " + motivation.getBody());
        System.out.println("source(기존) : " + motivation.getSource());

        System.out.print("body : ");
        String body = Container.getScanner().nextLine();
        System.out.print("source : ");
        String source = Container.getScanner().nextLine();

        // 불러온 motivation의 인스턴스변수 수정
        motivation.setBody(body);
        motivation.setSource(source);

        return id;
    }
}
