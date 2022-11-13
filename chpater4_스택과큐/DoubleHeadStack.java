package chpater4_스택과큐;

public class DoubleHeadStack {

    private int capacity; // 용량
    private int ptr1; // 첫 번째 스택 현재 크기
    private int ptr2; // 두 번째 스택 현재 크기
    private int stack[]; // 스택용 배열

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
    public DoubleHeadStack(int maxLength) {
        ptr1 = 0;
        ptr2 = 0;
        capacity = maxLength;
        try {
            stack = new int[capacity];
        }catch (OutOfMemoryError e){
            capacity = 0;
        }
    }

    //push
    public int push(int FirstOrSecond, int x) throws OverflowIntException {
        if(ptr1 + ptr2 >= capacity){
            throw new OverflowIntException();
        }
        if(FirstOrSecond == 1){
            return  stack[ptr1++] = x;
        }
        else if(FirstOrSecond == 2){
            return stack[capacity-(++ptr2)] = x;
        }
        return -1;
    }

    //pop
    public int pop(int FirstOrSecond) throws EmptyInStackException {
        if(FirstOrSecond == 1){
            if(ptr1 <= 0){
                throw new EmptyInStackException();
            }
            return stack[--ptr1];
        }
        else if(FirstOrSecond == 2){
            if(ptr2 <= 0){
                throw new EmptyInStackException();
            }
            return stack[capacity-(ptr2--)];
        }
        return -1;
    }

    //peek
    public int peek(int FirstOrSecond) throws EmptyInStackException {
        if(FirstOrSecond == 1){
            if(ptr1 <= 0){
                throw new EmptyInStackException();
            }
            return stack[ptr1-1];
        }
        else if(FirstOrSecond == 2){
            if(ptr2 <= 0){
                throw new EmptyInStackException();
            }
            return stack[capacity - ptr2];
        }
        return -1;
    }

    //clear
    public void clear(int FirstOrSecond){
        if(FirstOrSecond == 1){
            ptr1 = 0;
        }
        else if(FirstOrSecond == 2){
            ptr2 = 0;
        }
    }

    //indexOf
    public int indexOf(int FirstOrSecond, int x){
        if(FirstOrSecond == 1){
            for(int i=0;i<ptr1;i++){
                if(x == stack[i])
                    return i;
            }
        }
        else if(FirstOrSecond == 2){
            for(int i=capacity-1;i>=capacity-ptr2;i--){
                if(x == stack[i])
                    return i;
            }
        }
        return -1;
    }

    //용량 반환
    public int getCapacity(){
        return capacity;
    }

    //스택에 있는 데이터 개수를 반환
    public int size(int FirstOrSecond){
        if(FirstOrSecond == 1){
            return ptr1;
        }
        else if(FirstOrSecond == 2){
            return ptr2;
        }
        return -1;
    }

    //스택이 비어있는지 확인해줌
    public boolean isEmpty(int FirstOrSecond){
        if(FirstOrSecond == 1){
            if(ptr1 <= 0)
                return true;
        }
        else if(FirstOrSecond == 2){
            if(ptr2 <= 0)
                return true;
        }
        return false;
    }

    //스택이 가득 찼는지 확인
    public boolean isFull(){
        if(ptr1 + ptr2 >= capacity){
            return true;
        }
        return false;
    }

    //스택 안에 모든 데이터를 바닥부터 꼭대기 까지 출력
    public void dump(int FirstOrSecond){
        if(FirstOrSecond == 1){
            if(ptr1 <= 0){
                System.out.println("스택이 비어 있습니다.");
            }
            else{
                for(int i =0;i<ptr1;i++){
                    System.out.print(stack[i]+" ");
                }
                System.out.println();
            }
        }
        else if(FirstOrSecond == 2){
            if(ptr2 <= 0){
                System.out.println("스택이 비어 있습니다.");
            }
            else{
                for(int i = capacity-1;i>=capacity-ptr2;i--){
                    System.out.print(stack[i]+" ");
                }
                System.out.println();
            }
        }
    }

}
