package task2_words;

public class LongestWord implements TextTask {

    private String longest = "";

    @Override
    public void process(String line) {
        if (line == null) return;
        for (String w : line.split("\\s+")) {
            if (w.length() > longest.length()) {
                longest = w;
            }
        }
    }

    @Override
    public String result() {
        return "Самое длинное слово: " + longest + " (" + longest.length() + ")";
    }
}