package demo;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Tag;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestDemo1 {
    @Test
    @Tag("tag1")
    public void test1() {
        final Calc c = new Calc(2);
        assertEquals(5, c.add(3));
    }
}
