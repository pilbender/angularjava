# AngularJava
This project was originally generated with [Angular CLI](https://github.com/angular/angular-cli) 
version 6.0.7.

## Java Spring Boot Development
### Requirements
Java 8 or higher

### Building
mvn clean install

### Running
<pre>
java -jar angular-java-1.0-SNAPSHOT.jar
</pre>

Since this is a Spring Boot application, it can be used to run the app as well:
<pre>
spring-boot:run
</pre>

At this point you can hit the app: http://localhost:8080 

### Running Unit Tests
Java Junit tests are run by default but they can be skipped as well:
<pre>
mvn clean install -Dmaven.tests.skip=true
</pre>

### Selenium Tests
None written in Java at this time.

## Angular Javascript Development
### Development server
Run `ng serve` for a dev server. Navigate to `http://localhost:4200/`. The app will automatically reload if you change any of the source files.

### Code scaffolding
Run `ng generate component component-name` to generate a new component. You can also use `ng generate directive|pipe|service|class|guard|interface|enum|module`.

### Build
Run `ng build` to build the project. The build artifacts will be stored in the `dist/` directory. Use the `--prod` flag for a production build.

### Dynamic Loading of Changes
In addition to Spring Boot being able to pick up Java changes with standard Spring Boot
configuration changes, Javascript development can be loaded dynamically well:
<pre>
./ng build --watch
</pre>

### Running unit tests
Run `ng test` to execute the unit tests via [Karma](https://karma-runner.github.io).

### Running end-to-end tests
Run `ng e2e` to execute the end-to-end tests via [Protractor](http://www.protractortest.org/).

### Further help
To get more help on the Angular CLI use `ng help` or go check out the [Angular CLI README](https://github.com/angular/angular-cli/blob/master/README.md).

### References to Running Angular and Spring Boot
- https://github.com/dsyer/spring-boot-angular One of the Spring Boot 
maintainers illustrates how these technologies are brought together.
- https://docs.spring.io/spring-boot/docs/2.0.2.RELEASE/reference/htmlsingle 
Spring Boot Reference Guide
- https://angular.io/tutorial Official Angular Tutorial
- https://spring.io/blog/2015/08/19/migrating-a-spring-web-mvc-application-from-jsp-to-angularjs
JSP to Angular migration guide.  We're not doing this, but it would be helpful to others
to illustrate how this single page HTML with JSON services works.
- https://spring.io/blog/2015/01/12/spring-and-angular-js-a-secure-single-page-application
Another approach with security.  WRO4J is used for the build instead of Node.
- https://developer.okta.com/blog/2017/12/04/basic-crud-angular-and-spring-boot 
Completely decoupled approach by Matt Riable.  Illustrates using Angular Oauth to connect
to the backend.
