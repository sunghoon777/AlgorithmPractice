package chapter9_트리;

import chapter8_리스트.ArrayList;
import chapter8_리스트.List;
import java.util.Scanner;

public class BinaryTreeTest {

    //편의를 위해 그냥 key value 모두 정수로 함.
    private static BinaryTree<Integer,Integer> binaryTree;
    private static Scanner scanner;

    public static void main(String[] args) {
        binaryTree = new BinaryTree<>();
        scanner = new Scanner(System.in);
        while (true){
            System.out.println("1: 검색\t2: 추가\t3: 삭제\t4: 모두 출력\t5: 역순으로 모두 출력\t6: max 키 얻기\t7: min 키 얻기\texit : 나가기");
            System.out.print("입력 >>> ");
            String select = scanner.nextLine();
            if(select.startsWith("exit")){
                break;
            }
            switch (select){
                case "1":
                    search();
                    break;
                case "2":
                    add();
                    break;
                case "3":
                    remove();
                    break;
                case "4":
                    printAll();
                    break;
                case "5":
                    printReverseAll();
                    break;
                case "6":
                    getMaxKey();
                    break;
                case "7":
                    getMinKey();
                    break;
                default:
                    System.out.println("잘못 입력함, 다시 입력하세요");
            }
        }
    }

    private static void search(){
        System.out.println("검색할 키를 입력하세요");
        int key = Integer.parseInt(scanner.nextLine());
        System.out.println(binaryTree.search(key));
    }

    private static void add(){
        System.out.println("추가할 키를 입력하세요");
        int key = Integer.parseInt(scanner.nextLine());
        int value = key;
        binaryTree.add(key,value);
    }

    private static void remove(){
        System.out.println("삭제할 키를 입력하세요");
        int key = Integer.parseInt(scanner.nextLine());
        boolean isRemove = binaryTree.remove(key);
        if(isRemove){
            System.out.println("삭제됨");
        }
        else{
            System.out.println("해당 키 존재 안함");
        }
    }

    private static void printAll(){
        binaryTree.print();
    }

    private static void printReverseAll(){
        binaryTree.printReverse();
    }

    private static void getMaxKey(){
        System.out.println(binaryTree.getMaxKey()+" 입니다.");
    }

    private static void getMinKey(){
        System.out.println(binaryTree.getMinKey()+" 입니다.");
    }
}
