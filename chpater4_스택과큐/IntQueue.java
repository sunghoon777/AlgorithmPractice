package chpater4_스택과큐;

public class IntQueue {

    private int[] queue; // 큐용 배열
    private int capacity; // 큐의 용량
    private int front; // 맨 앞의 요소 커서
    private int rear; // 맨 뒤의 요소 커서
    private int number; // 현제 데이터 개수

    public class EmptyIntQueueException extends RuntimeException{
        public EmptyIntQueueException(){

        }
    }

    public class OverflowQueueException extends RuntimeException{
        public OverflowQueueException(){

        }
    }

    public IntQueue(int capacity){
        this.capacity = capacity;
        number=front=rear=0;
        try {
            queue = new int[capacity];
        }catch (OutOfMemoryError e){
            queue = new int[0];
        }
    }

    public int enQueue(int x) throws OverflowQueueException{
        if(number >= capacity){
            throw new OverflowQueueException();
        }
        queue[rear++] = x;
        number++;
        if(rear == capacity){
            rear = 0;
        }
        return x;
    }

    public int deQueue() throws EmptyIntQueueException{
        if(number <= 0){
            throw new EmptyIntQueueException();
        }
        int x = queue[front++];
        number--;
        if(front == capacity){
            front = 0;
        }
        return x;
    }

    public int peek() throws EmptyIntQueueException  {
        if(number <= 0){
            throw new EmptyIntQueueException();
        }
        return queue[front];
    }

    public void clear(){
        number=front=rear=0;
    }

    public int indexOf(int x){
        for(int i=0;i<number;i++){
            int index = (front + i) % capacity;
            if(queue[index] == x){
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
            if(queue[index] == x){
                return i+1;
            }
        }
        return 0;
    }



}
