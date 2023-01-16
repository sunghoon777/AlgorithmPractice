package chapter8_리스트;

/*
-- 대표 기능 --
첫 번째 노드 추가 삭제 , 마지막 노드 추가 삭제
선택 노드 삭제 , 선택 노드 다음으로 옮기기, 모든 노드 삭제, 선택 노드 출력, 모든 노드 출력

-- 메서드를 실행한 이후 노드 포인터의 값 --
생성자 : null  search : 찾은 노드
addFirst : 삽입한 첫 번쨰 노드  addLast : 삽입한 마지막 노드
removeFirst : 삭제 후 첫 번째 노드(null 일 수도 있다) removeLast : 삭제 후 마지막 노드(null 일 수도 있다)
removeCurrentNode : 삭제한 선택 노드 이전 노드를 가리킨다.(null 일 수도)
clear : null 
next : 다음 노드
 */
public class LinkedList1<E>{

    //머리 노드를 가리킨다.
    private Node<E> head;
    //꼬리 노드를 가리킨다.
    private Node<E> tail;
    //현재 선택 노드
    private Node<E> currentNode;
    private int size;
    

    public LinkedList1() {
        head = tail = currentNode = null;
        size = 0;
    }

    public int size(){
        return size;
    }

    //검색하기 찾으면 true or false
    //선택 노드는 찾은 노드를 가리킨다.
    public boolean search(E obj){
        if(head == null)
            return false;
        Node<E> ptr = head;
        while (ptr != null){
            if(ptr.data.equals(obj)){
                //선택 포인터는 조건을 만족한 노드를 가리킨다.
                currentNode = ptr;
                return true;
            }
            ptr = ptr.next;
        }
        return false;
    }

    //첫 번째 노드로 삽입
    //선택노드는 첫 번째 노드 가리킨다.
    public void addFirst(E data){
        Node<E> node = new Node<>(data,head);
        head = currentNode = node;
        //요소 1개이면 tail 은 head 와 똑같은 것을 가리킨다.
        if(head.next == null){
            tail = node;
        }
        size++;
    }

    //마지막 노드로 삽입
    //선택 노드는 마지막 노드를 가리킨다.
    public void addLast(E data){
        //리스트안에 아무것도 없으면 addFirst 실행
        if(head == null){
            addFirst(data);
            return;
        }
        Node<E> node = new Node<>(data,null);
        tail.next = node;
        tail = currentNode = node;
        size++;
    }

    //첫 번째 노드 삭제
    //선택 노드는 첫 번쨰 노드를 가리킨다.
    public void removeFirst(){
        //비어있으면 지울 수도 없기 때문에 리턴
        if(head == null){
            return;
        }
        head = currentNode = head.next;
        //요소 1개이면 tail 은 head 와 똑같은 것을 가리킨다.
        if(head.next == null){
            tail = head;
        }
        size--;
    }

    //마지막 노드 삭제
    //선택 노드는 마지막 노드를 가리킨다.
    public void removeLast(){
        //비어있으면 지울 수도 없기 때문에 리턴
        if(head == null){
            return;
        }
        if(head.next == null){
            removeFirst();
            return;
        }
        Node<E> lastNode = head;
        Node<E> lastPreNode = head;
        while (lastNode.next != null){
            lastPreNode = lastNode;
            lastNode = lastNode.next;
        }
        currentNode = lastPreNode;
        lastPreNode.next = null;
        //tail 이 last 가리키게함.
        tail = currentNode;
        size--;
    }


    //선택 노드 삭제
    //선택 노드는 제거한 노드의 전 노드를 가리킨다.
    public void removeCurrentNode(){
        //비어있으면 리턴
        if(head == null){
            return;
        }
        //요소 한개면 어차피 선택노드는 그 요소를 가리키므로 요소 삭제
        if(head.next == null){
            removeFirst();
            return;
        }
        //선택 노드 검색하기
        Node<E> ptr = head;
        Node<E> ptrPre = head;
        while (ptr !=  null){
            if(ptr == currentNode){
                break;
            }
            ptrPre = ptr;
            ptr = ptr.next;
        }
        //못찾음
        if(ptr == null) {
            return;
        }
        //찾음
        ptrPre.next = ptr.next;
        currentNode = ptrPre;
        //삭제한 노드가 마지막 노드였다면 tail 갱신
        if(currentNode.next == null){
            tail = currentNode;
        }
        size--;
    }

