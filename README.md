# hanbat-mystudy

한밭대학교 특강 실습 프로젝트 (전지환)

# Java & Gradle & Git 실무 팁 정리

## 🧑‍💻 Git 설정 및 명령어

### 기본 편집기 설정 (vi 편집기 → Visual Studio Code)

```bash
git config --global core.editor "code --wait"
```

### 원격 저장소 확인

```bash
git remote -v
```

### SSH 사용하여 원격 저장소 설정

```bash
git remote set-url origin git@github.com:user.id/repo.name.git
```

### .gitignore 생성 사이트

- [gitignore.io](https://gitignore.io)

---

## ⚙️ Java 컴파일 및 실행

### 컴파일

```bash
javac App.java
```

### 여러 파일 컴파일

```bash
javac App.java Utils.java
```

### 경로 단위 컴파일 (src 폴더 기준)

```bash
javac -d bin -sourcepath src src/App.java
```

### 실행 (확장자 붙이면 에러 발생)

```bash
java App
```

---

## 📦 JAR 파일 관련

### 메인 클래스 미지정 실행

```bash
java -cp app.jar App
```

### 메인 클래스 지정 후 실행

```bash
java -jar app.jar
```

### JAR 파일 생성 및 메인 클래스 설정

```bash
jar cfe app.jar App *.class
```

---

## 🛠 Gradle 관련

### 프로젝트 초기화

```bash
gradle init
```

### 소스 디렉토리 구조

```
src/
├── main/
│   ├── java/
│   └── resources/
└── test/
    ├── java/
    └── resources/
```

### 실행 명령어 예시

#### 출력 로그 자세히 보기

```bash
gradle classes --console=verbose
```

#### 출력만 보고 싶을 때

```bash
gradle run --quiet
```

#### 인코딩 깨질 때 (Windows)

```bash
chcp 65001
gradle run
```

#### devtools 적용

```groovy
developmentOnly 'org.springframework.boot:spring-boot-devtools'
```

#### mainClass 지정

```groovy
application {
    mainClass = 'org.example.myapp.App'
}
```

#### 한글 출력 인코딩 설정

```groovy
tasks.withType(JavaExec) {
    systemProperty 'sun.stdout.encoding', 'UTF-8'
    systemProperty 'sun.stderr.encoding', 'UTF-8'
}
```

#### OS 별 클래스패스 구분

- **Linux/Mac**
  ```bash
  java -cp bin:lib/guava-33.4.8-jre.jar org.example.myapp.App
  ```
- **Windows**
  ```bash
  java -cp bin;lib/guava-33.4.8-jre.jar org.example.myapp.App
  ```

---

## 🌐 패키지 구조

- 도메인 역순 → 제품명 순으로 구성
    - 예: `com.naver.search`, `kr.ac.hanbat.search`
- 명령어에서 경로는 파일 경로가 아닌 패키지 경로를 기준으로 작성해야 함

---

## 🧠 메모리 구조 및 객체 개념

| 개념         | 설명                                                       |
|------------|----------------------------------------------------------|
| Stack      | 기본적인 클래스의 코드 저장                                          |
| Heap       | `new` 키워드로 생성된 객체 저장                                     |
| 기본값        | `int`: 0, `float`: 0.0, `String`: null, `boolean`: false |
| 인스턴스 지역 변수 | 공유되지 않음, 각 인스턴스별로 별도 저장                                  |
| 레퍼런스 재할당   | 기존 객체는 가비지(쓰레기) 데이터가 됨                                   |

---

## 🔧 함수 유형

| 구분            | 설명                      |
|---------------|-------------------------|
| static 함수     | 외부 데이터 없이 파라미터만으로 동작 가능 |
| non-static 함수 | 클래스 내부의 데이터(필드 등) 필요    |

---

## 🚀 Spring Boot 개념

### 주요 애노테이션

| 애노테이션                      | 설명                   |
|----------------------------|----------------------|
| `@SpringBootApplication`   | 실행 클래스 지정, 아래 두 개 포함 |
| `@EnableAutoConfiguration` | 톰캣 등 서버 관련 설정 자동화    |
| `@ComponentScan`           | 하위 패키지 탐색하여 컴포넌트 등록  |

> `@SpringBootApplication = @SpringBootConfiguration + sssssssssssssssssss@EnableAutoConfiguration + @ComponentScan`

### 컴포넌트(빈) 개념

| 역할           | 어노테이션                            |
|--------------|----------------------------------|
| 요청을 받는 객체    | `@Controller`, `@RestController` |
| 요청을 처리하는 객체  | `@Service`                       |
| 데이터베이스 처리 객체 | `@Repository`                    |
| 기타 컴포넌트      | `@Component`                     |

### 메인 클래스 예시

```java

@SpringBootApplication
public class App {
    public static void main(String[] args) {
        System.out.println("스프링부트 서버 시작!");
    }
}
```

### 기본 실행 클래스 설정 예시

```java

@EnableAutoConfiguration
public class AppConfig {
}
```

> 실무에서는 일반적으로 실행 클래스와 대상 클래스를 나누지 않음

---

## 📌 개발 순서 요약

1. Gradle 설치 및 프로젝트 초기화
2. `build.gradle`에 Spring Boot 라이브러리 추가
3. 메인 클래스 설정
4. 필요한 컴포넌트 작성
5. 실행 및 테스트

---

## 응용 소프트웨어 종류

| 명칭              | 정의                                       |
|-----------------|------------------------------------------|
| Standalone      | 단독적으로 실행되는 프로그램                          |
| Client / Server | 단독으로 실행되지 않고 클라이언트와 서버의 상호작용으로 작동하는 프로그램 |

- Servlet의 규칙을 따라 만들 때와 Spring의 규칙을 따라 만들 때 코드의 절대적인 양이 차이가 있다. (Servlet LoC > Spring LoC)
- SpringBoot = Tomcat Server + SpringFramework
- DispatcherServlet은 사용자가 보낸 HTTP 요청 파라미터를 컨트롤러 메소드 인자로 변환하는 역할을 한다. 이 과정에서 문자열, 정수형, 실수형, 부울값 등으로 자동으로 변환된다.
- 사용자는 HTTP 요청을 통해 문자열 형태로 데이터를 서버에 전송하며, 서버는 이를 적절한 데이터 타입으로 변환하여 처리한다.
- ```@RestController```는 클라이언트에 리턴값을 보내는 어노테이션이고 ```@Controller```는 그 외에 리턴값을 보내는 어노테이션이다.

## 용어

### 기초 용어 약자

- HTTP : Hyper Text Transform Protocol
- HTML : Hyper Text Mark Language
- CSS : Cascading Style Sheets
- Java EE : Java Enterprise Edition

### 용어

- Servlet : 서버의 기능 중 작은 기능을 담당하는 자바 클래스
  > = Server Application + let(작은 조각을 의미하는 접미사)
- Container : Servlet 객체 생성·실행·소멸을 담당
- REST API : HTTP Client에서 호출하는 메소드
  > - REST API는 HTTP 프로토콜을 기반으로, ```GET```, ```POST```, ```PUT```, ```DELETE``` 같은 HTTP 메소드를 사용해 데이터를 주고받는다.
  > - REST API는 언어에 구애받지 않으며, 서버와 클라이언트가 서로 다른 언어로 개발되더라도 HTTP 프로토콜을 통해 통신할 수 있다.
  > - URL을 통해 리소스를 식별하고 요청을 보내며, 응답 데이터는 기본적으로 JSON 형식으로 주고받지만, 상황에 따라 다른 형식도 사용될 수 있다.
- Context Path : 기본 경로 주소
- Rendering : 파일을 읽어 최종 형태로 변환하는 과정
  > - 변수가 있으면 변수 자리에 값을 넣는다.
  > - 반복문이 있으면 태그를 반복 생성한다.
  > - 조건문이 있으면 조건에 따라 태그를 추가·삭제한다.
  > - ...

## 실무

### 실무 조언

- 실제 인재 수용력과 연봉 증가 추세가 웹 개발쪽이 우세한 경향이 강하게 보이기에 ```웹 개발 기술 + α``` 형태로 기술을 익기는 것을 권장한다.