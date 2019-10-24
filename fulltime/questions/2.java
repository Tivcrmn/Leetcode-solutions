class ArrayQueue<T> {
  private int head, tail, size;
  private T[] queue;
  private int initialSize = 8;
  public ArrayQueue() {
    this.queue = new T[initialSize];
    this.size = 0;
    this.head = -1;
    this.tail = -1;
  }
  public void offer(T t) {
    if (size == initialSize) {
      // resize
    }
    if (size == 0) {
      head = 0;
    }
    tail = (tail + 1) % initialSize;
    queue[tail] = t;
    size++;
  }
  public T poll() {
    if (size == 0) throw;
    T ret = queue[head];
    head = (head + 1) % initialSize;
    size--;
    if (size == 0) {
      head = -1;
      tail = -1;
    }
  }
  public T peek() {
    if (size == 0) throw;
    return queue[head];
  }
  public int size() {
    return size;
  }
}
