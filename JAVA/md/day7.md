# DAY 7

## 컬렉션 프레임워크

- 배열 - 여러가지 데이터 저장 구조
  - 동일 타입 데이터만 저장 구조
  - (형변환 가능하면 동일 타입 간주)

- collection framework 클래스들
  - 클래스로 다중상속 메소드 오버라이딩 구현
  - 순서 데이터 관리 = 인덱스 사용 가능
  - 같은 데이터 중복 저장 허용
- HashSet, TreeSet 클래스들 -> 검색속도 빠름
- java.util.Map 인터페이스 - 메소드 구현 X
  - 클래스로 다중상속 메소드 오버라이딩 구현
  - (키, 값)의 한 쌍
  - 키는 중복 X, 값 중복 O
  - HashMap, HashTable, Properties 

|       List       | Set              | Map                             |
| :--------------: | ---------------- | ------------------------------- |
|   데이터 = 값    | 데이터 = 값      | 데이터 = (키, 값)               |
|    순서 있음     | 순서 없음        | 순서 없음                       |
| 중복 데이터 허용 | 중복 데이터 불가 | 키 중복 허용 X / 값 중복 허용 O |
|    ArrayList     | HashSet          | HashMap                         |

- 여러 가지 데이터 타입 저장 가능
- 동적 크기 변경
- 참조형 데이터만 저장 가능

### ArrayList

#### 생성자

``` java
int i[] = new int[50]; // 데이터 타입과 크기 선언 O
ArrayList list = new ArrayList; // 데이터 타입과 크기 선언 X 
ArrayList list = new ArrayList; // 최초의 객체 5개 생성, 부족하면 자동으로 5개씩 증가.
ArrayList list = new ArrayList; // 최초의 객체 5개 생성, 부족하면 자동으로 3개씩 증가.
```

#### 메소드

- 저장

  - add(Object o) / insertAt(Object o, int index)

    ```java
    list.add(100); // int 기본형 = Integer 클래스 객체 참조형
    list.add(3.14); // double 기본형 = Double 클래스 객체 참조형
    list.add("aaa");
    ```

- 수정

  - set(int index, Object o)

    ``` java
    list.set(1, "java");
    ```

- 삭제

  - remove(int index)

    ``` java
    list.remove(1);
    ```

- 조회

  - size() / 데이터 개수 조회

  - contains(Object o) / 데이터 저장여부 조회

  - indexOf(Object o) / 데이터 저장위치 조회

  - get(int index) / 특정 위치 저장데이터 조회

  - -> LikedList, Vector

    ``` java
    list.size(); // return int
    list.contains(Object o); // return boolean 
    list.indexOf(Object o); // return int
    list.get(int index); // return Object
    ```

### HashSet

#### 생성자

``` java
HashSet set = new HashSet(); // 길이 동적 유지 / 여러 타입 저장 가능
HashSet<A> set = new HashSet<A>(); // 길이 동적 유지 / 한 타입 저장
```

- 저장

  - add(Object o) / insertAt(Object o, int index)

    ``` java
    set.add(100); // int 기본형 = Integer 클래스 객체 참조형
    set.add(3.14); // double 기본형 = Double 클래스 객체 참조형
    set.add("aaa");
    ```

- 조회

  - Iterator<E>

    ``` java
    Iterator it = set.iterator();
    while(it.hasNext()) {
    	Object o = it.next();
    }
    Iterator<A> it = set.iterator();
    while(it.hasNext()) {
    	A o = it.next();
    }
    ```

### HashMap

#### 생성자

~~~ java
HashMap map = new HashMap();
HashMap<String> map = new HashMap<String>();
HashMap<String> map = new HashMap();
~~~

#### 메소드

- 저장

  - put(Object key, Object o)

    ```java
    map.put("id", 100);
    map.put("score", 100);
    map.put("id", 200); // id key 값을 수정
    ```

- 조회

  - get(Object key)

    ``` java
    map.get("id");
    ```

    



