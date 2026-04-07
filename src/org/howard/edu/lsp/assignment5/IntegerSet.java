package org.howard.edu.lsp.assignment5;

import java.util.ArrayList;
import java.util.Collections;

/**
 * IntegerSet class models a mathematical set of integers.
 * It does not allow duplicate elements and supports common set operations.
 */
public class IntegerSet {
    private ArrayList<Integer> set;

    /**
     * Default constructor initializes an empty set.
     */
    public IntegerSet() {
        set = new ArrayList<>();
    }

    /**
     * Clears the internal representation of the set.
     */
    public void clear() {
        set.clear();
    }

    /**
     * Returns the length of the set.
     */
    public int length() {
        return set.size();
    }

    /**
     * Returns true if the two sets are equal.
     */
    public boolean equals(IntegerSet b) {
        if (b == null) {
            return false;
        }
        if (this.length() != b.length()) {
            return false;
        }
        return this.set.containsAll(b.set) && b.set.containsAll(this.set);
    }

    /**
     * Returns true if the set contains the given value.
     */
    public boolean contains(int value) {
        return set.contains(value);
    }

    /**
     * Returns the largest item in the set.
     * Throws RuntimeException if the set is empty.
     */
    public int largest() {
        if (set.isEmpty()) {
            throw new RuntimeException("Set is empty");
        }
        return Collections.max(set);
    }

    /**
     * Returns the smallest item in the set.
     * Throws RuntimeException if the set is empty.
     */
    public int smallest() {
        if (set.isEmpty()) {
            throw new RuntimeException("Set is empty");
        }
        return Collections.min(set);
    }

    /**
     * Adds an item to the set if it is not already present.
     */
    public void add(int item) {
        if (!set.contains(item)) {
            set.add(item);
        }
    }

    /**
     * Removes an item from the set if it exists.
     */
    public void remove(int item) {
        set.remove(Integer.valueOf(item));
    }

    /**
     * Returns a new set that is the union of this set and another set.
     */
    public IntegerSet union(IntegerSet intSetb) {
        IntegerSet result = new IntegerSet();

        // Add all elements from current set
        result.set.addAll(this.set);

        // Add elements from intSetb if not already present
        for (int item : intSetb.set) {
            if (!result.set.contains(item)) {
                result.set.add(item);
            }
        }

        return result;
    }

    /**
     * Returns a new set that is the intersection of this set and another set.
     */
    public IntegerSet intersect(IntegerSet intSetb) {
        IntegerSet result = new IntegerSet();

        for (int item : this.set) {
            if (intSetb.set.contains(item)) {
                result.add(item);
            }
        }

        return result;
    }

    /**
     * Returns a new set that is the difference of this set and another set (this - intSetb).
     */
    public IntegerSet diff(IntegerSet intSetb) {
        IntegerSet result = new IntegerSet();

        for (int item : this.set) {
            if (!intSetb.set.contains(item)) {
                result.add(item);
            }
        }

        return result;
    }

    /**
     * Returns a new set that is the complement of this set in another set (intSetb - this).
     */
    public IntegerSet complement(IntegerSet intSetb) {
        return intSetb.diff(this);
    }

    /**
     * Returns true if the set is empty.
     */
    public boolean isEmpty() {
        return set.isEmpty();
    }

    /**
     * Returns a string representation of the set in ascending order.
     * Format: [1, 2, 3]
     */
    @Override
    public String toString() {
        ArrayList<Integer> sorted = new ArrayList<>(set);
        Collections.sort(sorted);
        return sorted.toString();
    }
}
