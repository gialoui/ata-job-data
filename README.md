# Job Data Query Service

## What is it?

Basically, this mini project is a Web service written in Java and Spring Boot framework to query job data from a static
set. The CSV should have the following format columns:

- Timestamp
- Employer
- Location
- Job Title
- Years at Employer
- Years of Experience
- Salary
- Signing Bonus
- Annual Bonus
- Annual Stock Value/Bonus
- Gender
- Additional Comments

Here's an example for one row of data: 3/21/16 12:58,Opower,"San Francisco, CA",Systems Engineer,2,13,125000,5000,0,5000
shares,Male,Don't work here.

## Prerequisites

- JDK 17+
- Maven

## API Documentation

Open this url after running the application

```
http://localhost:8080/swagger-ui.html
```

## Testing

There's a Postman collection stored in `postman` directory of this codebase. Import it into your Postman to test the API
as you wish.

### How to start the application

Using the Maven command-line tool:

- Open a terminal or command prompt in the root directory of your Spring Boot project
- Run the command mvn spring-boot:run
- The Spring Boot application will start and you can access it at http://localhost:8080

## Things that were considered

- Salary should be a valid number to make the filter by range possible. As a matter of fact, I eliminated the data that
  cannot be converted to number types.
- The gender column could be of any value because the examples in the file are not consistent and don't follow a pattern
- Writing our own logic to handle the query parameters is time-consuming and wouldn't be as optimal as using what we
  currently have from Spring Data Specification feature. It deducts the cost of implementing old existing logic of
  search API and keeps the code simpler. However, to be able to utilize the Spring Data feature, we have to load the
  data from the static file to a supported data source, in this assignment, I prefer the light-weight in-memory database
  H2 which is able to fulfill the requirements.

## What to improve

- Unit tests
- Support more formats of salary and gender
- Allow pagination
- Spring Batch to read and process the file by batch of 10 or 20. Find the perfect number of items as you implement and
  test it by yourself.

### HAPPY TESTING EVERYONE!!!