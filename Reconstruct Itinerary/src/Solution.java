import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
    Given a list of airline tickets represented by pairs of departure and arrival airports [from, to],
    reconstruct the itinerary in order. All of the tickets belong to a man who departs from JFK. Thus, the itinerary
    must begin with JFK.

    Note:

    If there are multiple valid itineraries, you should return the itinerary that has the smallest lexical order
    when read as a single string. For example, the itinerary ["JFK", "LGA"] has a smaller lexical order
    than ["JFK", "LGB"].
    All airports are represented by three capital letters (IATA code).
    You may assume all tickets form at least one valid itinerary.

    Example 1:

    Input: [["MUC", "LHR"], ["JFK", "MUC"], ["SFO", "SJC"], ["LHR", "SFO"]]
    Output: ["JFK", "MUC", "LHR", "SFO", "SJC"]

    Example 2:

    Input: [["JFK","SFO"],["JFK","ATL"],["SFO","ATL"],["ATL","JFK"],["ATL","SFO"]]
    Output: ["JFK","ATL","JFK","SFO","ATL","SFO"]
    Explanation: Another possible reconstruction is ["JFK","SFO","ATL","JFK","ATL","SFO"].
                 But it is larger in lexical order.
 */
public class Solution {
    public List<String> findItinerary(List<List<String>> tickets) {

        List<String> iten = new ArrayList<>();
        Map<List<String>, Boolean> map = new HashMap<>();
        for(int i = 0; i < tickets.size(); i++) {
            if(tickets.get(i).get(0).equals("JFK")) {
                iten.add("JFK");
                fly(tickets, iten, tickets.get(i), map);
            }
        }
        return iten;
    }

    boolean fly(List<List<String>> tickets, List<String> iten, List<String> start, Map<List<String>, Boolean> map) {
        if(iten.size() == tickets.size() + 1) {
            return true;
        }

        if(map.get(start) != null && map.get(start)) {
            return true;
        }

        iten.add(start.get(1));
        for(List<String> list : tickets) {
            if(start.get(1).equals(list.get(0))) {
                Boolean b = fly(tickets, iten, list, map);
                map.put(list, b);
                if(!b) {
                    iten.remove(iten.size() - 1);
                    return false;
                }
            }
        }

        return true;
    }
}
