# hanbat-mystudy
한밭대학교 특강 실습 프로젝트 (전지환)

github commit with VS code test

## Tips

- Git에서의 Commit의 기본 편집기를 Visual Studio Code로 변경하는 방법 

```bash
git config --global core.editor "code --wait"
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