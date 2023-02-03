package chapter10_해시;

//해쉬 테이블 구현 , 해쉬값이 같은 데이터는 서로 링크드리스트로 연결되어 있음.
public class ChainHash<K,V>{
    
    //노드 클래스
    private class Node<K,V>{
        
        private K key;
        private V value;
        private Node next;

        public Node(K key, V value, Node next) {
            this.key = key;
            this.value = value;
            this.next = next;
        }
        
    }


    private int size; // 사이즈
    private Node<K,V>[] table; // 해시 테이블

    public ChainHash(int capacity) {
        this.size = capacity;
        table = new Node[capacity];
    }

    //해시 함수 , 해시 함수는 key 의 해쉬코드값을 구하여 현재 맵의 size 로 나눈 나머지를 해시 값으로 한다.
    private int getHash(K key){
        return key.hashCode() % size;
    }

    //검색, 성공 값반환 실패 null 반환
    public V search(K key){
        Node<K,V> p = table[getHash(key)];
        while (p != null){
            //key 를 비교함
            if(p.key.equals(key)){
                System.out.println(getHash(key)+" 에서 찾음");
                return p.value;
            }
            //실패시 다음으로
            p = p.next;
        }
        //찾기 실패
        return null;
    }

    //추가, 해당 해시의 링크드리스트의 맨앞에 삽입, 성공 0 실패 -1 리턴
    public int add(K key, V value){
        int hash = getHash(key);
        Node<K,V> p = table[hash];
        while (p != null){
            //이미 존재하면 -1 리턴
            if(p.key.equals(key)){
                return -1;
            }
            p = p.next;
        }
        Node<K,V> newNode = new Node<>(key,value,table[hash]);
        table[hash] = newNode;
        System.out.println(hash+" 에 추가함");
        return 0;
    }

    //삭제, 성공 0 실패 -1  리턴
    public int remove(K key){
        int hash = getHash(key);
        //현재 노드
        Node<K,V> p = table[hash];
        //전 노드
        Node<K,V> pp= null;
        while (p != null){
            //성공
            if(p.key.equals(key)){
                //해당 해시에 노드가 하나만 있을 때
                if(pp == null){
                    table[hash] = p.next;
                }
                else{
                    pp.next = p.next;
                }
                System.out.println(hash+" 에서 삭제함");
                return 0;
            }
            pp = p;
            p = p.next;
        }
        //못찾음 , 삭제 실패
        return -1;
    }

    //모두 출력
    public void dump(){
        for (int i=0;i<size;i++){
            Node<K,V> p = table[i];
            while (p != null){
                System.out.printf("key : %s value : %s\t",p.key,p.value);
                p = p.next;
            }
            System.out.println();
        }
    }

}
