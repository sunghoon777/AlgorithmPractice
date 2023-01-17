package chapter8_리스트;

//원형 이중 연결 리스트
public class DoubleLinkedList<E> {

    private class Node{

        //데이타
        E data;
        //전 노드 가리킴
        Node pre;
        //다음 노드 가리킴
        Node next;

        //더미 노드 생성할 때 사용하는 생성자
        public Node() {
            data = null;
            pre = next = this;
        }

        public Node(E data, Node pre, Node next) {
            this.data = data;
            this.pre = pre;
            this.next = next;
        }

    }

    //head 더미 노드를 가리킨다.
    private Node head;
    //선택 노드를 가리킨다.
    private Node currentNode;
    //현재 크기
    private int size;

    //생성자
    public DoubleLinkedList() {
        currentNode = head = new Node();
        size = 0;
    }

    //크기
    public int size(){
        return size;
    }

    //검색하기 찾으면 true or false
    //선택 노드는 찾은 노드를 가리킨다.
    public boolean search(E obj){
        Node ptr = head.next;
        if(ptr == head){
            return false;
        }
        while (ptr != head){
            if(ptr.data.equals(obj)){
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
        Node node = new Node(data,head,head.next);
        head.next.pre = node;
        head.next = node;
        currentNode = node;
        size++;
    }

    //마지막 노드로 삽입
    //선택 노드는 마지막 노드를 가리킨다.
    public void addLast(E data){
        Node node = new Node(data,head.pre,head);
        head.pre.next = node;
        head.pre = node;
        currentNode = node;
        size++;
    }

    //첫 번째 노드 삭제
    //선택 노드는 첫 번쨰 노드를 가리킨다.
    public void removeFirst(){
        currentNode = head.next;
        removeCurrentNode();
    }

    //마지막 노드 삭제
    //선택 노드는 마지막 노드를 가리킨다.
    public void removeLast(){
        currentNode = head.pre;
        removeCurrentNode();
    }


    //선택 노드 삭제
    //선택 노드는 제거한 노드의 전 노드를 가리킨다.
    public void removeCurrentNode(){
        if(currentNode == head){
            return;
        }
        currentNode.pre.next = currentNode.next;
        currentNode.next.pre = currentNode.pre;
        currentNode = currentNode.pre;
        if(currentNode == head){
            currentNode = head.next;
        }
        size--;
    }

    //모두 삭제
    public void clear(){
        currentNode = head.next;
        while (currentNode != head){
            removeCurrentNode();
        }
    }

    //선택 노드를 뒤로 진행
    public boolean next(){
        if(size == 0 || currentNode.next == head){
            return false;
        }
        currentNode = currentNode.next;
        return true;
    }

    //선택 노드 출력
    public void printCurrentNode(){
        if(size != 0){
            System.out.println(currentNode.data);
        }
        else{
            System.out.println("현재 존재하는 데이터 없음");
        }
    }

    //모든 노드 출력
    public void printAll(){
        Node ptr = head.next;
        while (ptr != head){
            System.out.print(ptr.data+" ");
            ptr = ptr.next;
        }
        System.out.println();
    }
}
