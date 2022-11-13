package chpater4_스택과큐;

import java.awt.desktop.QuitEvent;

public class IntArrayQueue {

    private int[] queue; // 큐용 배열
    private int capacity; // 큐 용량
    private int rear; // 현재 데이터 개수
    private int front; // 데이터가 나오는 위치

    public class EmptyInQueueException extends RuntimeException{

    }

    public class OverflowQueueException extends RuntimeException{

    }

    public IntArrayQueue(int capacity){
        rear = 0;
        front = 0;
        this.capacity = capacity;
        try {
            queue = new int[capacity];
        }catch (OutOfMemoryError e){
            queue = new int[0];
        }
    }
    
    public int enQueue(int x) throws OverflowQueueException{
        if(rear >= capacity){
            throw new OverflowQueueException();
        }
        return queue[rear++] = x;
    }

    public int deQueue() throws EmptyInQueueException{
        if(rear <= front){
            throw new EmptyInQueueException();
        }
        int x = queue[0];
        for(int i =0;i<rear-1;i++){
            queue[i] = queue[i+1];
        }
        return x;
    }

    public int peek() throws EmptyInQueueException{
        if(rear <= front){
            throw new EmptyInQueueException();
        }
        return queue[rear-1];
    }

    public void clear(){
        rear = 0;
    }

    public int indexOf(int x){
        for(int i =0;i<rear;i++){
            if(queue[i] == x)
                return i;
        }
        return -1;
    }

    public int getCapacity(){
        return capacity;
    }

    public int size(){
        return rear;
    }

    public boolean isEmpty(){
        return rear <= 0;
    }

    public boolean isFull(){
        return rear >= capacity;
    }

    public void dump(){
        if(rear <= front){
            System.out.println("스택이 비어 있습니다.");
        }
        else{
            for(int i =0;i<rear;i++){
                System.out.print(queue[i]+" ");
            }
            System.out.println();
        }
    }

    public int[] getQueue() {
        return queue;
    }
}
