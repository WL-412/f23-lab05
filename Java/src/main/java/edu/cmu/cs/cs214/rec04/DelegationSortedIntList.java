package edu.cmu.cs.cs214.rec04;

/**
 * DelegationSortedIntList -- a variant of a SortedIntList that keeps
 * count of the number of attempted element insertions (not to be confused
 * with the current size, which goes down when an element is removed)
 * and exports an accessor (totalAdded) for this count.
 *
 * @author Nora Shoemaker
 *
 */

public class DelegationSortedIntList implements IntegerList {
    // Write your implementation below with API documentation
    private SortedIntList sortedIntList = new SortedIntList();
    private int totalAdded = 0;

    @Override
    public boolean add(int value) {
        if (sortedIntList.add(value)) {
            totalAdded ++;
            return true;
        }
        return false;
    }

    @Override
    public boolean addAll(IntegerList list) {
        if (sortedIntList.addAll(list)) {
            totalAdded = size();
            return true;
        }
        return false;
    }

    public int getTotalAdded() {
        return totalAdded;
    }

    @Override
    public int get(int index) {
        return sortedIntList.get(index);
    }

    @Override
    public boolean remove(int num) {
        return sortedIntList.remove(num);
    }

    @Override
    public boolean removeAll(IntegerList list) {
        return sortedIntList.removeAll(list);
    }

    @Override
    public int size() {
        return sortedIntList.size();
    }
}