This project is to test enabling batch execution of sql commands in JPA
  
To enable JPA batch execution, the properties below are essential:  

```
spring.jpa.properties.hibernate.jdbc.batch_size
spring.jpa.properties.hibernate.order_inserts
spring.jpa.properties.hibernate.update_inserts
```
Note that these settings are not effected when using embedded database.  
Example: 
 
```yaml
spring:
  jpa:    
    show-sql: true
    hibernate:
      ddl-auto: none
    properties:
      hibernate:
        generate_statistics: true 
        order_inserts: true
        order_updates: true
        jdbc:
          batch_size: 5
          batch_versioned_data: true
```

Enable ```generate_statistics``` will display the statistics in log (see below)   
Find ```Executing 2 JDBC batches``` since we have 10 statements and batch size is 2
  
  
```
    5455000 nanoseconds spent acquiring 1 JDBC connections;
    0 nanoseconds spent releasing 0 JDBC connections;
    17680500 nanoseconds spent preparing 11 JDBC statements;
    19387700 nanoseconds spent executing 10 JDBC statements;
    537525000 nanoseconds spent executing 2 JDBC batches;
    0 nanoseconds spent performing 0 L2C puts;
    0 nanoseconds spent performing 0 L2C hits;
    0 nanoseconds spent performing 0 L2C misses;
    579664400 nanoseconds spent executing 1 flushes (flushing a total of 10 entities and 0 collections);
    0 nanoseconds spent executing 0 partial-flushes (flushing a total of 0 entities and 0 collections)
```


Add ```rewriteBatchedStatements``` property to connection url to enable rewrite multiple statements ino a *multi-row" statement.
