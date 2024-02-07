# Project's architecture

![Alt text](images/architecture.png)

### Environment setup
1. Inside the project folder, run the following command from the command line to start Docker Compose:

    ```bash
    docker-compose up
    ```

2. Open PGAdmin by navigating to [localhost:5050](http://localhost:5050).

   2.1. Click on Servers -> Register -> Server;
   
   2.2. In the Connection tab set up the addres to "postgres" (Name of the container running the postgres image);
   
   2.3. Once the server is connected create the database fraud, customer and notification.

3. Check if also Zipkin is running at [localhost:9411](http://localhost:9411).

4. Launch the EurekaServerApplication, **MUST** be up and running.
5. Launch the ApiGW Application.
6. Launch The application for Fraud, Customer and Notification.
7. Execute registrate customer HTTP request to the API GW. Can be found in Postman's collection.




Inspired by the Spring Microservices course available on https://www.amigoscode.com/
