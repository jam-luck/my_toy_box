# my_toy_box
개발연습용 프로젝트 - 장난감상자  
개발하고 싶은거 다해보는중..  

프런트 React.js 백 Springboot

vscdoe 에서 React.js Springboot 개발.  

## 실행방법
실행하기 쉽게 쉘스크립트 만들어 두었음.  
sh build.sh // react build 및 gradle build  

sh run.sh   // nohup을 이용한 spring-boot 백그라운드 실행, npm run  

java or node 프로세스가 실행중일때는  
lsof -iTCP -sTCP:LISTEN -n -P  
netstat -tulpn  
둘중 하나를 사용해 java, node 프로세스 PID 확인하고  
kill -9 {PID} 사용하여 process kill


## 개발진행사항
### 2022.12
* 쉘스크립트를 통한 build, run 기능 추가
* nohup 사용, background 실행
### 2022.07
* swagger 3.0 추가 jpa 테스트
* gradle.build 수정(front - back 빌드 통합을 위한)
* 백엔드 연결실패시 띄울 ErrorPage 추가
* react-router-dom 사용 라우팅추가, 라우팅 통한 NotFound 페이지 추가
* https://mui.com/material-ui/getting-started/templates/blog/ 템플릿 사용
### 2022.06
* 백엔드 연결확인용 PageTop, PageMain 컴포넌트 추가
* 백엔드추가 및 프록시설정 (서버연결체크용 TestController 작동확인)
* material-ui 적용
* DTO틀 추가, 연습용 Spring3 Rest 테스트코드 추가
* application.properies gitignore추가, mysql - jpa 연동
### 2022.05
* react-app 생성


## 앞으로 해보고 싶은것
aws sdk 적용하기. (이건 회사에서 많이해봐서 안할수도?..)  
EC2나 docker에 환경구성하기  
jenkins 배포 구성하기  (해봐서 안할수도?)  
외부로그인 연동하기  (node toy-box에선 구현.. 많이해서 식상)   
간단한 MongoDB 테스트?  



