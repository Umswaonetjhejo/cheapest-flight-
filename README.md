# cheapest-flight-
This program is designed to find the cheapest flight route from a given source city to a destination city within a network of interconnected flights. It is essentially a simple flight route cost calculator. Here's what the program is about:

1. **Flight Data Representation**: The program defines a set of classes, `Flight` and `FlightGraph,` to represent flights and the flight network. Each `Flight` object contains information about the source city, destination city, and the price (cost) of the flight.

2. **Flight Network**: An example flight network is provided using a list of `Flight` objects. These flights represent the connections between various cities and the associated costs for flying between them.

3. **Cheapest Flight Calculation**: Users are prompted to input two cities:

   - Source city (where they want to start their journey)
   - Destination city (where they want to reach)

4. **Route Cost Calculation**: The program uses Dijkstra's algorithm to calculate the cheapest flight route from the specified source city to the destination city within the given flight network. It computes the minimum cost for the journey.

5. **Result Display**: The program displays the source city, destination city, and the cost of the cheapest flight route to the user.

This program is written in Python and Java. The program is the same in those two files.

In essence, this program provides a way for users to find the most economical way to travel from one city to another within a given network of flights. It can be useful for travelers looking to minimize their travel expenses when planning trips within the provided flight network.
