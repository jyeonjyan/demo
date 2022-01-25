# jyeonjyan/springboot-starter

## intro
안녕하세요. 전지환입니다.

매번 새 프로젝트를 개발하려고 하면 초기 환경 세팅 때문에 많은 시간을 쓰곤 하는데요.  
제가 만든 데모를 애플리케이션은 최대한 스프링 애플리케이션에 공통으로 사용되는 라이브러리와 설정값을 넣었습니다.  
제 데모를 이용해보니 이런 라이브러리도(build.gradle) 필요한 것 같다, 이런 설정값(application.yml)도 필요한 것 같다. 하는 부분 issue로 제안해주시면 감사하겠습니다.

감사합니다.

## project configuration
```
- Dependencies
Spring Web
Spring Data JPA 
querydsl-jpa
Lombok
Validation
H2 Database
```

## application configuration
* application runs on port `8080`
* enable querydsl
    * Enable annotation processing  
    * Press `Gradle/Tasks/other/compileQuerydsl.sh` file or type command that `./gradlew clean build` 
    * The location of Q-Class `project/build/generated/querydsl/` 

## get start
* git clone
    * `git clone https://github.com/jyeonjyan/springboot-starter [your project name]`
* edit project name in IntelliJ
    1. Go to File >> Project Structure >> Project > Project Name Update project name with its new name
    2. Exit IntelliJ IDEA
    3. Edit contents of the following files
      * {project_root}/settings.gradle 
      * {project_root}/.idea/.name (if exists)
    4. Open IntelliJ IDEA
    5. Refresh Gradle Project
    6. Change app package name like `com.app.yourprojectname`
    7. Change app entry point class name like `yourApplication.java` 