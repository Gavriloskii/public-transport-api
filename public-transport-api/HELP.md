#Public Transport API

Introduction
This API provides endpoints for managing fares, routes, service updates, and timetables in a public transportation system. It enables efficient handling of public transport information and facilitates interaction between users and the system.

Base URL
http://localhost:8080/api

Endpoints
1. Fares
1.1 Create a New Fare
HTTP Method: POST

Endpoint: /fares

Description: Create a new fare entry.

Request Headers:

Content-Type: application/json
Request Body:

json
Copy code
{

  "transportMode": "Bus",
  "price": 2.5
}
Responses:

201 Created:
json
Copy code
{
  "id": 1,
  "transportMode": "Bus",
  "price": 2.5
}
400 Bad Request: Invalid input
1.2 View All Fares
HTTP Method: GET

Endpoint: /fares

Description: Retrieve all fare entries.

Request Headers:

Accept: application/json
Responses:

200 OK:
json
Copy code
[
  {
    "id": 1,
    "transportMode": "Bus",
    "price": 2.5
  },
  {
    "id": 2,
    "transportMode": "Train",
    "price": 5.0
  }
]
204 No Content: No fares found
1.3 Retrieve a Single Fare
HTTP Method: GET

Endpoint: /fares/{id}

Description: Retrieve details of a single fare by its ID.

Request Headers:

Accept: application/json
Path Parameters:

id (integer): ID of the fare
Responses:

200 OK:
json
Copy code
{
  "id": 1,
  "transportMode": "Bus",
  "price": 2.5
}
404 Not Found: Fare not found
1.4 Update Fare
HTTP Method: PUT

Endpoint: /fares/{id}

Description: Update the details of an existing fare.

Request Headers:

Content-Type: application/json
Path Parameters:

id (integer): ID of the fare
Request Body:

json
Copy code
{
  "transportMode": "Bus",
  "price": 3.0
}
Responses:

200 OK:
json
Copy code
{
  "id": 1,
  "transportMode": "Bus",
  "price": 3.0
}
400 Bad Request: Invalid input
404 Not Found: Fare not found
1.5 Delete Fare
HTTP Method: DELETE

Endpoint: /fares/{id}

Description: Delete a fare entry by its ID.

Request Headers:

Accept: application/json
Path Parameters:

id (integer): ID of the fare
Responses:

204 No Content: Successfully deleted
404 Not Found: Fare not found
2. Routes
2.1 Create a New Route
HTTP Method: POST

Endpoint: /routes

Description: Create a new route entry.

Request Headers:

Content-Type: application/json
Request Body:

json
Copy code
{
  "startLocation": "Station A",
  "endLocation": "Station B"
}
Responses:

201 Created:
json
Copy code
{
  "id": 1,
  "startLocation": "Station A",
  "endLocation": "Station B"
}
400 Bad Request: Invalid input
2.2 View All Routes
HTTP Method: GET

Endpoint: /routes

Description: Retrieve all route entries.

Request Headers:

Accept: application/json
Responses:

200 OK:
json
Copy code
[
  {
    "id": 1,
    "startLocation": "Station A",
    "endLocation": "Station B"
  },
  {
    "id": 2,
    "startLocation": "Station C",
    "endLocation": "Station D"
  }
]
204 No Content: No routes found
2.3 Retrieve a Single Route
HTTP Method: GET

Endpoint: /routes/{id}

Description: Retrieve details of a single route by its ID.

Request Headers:

Accept: application/json
Path Parameters:

id (integer): ID of the route
Responses:

200 OK:
json
Copy code
{
  "id": 1,
  "startLocation": "Station A",
  "endLocation": "Station B"
}
404 Not Found: Route not found
2.4 Update Route
HTTP Method: PUT

Endpoint: /routes/{id}

Description: Update the details of an existing route.

Request Headers:

Content-Type: application/json
Path Parameters:

id (integer): ID of the route
Request Body:

json
Copy code
{
  "startLocation": "Station E",
  "endLocation": "Station F"
}
Responses:

200 OK:
json
Copy code
{
  "id": 1,
  "startLocation": "Station E",
  "endLocation": "Station F"
}
400 Bad Request: Invalid input
404 Not Found: Route not found
2.5 Delete Route
HTTP Method: DELETE

Endpoint: /routes/{id}

Description: Delete a route entry by its ID.

Request Headers:

Accept: application/json
Path Parameters:

id (integer): ID of the route
Responses:

204 No Content: Successfully deleted
404 Not Found: Route not found
3. Service Updates
3.1 Create a New Service Update
HTTP Method: POST

Endpoint: /service-updates

Description: Create a new service update entry.

Request Headers:

Content-Type: application/json
Request Body:

json
Copy code
{
  "message": "Service interruption on Line 1",
  "date": "2024-05-25T12:00:00Z"
}
Responses:

201 Created:
json
Copy code
{
  "id": 1,
  "message": "Service interruption on Line 1",
  "date": "2024-05-25T12:00:00Z"
}
400 Bad Request: Invalid input
3.2 View All Service Updates
HTTP Method: GET

