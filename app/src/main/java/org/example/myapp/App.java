package org.example.myapp;

import java.util.Scanner;

/** 이 클래스는 한밭대학교 특강 실습 예제를 위한 첫 번재 클래스입니다. <code>App</code> 클래스! */
public class App {

  /**
   * 프로그램의 진입점(entry point) 메서드입니다. 콘솔에 메시지를 출력합니다.
   *
   * @param args 명령행 인수 배열 (이 프로그램에서는 사용되지 않음)
   */
  public static void main(String[] args) {
    //    Scanner scanner = new Scanner(new FileInputStream("a.txt"));
    //    Scanner scanner = new Scanner(new ByteArrayInputStream());
    Scanner scanner = new Scanner(System.in);
    System.out.print("이름? ");
    String name = scanner.nextLine();
    System.out.printf("안녕하세요 %s 님!\n", name);
    scanner.close();
  }
}