    //모두 삭제
    //선택 노드는 null 가리킴
    //모든 노드가 참조되지 못하게 만든다.
    public void clear(){
        if(head == null)
            return;
        if(head.next == null){
            removeFirst();
        }
        Node<E> ptr = head;
        while (head != null){
            ptr = head.next;
            head.next = null;
            head = ptr;
        }
        tail = currentNode = head;
        size = 0;
    }

    //선택 노드를 뒤로 진행
    //선택 노드가 null 이거나 다음 노드가 null 이면 진행 못함.
    public boolean next(){
        if(currentNode == null || currentNode.next == null){
            return false;
        }
        currentNode = currentNode.next;
        return true;
    }

    //선택 노드 출력
    public void printCurrentNode(){
        if(currentNode == null){
            System.out.println("현재 선택 노드는 없습니다.");
            return;
        }
        System.out.println(currentNode.data);
    }

    //모든 노드 출력
    public void printAll(){
        if(head == null){
            System.out.println("리스트에는 노드가 존재하지 않습니다.");
            return;
        }
        Node<E> ptr = head;
        while (ptr != null){
            System.out.print(ptr.data+"\t");
            ptr = ptr.next;
        }
        System.out.println();
    }
    
    /*
    index 를 통한 삭제 추가 메소드들
     */
    
    //index 로 노드 삭제
    public boolean remove(int index){
        if(index >= size){
            return false;
        }
        if(index == 0){
            removeFirst();
            return true;
        }
        if(index == size-1){
            removeLast();
            return true;
        }
        Node<E> ptr = head.next;
        Node<E> ptrPre = head;
        int i=1;
        while (ptr != null){
            if(i == index){
                ptrPre.next = ptr.next;
                break;
            }
            ptrPre = ptr;
            ptr = ptr.next;
            i++;
        }
        size--;
        return true;
    }

    //특정 노드 삭제
    public boolean remove(E obj){
        if(search(obj)){
            removeCurrentNode();
            return true;
        }
        else{
            return false;
        }
    }
    
    //index 로 노드 추가
    public void add(int index, E obj){
        if(index >= size){
            return;
        }
        if(index == 0){
            addFirst(obj);
            return;
        }
        if(index == size-1){
            addLast(obj);
            return;
        }
        int i = 1;
        Node<E> ptr = head.next;
        Node<E> ptrPre = head;
        while (ptr != null){
            if(i == index){
                Node<E> node = new Node<>(obj,ptr);
                ptrPre.next = node;
                break;
            }
            ptrPre = ptr;
            ptr = ptr.next;
            i++;
        }
        size++;
    }
    
    //노드의 index 반환하기
    public int indexOf(E data){
        if(head == null){
            return -1;
        }
        int i =0;
        Node<E> ptr = head;
        while (ptr != null){
            if(ptr.data.equals(data)){
                return i;
            }
            ptr = ptr.next;
            i++;
        }
        return -1;
    }

    //index 에 해당되는 노드 가져오기
    public E get(int index){
        if(index >= size || head == null){
            return null;
        }
        int i =0;
        Node<E> ptr = head;
        while (ptr != null){
            if(i == index){
                return ptr.data;
            }
            ptr = ptr.next;
            i++;
        }
        return null;
    }
    
    //노드 클래스
    class Node<E>{
        //데이터
        private E data;
        //다음 노드를 가리키는 포인터
        private Node<E> next;

        public Node(E data, Node<E> next) {
            this.data = data;
            this.next = next;
        }
    }
    
}
