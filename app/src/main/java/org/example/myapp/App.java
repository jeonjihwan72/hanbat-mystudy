package org.example.myapp;

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

    //    Scanner scanner = new Scanner(System.in);
    //    System.out.print("이름? ");
    //    String name = scanner.nextLine();
    //    System.out.printf("안녕하세요 %s 님!\n", name);
    //    scanner.close();

    class Calculator {
      int result;

      void plus(int a) {
        this.result += a;
      }

      void minus(int a) {
        this.result -= a;
      }
    }

    Calculator c1 = new Calculator(); // 객체 주소를 담아둔 c1은 'reference'라고 한다.
    Calculator c2 = new Calculator();

    c1.plus(100); // 실무에서는 레퍼런스와 객체를 구분하지 않고 '객체'로 동일하게 칭한다.
    c2.plus(555);

    c1 = new Calculator();
  }
}
