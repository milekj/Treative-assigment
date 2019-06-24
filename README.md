We were asked to create an application for managing space tourist flights.
The client would like the system to be available through the browser (by default they use the
latest Chrome, butsome users might use other browsers, including IE).
The system will store data in a SQL or NoSQL database. The requirement is to create an
architecture in which the browser runs a javascript client which will communicate through REST
with a server implementing business logic and managing the connection to the database. As
part of the service the client will receive sources, so all names and comments should be in
English.

Functionalities
1. Tourist management
a. List of tourists
b. Adding a tourist
c. Removing a tourist
d. Editiing a tourist
i. Adding a flight (selection from existing flights, take into consideration the
number of seats)
ii. Removing the flight

2. Flight management
a. List of flights
b. Adding a flight
c. Removing a flight
d. Editing a flight
i. Adding a tourist to the flight (selection of existing tourists, take into
consideration the number of seats)
ii. Removal of a tourist from the flight

Data structure
1. Tourist
a. First name

b. Last name
c. Gender
d. Country
e. Remarks
f. Date of birth
g. List of flights
2. Flight
a. Departure date and time
b. Arrival date and time
c. Number of seats
d. List of tourists
e. Ticket price
