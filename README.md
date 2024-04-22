# REST API - Event 생성, 조회, 수정 

## 💻프로젝트 소개
-  Self-Describtive Message와 HATEOAS를 만족하는 REST API를 구현
-  REST Docs를 통하여 REST API 문서화

 ## 📌 사용기술
- 스프링 부트
- 스프링 데이터 JPA
- 스프링 HATEOAS
- 스프링 REST Docs
- 스프링 시큐리티 OAuth2

### [블로그 링크](https://velog.io/@cse05091/series/REST-API)

- ## 스프링 REST Docs 구현

![image](https://github.com/dlcksgh1/REST-API/assets/119422058/81337e06-37e1-4c19-a52d-326b53449ec4)


- ## 엑세스 토큰발급
#### Authorization type 을 Basic Auth로 설정하고  client-id, client-secret를 입력
![image](https://github.com/dlcksgh1/REST-API/assets/119422058/057a79ab-76e1-4c55-97fa-1d833f729bab)

#### Body 에 username,password, grant_type 정보를 입력하여 요청하면 access_type이 bearer 인 access_token 정보를 받을 수있다. 
![image](https://github.com/dlcksgh1/REST-API/assets/119422058/85fc0eec-ebed-4ef2-b066-d4b13e8bfea3)

- ## 엑세스 토큰갱신
#### Authorization type 을 Basic Auth로 설정하고  client-id, client-secret를 입력해준다.
![image](https://github.com/dlcksgh1/REST-API/assets/119422058/057a79ab-76e1-4c55-97fa-1d833f729bab)
#### Body 에 grant_type에 refresh_token, refresh_token에 엑세스 토큰발급받을 때 같이 발급받았던 refresh_token에 정보를 입력하여 요청하면 access_type이 bearer 인 access_token 정보를 받을 수있다. 
![image](https://github.com/dlcksgh1/REST-API/assets/119422058/0a8ea25b-03fe-4a2a-b8e2-4c63fc833d6c)

- ## Api root 요청

#### API가 제공하는 resource 정보를 볼 수 있다.
![image](https://github.com/dlcksgh1/REST-API/assets/119422058/3989d113-d470-4f43-8ff8-e5a15d89c3e2)

- ## Event 목록 조회

####  권한이 없더라도 목록조회는 가능
![image](https://github.com/dlcksgh1/REST-API/assets/119422058/bacf54c6-d18e-42ae-a3f9-220b990d9603)

#### 응답 예시
```json
{
    "_embedded": {
        "eventList": [
            {
                "id": 3,
                "name": "event 0",
                "description": "test index 0",
                "beginEnrollmentDateTime": "2024-03-23T14:21:00",
                "closeEnrollmentDateTime": "2024-03-24T14:21:00",
                "beginEventDateTime": "2024-03-25T14:21:00",
                "endEventDateTime": "2024-03-26T14:21:00",
                "location": "강남역 D2 스타텁 팩토리",
                "basePrice": 100,
                "maxPrice": 200,
                "limitOfEnrollment": 100,
                "offline": true,
                "free": false,
                "eventStatus": "DRAFT",
                "manger": {
                    "id": 1,
                    "email": "chanho@email.com",
                    "password": "{bcrypt}$2a$10$KTD714PHVrMvkMDHForzKu12mvQ94/GW0LtWfOGRQjC7Qu92zC.mC",
                    "roles": [
                        "USER",
                        "ADMIN"
                    ]
                },
                "_links": {
                    "self": {
                        "href": "http://localhost:8080/api/events/3"
                    }
                }
            },

            ... 

            {
                "id": 22,
                "name": "event 19",
                "description": "test index 19",
                "beginEnrollmentDateTime": "2024-03-23T14:21:00",
                "closeEnrollmentDateTime": "2024-03-24T14:21:00",
                "beginEventDateTime": "2024-03-25T14:21:00",
                "endEventDateTime": "2024-03-26T14:21:00",
                "location": "강남역 D2 스타텁 팩토리",
                "basePrice": 100,
                "maxPrice": 200,
                "limitOfEnrollment": 100,
                "offline": true,
                "free": false,
                "eventStatus": "DRAFT",
                "manger": {
                    "id": 1,
                    "email": "chanho@email.com",
                    "password": "{bcrypt}$2a$10$KTD714PHVrMvkMDHForzKu12mvQ94/GW0LtWfOGRQjC7Qu92zC.mC",
                    "roles": [
                        "USER",
                        "ADMIN"
                    ]
                },
                "_links": {
                    "self": {
                        "href": "http://localhost:8080/api/events/22"
                    }
                }
            }
        ]
    },
    "_links": {
        "first": {
            "href": "http://localhost:8080/api/events?page=0&size=20"
        },
        "self": {
            "href": "http://localhost:8080/api/events?page=0&size=20"
        },
        "next": {
            "href": "http://localhost:8080/api/events?page=1&size=20"
        },
        "last": {
            "href": "http://localhost:8080/api/events?page=1&size=20"
        },
        "profile": {
            "href": "/docs/index.html#resources-events-list"
        }
    },
    "page": {
        "size": 20,
        "totalElements": 30,
        "totalPages": 2,
        "number": 0
    }
}
```

####  로그인후 Event 목록 조회를 하게된다면  Event 생성 링크 제공한다.

![image](https://github.com/dlcksgh1/REST-API/assets/119422058/3dcf3439-adfc-4eb4-94ea-fa7888c756ac)
#### 응답 예시
```json
{
    "_embedded": {
        "eventList": [
            {
                "id": 3,
                "name": "event 0",
                "description": "test index 0",
                "beginEnrollmentDateTime": "2024-03-23T14:21:00",
                "closeEnrollmentDateTime": "2024-03-24T14:21:00",
                "beginEventDateTime": "2024-03-25T14:21:00",
                "endEventDateTime": "2024-03-26T14:21:00",
                "location": "강남역 D2 스타텁 팩토리",
                "basePrice": 100,
                "maxPrice": 200,
                "limitOfEnrollment": 100,
                "offline": true,
                "free": false,
                "eventStatus": "DRAFT",
                "manger": {
                    "id": 1,
                    "email": "chanho@email.com",
                    "password": "{bcrypt}$2a$10$5RDzJX9og.Sli/SdHoRRwe1b7DySAPNhvbipb/5IYNbbpZSn7O5NK",
                    "roles": [
                        "USER",
                        "ADMIN"
                    ]
                },
                "_links": {
                    "self": {
                        "href": "http://localhost:8080/api/events/3"
                    }
                }
            },
            ...
            {
                "id": 10,
                "name": "event 7",
                "description": "test index 7",
                "beginEnrollmentDateTime": "2024-03-23T14:21:00",
                "closeEnrollmentDateTime": "2024-03-24T14:21:00",
                "beginEventDateTime": "2024-03-25T14:21:00",
                "endEventDateTime": "2024-03-26T14:21:00",
                "location": "강남역 D2 스타텁 팩토리",
                "basePrice": 100,
                "maxPrice": 200,
                "limitOfEnrollment": 100,
                "offline": true,
                "free": false,
                "eventStatus": "DRAFT",
                "manger": {
                    "id": 1,
                    "email": "chanho@email.com",
                    "password": "{bcrypt}$2a$10$5RDzJX9og.Sli/SdHoRRwe1b7DySAPNhvbipb/5IYNbbpZSn7O5NK",
                    "roles": [
                        "USER",
                        "ADMIN"
                    ]
                },
                "_links": {
                    "self": {
                        "href": "http://localhost:8080/api/events/10"
                    }
                }
            }
            
        ]
    },
    "_links": {
        "first": {
            "href": "http://localhost:8080/api/events?page=0&size=20"
        },
        "self": {
            "href": "http://localhost:8080/api/events?page=0&size=20"
        },
        "next": {
            "href": "http://localhost:8080/api/events?page=1&size=20"
        },
        "last": {
            "href": "http://localhost:8080/api/events?page=1&size=20"
        },
        "profile": {
            "href": "/docs/index.html#resources-events-list"
        },
        "create-event": {
            "href": "http://localhost:8080/api/events"
        }
    },
    "page": {
        "size": 20,
        "totalElements": 30,
        "totalPages": 2,
        "number": 0
    }
}
```

- ## Event 생성

#### 권한추가 없이 Event 생성 요청을 하게되면 unauthorized 에러가 발생한다.
![image](https://github.com/dlcksgh1/REST-API/assets/119422058/e7950fd4-0661-40d1-8f62-b30727c4ffb2)

#### Bearer Token 추가 후 Event 생성 요청을 하게 되면 Event 가 정상적으로 생성 된 것을 확인할 수 있다. 
![image](https://github.com/dlcksgh1/REST-API/assets/119422058/5243a053-b563-4efc-8169-5df24b2635bb)

#### Event 생성 응답 예시 (수정할 수있는 link 정보도 추가도 제공된다.)
```Json
{
    "id": 33,
    "name": "Spring",
    "description": "REST API Development with Spring",
    "beginEnrollmentDateTime": "2024-03-23T14:21:00",
    "closeEnrollmentDateTime": "2024-03-24T14:21:00",
    "beginEventDateTime": "2024-03-25T14:21:00",
    "endEventDateTime": "2024-03-26T14:21:00",
    "location": "강남역 D2 스타텁 팩토리",
    "basePrice": 100,
    "maxPrice": 200,
    "limitOfEnrollment": 100,
    "offline": true,
    "free": false,
    "eventStatus": "DRAFT",
    "manger": null,
    "_links": {
        "self": {
            "href": "http://localhost:8080/api/events/33"
        },
        "query-events": {
            "href": "http://localhost:8080/api/events"
        },
        "update-event": {
            "href": "http://localhost:8080/api/events/33"
        },
        "profile": {
            "href": "/docs/index.html#resources-events-create"
        }
    }
}
```
- ## Event 조회

#### 로그인 없이 Event 조회
![image](https://github.com/dlcksgh1/REST-API/assets/119422058/3d281485-4cb9-44c7-b8ef-cd0fb8cb14e2)

#### 로그인 했을 때 로그인 사용자가 Event Manager 인 경우에 Event 수정할 수 있는 link를 제공한다.

![image](https://github.com/dlcksgh1/REST-API/assets/119422058/ca196d9b-7e7e-4f2c-8cce-768b9ae39a87)


