package demo;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Tag;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Demo3IT {
    @Test
    @Tag("tag1")
    public void exampleTest() {
        final Calc c = new Calc(3);
        assertEquals(7, c.add(4));
    }
}
