package org.howard.edu.lsp.assignment6;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class IntegerSetTest {

    @Test
    public void testClearNormal() {
        IntegerSet set = new IntegerSet();
        set.add(1);
        set.add(2);

        set.clear();

        assertEquals(0, set.length());
        assertTrue(set.isEmpty());
        assertEquals("[]", set.toString());
    }

    @Test
    public void testClearEdgeEmptySet() {
        IntegerSet set = new IntegerSet();

        set.clear();

        assertEquals(0, set.length());
        assertTrue(set.isEmpty());
        assertEquals("[]", set.toString());
    }

    @Test
    public void testLengthNormal() {
        IntegerSet set = new IntegerSet();
        set.add(1);
        set.add(2);
        set.add(3);

        assertEquals(3, set.length());
    }

    @Test
    public void testLengthEdgeEmptySet() {
        IntegerSet set = new IntegerSet();

        assertEquals(0, set.length());
    }

    @Test
    public void testEqualsNormalSameElementsDifferentOrder() {
        IntegerSet set1 = new IntegerSet();
        IntegerSet set2 = new IntegerSet();

        set1.add(1);
        set1.add(2);
        set1.add(3);

        set2.add(3);
        set2.add(1);
        set2.add(2);

        assertTrue(set1.equals(set2));
    }

    @Test
    public void testEqualsEdgeMismatch() {
        IntegerSet set1 = new IntegerSet();
        IntegerSet set2 = new IntegerSet();

        set1.add(1);
        set1.add(2);
        set2.add(1);
        set2.add(3);

        assertFalse(set1.equals(set2));
    }

    @Test
    public void testContainsNormalPresent() {
        IntegerSet set = new IntegerSet();
        set.add(10);
        set.add(20);

        assertTrue(set.contains(10));
    }

    @Test
    public void testContainsEdgeAbsent() {
        IntegerSet set = new IntegerSet();
        set.add(10);
        set.add(20);

        assertFalse(set.contains(30));
    }

    @Test
    public void testLargestNormal() {
        IntegerSet set = new IntegerSet();
        set.add(4);
        set.add(9);
        set.add(1);

        assertEquals(9, set.largest());
    }

    @Test
    public void testLargestEdgeSingleElement() {
        IntegerSet set = new IntegerSet();
        set.add(42);

        assertEquals(42, set.largest());
    }

    @Test
    public void testLargestEdgeEmptyException() {
        IntegerSet set = new IntegerSet();

        assertThrows(RuntimeException.class, set::largest);
    }

    @Test
    public void testSmallestNormal() {
        IntegerSet set = new IntegerSet();
        set.add(4);
        set.add(9);
        set.add(1);

        assertEquals(1, set.smallest());
    }

    @Test
    public void testSmallestEdgeSingleElement() {
        IntegerSet set = new IntegerSet();
        set.add(42);

        assertEquals(42, set.smallest());
    }

    @Test
    public void testSmallestEdgeEmptyException() {
        IntegerSet set = new IntegerSet();

        assertThrows(RuntimeException.class, set::smallest);
    }

    @Test
    public void testAddNormal() {
        IntegerSet set = new IntegerSet();

        set.add(5);

        assertTrue(set.contains(5));
        assertEquals(1, set.length());
    }

    @Test
    public void testAddEdgeDuplicateValues() {
        IntegerSet set = new IntegerSet();

        set.add(5);
        set.add(5);

        assertEquals(1, set.length());
        assertEquals("[5]", set.toString());
    }

    @Test
    public void testRemoveNormal() {
        IntegerSet set = new IntegerSet();
        set.add(5);
        set.add(7);

        set.remove(5);

        assertFalse(set.contains(5));
        assertEquals(1, set.length());
    }

    @Test
    public void testRemoveEdgeValueNotPresent() {
        IntegerSet set = new IntegerSet();
        set.add(5);
        set.add(7);

        set.remove(100);

        assertEquals(2, set.length());
        assertTrue(set.contains(5));
        assertTrue(set.contains(7));
    }

    @Test
    public void testUnionNormal() {
        IntegerSet set1 = new IntegerSet();
        IntegerSet set2 = new IntegerSet();

        set1.add(1);
        set1.add(2);
        set2.add(2);
        set2.add(3);

        IntegerSet result = set1.union(set2);

        assertEquals("[1, 2, 3]", result.toString());
        assertEquals("[1, 2]", set1.toString());
        assertEquals("[2, 3]", set2.toString());
    }

    @Test
    public void testUnionEdgeWithEmptySet() {
        IntegerSet set1 = new IntegerSet();
        IntegerSet emptySet = new IntegerSet();

        set1.add(1);
        set1.add(2);

        IntegerSet result = set1.union(emptySet);

        assertEquals("[1, 2]", result.toString());
        assertEquals("[1, 2]", set1.toString());
        assertEquals("[]", emptySet.toString());
    }

    @Test
    public void testIntersectNormal() {
        IntegerSet set1 = new IntegerSet();
        IntegerSet set2 = new IntegerSet();

        set1.add(1);
        set1.add(2);
        set1.add(3);

        set2.add(2);
        set2.add(3);
        set2.add(4);

        IntegerSet result = set1.intersect(set2);

        assertEquals("[2, 3]", result.toString());
    }

    @Test
    public void testIntersectEdgeNoCommonElements() {
        IntegerSet set1 = new IntegerSet();
        IntegerSet set2 = new IntegerSet();

        set1.add(1);
        set1.add(2);

        set2.add(3);
        set2.add(4);

        IntegerSet result = set1.intersect(set2);

        assertEquals("[]", result.toString());
        assertTrue(result.isEmpty());
    }

    @Test
    public void testDiffNormal() {
        IntegerSet set1 = new IntegerSet();
        IntegerSet set2 = new IntegerSet();

        set1.add(1);
        set1.add(2);
        set1.add(3);

        set2.add(2);
        set2.add(4);

        IntegerSet result = set1.diff(set2);

        assertEquals("[1, 3]", result.toString());
    }

    @Test
    public void testDiffEdgeIdenticalSets() {
        IntegerSet set1 = new IntegerSet();
        IntegerSet set2 = new IntegerSet();

        set1.add(1);
        set1.add(2);

        set2.add(1);
        set2.add(2);

        IntegerSet result = set1.diff(set2);

        assertEquals("[]", result.toString());
        assertTrue(result.isEmpty());
    }

    @Test
    public void testComplementNormal() {
        IntegerSet set1 = new IntegerSet();
        IntegerSet set2 = new IntegerSet();

        set1.add(1);
        set1.add(2);
        set1.add(3);

        set2.add(2);
        set2.add(3);
        set2.add(4);

        IntegerSet result = set1.complement(set2);

        assertEquals("[4]", result.toString());
    }

    @Test
    public void testComplementEdgeDisjointSets() {
        IntegerSet set1 = new IntegerSet();
        IntegerSet set2 = new IntegerSet();

        set1.add(1);
        set1.add(2);

        set2.add(3);
        set2.add(4);

        IntegerSet result = set1.complement(set2);

        assertEquals("[3, 4]", result.toString());
    }

    @Test
    public void testIsEmptyNormalEmptySet() {
        IntegerSet set = new IntegerSet();

        assertTrue(set.isEmpty());
    }

    @Test
    public void testIsEmptyEdgeNonEmptySet() {
        IntegerSet set = new IntegerSet();
        set.add(1);

        assertFalse(set.isEmpty());
    }

    @Test
    public void testToStringNormal() {
        IntegerSet set = new IntegerSet();
        set.add(3);
        set.add(1);
        set.add(2);

        assertEquals("[1, 2, 3]", set.toString());
    }

    @Test
    public void testToStringEdgeEmptySet() {
        IntegerSet set = new IntegerSet();

        assertEquals("[]", set.toString());
    }
}
