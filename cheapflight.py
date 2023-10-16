import sys

class Flight:
    def __init__(self, source, destination, price):
        self.source = source
        self.destination = destination
        self.price = price

class FlightGraph:
    def __init__(self):
        self.flights = []

    def initializeFlightGraph(self, flights):
        self.flights = flights

    def getCheapestFlight(self, source, destination):
        cities = set()
        for flight in self.flights:
            cities.add(flight.source)
            cities.add(flight.destination)

        distances = {city: sys.maxsize for city in cities}
        distances[source] = 0

        for _ in range(len(cities)):
            for flight in self.flights:
                if distances[flight.source] + flight.price < distances[flight.destination]:
                    distances[flight.destination] = distances[flight.source] + flight.price

        if distances[destination] == sys.maxsize:
            return -1
        else:
            return distances[destination]

# Example usage:
flights = [
    Flight("A", "B", 100),
    Flight("A", "C", 150),
    Flight("B", "C", 40),
    Flight("B", "D", 200),
    Flight("C", "D", 100),
    Flight("C", "E", 120),
    Flight("D", "E", 80)
]

flight_graph = FlightGraph()
flight_graph.initializeFlightGraph(flights)

source = input('> ')
destination = input('> ')
cheapest_price = flight_graph.getCheapestFlight(source, destination)

print(f"The cheapest flight from {source} to {destination} costs {cheapest_price}")
