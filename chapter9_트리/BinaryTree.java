package chapter9_트리;

import java.util.Comparator;

public class BinaryTree<K,V>{

    private class Node<K,V>{
        private K key;
        private V value;
        private Node<K,V> left;
        private Node<K,V> right;
        private static int a = 10;

        Node(K key, V value, Node<K, V> left, Node<K, V> right) {
            this.key = key;
            this.value = value;
            this.left = left;
            this.right = right;
        }

    }

    private Node<K,V> root; // 루트 노드
    private Comparator<? super K> comparator = null; // key 가 구현한 comparable 을 통해 비교를 하기 싫다면 comparator 를 따로 설정하여 비교 가능

    //root 를 null 로 초기화
    public BinaryTree() {
        root = null;
    }

    //root 를 null 로 초기화 후 comparator 설정
    public BinaryTree(Comparator<? super K> comparator){
        this();
        this.comparator = comparator;
    }

    //비교
    private int compare(K key1, K key2){
        return comparator==null?((Comparable<K>)key1).compareTo(key2):comparator.compare(key1,key2);
    }

    //키 찾기
    public V search(K key){
        //루트부터 노드 검색 시작
        Node<K,V> p = root;
        while (true){
            //현재 노드 null 이면 null 리턴
            if(p == null){
                return null;
            }
            int i = compare(key,p.key);
            //key 가 현재 노드 보다 작음
            if(i < 0){
                p = p.left;
            }
            //key 가 현재 노드 보다 크다.
            else if(i > 0){
                p = p.right;
            }
            //같다.
            else if(i == 0){
                return p.value;
            }
        }
    }

    //노드 추가
    public void add(K key, V value){
        //트리에 아무것도 없으면 root 노드 생성해줌
        if(root == null){
            root = new Node<K,V>(key,value,null,null);
            return;
        }
        Node<K,V> p = root;
        while (true){
            int i = compare(key,p.key);
            if(i < 0){
                if(p.left == null){
                    System.out.println(p.key+" 왼쪽에 노드 추가하였음");
                    p.left = new Node<K,V>(key,value,null,null);
                    break;
                }
                p = p.left;
            }
            else if(i > 0){
                if(p.right == null){
                    System.out.println(p.key+" 오른쪽에 노드 추가하였음");
                    p.right = new Node<K,V>(key,value,null,null);
                    break;
                }
                p = p.right;
            }
            else if(i == 0){
                break;
            }
        }
    }

    //제거
    public boolean remove(K key){
        //현재 노드
        Node<K,V> p = root;
        //현재 노드의 부모 노드
        Node<K,V> parentNode = root;
        //현재 노드가 부모의 왼쪽인지 아닌지 구분하는 것.
        boolean isLeftChild = true;

        //key 찾기
        while (true){
            //key 가 없으면 null 리턴
            if(p == null){
                return false;
            }
            int i = compare(key,p.key);
            if(i < 0){
                parentNode = p;
                p = p.left;
                isLeftChild = true;
            }
            else if(i > 0){
                parentNode = p;
                p = p.right;
                isLeftChild = false;
            }
            //찾기 완료
            else if(i == 0){
                break;
            }
        }
        //현재 노드의 자식이 없을 때
        if(p.left == null && p.right == null){
            if(p == root){
                root = null;
            }
            //현재 노드가 부모의 왼쪽 자식
            else if(isLeftChild){
                parentNode.left = null;
            }
            //현재 노드가 부모의 오른쪽 자식
            else{
                parentNode.right = null;
            }
        }
        //자식이 2개 일 때(이 경우에는 왼쪽 서브 트리의 가장 오른쪽 노드가 현재 노드 값을 대체한다, 가장 오른쪽 노드가 순서상으로 현재 노드 바로 전 노드이므로)
        else if(p.left != null && p.right != null){
            Node<K,V> replaceNode = p.left;
            Node<K,V> replaceParentNode = p;
            //현재 노드의 왼쪽 자식이 가장 오른쪽 노드일 때
            if(replaceNode.right == null){
                p.key = replaceNode.key;
                p.value = replaceNode.value;
                p.left = replaceNode.left;
            }
            //그 외
            else{
                //왼쪽 서브 트리의 가장 오른쪽 노드로 이동
                while (replaceNode.right != null){
                    replaceParentNode = replaceNode;
                    replaceNode = replaceParentNode.right;
                }
                p.key = replaceNode.key;
                p.value = replaceNode.value;
                replaceParentNode.right = replaceNode.left;
            }
        }
        //자식이 1개 일 때
        else{
            if(p == root){
                if(p.left != null){
                    root = p.left;
                }
                else{
                    root = p.right;
                }
            }
            //현재 노드가 부모의 왼쪽 자식
            else if(isLeftChild){
                if(p.left != null){
                    parentNode.left = p.left;
                }
                else{
                    parentNode.left = p.right;
                }
            }
            //현재 노드가 부모의 오른쪽 자식
            else{
                if(p.left != null){
                    parentNode.right = p.left;
                }
                else{
                    parentNode.right = p.right;
                }
            }

        }
        return true;
    }

    private void printTree(Node<K,V> p){
        if(p != null){
            printTree(p.left);
            System.out.println("key : "+p.key+"  value : "+p.value);
            printTree(p.right);
        }
    }

    //모두 출력
    public void print(){
        printTree(root);
    }

    private void printReverseTree(Node<K,V> p){
        if(p != null){
            printReverseTree(p.right);
            System.out.println("key : "+p.key+"  value : "+p.value);
            printReverseTree(p.left);
        }
    }

    //역순으로 모두 출력
    public void printReverse(){
        printReverseTree(root);
    }

    //max 노드 얻기
    private Node<K,V> getMaxNode(){
        Node<K,V> p = root;
        while (p.right != null){
            p = p.right;
        }
        return p;
    }

    public K getMaxKey(){
        if(root == null){
            return null;
        }
        return getMaxNode().key;
    }

    public V getValueWithMaxKey(){
        if(root == null){
            return null;
        }
        return getMaxNode().value;
    }

    //min 노드 얻기
    private Node<K,V> getMinNode(){
        Node<K,V> p = root;
        while (p.left != null){
            p = p.left;
        }
        return p;
    }

    public K getMinKey(){
        if(root == null){
            return null;
        }
        return getMinNode().key;
    }

    public V getValueMinKey(){
        if(root == null){
            return null;
        }
        return getMinNode().value;
    }
    
}
