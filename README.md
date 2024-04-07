# java-baekjoon-setup

## 프로젝트 생성
- IntelliJ에서 일반 자바 프로젝트 생성(Build system: IntelliJ)
- 이유: 백준에 문제 제출 시 패키지 제거 스텝이 필요 없도록

<br>

## 해두면 편한 세팅

- [저장 시 자동 정렬 및 안쓰는 import 정리하도록 설정](https://velog.io/@viiviii/intelliJ-trigger-actions-when-saving-changes)
- [자주 쓰는 코드 Live Template 등록](https://velog.io/@viiviii/IntelliJ-Live-Templates-Setting)

<br>

## 등록해둔 Live Template

### 메인 셋업
```java
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;


public class Main {

    public static void main(String[] args) throws Exception {
        //준비
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        //입력
        String input = br.readLine();

        //풀이
        new Main().solution();

        //출력

        //정리
        bw.flush();
        br.close();
        bw.close();
    }

    public void solution() {

    }
}
```

### 예시 셋업

```java
@Example
void example$NUMBER$() {
    input("""
            $INPUT$""");

    run();

    assertOutputEqualTo("""
            $OUTPUT$""");
}
```

<br>

## 사용

백준 입출력 복사 해서 붙여넣기 한 후 `Examples.class`의 `main` 메서드 실행

```java
@Example
void example1() {
    input("""
            6 7 3
            .......
            ...O...
            ....O..
            .......
            OO.....
            OO.....""");

    run();

    assertOutputEqualTo("""
            OOO.OOO
            OO...OO
            OOO...O
            ..OO.OO
            ...OOOO
            ...OOOO""");

}
```




