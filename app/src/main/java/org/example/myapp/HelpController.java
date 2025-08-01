package org.example.myapp;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller // request handler의 리턴 값은 Thymeleaf가 실행할 view(템플릿 파일) 이름이다.
public class HelpController {

  @GetMapping("/help")
  public String help() {
    // 이때 리턴하는 문자열은 파일의 이름이어야 한다.
    return "help"; // 리턴 값은 클라이언트에게 보낼 콘텐츠가 아니다. Thymeleaf 엔진에게 알려줄 템플릿 파일 이름이다.
  }
}
