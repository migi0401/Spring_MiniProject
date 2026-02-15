# 🏃‍♂️Spring Mini Project
> **Spring Boot와 React Native를 연동**

## 1. 📖 프로젝트 소개
기존에 제작한 만보기 화면에 직접 설계한 백엔드 코드를 연동해본 프로젝트입니다.
백엔드 학습을 위해 인프런 강의를 수강하고 **Spring Boot**를 사용하여 API 서버를 구축하였으며, **React Native(Expo)**를 통해 안드로이드 앱을 구현하여 실제 데이터를 연동해보는 것을 목표로 했습니다.

- **개발 기간:** 2026.02.02 ~ 2026.02.27 (약 4주)
- **개발 인원:** 1인 개인 프로젝트

## 2. 🛠️ 기술 스택 (Tech Stack)

### Backend
- **Java 25**, **Spring Boot 4.0.2**
- **Spring Data JPA**, **H2 Database** (로컬 개발용)
- **Gradle**

### Frontend
- **React Native**, **Expo**
- **JavaScript**
- **Axios** (미정)

### Tools & DevOps
- **IntelliJ IDEA**, **VS Code**
- **Git**, **GitHub**
- **Postman** (API 테스트)

## 3. 💡 주요 기능
1. **회원가입/로그인**: JWT 기반 인증 (미정)
2. **걸음 수 측정**: Expo Sensors를 활용한 실시간 걸음 수 추적
3. **포인트 적립**: 백엔드 API와 통신하여 포인트 이력 추적
4. **쿠폰 정보**: DB 조회를 통한 쿠폰 정보 표시

## 4. 🏛️ 아키텍처 및 설계
추후 예정

### ERD (데이터베이스 설계)
- **User**: 사용자 정보 (id, username, nickname, userPoint)
- **StepInfo**: 일일 걸음 기록 (user_id, step_count, date)
- **CouponInfo**: 쿠폰 정보 (user_id, coupon_name, valid_date)
- **PointHistory**: 이력 정보 (user_id, amount, description, createdAt)

## 5. 🔥 트러블 슈팅 (Trouble Shooting)
> 개발 중 발생한 문제와 해결 과정을 기록했습니다.

### 1) 자바 & 스프링부트 버전 다운그레이드
자바 25 와 부트 4.0.2 에서 자바 21 과 부트 3.5.10 으로 변경하고자 하였습니다. 허나, 기존 단위 테스트를 실행하였을 때 쿼리가 보내지지 않는 문제가 발생하였음을 확인하였습니다.
Cannot compare left expression of type 'Member' with right expression of type 'String' 이러한 로그가 뜨는 것을 발견하였고, 
Member 타입의 member를 String타입으로 검색하려고 하여 오류가 발생하는 것을 인지하였습니다.
비슷한 오류로 Cannot compare left expression of type 'java.time.LocalDate' with right expression of type 'java.lang.String' 도 발견하여 타입을 변경해주니 정상 작동함을 확인하였습니다.

### 2)


## 6. 📝 배운 점 & 회고
- 김영한 님의 스프링 강의에서 배운 **JPA의 영속성 컨텍스트** 개념을 실제로 적용해 보며, 엔티티 업데이트 시점이 언제 발생하는지 직접 확인할 수 있었습니다.
- @DataJpaTest를 통해 웹 상으로 구현하지 않아도 테스트가 가능함을 확인했습니다. 스프링 데이터 JPA가 서버를 작동시켜 h2 데이터베이스를 사용하여 검증합니다.


## 7. 커밋 컨벤션 (Commit Convention)

| 타입 | 설명 |
|-|-|
| **feat** | 새로운 기능 추가 |
| **fix** | 버그 수정 |
| **docs** | 문서 수정 (README, 주석, 가이드 등) |
| **style** | 코드 포맷팅, 세미콜론 누락, 오타 수정 (로직 변경 없음) |
| **refactor** | 코드 리팩토링 (기능 변경 없이 구조만 개선) |
| **test** | 테스트 코드 추가/수정 |
| **chore** | 빌드 설정, 패키지 매니저 설정, 라이브러리 추가 (코드 변경 없음) |


## 8. 🚀 설치 및 실행 방법 (How to run)
### Backend
```bash
cd backend
./gradlew bootRun


