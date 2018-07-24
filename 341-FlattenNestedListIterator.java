/**
 * // This is the interface that allows for creating nested lists.
 * // You should not implement it, or speculate about its implementation
 * public interface NestedInteger {
 *
 *     // @return true if this NestedInteger holds a single integer, rather than a nested list.
 *     public boolean isInteger();
 *
 *     // @return the single integer that this NestedInteger holds, if it holds a single integer
 *     // Return null if this NestedInteger holds a nested list
 *     public Integer getInteger();
 *
 *     // @return the nested list that this NestedInteger holds, if it holds a nested list
 *     // Return null if this NestedInteger holds a single integer
 *     public List<NestedInteger> getList();
 * }
 */
public class NestedIterator implements Iterator<Integer> {
    private Stack<NestedInteger> stack;
    private void pushListsToStack(List<NestedInteger> lists) {
        Stack<NestedInteger> temp = new Stack<>();
        for (NestedInteger list : lists) {
            temp.push(list);
        }
        while (!temp.isEmpty()) {
            stack.push(temp.pop());
        }
    }
    public NestedIterator(List<NestedInteger> nestedList) {
        stack = new Stack<>();
        pushListsToStack(nestedList);
    }

    @Override
    public Integer next() {
        if (!hasNext()) return null;
        else return stack.pop().getInteger();
    }

    @Override
    public boolean hasNext() {
        while (!stack.isEmpty() && !stack.peek().isInteger()) {
            pushListsToStack(stack.pop().getList());
        }
        return !stack.isEmpty();
    }
}

/**
 * Your NestedIterator object will be instantiated and called as such:
 * NestedIterator i = new NestedIterator(nestedList);
 * while (i.hasNext()) v[f()] = i.next();
 */
