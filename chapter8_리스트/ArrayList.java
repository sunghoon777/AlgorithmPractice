package chapter8_리스트;

public class ArrayList<E> implements List<E>{

    private Object[] list;

    private int size;

    public ArrayList() {
        list = new Object[10];
        size = 0;
    }

    public ArrayList(int initialCapacity) {
        list = new Object[initialCapacity];
        size = 0;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        if(size == 0){
            return true;
        }
        return false;
    }

    @Override
    public boolean contains(Object obj) {
        for(Object element : list){
            if(element.equals(obj)){
                return true;
            }
        }
        return false;
    }

    @Override
    public void add(E obj) {
        if(size == list.length){
            Object[] newList = new Object[size*2];
            System.arraycopy(list,0,newList,0,size);
            list = newList;
        }
        list[size++] = obj;
    }

    @Override
    public boolean remove(Object obj) {
        if(size == 0){
            return false;
        }
        for(int i=0;i<size;i++){
            if(list[i].equals(obj)){
                list[i] = null;
                if(i != size-1){
                    for(int j=i+1;j<size;j++){
                        list[j-1] = list[j];
                    }
                }
                size--;
                return true;
            }
        }
        return false;
    }

    @Override
    public void clear() {
        for(Object element : list){
            element = null;
        }
        size = 0;
    }

    @Override
    public void add(int index, E element) {
        if(size == list.length){
            Object[] newList = new Object[size*2];
            System.arraycopy(list,0,newList,0,size);
            list = newList;
        }
        System.arraycopy(list,index,list,index+1,size-index);
        list[index] = element;
        size++;
    }

    @Override
    public void remove(){
        list[--size] = null;
    }

    @Override
    public E remove(int index) {
        if(isEmpty() || index >= size){
            return null;
        }
        E element = (E) list[index];
        if(size-1 == index){
            remove();
            return element;
        }
        System.arraycopy(list,index+1,list,index,size-index-1);
        size--;
        return element;
    }

    @Override
    public Integer indexOf(Object o) {
        for(int i=0;i<size;i++){
            if(list[i].equals(o)){
                return i;
            }
        }
        return -1;
    }

    @Override
    public void print(int index) {
        if(list[index] == null){
            System.out.println("element 존재하지 않음");
            return;
        }
        System.out.println(list[index]);
    }

    @Override
    public void printAll() {
        for(int i=0;i<size;i++){
            System.out.print(list[i]+" ");
        }
        System.out.println();
    }
}
