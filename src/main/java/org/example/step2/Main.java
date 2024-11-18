package org.example.step2;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("== 명언 앱 ==");

        while (true) {
            System.out.print("명령) ");
            String option = scanner.nextLine();
            if (option.equals("등록")) {
                System.out.print("명언 : ");
                String wiseSaying = scanner.nextLine();
                System.out.print("작가 : ");
                String writer = scanner.nextLine();
            } else if (option.equals("종료")) {
                break;
            }
        }
        scanner.close();
    }
}
