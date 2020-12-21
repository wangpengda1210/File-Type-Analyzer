package analyzer;

public class Pattern implements Comparable<Pattern> {

    private final int priority;
    private final String pattern;
    private final String type;

    public Pattern(int priority, String pattern, String type) {
        this.priority = priority;
        this.pattern = pattern;
        this.type = type;
    }

    public int getPriority() {
        return priority;
    }

    public String getPattern() {
        return pattern;
    }

    public String getType() {
        return type;
    }

    @Override
    public int compareTo(Pattern pattern) {
        return pattern.getPriority() - this.priority;
    }

}
