package ch.cyberduck.core;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * @version $Id:$
 */
public class NaturalOrderComparatorTest {

    @Test
    public void testCompare() throws Exception {
        assertEquals(-1, new NaturalOrderComparator().compare("123a", "a"));
        assertEquals(-1, new NaturalOrderComparator().compare("365", "400"));
    }
}
