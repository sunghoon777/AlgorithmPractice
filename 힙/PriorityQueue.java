package 힙;

import java.util.Comparator;

//우선순위 큐를 heap 으로 구현함.
public class PriorityQueue<E> {

    private final Comparator<? super E> comparator;
    private int capacity;
    private int size;
    private Object[] heapList;


    public PriorityQueue(Comparator<? super E> comparator) {
        this.comparator = comparator;
        capacity = 10;
        size = 0;
        heapList = new Object[capacity];
    }

    public PriorityQueue(int capacity){
        comparator = null;
        this.capacity = capacity;
        size = 0;
        heapList = new Object[capacity];
    }

    public PriorityQueue(int capacity, Comparator<? super E> comparator){
        this.comparator = comparator;
        this.capacity = capacity;
        size = 0;
        heapList = new Object[capacity];
    }

    private int getParent(int index){
        return (index-1)/2;
    }

    private int getLeftChild(int index){
        return index*2 + 1;
    }

    private int getRightChild(int index){
        return index*2 + 2;
    }

    private void resize(int newCapacity){
        Object[] newHeapList = new Object[newCapacity];
        for(int i=0;i<capacity;i++){
            newHeapList[i] = heapList[i];
        }
        heapList = null;
        heapList = newHeapList;
    }

    private int compare(int index1, int index2){
        E value1 = (E) heapList[index1];
        E value2 = (E) heapList[index2];
        return (comparator == null)?((Comparable<E>)value1).compareTo(value2):comparator.compare(value1,value2);
    }

    private void swap(int index1, int index2){
        Object temp = heapList[index1];
        heapList[index1] = heapList[index2];
        heapList[index2] = temp;
    }

    //추가, 맨 뒤에 추가
    public void offer(E element){
        if(!(element instanceof E)){
            throw new ClassCastException();
        }
        //꽉차면 2배 늘림
        if(capacity <= size){
            resize(capacity*2);
        }
        //추가
        heapList[size++] = element;
        //heap 상태로 만든다.
        int targetIndex = size-1;
        while (targetIndex > 0){
            int parentIndex = getParent(targetIndex);
            int a = compare(parentIndex,targetIndex);
            //parent 가 더 우선순위 높기 때문에 heap 상태, 빠져나온다
            if(a>=0){
                break;
            }
            //parent 와 target 교체 후 target parent 로 갱신
            else{
                swap(parentIndex,targetIndex);
                targetIndex = parentIndex;
            }
        }
    }

    //제거, 맨 앞을 제거한다.
    public E poll(){
        if(size <= 0){
            System.out.println("size 0 입니다.");
            return null;
        }
        //맨 첫 노드를 빼온다.
        E element = (E) heapList[0];
        heapList[0] = heapList[--size];
        int targetIndex = 0;
        int lastIndex = size - 1;
        //targetIndex 가 끝 인덱스보다 작을 때까지 반복
        while (getLeftChild(targetIndex) <= lastIndex){
            //우선 부모 인덱스를 가장 큰 인덱스로 둔다.
            int largestIndex = targetIndex;
            int leftChild = getLeftChild(targetIndex);
            int rightChild = getLeftChild(targetIndex);

            //부모 왼쪽 자식 비교
            int compare = compare(leftChild,largestIndex);
            if(compare > 0){
                largestIndex = leftChild;
            }

            //부모 오른쪽 자식 비교
            if(rightChild <= lastIndex){
                compare = compare(rightChild,largestIndex);
                if(compare > 0){
                    largestIndex = rightChild;
                }
            }

            //heap 상태가 아님.
            if(targetIndex != largestIndex){
                //교환
                swap(targetIndex,largestIndex);
                //targetIndex 를 교환된 자식 index(largestIndex) 로 갱신
                targetIndex = largestIndex;
            }
            //heap 상태임
            else{
                break;
            }
        }
        return element;
    }

    //현재 크기 리턴
    public int size(){
        return size;
    }

    //peek
    public E peek() throws NoSuchFieldException {
        if(size <= 0){
            throw new NoSuchFieldException();
        }
        return (E) heapList[0];
    }

    public boolean isEmpty(){
        if(size <= 0){
            return true;
        }
        return false;
    }

    public boolean contains(E e){
        for(int i=0;i<size;i++){
            if(e.equals(heapList[i])){
                return true;
            }
        }
        return false;
    }

    public void clear(){
        for(int i=0;i<size;i++){
            heapList[i] = null;
        }
        size = 0;
    }

    public void printAll(){
        for(int i=0;i<size;i++){
            System.out.print(heapList[i]+"   ");
        }
        System.out.println();
    }


}
