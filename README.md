# jyeonjyan/springboot-starter

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