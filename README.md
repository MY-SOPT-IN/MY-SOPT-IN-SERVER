# My SOPT In
SOPT 32기 합동 세미나 모바일 8조 서버

## GO SOPT CDS SEMINAR - Mobile 8
### 🧑‍💻 Developers
| 정동규 | 전선희 |
| :---: | :---: | 
|[yummygyudon](https://github.com/yummygyudon)|[funnysunny08](https://github.com/funnysunny08)| 

 ### 🐾 Roles
| 기능명 | 엔드포인트 | 담당자 |
| :-----: | :---: | :---: |
| 회고 단일 조회 | [GET] /retro?date=${date} | `전선희` | 
| 회고 전체 조회 | [GET] /retro/all?month=${month} | `전선희` | 
| 회고 추가 | [POST] /retro | `정동규` | 
| 회고 수정 | [PUT] /retro/${retroId} | `정동규` | 

### ⌨️ Code Convention

<details>
<summary>변수명</summary>   
<div markdown="1">
 
 1. Camel Case 사용 
   - lower Camel Case
 2. 함수의 경우 "동사+명사" 사용 
   - ex) getStatus()
 3. flag로 사용 되는 변수는 조동사 + flag 종류로 구성 
   - ex) isExist
 4. 약어는 되도록 사용하지 않는다.
   - 부득이하게 약어가 필요하다고 판단되는 경우 팀원과 상의를 거친다.
 
</div>
</details>

<details>
<summary>주석</summary>
<div markdown="1">       

 1. 한줄 주석은 // 를 사용한다.
  ```java
    // 한줄 주석일 때
    /**
    * 여러줄
    * 주석일 때
    */
  ```
 2. Bracket 사용 시 내부에 주석을 작성한다.
  ```java
    if (a == 5) {
	  // 주석
    }
  ```
 
</div>
</details>

### 🌿 Branch Strategy

<details>
<summary>Git Workflow</summary>
<div markdown="1">       

```
main → feature/#issue_num
issue_num : issue 번호에 맞게 생성

1. issue 생성
2. local - feature/#issue_num 에서 각자 기능 작업 (issue_num : issue 번호에 맞게 생성)
3. remote - feature/#issue_num 에 Push
4. remote - main 으로 PR
5. 코드 리뷰 후 Confirm 받고 remote - main Merge
6. remote - main 에 Merge 될 때 마다 모든 팀원 local - main pull 받아 최신 상태 유지
 ```

</div>
</details>


| Branch Name | 설명 |
| :---: | :-----: |
| main | 구현 완료 브랜치 |
| feature/#issue_num | 이슈 별 기능 구현 브랜치 |

### 📌 Commit Convention

##### [TAG] 메시지 => [feature/#issue_num] TAG: commit message

| 태그 이름  |                             설명                             |
| :--------: | :----------------------------------------------------------: |
|  [CHORE]   |                  코드 수정, 내부 파일 수정                   |
|   [FEAT]   |                       새로운 기능 구현                       |
|   [ADD]    | FEAT 이외의 부수적인 코드 추가, 라이브러리 추가, 새로운 파일 생성 |
|  [HOTFIX]  |             issue나 QA에서 급한 버그 수정에 사용             |
|   [FIX]    |                       버그, 오류 해결                        |
|   [DEL]    |                     쓸모 없는 코드 삭제                      |
|   [DOCS]   |                 README나 WIKI 등의 문서 개정                 |
| [CORRECT]  |       주로 문법의 오류나 타입의 변경, 이름 변경에 사용       |
|   [MOVE]   |               프로젝트 내 파일이나 코드의 이동               |
|  [RENAME]  |                파일 이름 변경이 있을 때 사용                 |
| [IMPROVE]  |                     향상이 있을 때 사용                      |
| [REFACTOR] |                   전면 수정이 있을 때 사용                   |

### 📁 Project Foldering
```
📁 server _
|_ 📁 common _
|_ 📁 controller _
|_ 📁 domain _
|_ 📁 exception _
|_ 📁 infrastructure _
|_ 📁 service _
|_ ServerApplication
```

### 🥫 ERD
<img width="320" alt="image" src="https://github.com/funnysunny08/Algorithm-java/assets/88873302/af3117aa-f7d8-48fb-b3a7-ff916426d76d">
