package chpater4_스택과큐;

public class IntStack {
    
    private int[] stack; // 스택용 배열
    private int capacity; // 용량
    private int ptr; // 스택 포인터, 사이즈

    //실행 시 예외 : 스택이 비어있음
    public class EmptyInStackException extends RuntimeException{
        public EmptyInStackException() {
        }
    }

    //실행 시 예외 : 스택이 가득참
    public class OverflowIntException extends RuntimeException{
        public OverflowIntException() {
        }
    }

    //생성자
    public IntStack(int maxLength) {
        ptr = 0;
        capacity = maxLength;
        try {
            stack = new int[capacity];
        }catch (OutOfMemoryError e){
            capacity = 0;
        }
    }

    //push
    public int push(int x) throws OverflowIntException{
        if(ptr >= capacity){
            throw new OverflowIntException();
        }
        return stack[ptr++] = x;
    }

    //pop

    public int pop() throws EmptyInStackException{
        if(ptr <= 0){
            throw new EmptyInStackException();
        }
        return stack[--ptr];
    }

    //스택의 꼭대기의 데이터를 알려줌 pop과달리 ptr은 줄어들지 않는다.
    public int peek() throws EmptyInStackException{
        if(ptr <= 0){
            throw new EmptyInStackException();
        }
        return stack[ptr-1];
    }

    //모든 데이터 지우기
    public void clear(){
        ptr = 0;
    }

    //특정 데이터 찾고 인덱스 반환(없으면 -1)
    public int indexOf(int x){
        for(int i=0;i<ptr-1;i++){
            if(stack[i] == x)
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
        if(ptr <= 0){
            System.out.println("스택이 비어 있습니다.");
        }
        else{
            for(int i =0;i<ptr;i++){
                System.out.print(stack[i]+" ");
            }
            System.out.println();
        }
    }


}