Endpoint: /service-updates

Description: Retrieve all service update entries.

Request Headers:

Accept: application/json
Responses:

200 OK:
json
Copy code
[
  {
    "id": 1,
    "message": "Service interruption on Line 1",
    "date": "2024-05-25T12:00:00Z"
  },
  {
    "id": 2,
    "message": "Line 2 delayed due to maintenance",
    "date": "2024-05-26T14:00:00Z"
  }
]
204 No Content: No service updates found
3.3 Retrieve a Single Service Update
HTTP Method: GET

Endpoint: /service-updates/{id}

Description: Retrieve details of a single service update by its ID.

Request Headers:

Accept: application/json
Path Parameters:

id (integer): ID of the service update
Responses:

200 OK:
json
Copy code
{
  "id": 1,
  "message": "Service interruption on Line 1",
  "date": "2024-05-25T12:00:00Z"
}
404 Not Found: Service update not found
3.4 Update Service Update
HTTP Method: PUT

Endpoint: /service-updates/{id}

Description: Update the details of an existing service update.

Request Headers:

Content-Type: application/json
Path Parameters:

id (integer): ID of the service update
Request Body:

json
Copy code
{
  "message": "Service resumed on Line 1",
  "date": "2024-05-25T18:00:00Z"
}
Responses:

200 OK:
json
Copy code
{
  "id": 1,
  "message": "Service resumed on Line 1",
  "date": "2024-05-25T18:00:00Z"
}
400 Bad Request: Invalid input
404 Not Found: Service update not found
3.5 Delete Service Update
HTTP Method: DELETE

Endpoint: /service-updates/{id}

Description: Delete a service update entry by its ID.

Request Headers:

Accept: application/json
Path Parameters:

id (integer): ID of the service update
Responses:

204 No Content: Successfully deleted
404 Not Found: Service update not found
4. Timetables
4.1 Create a New Timetable
HTTP Method: POST

Endpoint: /timetables

Description: Create a new timetable entry.

Request Headers:

Content-Type: application/json
Request Body:

json
Copy code
{
  "route": "Route 1",
  "departureTime": "2024-05-26T08:00:00Z",
  "arrivalTime": "2024-05-26T09:00:00Z"
}
Responses:

201 Created:
json
Copy code
{
  "id": 1,
  "route": "Route 1",
  "departureTime": "2024-05-26T08:00:00Z",
  "arrivalTime": "2024-05-26T09:00:00Z"
}
400 Bad Request: Invalid input
4.2 View All Timetables
HTTP Method: GET

Endpoint: /timetables

Description: Retrieve all timetable entries.

Request Headers:

Accept: application/json
Responses:

200 OK:
json
Copy code
[
  {
    "id": 1,
    "route": "Route 1",
    "departureTime": "2024-05-26T08:00:00Z",
    "arrivalTime": "2024-05-26T09:00:00Z"
  },
  {
    "id": 2,
    "route": "Route 2",
    "departureTime": "2024-05-26T10:00:00Z",
    "arrivalTime": "2024-05-26T11:00:00Z"
  }
]
204 No Content: No timetables found
4.3 Retrieve a Single Timetable
HTTP Method: GET

Endpoint: /timetables/{id}

Description: Retrieve details of a single timetable by its ID.

Request Headers:

Accept: application/json
Path Parameters:

id (integer): ID of the timetable
Responses:

200 OK:
json
Copy code
{
  "id": 1,
  "route": "Route 1",
  "departureTime": "2024-05-26T08:00:00Z",
  "arrivalTime": "2024-05-26T09:00:00Z"
}
404 Not Found: Timetable not found
4.4 Update Timetable
HTTP Method: PUT

Endpoint: /timetables/{id}

Description: Update the details of an existing timetable.

Request Headers:

Content-Type: application/json
Path Parameters:

id (integer): ID of the timetable
Request Body:

json
Copy code
{
  "route": "Route 3",
  "departureTime": "2024-05-26T12:00:00Z",
  "arrivalTime": "2024-05-26T13:00:00Z"
}
Responses:

200 OK:
json
Copy code
{
  "id": 1,
  "route": "Route 3",
  "departureTime": "2024-05-26T12:00:00Z",
  "arrivalTime": "2024-05-26T13:00:00Z"
}
400 Bad Request: Invalid input
404 Not Found: Timetable not found
4.5 Delete Timetable
HTTP Method: DELETE

Endpoint: /timetables/{id}

Description: Delete a timetable entry by its ID.

Request Headers:

Accept: application/json
Path Parameters:

id (integer): ID of the timetable
Responses:

204 No Content: Successfully deleted
404 Not Found: Timetable not found
This documentation provides a structured overview of the Public Transport API, including endpoints for managing fares, routes, service updates, and timetables. Each section details the HTTP methods, endpoints, request headers, request bodies, and possible responses for various operations.
