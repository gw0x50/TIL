# DAY 8

## 중첩 클래스

``` java
class A() {
  class B() {
    
  }
}
```

- instance 멤버 내부 클래스
- static 멤버 내부 클래스
- 메소드 내부 - 지역 내부 클래스
- 익명 내부 클래스 - 상속 인터페이스 구현 / 객체 생성

## lambda 식

제네릭 람다 익명클래스f

메소드 정의 - 클래스가 없을 수도 있다.

람다 - 매개변수 선언 실행 문장 블록

​	무명의 메소드

(타입 변수명, , , ) -> {실행문장 블록}

(변수명 , , ) -> {실행문장 블록}

() -> {실행문장 블록}

변수명 -> {실행문장 블록}

변수명 -> 실행문장;

``` java
class A {
  int add(int x, int y) {
    return x + y;
  }
}

(x, y) -> {return x + y;};

I i1 = (x) -> {...}; // I 타겟 타입 람다식
// I 상속 하위 클래스(무명, 유명) 정의 객체 생성
i1.m1(10);
```

## 입출력 / 네트워크

|      | 1바이트 / 이미지 동영상 음향 | 2바이트 / 문자 기반 |
| ---- | ---------------------------- | ------------------- |
|      |                              |                     |
|      |                              |                     |
|      |                              |                     |

