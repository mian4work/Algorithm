import java.util.*;

/*
    Given an unordered list of flights taken by someone, each represented as (origin, destination) pairs,
    and a starting airport, compute the person’s itinerary. If no such itinerary exists, return null.
    All flights must be used in the itinerary.

    For example, given the following list of flights:

    HNL ➔ AKL
    YUL ➔ ORD
    ORD ➔ SFO
    SFO ➔ HNL

    and starting airport YUL, you should return YUL ➔ ORD ➔ SFO ➔ HNL ➔ AKL
 */
public class FlightItinerary {

    public String[] itinerary(Flight[] flights, String start) {
        if(flights == null || flights.length == 0) {
            return null;
        }

        Map<String, List<String>> map = new HashMap<>();
        for(Flight flight : flights) {
            if(map.get(flight.start) != null) {
                map.get(flight.start).add(flight.end);
            } else {
                List<String> list = new ArrayList<>();
                list.add(flight.end);
                map.put(flight.start, list);
            }
        }

        Set<String> visited = new HashSet<>();
        List<String> iten = new ArrayList<>();

        helper(start, map, iten, visited);

        return iten.size() == 0 ? null : iten.toArray(new String[]{});
    }

    private void helper(String start, Map<String, List<String>> map, List<String> iten, Set<String> visited) {
        if(start == null || !visited.add(start)) {
            return;
        }

        iten.add(start);
        List<String> ends = map.get(start);

        if(ends == null) {
            return;
        }

        for(int i = 0; i < ends.size(); i++) {
            helper(ends.get(i), map, iten, visited);
            return;
        }

        iten.remove(iten.size() - 1);
    }
}

class Flight {
    public String start;
    public String end;

    public Flight(String start, String end) {
        this.start = start;
        this.end = end;
    }
}
