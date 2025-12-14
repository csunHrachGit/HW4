import java.util.*;

public class CSLinkedList<E> extends AbstractList<E> {

  private static final class Node<E> {
    E data;
    Node<E> next;
    Node(E d, Node<E> n) { data = d; next = n; }
  }

  private final Node<E> head;
  private Node<E> tail;
  private int size;

  public CSLinkedList() {
    head = new Node<>(null, null);
    tail = null;
    size = 0;
  }

  @Override
  public int size() { return size; }

  public boolean isEmpty() { return size == 0; }

  private void checkElementIndex(int index) {
    if (index < 0 || index >= size)
      throw new IndexOutOfBoundsException("index=" + index + ", size=" + size);
  }

  private void checkPositionIndex(int index) {
    if (index < 0 || index > size)
      throw new IndexOutOfBoundsException("index=" + index + ", size=" + size);
  }

  private Node<E> nodeAt(int index) {
    checkElementIndex(index);
    Node<E> cur = head.next;
    for (int i = 0; i < index; i++) cur = cur.next;
    return cur;
  }

  @Override
  public boolean add(E e) {
    Node<E> n = new Node<>(e, null);
    if (size == 0) {
      head.next = n;
      tail = n;
    } else {
      tail.next = n;
      tail = n;
    }
    size++;
    modCount++;
    return true;
  }

  @Override
  public void add(int index, E e) {
    checkPositionIndex(index);
    Node<E> prev = (index == 0) ? head : nodeAt(index - 1);
    Node<E> n = new Node<>(e, prev.next);
    prev.next = n;
    if (index == size) tail = n;
    size++;
    modCount++;
  }

  @Override
  public E get(int index) {
    return nodeAt(index).data;
  }

  @Override
  public E set(int index, E e) {
    Node<E> n = nodeAt(index);
    E old = n.data;
    n.data = e;
    return old;
  }

  @Override
  public E remove(int index) {
    checkElementIndex(index);
    Node<E> prev = (index == 0) ? head : nodeAt(index - 1);
    Node<E> target = prev.next;
    prev.next = target.next;
    if (target == tail) {
      tail = (prev == head && prev.next == null) ? null : prev;
    }
    size--;
    modCount++;
    return target.data;
  }

  @Override
  public int indexOf(Object o) {
    int i = 0;
    for (Node<E> cur = head.next; cur != null; cur = cur.next, i++) {
      if (o == null ? cur.data == null : o.equals(cur.data)) return i;
    }
    return -1;
  }

  // LL3 – add item only if it is not already in the list
  public boolean addIfAbsent(E item) {
    if (indexOf(item) != -1) {
      return false; // already present
    }
    add(item);
    return true;
  }

  // LL5 – move an existing item to the front (index 0)
  public void moveToFront(E item) {
    int idx = indexOf(item);
    if (idx <= 0) {
      // either not found (-1) or already at front (0)
      return;
    }
    E value = remove(idx);
    add(0, value);
  }

  // LL6 – insert newItem immediately AFTER the first occurrence of target
  public boolean addAfter(E target, E newItem) {
    int idx = indexOf(target);
    if (idx == -1) {
      return false; // target not found
    }
    add(idx + 1, newItem);
    return true;
  }

  // LL8 – insert item in sorted order using a Comparator
  public void addInOrder(E item, Comparator<E> cmp) {
    int i = 0;
    for (; i < size(); i++) {
      if (cmp.compare(item, get(i)) <= 0) {
        break;
      }
    }
    add(i, item); // inserts at position i (possibly at end)
  }

  // LL9 – remove only the first occurrence of item
  public boolean removeFirstOccurrence(E item) {
    int idx = indexOf(item);
    if (idx == -1) {
      return false;
    }
    remove(idx);
    return true;
  }

  // LL10 – return a shallow copy of this linked list
  public CSLinkedList<E> copy() {
    CSLinkedList<E> result = new CSLinkedList<>();
    for (E e : this) {
      result.add(e);
    }
    return result;
  }

  @Override
  public void clear() {
    head.next = null;
    tail = null;
    size = 0;
    modCount++;
  }

  @Override
  public Iterator<E> iterator() {
    return new Itr();
  }

  private final class Itr implements Iterator<E> {
    private Node<E> prev = head;
    private Node<E> cursor = head.next;
    private Node<E> lastPrev = null;
    private Node<E> lastRet = null;
    private int expectedMod = modCount;

    @Override
    public boolean hasNext() { return cursor != null; }

    @Override
    public E next() {
      checkForComod();
      if (cursor == null) throw new NoSuchElementException();
      lastPrev = prev;
      lastRet = cursor;
      prev = cursor;
      cursor = cursor.next;
      return lastRet.data;
    }

    @Override
    public void remove() {
      checkForComod();
      if (lastRet == null) throw new IllegalStateException();
      lastPrev.next = lastRet.next;
      if (lastRet == tail) {
        tail = (lastPrev == head && lastPrev.next == null) ? null : lastPrev;
      }
      size--;
      modCount++;
      expectedMod++;
      lastRet = null;
    }

    private void checkForComod() {
      if (expectedMod != modCount) throw new ConcurrentModificationException();
    }
  }
}
