package demo;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Tag;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestDemo2 {
    @Test
    @Tag("tag2")
    public void exampleTest() {
        final Calc c = new Calc(2);
        assertEquals(5, c.add(3));
    }
}
