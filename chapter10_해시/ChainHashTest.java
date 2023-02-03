package chapter10_해시;

import chapter9_트리.BinaryTree;

import java.util.Scanner;

public class ChainHashTest {

    //편의상 키와 value 모두 Person 으로함.
    private static ChainHash<Person,Person> chainHash;
    private static Scanner scanner;

    public static void main(String[] args) {
        chainHash = new ChainHash<>(13);
        scanner = new Scanner(System.in);
        while (true){
            System.out.println("1: 검색\t2: 추가\t3: 삭제\t4: 모두 출력\texit : 나가기");
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
                default:
                    System.out.println("잘못 입력함, 다시 입력하세요");
            }
        }
    }

    private static void search(){
        System.out.println("신상 정보 입력");
        System.out.println("나이를 입력하세요");
        int age = Integer.parseInt(scanner.nextLine());
        System.out.println("이름을 입력하세요");
        String name = scanner.nextLine();
        Person person = chainHash.search(new Person(age,name));
        if(person == null){
            System.out.println("실패");
        }
        else{
            System.out.println("찾기 성공");
        }
    }

    private static void add(){
        System.out.println("추가할 키를 입력하세요");
        System.out.println("신상 정보 입력");
        System.out.println("나이를 입력하세요");
        int age = Integer.parseInt(scanner.nextLine());
        System.out.println("이름을 입력하세요");
        String name = scanner.nextLine();
        Person person = new Person(age,name);
        int i = chainHash.add(person,person);
        if(i == 0){
            System.out.println("성공");
        }
        else{
            System.out.println("이미 존재함");
        }
    }

    private static void remove(){
        System.out.println("삭제할 키를 입력하세요");
        System.out.println("신상 정보 입력");
        System.out.println("나이를 입력하세요");
        int age = Integer.parseInt(scanner.nextLine());
        System.out.println("이름을 입력하세요");
        String name = scanner.nextLine();
        int i =chainHash.remove(new Person(age,name));
        if(i == 0){
            System.out.println("성공");
        }
        else{
            System.out.println("실패");
        }
    }

    private static void printAll(){
        chainHash.dump();
    }


}
