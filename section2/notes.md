# section 2

## sprint initializer boilerplate
- https://start.spring.io/
    - using the following settings for our project:
        - maven, java, 206
        - extended packages:
            - web:
                - web
            - sql:
                - jpa
                - h2
            - template:
                - thymeleaf
            - ops: actuator\
    - generating the project via a zip file for us to use
- this can be started in intellije using File > New > Project From existing sources

## Structure 

### /pom.xml
- contains an xml file of the apps properties
- spring gives us a set of dependencies which are inherited
- lists dependencies, which we grabbed from the spring boilerplate
	- this is the power of spring, which allows us to grab, import, and utilize packages easily.
	- could be compared to NPM 

## Inititalizing
- click on the terminal (bottom left, intellij)
- type: `mvnw spring-boot:run`
- initializes app on port 8080, super easy!

## JPA
- java persistence API
- its the bridge from java's object world to how data is stored in relational databases
- this is an ORM, just like mongoose, or sequelize
- 