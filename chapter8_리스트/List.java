package chapter8_리스트;

public interface List<E> {

    public int size();

    public boolean isEmpty();

    public boolean contains(Object obj);

    public void add(E obj);

    public boolean remove(Object obj);

    public void clear();

    public void add(int index, E element);

    public void remove();

    public E remove(int index);

    public Integer indexOf(Object o);

    public void print(int index);

    public void printAll();
}
