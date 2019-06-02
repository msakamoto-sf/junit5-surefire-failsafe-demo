package demo;

public class Calc {
    private final int base;
    public Calc(final int base) {
        this.base = base;
    }

    public int add(final int t) {
        return this.base + t;
    }
}
