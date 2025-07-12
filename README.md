# OrbitRise - 개발자 스터디 관리 플랫폼

각자의 궤도에서 서로 성장하는 개발자들을 위한 **스터디 운영 플랫폼**입니다.  
스터디 리더 혼자 고생하지 않아도, 구성원이 함께 책임지고 성장할 수 있도록 설계했습니다.

## ✨ 프로젝트 개요
- **목표:** 깃허브, 디스코드, 회비 관리 기능을 통합한 실용적 스터디 운영 시스템 구축
- **대상:** 정기적 스터디를 운영하거나 참여하는 개발자/학생/커뮤니티 리더
- **형태:** 개인 토이 프로젝트 (기획/DB설계/개발 전반 담당)

---

## 🧩 주요 기능

| 도메인           | 핵심 기능                                                   |
| ------------- | ------------------------------------------------------- |
| 👤 **사용자 관리** | 회원가입 (아이디/비번/포지션/소개), JWT 로그인, 외부 링크 등록, 마이페이지 정보 조회    |
| 📚 **스터디 관리** | 스터디 생성/공개 설정, 가입 신청 및 승인, 권한 구조(운영자/팀원) 관리              |
| 👥 **팀 구성**   | 팀 사용 여부 설정, 팀 단위 활동, 팀원 배정 및 관리                         |
| 📝 **회차 관리**  | 일정별 회차 생성, 발표자/주제/출석 정보 등록, 팀 단위 or 전체 구성               |
| 📒 **활동 일지**  | 공부일지/발표/회의록 작성, 피드백 기능, 작성자 수정 제한, GitHub 연동 예정         |
| 🗣 **회의록/공지** | 운영자 전용 공지/회의록 작성, 고정 공지/일자별 내용 기록, 마크다운 또는 에디터 고려       |
| 🔗 **외부 연동**  | GitHub URL 또는 OAuth 연동, Discord Webhook 통한 자동 메시지 발송 기능 |


---

## 🛠 기술 스택

- **Backend:** Java 17, Spring Boot 3.4.3, Spring Security, JPA (Hibernate 5)
- **DB:** OracleDB (개발 중 Oracle 병렬 테스트 진행)
- **Infra:** CloueType, GitHub Actions
- **Tool:** IntelliJ, DBeaver, Postman, GitHub

---

## ⚙️ 내가 담당한 역할

- 전체 서비스 기획 및 화면 플로우 설계
- DB 모델링 (ERD, 테이블 정의, PK/FK, 주석 등)
- 사용자 인증 및 권한별 접근 제어 구현
- 출결 로직 및 공부일지 기록 API 개발
- 팀 프로젝트 시나리오 기반 테스트 설계

---

## 🖼️ 화면 설계 (Figma)

> 서비스 전체 흐름과 UI는 디자이너와 협업하여 Figma 기반으로 설계하였습니다.  
> 👉 [Figma 화면 기획 보기](https://www.figma.com/file/your-figma-link-goes-here)

(추후 실제 화면 구현 캡쳐도 업데이트 예정)

---

## 🧰 데이터베이스 설계

> 전체 서비스 흐름을 고려하여 직접 ERD를 설계하고 모델링하였습니다.  
> 👉 [ERD 보기 (ERD Cloud)](https://www.erdcloud.com/d/77DYzjE5Sw8ewHoc2)

---

## 📄 프로젝트 기획 문서

> 프로젝트 개요, 요구사항, 플로우, 페이지 구성을 Notion 기반으로 정리하였습니다.  
> 👉 [orbitRise Notion 기획서 보기](https://burly-viper-81b.notion.site/orbitRise-20715d338b3480c1a33dcbbf1437265f?source=copy_link)


---

## 🧪 실행 방법 (개발용)

```bash
git clone https://github.com/seedWave/orbitRise.git
cd orbitRise
./gradlew bootRun
