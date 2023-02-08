package 힙;

import chapter10_해시.ChainHash;
import chapter10_해시.Person;

import java.util.Scanner;

public class PriorityQueueTest {

    //편의상 정수로 우선순위 비교
    private static PriorityQueue<Integer> priorityQueue;
    private static Scanner scanner;

    public static void main(String[] args) {
        priorityQueue = new PriorityQueue<>(30);
        scanner = new Scanner(System.in);
        while (true){
            System.out.println("1: 검색\t2: 추가\t3: 삭제\t4: 모두 출력\t5 : peek\t6 : 크기\t7 : 모두 삭제\texit : 나가기");
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
                    peek();
                    break;
                case "6":
                    size();
                    break;
                case "7":
                    clear();
                    break;
                default:
                    System.out.println("잘못 입력함, 다시 입력하세요");
            }
        }
    }

    private static void search(){
        System.out.println("숫자를 입력하세요");
        boolean i = priorityQueue.contains(Integer.valueOf(scanner.nextLine()));
        if(i){
            System.out.println("존재합니다.");
        }
        else{
            System.out.println("존재하지 않습니다.");
        }
    }

    private static void add(){
        System.out.println("숫자를 입력하세요");
        priorityQueue.offer(Integer.valueOf(scanner.nextLine()));
    }

    private static void remove(){;
        int i = priorityQueue.poll();
        System.out.println(i+" 빠져나옴");
    }

    private static void printAll(){
        priorityQueue.printAll();
    }

    private static void peek(){
        try {
            int i = priorityQueue.peek();
            System.out.println("현재 우선순위가 가장 높은 요소 : "+i);
        } catch (NoSuchFieldException e) {
            throw new RuntimeException(e);
        }
    }

    private static void size(){
        System.out.println("현재 크기 : "+priorityQueue.size());
    }

    private static void clear(){
        System.out.println("모두 삭제");
        priorityQueue.clear();
    }
}
