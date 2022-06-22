# Technical Assignment
The task is to complete below listed items.
1) Create a basic API
2) Enable Logging
3) Test service

# Solution:
Above tasks are completed using 
- Spring Boot version 2.7 
- Java 17
- Maven

```
java --version
openjdk 17.0.3 2022-04-19
OpenJDK Runtime Environment Temurin-17.0.3+7 (build 17.0.3+7)
OpenJDK 64-Bit Server VM Temurin-17.0.3+7 (build 17.0.3+7, mixed mode)
```

## Prerequsties

Please follow the instructions from the document link below to install the JDK
https://access.redhat.com/documentation/en-us/openjdk/17/html-single/installing_and_using_openjdk_17_on_rhel/index#installing-jre-on-rhel-using-yum_openjdk

**Note:**  Base spring boot project was created from https://start.spring.io/ 

## Build the application

To build a new package, Go to the project folder and run the below command to generate new pacakge

> ./mvnw clean install

## Start the application

Use the command below to start the application

> java -jar /Users/selvakumar/.m2/repository/com/project/autotask/0.0.1-SNAPSHOT/autotask-0.0.1-SNAPSHOT.jar

## Manual Testing

Upon successful TomcatWebServer is started, execute the command below to do testing.

- GET request without the accept header

```
╰─ curl http://localhost:8080/apitesting/getapipoc
<p>Hello,world</p>%
```

Log output with debug mode enabled

```
[2022-06-22 17:08:15] DEBUG o.s.web.servlet.DispatcherServlet - GET "/apitesting/getapipoc", parameters={}
[2022-06-22 17:08:15] DEBUG o.s.w.s.m.m.a.RequestMappingHandlerMapping - Mapped to com.project.autotask.controller.SampleTask#getApiPoc(String, HttpServletRequest)
[2022-06-22 17:08:15] DEBUG c.p.autotask.controller.SampleTask - Debug Message Logged !!!
[2022-06-22 17:08:15] INFO  c.p.autotask.controller.SampleTask - Info Message Logged !!!
[2022-06-22 17:08:15] DEBUG c.p.autotask.controller.SampleTask - /apitesting/getapipoc
[2022-06-22 17:08:15] INFO  c.p.autotask.controller.SampleTask - AcceptHeader is null or empty or */*: */*
[2022-06-22 17:08:15] DEBUG o.s.w.s.m.m.a.HttpEntityMethodProcessor - Using 'application/json', given [*/*] and supported [application/json]
[2022-06-22 17:08:15] DEBUG o.s.w.s.m.m.a.HttpEntityMethodProcessor - Writing ["<p>Hello,world</p>"]
[2022-06-22 17:08:15] DEBUG o.s.web.servlet.DispatcherServlet - Completed 200 OK
```


- GET request with accept header

```
╰─ curl http://localhost:8080/apitesting/getapipoc --header 'Accept: application/json'
{"message":"Hello World"}%
```

Log output with debug mode enabled

```
[2022-06-22 17:10:35] DEBUG o.s.web.servlet.DispatcherServlet - GET "/apitesting/getapipoc", parameters={}
[2022-06-22 17:10:35] DEBUG o.s.w.s.m.m.a.RequestMappingHandlerMapping - Mapped to com.project.autotask.controller.SampleTask#getApiPoc(String, HttpServletRequest)
[2022-06-22 17:10:35] DEBUG c.p.autotask.controller.SampleTask - Debug Message Logged !!!
[2022-06-22 17:10:35] INFO  c.p.autotask.controller.SampleTask - Info Message Logged !!!
[2022-06-22 17:10:35] DEBUG c.p.autotask.controller.SampleTask - /apitesting/getapipoc
[2022-06-22 17:10:35] INFO  c.p.autotask.controller.SampleTask - AcceptHeader is: application/json
[2022-06-22 17:10:35] DEBUG o.s.w.s.m.m.a.HttpEntityMethodProcessor - Using 'application/json', given [application/json] and supported [application/json]
[2022-06-22 17:10:35] DEBUG o.s.w.s.m.m.a.HttpEntityMethodProcessor - Writing [{message=Hello World}]
[2022-06-22 17:10:35] DEBUG o.s.web.servlet.DispatcherServlet - Completed 200 OK
```

- POST request

```
╰─ curl --request POST http://localhost:8080/apitesting/postapipoc
{"message":"Post API Successful"}%
```

Log output with debug mode enabled

```
[2022-06-22 17:11:19] DEBUG o.s.web.servlet.DispatcherServlet - POST "/apitesting/postapipoc", parameters={}
[2022-06-22 17:11:19] DEBUG o.s.w.s.m.m.a.RequestMappingHandlerMapping - Mapped to com.project.autotask.controller.SampleTask#postApiPoc()
[2022-06-22 17:11:19] DEBUG c.p.autotask.controller.SampleTask - Debug Message postApiPoc Logged !!!
[2022-06-22 17:11:19] INFO  c.p.autotask.controller.SampleTask - Info Message postApiPoc Logged !!!
[2022-06-22 17:11:19] DEBUG o.s.w.s.m.m.a.HttpEntityMethodProcessor - Using 'application/json', given [*/*] and supported [application/json]
[2022-06-22 17:11:19] DEBUG o.s.w.s.m.m.a.HttpEntityMethodProcessor - Writing [{message=Post API Successful}]
[2022-06-22 17:11:19] DEBUG o.s.web.servlet.DispatcherServlet - Completed 200 OK
```

# Run Unit Test

Download the source code and Go to the project folder

```
╰─ ls -lrt
total 64
-rw-r--r--@  1 selvakumar  staff   6734 Jun 20 11:57 mvnw.cmd
-rwxr-xr-x@  1 selvakumar  staff  10284 Jun 20 11:57 mvnw
-rw-r--r--@  1 selvakumar  staff   1054 Jun 20 11:57 HELP.md
drwxr-xr-x@  5 selvakumar  staff    160 Jun 20 21:33 src
drwxr-xr-x  13 selvakumar  staff    416 Jun 20 21:33 bin
-rw-r--r--@  1 selvakumar  staff   3748 Jun 21 14:59 pom.xml
drwxr-xr-x   3 selvakumar  staff     96 Jun 22 09:20 logs
drwxr-xr-x   8 selvakumar  staff    256 Jun 22 17:17 target
-rw-r--r--   1 selvakumar  staff     11 Jun 22 17:22 README.md
```

and Use the command below to run the Unit test

> ./mvnw clean test -Dtest=com.project.autotask.SampleTaskTests

below snippet shows the successful unit run.

```
[INFO] Tests run: 3, Failures: 0, Errors: 0, Skipped: 0, Time elapsed: 1.399 s - in com.project.autotask.SampleTaskTests
[2022-06-22 17:17:48] DEBUG o.s.w.c.s.GenericWebApplicationContext - Closing org.springframework.web.context.support.GenericWebApplicationContext@389562d6, started on Wed Jun 22 17:17:48 SGT 2022
[2022-06-22 17:17:48] DEBUG o.s.s.c.ThreadPoolTaskExecutor - Shutting down ExecutorService 'applicationTaskExecutor'
[INFO]
[INFO] Results:
[INFO]
[INFO] Tests run: 3, Failures: 0, Errors: 0, Skipped: 0
[INFO]
[INFO] ------------------------------------------------------------------------
[INFO] BUILD SUCCESS
[INFO] ------------------------------------------------------------------------
[INFO] Total time:  3.920 s
[INFO] Finished at: 2022-06-22T17:17:49+08:00
[INFO] ------------------------------------------------------------------------
```


