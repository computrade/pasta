# Pasta Demo

**Application description:**

1. Gil wants to create a website to advertise his fresh hand-made pasta store.
He would like the site to have a menu (list of the types of pasta you can buy in his store), and
also an option to see the details of each type of pasta.

2. Application support also order a pasta with integration to food2fork.com

**Architecture**

Implementation is devided to the following layers:
1. Service Layer (`package com.demo.pasta.store`)
2. Business Logic Layer. (`package com.demo.pasta.store.business`)
3. Data layer. (`package com.demo.pasta.store.data`)
4. External Services Layer. (`package com.demo.pasta.store.food2fork`)

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
  
  **Dependency Injection**
  Spring capabilities were used to inject @Bean such as `BusinessLogic, DataLayer, RecipeApi`
 
 **Rest Services Sample:**
 
 An endpoint that returns the list of all pasta types sold in the store
 
  `curl -X GET http://localhost:8080/pasta`
 
  Sample json result:  
  `{"id":1,"pastas":["Spaghetti","Farfalle","Lasagna","Fettuccine"]}`

An endpoint that returns the list of all sauces types sold in the store

  `curl -X GET http://localhost:8080/sauce`

  Sample json result:
  `{"id":2,"sauces":["Tomato","Cream cheese","Pesto","Alfredo","Bolognese"]}`

An endpoint that receives a type of pasta and returns the details about it

 `curl -X GET http://localhost:8080/pasta/Spaghetti`

 Sample json result:
 `{"id":3,"pasta":{"name":"Spaghetti","sauces":["Tomato","Cream cheese","Pesto"],"howtocook":["Default"],"price":15.99}}`
 
 An endpoint to order pasta

 `curl -H "Content-Type: application/json" -X POST  -d '{"pasta":"Spaghetti","sauces":["Pesto","Tomato"]}' http://localhost:8080/order`

 Sample json result:
 ```
 {
    "id": 1,
    "price": 22.97,
    "cook": [
        "Default"
    ],
    "image": "http://static.food2fork.com/535_1_1349687284_lrg8974.jpg",
    "ingredients": [
        "6 heaped tablespoons fresh pesto",
        "1.5 litres organic chicken, ham or vegetable stock",
        "1 bulb fennel",
        "100 g fine asparagus",
        "2  Romanesco cauliflowers, or 1 large cauliflower",
        "6  baby courgettes",
        "6  plum tomatoes",
        "  extra virgin olive oil",
        "2 cloves garlic, finely sliced",
        "1 bunch spring onions, finely chopped",
        "100 g green beans, finely sliced",
        "100 g yellow beans, finely sliced",
        "100 g peas, podded",
        "100 g broad beans, podded",
        "100 g spaghetti, broken-up",
        "  sea salt",
        "  freshly ground black pepper",
        "1 small handful fresh green or purple basil",
        "1 small handful fresh chives"
    ]
}
```
Monitoring end points were added with spring Actuator.
```
http://localhost:8080/health
http://localhost:8080/metrics
```
See more here: `https://docs.spring.io/spring-boot/docs/current/reference/html/production-ready-endpoints.html`

