# api-test-automation
Project to test APIs using Rest-Assured Java


## Project Structure

The project is organized into multiple Maven modules
* ![#fa9805](https://placehold.it/15/fa9805/000000?text=+) `api-core`
      - Contains Core Methods for HTTP Request Handling
* ![#1589F0](https://placehold.it/15/1589F0/000000?text=+) `zomato-api`
      - Contains Zomato API Specific classes and Cucumber Tests
* ![#36fa05](https://placehold.it/15/36fa05/000000?text=+) `employee-api`
      - Contains Employee API Specific classes and Cucumber Tests

## Test Execution Steps

**PRE-REQUISITE**: The system needs to have JAVA 8 and Apache Maven 3.6.3 installed

0. Setup the Infrastructure

    ```
    cd docker
    docker build -t ubuntu_jdk8_maven363:v1 .
   ```
   This will build the dependencies (java, maven etc.) and pull the source code.
   On successful Docker Image build, Run the container & Go inside it to execute the tests
    ```
    docker run --name test  -ti ubuntu_jdk8_maven363:v1 /bin/bash
   ```
1. Inside the project direcotry, clean install the project to install all dependencies
      ```
      mvn clean install -Dmaven.test.skip=true
      ```
    
    For executing Tests of Individual Modules, following are the commands:
    ```
    mvn -DENV=DEV test -pl zomato-api    // Runs Tests in Zomato-API module
   
    mvn -DENV=DEV test -pl employee-api 
    mvn -DENV=DOCKER test -pl employee-api   // Runs Tests in Employee-API module
    ```

    
### Running Zomato API Tests      
1. Set the user-key for the requests in 
   **`zomato-api/src/main/resources/zomato-config.properties`**
   
   Example:
   ```
   com.zomato.dev.key=1232131samplekey124323
   
   ```
2. In the project directory i.e. api-test-automation, Open the terminal / command prompt and execute the following:
    ```
    mvn -DENV=DEV test
    ```

3. Test Reports will be generated at the following path:
    ```
    api-test-automation/zomato-api/target/cucumber-reports/advanced-reports/cucumber-html-reports
    ```
