package org.example.step6;

import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class Main {
    // 내림차순 출력 수정 생각해보기
    // 추후 스트림으로 변경해보기

    public static void main(String[] args) {
        System.out.println("== 명언 앱 ==");
        startApp();
    }

    private static void startApp() {
        int index = 1;
        while (true) {
            Scanner scanner = new Scanner(System.in);
            System.out.print("명령) ");
            String option = scanner.nextLine();
            if (option.equals("등록")) {
                System.out.print("명언 : ");
                String wiseSaying = scanner.nextLine();
                System.out.print("작가 : ");
                String writer = scanner.nextLine();
                WiseSaying wiseObj = new WiseSaying(wiseSaying, writer, index);
                WiseSaying.getWsList().add(wiseObj);
                System.out.println(index + "번 명언이 등록되었습니다.");
                index++;
            } else if(option.equals("목록")) {
                printWsList();
            } else if (option.startsWith("삭제?id=")) {
                // contains를 사용하면 asdf삭제?id= 이런 경우 예외 발생
                int deleteNumber = Integer.parseInt(option.substring(6));
                deleteWsList(deleteNumber);
                System.out.println(deleteNumber + "명언이 삭제되었습니다.");
            } else if (option.equals("종료")) {
                scanner.close();
                break;
            }
        }
    }
    private static void printWsList() {
        // 내림차순 정렬
        Collections.sort(WiseSaying.getWsList(), new Comparator<WiseSaying>() {
            @Override
            public int compare(WiseSaying ws1, WiseSaying ws2) {
                return Integer.compare(ws2.getNumber(), ws1.getNumber()); // 내림차순
            }
        });

        for (WiseSaying ws : WiseSaying.getWsList()) {
            System.out.println(ws.getNumber() + " / " + ws.getWriter() + " / " + ws.getWiseSaying());
        }
    }

    private static void deleteWsList(int number) {
        for (int i = 0; i < WiseSaying.getWsList().size(); i++) {
            if (WiseSaying.getWsList().get(i).getNumber() == number) {
                WiseSaying.getWsList().remove(i);
                break;
            }
        }
    }
}
