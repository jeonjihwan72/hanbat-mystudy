package org.example.myapp;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

  @GetMapping("/hello") // HTTP GET 요청을 처리하는 메서드 지정
  public String hello() {
    return "hello, world"; // 클라이언트에게 리턴할 콘텐트
  }

  @GetMapping("/hello2") // URL 경로에서 name 값을 받음
  public String helloWithName(String name) {
    return "안녕하세요, " + name + "님!"; // 입력받은 이름을 포함한 메시지 리턴
  }
}
