# csv-generator
### 가이드
#### 앱 실행
1. 터미널(CMD, PowerShell, iTermn) 실행
2. 프로젝트 루트로 이동
3. `.\gradle clean build` 명령어로 build 수행
4. csv-generator.jar 파일 경로로 이동
5. `java -jar csv-generator.jar` 명령어로 앱 실행
#### 앱 사용법
1. 저장할 파일 명 입력 (영문, 확장자명x)
2. 생성 방법 선택
    - 데이터 자동 생성 -> 'A' 입력
    - 데이터 직접 입력 -> 'M' 입력 (개발 예정)
3. 컬럼 이름 입력
    - 다음 Step 이동 -> '!Y' 입력
    - 이전에 입력한 컬럼 삭제 -> '!R' 입력
5. 컬럼별 타입 입력
    - sequance / integer / double / char / string / boolean
6. 생성할 row 수 입력
7. files 디렉토리에 csv 파일 생성
#### 추가 예정
- 이름 / 이메일 / 연락처 / 주소 / 날짜 데이터 생성기
- 한글 인코딩
