# hanbat-mystudy

한밭대학교 특강 실습 프로젝트 (전지환)

## Tips

- Git에서의 Commit의 기본 편집기를 Visual Studio Code로 변경하는 방법

```bash
git config --global core.editor "code --wait"
```

- 프로젝트 생성 시 직접 폴더를 생성하기보다는 아래의 코드와 같이 gradle을 사용하여 생성하는 것이 권장된다.

```bash
gradle init
```

- 현재 cmd가 가리키고 있는 위치를 확인하는 명령어

```
git remote -v
```

- ssh를 사용한 통신 방법

```
git remote set-url origin git@github.com:user.id/repo.name.git
```

- java코드를 class파일(기계어에 가까운 형태)로 변환하는 코드

```
javac App.java
```

- 만들어진 클래스 파일을 실행하는 코드 (바이트 코드를 읽는 코드)
    - 바이트 코드 인터프리터
    - 자바 가상 머신 (JVM)

```
# 확장자명을 붙이면 에러발생
java.exe App
```

- .gitignore 파일 생성하는 사이트

> [gitignore.io](https://gitignore.io)

- [java byte code 구성](https://medium.com/@davethomas_9528/writing-hello-world-in-java-byte-code-34f75428e0ad)

---

아래의 두 코드는 결과적으로 동일한 결과를 출력하지만

```
jar cfe app.jar App *.class
```

커맨드를 통해 사전에 jar 파일에 메인을 설정해야 한다

1. jar 명령어 x

```
java -cp app.jar App
```

2. jar 명령어 o

```
java -jar app.jar
```

---

- Java Compiler를 통해 여러 개의 .java 파일을 컴파일링 할 때 아래와 같이 병렬적으로 나열하여 명령어를 작성한다.

```
javac App.java Utils.java
```

- Java Compiler를 병렬적으로 할 때 파일이 많다면 아래의 코드로 경로를 지정하여 경로 단위로 컴파일한다. (단 파일들이 src 폴더 아래에 있어야 한다.)

```bash 
javac -d bin -sourcepath src src/App.java
```

---

- 패키지화 할 때 (도메인 역순) - (제품 명) 순으로 구성하는 것이 관례
    - ex. naver.com의 검색 기능
      > com → naver → search → search.java
    - ex. hanbat.ac.kr의 검색 기능
      > kr → ac → hanbat → search → search.java

- command line에서 패키지를 경로로 지정해서는 안되고 클래스를 선언할 때에는 반드시 최상위 패키지부터 경로대로 작성하며 호출해야 한다.

- os 환경에 따라 아래의 코드가 변경된다.

```
# Linux OS, Mac OS
java -cp bin:lib/guava-33.4.8-jre.jar org.example.myapp.App

# Windows
java -cp bin;lib/guava-33.4.8-jre.jar org.example.myapp.App
```

- gradle에서의 소스폴더는 main - java, main - resources, test - java, test - resources 폴더이다.

- 파일은 백업이 되지만 빈 폴더는 백업이 되지 않음

- 실무에서는 gradle을 사용하고 팀 프로젝트에서 실행해볼 때에는 gradlew를 사용하여 실행함으로써 환경적 차이를 상쇄하여 확인할 수 있다.

- gradle에서 어떠한 코드가 작동되었는지, 어떤 순서로 실행되었는지 확인하기 위해서는 --console=verbose를 추가한다.

> ex.

```commandline
gradle classes --console=verbose
```

- gradle에서 출력내용만 확인하고 싶다면 --quiet 옵션을 사용한다.

> ex.

```commandline
gradle run --quiet
```

- 계층 관계는 공식 문서에서 확인할 수 있음. [gradle.org](https://docs.gradle.org/current/userguide/java_plugin.html)

- 제품 개발 시 프로그래밍 언어의 버전은 고객·고객사의 사용 버전을 기준으로 설정

> 버전 변경으로 인한 피해 발생시 피해보상 청구 소송에 걸릴 수 있음

- build.gradle에서는 설정하는 것으로 보이지만 실질적으로는 method를 호출하는 형태이다.

- static function vs non-static function

> - static : 파라미터 외의 외부 데이터가 필요하지 않음
> - non-static : 파라미터 외의 외부 데이터가 필요함

- 명령 프롬프트에서 한글이 깨지는 경우 명령 프롬프트에서는 기본적인 인코딩 방식이 CP949이기 때문에 발생할 가능성이 높다.
- 이 경우 아래의 코드를 통해 UTF-8로 출력하도록 설정한 뒤 ```gradle run``` 을 실행한다.

```
chcp 65001
```

- 기본적인 class의 코드는 Stack에 저장된다.
- ```new``` 변수를 통해 만들어지는 것은 Heap에 저장된다.

- 별도의 초기화를 하지 않은 인스턴스의 기본값
  > - int : 0
  > - float : 0.0
  > - string : null
  > - boolean : False

- 같은 클래스에서 파생된 인스턴스라도 클래스 내의 지역변수를 공유하지 않으며 각각의 지역변수를 별도로 할당하여 적용한다.

- 기존의 변수에 새로운 레퍼런스 생성을 시도할 경우, 기존의 변수는 새로운 주소를 할당 받고 새로운 인스턴스가 생성된다.
- 이때, 기존의 주소의 데이터는 가비지 데이터(Garbage Data)가 되며, 이 주소는 추후 새로운 데이터가 주소를 차지할 수 있게 된다.

- 실무에서는 레퍼런스와 객체를 별도로 구분하지 않고 '객체'로 동일하게 칭함.

- application 플러그인은 기본적으로 java 플러그인을 내장하고 있다.

- 메인 클래스 설정

```
application {
    mainClass = 'org.example.myapp.App'
}
```

- Windows console에서 한글이 깨질 때

```groovy
tasks.withType(JavaExec) {
    systemProperty 'sun.stdout.encoding', 'UTF-8'   // 한글이 깨지는 경우 사용(출력 인코딩 UTF-8로 설정)
    systemProperty 'sun.stderr.encoding', 'UTF-8'   // 한글이 깨지는 경우 사용(에러 출력 인코딩 UTF-8로 설정)
}
```

SpringBoot에서 main 메소드가 여러 개인 경우 아래와 같이 ```@SpringBootApplication``` 애노태이션(annotation)을 클래스 앞에 붙여주어 메인 클래스임을 명시한다.

```java

@SpringBootApplication
public class App {
    public static void main(String[] args) {
        System.out.println("스프링부트 서버 시작!");
    }
}
```

- ```this.변수·메소드명```에서의 this는 해당되는 객체의 주소를 가지고 있는 변수이다.

- SpringBoot 서버를 실행하는 클래스에 ```@EnableAutoConfiguration``` 어노테이션을 붙여줘야 한다.
- ```@EnableAutoConfiguration```: 톰캣 서버 실행에 관련된 기초 설정을 자동으로 처리
- 실무에서는 일반적으로 서버 시작 클래스와 실행 대상 클래스를 나누지 않는다.
- ```@SpringBootApplication```이 적용되는 클래스와 ```@EnableAutoConfiguration```이 적용되는 클래스가 같은 경우,
  ```@SpringBootApplication``` 어노테이션만 붙여주면 된다.

> ex.

```java

@EnableAutoConfiguration
public class AppConfig {

}
```

- 전체 과정
  > 1. gradle 설치 및 적용
  > 2. springboot 라이브러리 build.gradle에 저장


- ```@GetMapping(path = "/hello/hi")```: URL와 메소드를 연결해주는 어노테이션

- ```@EnableAutoConfiguration``` 만 사용할 경우 생성자가 자동 호출되지 않는다.
- 만약 ```@SpringBootApplication```을 사용하지 않고 ```@EnableAutoConfiguration```을 사용하는 경우 ```@ComponentScan```을 같이 써서
  다른 클래스를
  바라볼 수 있도록 해야 한다.
- ```@ComponentScan```: 현재 클래스와 같은 패키지 및 최하위 패키지를 모두 뒤져 컴포넌트를 찾아 자동 생성하는 설정
  > @Component, @RestController, @Controller, @Service, @Repository가 붙은 클래스에서만 찾는다.

- ```@SpringBootApplication``` = ```@SpringBootConfiguration``` + ```@EnableAutoConfiguration``` + ```@ComponentScan```

- 객체 = Bean(빈) = 인스턴스 = 컴포넌트
  > 컴포넌트(Component) : 역할이 주어진 객체
  > 사용자의 요청에 반응하는 컴포넌트 : 컨트롤러
  > 사용자의 요청을 처리하는 컴포넌트 : 리포지토리
  > 업무를 처리하는 컴포넌트 : 서비스

- 아래의 코드는 기존의 컨트롤러의 변경사항을 자동으로 반영하도록하는 코드이다.

```groovy
developmentOnly 'org.springframework.boot:spring-boot-devtools'
```