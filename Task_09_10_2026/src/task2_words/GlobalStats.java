package task2_words;

import java.util.HashMap;
import java.util.Map;

public class GlobalStats {

    private final Map<String, Integer> global = new HashMap<>();

    public synchronized void merge(Map<String, Integer> local) {
        for (Map.Entry<String, Integer> e : local.entrySet()) {
            global.merge(e.getKey(), e.getValue(), Integer::sum);
        }
    }

    public synchronized Map<String, Integer> snapshot() {
        return new HashMap<>(global);
    }

    public synchronized long totalCount() {
        long sum = 0;
        for (int v : global.values()) sum += v;
        return sum;
    }
}