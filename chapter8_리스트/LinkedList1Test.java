package chapter8_리스트;

import java.util.LinkedList;
import java.util.Scanner;

public class LinkedList1Test {

    private static LinkedList1<Integer> linkedList1;
    private static Scanner scanner;

    public static void main(String[] args) {
        linkedList1 = new LinkedList1<>();
        scanner = new Scanner(System.in);
        while (true){
            System.out.println("1 : 첫 번째 노드 추가 2 : 마지막 노드 추가 3: 첫 번째 노드 삭제 4 : 마지막 노드 삭제 5 : 선택 노드 삭제 6 : 선택 노드 다음으로 옮기기" +
                    " 7 : 모든 노드 삭제 8: 선택 노드 출력 9: 모든 노드 출력 10 : 노드 검색");
            System.out.print("입력 >>> ");
            String select = scanner.nextLine();
            switch (select){
                case "1":
                    addFirst();
                    break;
                case "2":
                    addLast();
                    break;
                case "3":
                    removeFirst();
                    break;
                case "4":
                    removeLast();
                    break;
                case "5":
                    removeCurrentNode();
                    break;
                case "6":
                    next();
                    break;
                case "7":
                    removeAll();
                    break;
                case "8":
                    printCurrentNode();
                    break;
                case "9":
                    printAll();
                    break;
                case "10":
                    search();
                    break;
                default:
                    System.out.println("잘못 입력함, 다시 입력하세요");
            }
        }
    }

    private static void addFirst() {
        System.out.println("입력할 값을 입력해주세요");
        System.out.print("입력 >>> ");
        int value = Integer.parseInt(scanner.nextLine());
        linkedList1.addFirst(value);
    }

    private static void addLast() {
        System.out.println("입력할 값을 입력해주세요");
        System.out.print("입력 >>> ");
        int value = Integer.parseInt(scanner.nextLine());
        linkedList1.addLast(value);
    }

    private static void removeFirst() {
        System.out.println("삭제함");
        linkedList1.removeFirst();
    }

    private static void removeLast() {
        System.out.println("삭제함");
        linkedList1.removeLast();
    }

    private static void removeCurrentNode() {
        System.out.println("현재 노드 삭제함");
        linkedList1.removeCurrentNode();
    }

    private static void next() {
        System.out.println("선택 노드 다음으로");
        boolean i = linkedList1.next();
        if(!i)
            System.out.println("다음 노드 존재하지 않음");

    }

    private static void removeAll() {
        System.out.println("모두 제거함");
        linkedList1.clear();
    }

    private static void printCurrentNode() {
        linkedList1.printCurrentNode();
    }

    private static void printAll() {
        linkedList1.printAll();
    }

    private static void search() {
        System.out.println("값을 입력해주세요");
        System.out.print("입력 >>> ");
        int value = Integer.parseInt(scanner.nextLine());
        boolean i = linkedList1.search(value);
        if(i)
            System.out.println("존재합니다.");
        else
            System.out.println("존재하지 않습니다.");
    }
}
