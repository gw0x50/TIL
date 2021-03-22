# DAY 9

## 입출력 네트워크

## 파일 입출력

|      | 바이트                      | 문자 - 2바이트 |
| ---- | --------------------------- | -------------- |
|      | 텍스트-영문, 이미지, 동영상 |                |
| 입력 | InputStream                 | Reader         |
| 출력 | OutputStream                | Writer         |

|      | .txt, .gif, .jpg, .mp3 | .txt                                                        |
| ---- | ---------------------- | ----------------------------------------------------------- |
| 입력 | FileInputStream        | FileReader                                                  |
| 출력 | FileOutputStream       | FileWriter                                                  |
|      | File                   | 파일 입출력 기능이 없으며, 파일과 디렉토리 정보 제공 메소드 |

### 메소드

- File 생성

  ~~~ java
  File f1 = new File("c:/test/a/A.java"); //절대경로
  File f2 = new File("src/A.java"); //상대경로
  File f3 = new File("."); //현재경로
  File f4 = new File(".."); //현재의 상위 디렉토리 경로
  f1.isFile();
  ~~~

- 메소드

  - exists() - boolean
  - isFile / isDirectory() - boolean
  - canRead() / canWrite() - boolean
  - length() - 파일 총 바이트 수 / int
  - lastModified() - 수정최종시각 / long, 1/1000초 단위
  - getName() - 파일 명
  - getParent(), getXXXPath() - 파일 저장 경로명
  - createNewFile() / mkdir() / delete() - 파일 생성/삭제