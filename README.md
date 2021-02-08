# api-test-automation
Project to test APIs using Rest-Assured Java


## Project Structure

The project is organized into two Maven modules
* ![#fa9805](https://placehold.it/15/fa9805/000000?text=+) `api-core`
      - Contains Core Methods for HTTP Request Handling
* ![#1589F0](https://placehold.it/15/1589F0/000000?text=+) `zomato-api`
      - Contains Zomato API Specific classes and Cucumber Tests
* ![#36fa05](https://placehold.it/15/36fa05/000000?text=+) `employee-api`
      - Contains Employee API Specific classes and Cucumber Tests

## Test Execution Steps

**PRE-REQUISITE**: The system needs to have JAVA 8 and Apache Maven 3.6.3 installed

0. Clean install the project to install all dependencies
      ```
      mvn clean install
      ```
    
    For executing Tests of Individual Modules, following are the commands:
    ```
    mvn test -pl zomato-api    // Runs Tests in Zomato-API module
    mvn test -pl employee-api   // Runs Tests in Employee-API module
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
