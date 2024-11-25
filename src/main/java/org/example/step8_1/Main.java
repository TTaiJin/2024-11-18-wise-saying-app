package org.example.step8_1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Main {
    // 추후 스트림 공부하고 스트림으로 변경해보기
    private static Scanner scanner = new Scanner(System.in);
    private static int index = 1;
    private static ArrayList<WiseSaying> wsList = new ArrayList<>();

    public static void main(String[] args) {
        System.out.println("== 명언 앱 ==");
        while (true) {
            System.out.print("명령) ");
            String option = scanner.nextLine();
            if (option.equals("등록")) {
                register();
            } else if (option.equals("목록")) {
                print();
            } else if (option.startsWith("삭제?id=")) {
                int deleteNumber = Integer.parseInt(option.substring(6));
                boolean isExist = delete(deleteNumber);
                if (isExist) {
                    System.out.println(deleteNumber + "번 명언이 삭제되었습니다.");
                } else {
                    System.out.println(deleteNumber + "번 명언이 존재하지 않습니다.");
                }
            } else if (option.startsWith("수정?id=")) { // contains를 사용하면 asdf삭제?id= 이런 경우 예외 발생
                int editNumber = Integer.parseInt(option.substring(6));
                boolean isExist = edit(editNumber);
                if (isExist) {
                    System.out.println(editNumber + "번 명언이 수정되었습니다.");
                } else {
                    System.out.println(editNumber + "번 명언이 존재하지 않습니다.");
                }
            } else if (option.equals("종료")) {
                scanner.close();
                break;
            }
        }
    }

    private static void register() {
        System.out.print("명언 : ");
        // 정규 표현식으로 특수 기호 필터링(GPT)
        String wiseSaying = scanner.nextLine().replaceAll("[^a-zA-Z0-9가-힣\\s]", "");
        System.out.print("작가 : ");
        String writer = scanner.nextLine().replaceAll("[^a-zA-Z0-9가-힣\\s]", "");;
        WiseSaying wsObj = new WiseSaying(wiseSaying, writer, index);
        wsList.add(wsObj);
        System.out.println(index + "번 명언이 등록되었습니다.");
        index++;
    }

    private static void print() {
        // 내림차순 정렬(GPT)
     /*   Collections.sort(wsList, new Comparator<WiseSaying>() {
            @Override
            public int compare(WiseSaying ws1, WiseSaying ws2) {
                return Integer.compare(ws2.getIndex(), ws1.getIndex()); // 내림차순
            }
        });*/
        Collections.reverse(wsList);
        System.out.println("번호 / 작가 / 명언");
        System.out.println("------------------");
        for (WiseSaying ws : wsList) {
            System.out.println(ws.getIndex() + " / " + ws.getWriter() + " / " + ws.getWiseSaying());
        }
    }

    private static boolean delete(int number) {
        for (int i = 0; i < wsList.size(); i++) {
            if (wsList.get(i).getIndex() == number) {
                wsList.remove(i);
                return true;
            }
        }
        return false;
    }

    private static boolean edit(int number) {
        for (int i = 0; i < wsList.size(); i++) {
            if (wsList.get(i).getIndex() == number) {
                System.out.println("명언(기존) : " + wsList.get(i).getWiseSaying());
                System.out.print("명언 : ");
                String editedWiseSaying = scanner.nextLine();
                wsList.get(i).setWiseSaying(editedWiseSaying);

                System.out.println("작가(기존) : " + wsList.get(i).getWriter());
                System.out.print("작가 : ");
                String editedWriter = scanner.nextLine();
                wsList.get(i).setWriter(editedWriter);
                return true;
            }
        }
        return false;
    }
}
