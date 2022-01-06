# 한 줄 일기장(코틀린)
## 기존에 만든 자바 버전을 참고하여 코틀린 버전으로 새로 작업
 
### 한 줄 일기장의 기본 기능
1. 일기 리스트 조회(메인 화면)
2. 일기 작성
3. 일기 수정
4. 일기 삭제

### 한 줄 일기장의 구성 과정

* 1차 - 화면 구성 및 기본 기능 구현(22/01/03 ~)
  * 화면 구성
    * 메인 화면
    * 입력 화면   
    * 상세 화면 및 수정 화면
 
  * 데이터 베이스 연동
    * 기기의 로컬 데이터베이스 사용
    * MVVM 패턴(Model View ViewModel)과 Jetpack의 구성요소 AAC(Android Architecture Component)를 사용
      * LiveDate, ViewModel, repository, Room 등 
    * 조회, 저장, 수정, 삭제
