# 네트워크

## TCP

| TCP Sever 클래스                                             | TCP Client 클래스                                  |
| ------------------------------------------------------------ | -------------------------------------------------- |
| ServerSocket 생성 (port : 9999)                              | Socket 생성 = Server 연결 (Server ip, port : 9999) |
| tcp 연결 클라이언트 대기 - 승인시 Socket 리턴                |                                                    |
|                                                              | Server로 데이터 전송 = Client 출력                 |
| Client로부터 데이터를 전송 받음 = Server 입력                |                                                    |
| 처리 결과를 Client로 전송 = Server 출력                      |                                                    |
|                                                              | Server로 부터 데이터를 전송 받음 = Client 입력     |
|                                                              | Socket Close = Server 연결 해제                    |
| Socket Close = Client 연결 해제, 또 다른 Client 요청 대기, 승인 |                                                    |



| java.io.DataInputStream --> DataOutputStream 출력된 데이터를 입력 받는 객체 | = java.util.Scanner 동일 |
| ------------------------------------------------------------ | ------------------------ |
| java.io.DataOutputStream --> 출력시 데이터 변환              |                          |



public static void main(String[] args) = public static void main(String... args)



- DAO = DATA ACCESS OBJECT 클래스
  - 데이터 접근 객체 = 파일 입출력/DB 입출력
- DTO = DATA TRANSFER OBJECT 클래스
- VO = VALUE OBJECT 클래스
- DO = DATA OBJECT 클래스
-  EmployeeDTO = VO = DO
- Controller = 제어 클래스
  - 사원 등록 -> 등록이 필요한 데이터 입력 -> EmployeeDAO -> EmployeeVO -> 저장
  - ---> Controller -> ManagerDAO -> ManagerVO -> 저장