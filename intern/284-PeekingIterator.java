// Java Iterator interface reference:
// https://docs.oracle.com/javase/8/docs/api/java/util/Iterator.html
class PeekingIterator implements Iterator<Integer> {
    private Iterator<Integer> it;
    private boolean isPeek;
    private int nextVal;
	public PeekingIterator(Iterator<Integer> iterator) {
	    // initialize any member here.
        it = iterator;
	}

    // Returns the next element in the iteration without advancing the iterator.
	public Integer peek() {
        if (!isPeek) {
            isPeek = true;
            nextVal = it.next();
        }
        return nextVal;
	}

	// hasNext() and next() should behave the same as in the Iterator interface.
	// Override them if needed.
	@Override
	public Integer next() {
	    if (!isPeek) {
            return it.next();
        } else {
            isPeek = false;
            return nextVal;
        }
	}

	@Override
	public boolean hasNext() {
	    return isPeek || it.hasNext();
	}
}
