package chpater4_스택과큐;

public class Stack <E>{

    private E[] stack; // 스택용 배열
    private int capacity; // 용량
    private int ptr; // 스택 포인터

    //실행 시 예외 : 스택이 비어있음
    public static class EmptyInStackException extends RuntimeException{
        public EmptyInStackException() {
        }
    }

    //실행 시 예외 : 스택이 가득참
    public static class OverflowIntException extends RuntimeException{
        public OverflowIntException() {
        }
    }

    public Stack(int capacity) {
        ptr = 0;
        this.capacity = capacity;
        try {
            stack = (E[]) new Object[capacity];

        }catch (OutOfMemoryError e){
            this.capacity = 0;
        }
    }

    //push
    public E push(E x)throws Stack.OverflowIntException{
        if(ptr >= capacity){
            throw new Stack.OverflowIntException();
        }
        return stack[ptr++] = x;
    }

    //pop
    public E pop() throws Stack.EmptyInStackException{
        if(ptr <= 0){
            throw new Stack.EmptyInStackException();
        }
        return stack[--ptr];
    }

    //스택의 꼭대기의 데이터를 알려줌 pop과달리 ptr은 줄어들지 않는다.
    public E peek() throws Stack.EmptyInStackException{
        if(ptr <= 0){
            throw new Stack.EmptyInStackException();
        }
        return stack[ptr-1];
    }

    //모든 데이터 지우기
    public void clear(){
        ptr = 0;
    }

    //특정 데이터 찾고 인덱스 반환(없으면 -1)
    public int indexOf(E x){
        for(int i=0;i<ptr;i++){
            if(x.equals(stack[i]))
                return i;
        }
        return -1;
    }

    //용량 반환
    public int getCapacity(){
        return capacity;
    }

    //스택에 있는 데이터 개수를 반환
    public int size(){
        return ptr;
    }

    //스택이 비어있는지 확인해줌
    public boolean isEmpty(){
        return ptr <= 0;
    }

    //스택이 가득 찼는지 확인
    public boolean isFull(){
        return ptr >= capacity;
    }

    //스택 안에 모든 데이터를 바닥부터 꼭대기 까지 출력
    public void dump(){
        for(int i=0;i<ptr;i++){
            System.out.print(stack[i]+" ");
        }
        System.out.println();
    }



}
