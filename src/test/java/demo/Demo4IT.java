package demo;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Tag;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Demo4IT {
    @Test
    @Tag("tag2")
    public void exampleTest() {
        final Calc c = new Calc(4);
        assertEquals(9, c.add(5));
    }
}
