# Pasta Demo

**Business logic:**

Gil wants to create a website to advertise his fresh hand-made pasta store.
He would like the site to have a menu (list of the types of pasta you can buy in his store), and
also an option to see the details of each type of pasta.

There are two methods to calculate the weight:

**The following technologies were used in this implementation:**
1. Java 8
2. Spring MVC for REST Service implementation.
3. Spring Boot.
4. Project is built using Maven.
5. Test:
  * SpringBootTest was used to test ReST ( see: PastaControllerTests ) 

### Production ready

Solution is production ready from the following perspective:
  
  **Logging:** 
  slf4j was used for logging.
  Debug level can be configured in the application.properties as such:
   
    logging.level.org.springframework.web=INFO
    logging.level.com.demo.pasta=DEBUG
       
  **Error Handeling:**
  
  New Exceptions were created to handle specific application exceptions. (see in package 'com.demo.pasta.store.exception')
  HTTP response code were updated according the exception. ( see: 'GlobalExceptionHandlingControllerAdvice' class )
    
  **Testing:**
  Tests were added to check the ReST layer. ( see: PastaControllerTests ) 
  
  **Documentation:**
  There is a readme.md file for documentation.
  
  **Monitoring:**
  Spring Actuator was added for monitoring see example below.
 
 **Rest Services Sample:**
 
 An endpoint that returns the list of all pasta types sold in the store
 
  `curl -X GET http://localhost:8080/pasta`
 
  Sample json result:  {"id":1,"pastas":["Spaghetti","Farfalle","Lasagna","Fettuccine"]}

An endpoint that returns the list of all sauces types sold in the store

  `curl -X GET http://localhost:8080/sauce`

  Sample json result {"id":2,"sauces":["Tomato","Cream cheese","Pesto","Alfredo","Bolognese"]}

An endpoint that receives a type of pasta and returns the details about it

 `curl -X GET http://localhost:8080/pasta/Spaghetti`

 Sample json result {"id":3,"pasta":{"name":"Spaghetti","sauces":["Tomato","Cream cheese","Pesto"],"howtocook":["Default"],"price":15.99}}

Monitoring end points were added with spring Actuator.
```
http://localhost:8080/health
http://localhost:8080/metrics
```
see more here: `https://docs.spring.io/spring-boot/docs/current/reference/html/production-ready-endpoints.html`




2. 
3. 
