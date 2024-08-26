package org.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class UtilsTest {

    @Test
    public void testIsAllPositiveNumbers() {
        assertTrue(Utils.isAllPositiveNumbers("1", "2", "3"));
        assertFalse(Utils.isAllPositiveNumbers("1", "-2", "3"));
        assertFalse(Utils.isAllPositiveNumbers("1", "a", "3"));
        assertFalse(Utils.isAllPositiveNumbers());
    }
}
