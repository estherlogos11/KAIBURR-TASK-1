# KAIBURR-TASK-1
#Task 1. Java REST API example
The provided code is a Java application that implements a REST API for managing "server" objects using MongoDB as the database.

1. The `Server` class represents the model for a server object. It has properties such as `id`, `name`, `language`, and `framework`. This class is annotated with `@Document` to specify the MongoDB collection name.

2. The `ServerRepository` interface extends `MongoRepository` and provides methods for interacting with the MongoDB database. In this case, it includes a method `findByNameContaining` to search for servers by name.

3. The `ServerController` class is a REST controller that handles the API endpoints. It is annotated with `@RestController` to indicate that it handles HTTP requests. The class has methods for handling GET, PUT, and DELETE requests.

   - The `getServers` method handles the GET request to retrieve all servers or a single server by ID. If an ID is provided as a query parameter, it returns the server with that ID. Otherwise, it returns all servers. It uses the `serverRepository` to interact with the database.

   - The `createServer` method handles the PUT request to create a new server. It expects a JSON-encoded server object in the request body. It saves the server object to the database using the `serverRepository` and returns the created server in the response.

   - The `deleteServer` method handles the DELETE request to delete a server by ID. It uses the `serverRepository` to delete the server from the database.

   - The `searchServers` method handles the GET request to search for servers by name. It expects a name parameter and uses the `serverRepository` to find servers whose names contain the specified string. It returns the matching servers or a 404 response if no servers are found.

4. The `ServerApplication` class is the main entry point of the application. It uses Spring Boot's `@SpringBootApplication` annotation to enable auto-configuration and component scanning.

To run the code and see the output:

1. Make sure you have MongoDB installed and running locally.

2. Build and run the application using Maven. Open a terminal or command prompt, navigate to the project directory, and run the following command:
   ```
   mvn spring-boot:run
   ```

3. Once the application is running, you can test the API endpoints using a tool like Postman or curl.

   - To retrieve all servers, send a GET request to `http://localhost:8080/servers`. You should see a JSON response with all the servers stored in the database.

   - To retrieve a single server by ID, send a GET request to `http://localhost:8080/servers?id={serverId}`. Replace `{serverId}` with the ID of the server you want to retrieve. If the server exists, you will see a JSON response with the server details. Otherwise, you will receive a 404 response.

   - To create a new server, send a PUT request to `http://localhost:8080/servers` with a JSON payload containing the server details. For example:
     ```json
     {
       "name": "my centos",
       "id": "123",
       "language": "java",
       "framework": "django"
     }
     ```
     You should receive a response with the created server details.

   - To delete a server by ID, send a DELETE request to `http://localhost:8080/servers/{serverId}`. Replace `{serverId}` with the ID of the server you want to delete. If the server exists, it will be deleted, and you will receive a 204 response with no content.

   - To search for servers by name, send a GET request to `http://localhost:8080/servers/search?name={searchString}`. Replace `{searchString}` with the string you want to search for in server names. If any servers match the search criteria, you will receive a JSON response with the matching servers. Otherwise, you will receive a 404 response.

That's it! You have now successfully implemented a Java REST API for managing server objects using MongoDB as the database.

If you have any further questions or need assistance with anything else, feel free to ask.
