package task2_words;

import java.util.HashMap;
import java.util.Map;

public class WordCounter implements TextTask {

    private final Map<String, Integer> freq = new HashMap<>();

    @Override
    public void process(String line) {
        if (line == null || line.isEmpty()) return;
        String[] words = line.toLowerCase().split("\\s+");
        for (String w : words) {
            if (w.isEmpty()) continue;
            freq.merge(w, 1, Integer::sum);
        }
    }

    @Override
    public String result() {
        return "Всего уникальных слов: " + freq.size();
    }

    public Map<String, Integer> getFreq() {
        return freq;
    }
}