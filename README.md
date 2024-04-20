# REST API - Event 생성, 조회, 수정 

## 💻프로젝트 소개
-  Self-Describtive Message와 HATEOAS를 만족하는 REST API를 구현
-  REST Docs를 통하여 REST API 문서화

## 사용기술
- 스프링 부트
- 스프링 데이터 JPA
- 스프링 HATEOAS
- 스프링 REST Docs
- 스프링 시큐리티 OAuth2

### [블로그 링크](https://velog.io/@cse05091/series/REST-API)

## 스프링 REST Docs 구현

![image](https://github.com/dlcksgh1/REST-API/assets/119422058/81337e06-37e1-4c19-a52d-326b53449ec4)


## 엑세스 토큰발급
#### Authorization type 을 Basic Auth로 설정하고  client-id, client-secret를 입력
![image](https://github.com/dlcksgh1/REST-API/assets/119422058/057a79ab-76e1-4c55-97fa-1d833f729bab)

#### Body 에 username,password, grant_type 정보를 입력하여 요청하면 access_type이 bearer 인 access_token 정보를 받을 수있다. 
![image](https://github.com/dlcksgh1/REST-API/assets/119422058/85fc0eec-ebed-4ef2-b066-d4b13e8bfea3)

## Api root 요청

#### API가 제공하는 resource 정보를 볼 수 있다.
![image](https://github.com/dlcksgh1/REST-API/assets/119422058/3989d113-d470-4f43-8ff8-e5a15d89c3e2)

#### Event 목록 조회

![image](https://github.com/dlcksgh1/REST-API/assets/119422058/bacf54c6-d18e-42ae-a3f9-220b990d9603)
