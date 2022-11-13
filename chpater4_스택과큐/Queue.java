package chpater4_스택과큐;

public class Queue<E>{

    private E[] queue; // 큐 배열
    private int capacity; // 큐의 용량
    private int front; // 맨 앞의 요소 커서
    private int rear; // 맨 뒤의 요소 커서
    private int number; // 현제 데이터 개수

    public static class EmptyIntQueueException extends RuntimeException{
        public EmptyIntQueueException(){

        }
    }

    public static class OverflowQueueException extends RuntimeException{
        public OverflowQueueException(){

        }
    }

    public Queue(int capacity){
        this.capacity = capacity;
        number=front=rear=0;
        try {
            queue = (E[]) new Object[capacity];
        }catch (OutOfMemoryError e){
            queue = (E[]) new Object[0];
        }
    }

    public E enQueue(E x) throws Queue.OverflowQueueException {
        if(number >= capacity){
            throw new Queue.OverflowQueueException();
        }
        queue[rear++] = x;
        number++;
        if(rear == capacity){
            rear = 0;
        }
        return x;
    }

    public E deQueue() throws Queue.EmptyIntQueueException {
        if(number <= 0){
            throw new Queue.EmptyIntQueueException();
        }
        E x = queue[front++];
        number--;
        if(front == capacity){
            front = 0;
        }
        return x;
    }

    public E peek() throws IntQueue.EmptyIntQueueException {
        if(number <= 0){
            throw new Queue.EmptyIntQueueException();
        }
        return queue[front];
    }

    public void clear(){
        number=front=rear=0;
    }

    public int indexOf(E x){
        for(int i=0;i<number;i++){
            int index = (front + i) % capacity;
            if(queue[index].equals(x)){
                return index;
            }
        }
        return -1;
    }

    public int getCapacity(){
        return capacity;
    }

    public int size(){
        return number;
    }

    public boolean isEmpty(){
        return number <= 0;
    }

    public boolean isFull(){
        return number >= capacity;
    }

    public void dump(){
        if(number <= 0){
            System.out.println("비어있습니다.");
        }
        else{
            for(int i=0;i<number;i++){
                int index = (front + i) % capacity;
                System.out.print(queue[index]+" ");
            }
            System.out.println();
        }
    }

    //논리적으로 몇 번째 있는가 반환 실패시 0 front에 있으면 1을 반환하는 것임.
    public int search(int x){
        if(number <= 0){
            System.out.println("비어있습니다.");
            return 0;
        }
        for(int i=0;i<number;i++){
            int index = (front + i) % capacity;
            if(queue[index].equals(x)){
                return i+1;
            }
        }
        return 0;
    }





}
