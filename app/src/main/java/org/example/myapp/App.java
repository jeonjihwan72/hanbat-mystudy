package org.example.myapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/*
// 스프링 부트를 실행할 수 있도록 기본 정보를 자동 설정
@EnableAutoConfiguration

// 현재 클래스와 같은 패키지 및 하위 패키지를 모두 뒤져 컴포넌트를 찾아 자동 생성하는 설정
// @Component, @RestController, @Controller, @Service, @Repository가 붙은 클래스에서만 찾는다.
@ComponentScan
*/

@SpringBootApplication // = @SpringBootConfiguration + @EnableAutoConfiguration + @ComponentScan
public class App {
  public static void main(String[] args) {
    SpringApplication.run(App.class, args);
    System.out.println("스프링부트 서버 시작!");
  }
}
