package net.skillspire.fleet;

// POINT: a plain Java class with no Spring and no database: the easiest thing to unit test.
//        The same class as the LMS lesson (Introduction to Unit Testing Frameworks, Part 2).
// ASK:   "Which values of level would you test for isLow()?"

public class Battery {
    private int level;     // percent, 0 to 100

    public Battery(int level) {
        this.level = level;
    }

    public int getLevel() {
        return level;
    }

    public boolean isLow() {
        return level < 20;
    }

    public void charge(int percent) {
        if (percent < 0) {
            throw new IllegalArgumentException("percent can't be negative");
        }
        level = Math.min(100, level + percent);
    }
}
