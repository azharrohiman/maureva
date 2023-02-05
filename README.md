# Maureva Airline

Clone the code repo with the following command:

```
git clone https://github.com/azharrohiman/maureva.git
```

Before running the app, run the following docker command from the project directory to start up MSSQL Server:

```
docker-compose -f ./docker/db.docker-compose.yml --project-name maurevair up -d
```

Once MSSQL Server is up and running, create a database named "maurevair"

Run the application and register a user with the following endpoint:

```
POST http://localhost:8080/api/v1/auth/register
```

Body:
``` json
{
    "firstname": "first",
    "lastname": "last",
    "email": "user@maureva.com",
    "password": "1234"
}
```

You can authenticate an existing user with the following endpoint:

```
POST http://localhost:8080/api/v1/auth/authenticate
```

Body:
``` json
{
    "email": "user@maureva.com",
    "password": "1234"
}
```

Retrieve the token from the /authenticate endpoint and use it in "Bearer "Token"" in the header for 
every request.

NOTE: The airport_info.csv and flights.xml file can be found in the data directory.
1) Upload airports (Postman -> Body -> form-data, key: file, value: airport_info.csv):
```
POST http://localhost:8080/airport/upload
```

2) Upload flights (Postman -> Body -> form-data, key: file, value: flights.xml):
```
POST http://localhost:8080/flight/upload
```

3) Get all the airports and their details.
```
GET http://localhost:8080/airport/all-airports
```

4) Get a specific airport along with their details.
```
GET http://localhost:8080/airport?airportCode={airportCode}
```

5) Get all available flights between an origin and a destination, as well as their details (seats available).
```
GET http://localhost:8080/flight/all-flights
```

6) Making a reservation
```
POST http://localhost:8080/booking/save
```
Body:
``` json
{
    "email": "user@maureva.com",
    "flightId": "=CvATzKkACFRMQ23sWAABAA=",
    "cabinClass": "First"
}
```