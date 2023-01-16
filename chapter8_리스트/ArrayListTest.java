package chapter8_리스트;

import java.util.Scanner;

public class ArrayListTest {

    private static List<Integer> arrayList;
    private static Scanner scanner;

    public static void main(String[] args) {
        arrayList = new ArrayList<>();
        scanner = new Scanner(System.in);
        while (true){
            System.out.println("1 : 크기  2 : 빈리스트?   3 : 요소 존재 확인    4 : 요소 추가   5 : 특정 요소 제거    6 : 모두 제거\n" +
                    "7 : index에 요소 추가   8 : 맨뒤요소 제거     9 : index 요소 제거     10 : index 요소 얻기    11 : index 출력   12 : 모두 출력");
            System.out.print("입력 >>> ");
            String select = scanner.nextLine();
            switch (select){
                case "1":
                    size();
                    break;
                case "2":
                    isEmpty();
                    break;
                case "3":
                    contains();
                    break;
                case "4":
                    add();
                    break;
                case "5":
                    removeByObject();
                    break;
                case "6":
                    clear();
                    break;
                case "7":
                    addByIndex();
                    break;
                case "8":
                    removeLastIndex();
                    break;
                case "9":
                    removeByIndex();
                    break;
                case "10":
                    indexOf();
                    break;
                case "11":
                    print();
                    break;
                case "12":
                    printAll();
                    break;
                default:
                    System.out.println("잘못 입력함, 다시 입력하세요");
            }
        }
    }

    public static void  size(){
        System.out.println("현재 크기는 "+arrayList.size());
    }

    public static void  isEmpty(){
        if(arrayList.isEmpty()){
            System.out.println("비어있음");
        }
        else{
            System.out.println("비어있지않음");
        }
    }

    public static void contains(){
        System.out.println("숫자를 입력하세요");
        Integer element = Integer.valueOf(scanner.nextLine());
        if(arrayList.contains(element)){
            System.out.println("존재함");
        }
        else{
            System.out.println("존재하지않음");
        }
    }

    public static void add(){
        System.out.println("숫자를 입력하세요");
        Integer element = Integer.valueOf(scanner.nextLine());
        arrayList.add(element);
    }

    public static void removeByObject(){
        System.out.println("제거할 숫자를 입력하세요");
        Integer element = Integer.valueOf(scanner.nextLine());
        if(arrayList.remove(element)){
            System.out.println("제거함");
        }
        else{
            System.out.println("해당 숫자 존재하지 않음");
        }
    }

    public static void clear(){
        arrayList.clear();
        System.out.println("모두 제거함");
    }

    public static void addByIndex(){
        System.out.println("추가할 숫자를 입력하세요");
        Integer element = Integer.valueOf(scanner.nextLine());
        System.out.println("추가할 index 위치를 입력하세요");
        int index =  Integer.valueOf(scanner.nextLine());
        arrayList.add(index,element);
    }

    public static void removeLastIndex(){
        System.out.println("마지막 숫자 제거");
        arrayList.remove();
    }

    public static void removeByIndex(){
        System.out.println("삭제할 index 위치를 입력하세요");
        int index =  Integer.valueOf(scanner.nextLine());
        arrayList.remove(index);
    }

    public static void indexOf(){
        System.out.println("숫자를 입력하세요");
        Integer element =  Integer.valueOf(scanner.nextLine());
        System.out.println(arrayList.indexOf(element)+" 에 있음");
    }

    public static void print(){
        System.out.println("출력할 index 입력");
        int index =  Integer.valueOf(scanner.nextLine());
        arrayList.print(index);
    }

    public static void printAll(){
        arrayList.printAll();
    }
}
