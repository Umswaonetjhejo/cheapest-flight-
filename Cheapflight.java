import java.util.*;

class AlgoJet {
    private Map<String, Map<String, Integer>> flights = new HashMap<>();

    public void addFlight(String source, String destination, int price) {
        flights.computeIfAbsent(source, k -> new HashMap<>()).put(destination, price);
        flights.computeIfAbsent(destination, k -> new HashMap<>()).put(source, price);
    }

    public int findCheapestFlight(String source, String destination) {
        if (!flights.containsKey(source) || !flights.containsKey(destination)) {
            return -1; // Cities are not in the database
        }

        Map<String, Integer> cheapestPrices = new HashMap<>();
        for (String city : flights.keySet()) {
            cheapestPrices.put(city, Integer.MAX_VALUE);
        }

        cheapestPrices.put(source, 0);
        Set<String> visited = new HashSet<>();

        while (true) {
            String currentCity = null;
            int currentPrice = Integer.MAX_VALUE;

            // Find the city with the cheapest known price
            for (String city : flights.keySet()) {
                if (!visited.contains(city) && cheapestPrices.get(city) < currentPrice) {
                    currentCity = city;
                    currentPrice = cheapestPrices.get(city);
                }
            }

            if (currentCity == null) {
                break; // No more cities to visit
            }

            visited.add(currentCity);

            for (Map.Entry<String, Integer> neighbor : flights.get(currentCity).entrySet()) {
                String neighborCity = neighbor.getKey();
                int neighborPrice = neighbor.getValue();
                int totalPrice = currentPrice + neighborPrice;

                if (totalPrice < cheapestPrices.get(neighborCity)) {
                    cheapestPrices.put(neighborCity, totalPrice);
                }
            }
        }

        return cheapestPrices.get(destination);
    }

    public static void main(String[] args) {
        AlgoJet algoJet = new AlgoJet();

        // Add flights to the system
        algoJet.addFlight("A", "B", 100);
        algoJet.addFlight("A", "C", 150);
        algoJet.addFlight("B", "C", 40);
        algoJet.addFlight("B", "D", 200);
        algoJet.addFlight("C", "D", 100);
        algoJet.addFlight("C", "E", 120);
        algoJet.addFlight("D", "E", 80);

        // Find and print the cheapest flight from A to E
        int cheapestPrice = algoJet.findCheapestFlight("A", "D");
        System.out.println("Cheapest flight from A to E: " + cheapestPrice);
    }
}
