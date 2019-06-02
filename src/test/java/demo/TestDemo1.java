package demo;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Tag;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestDemo1 {
    @Test
    @Tag("tag1")
    public void test1() {
        final Calc c = new Calc(1);
        assertEquals(3, c.add(2));
    }
}
