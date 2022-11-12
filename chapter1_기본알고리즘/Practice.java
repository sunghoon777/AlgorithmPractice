package chapter1_기본알고리즘;

import java.util.Scanner;

public class Practice {

    public static Scanner scan = new Scanner(System.in);
    
    //4개 중 최댓값 구하기
    public static int practice_1(int a, int b, int c, int d){
        int max = a;
        if(max < b)
            max = b;
        if(max < c)
            max = c;
        if(max < d)
            max = d;
        return max;
    }
    
    //3개 중 최솟값 구하기
    public static int practice_2(int a, int b, int c){
        int min = a;
        if(min > b)
            min = b;
        if(min > c)
            min = c;
        return min;
    }
    
    //4개 중 최솟값 구하기
    public static int practice_3(int a, int b, int c,int d){
        int min = a;
        if(min > b)
            min = b;
        if(min > c)
            min = c;
        if(min > d)
            min = d;
        return min;
    }
    
    //3개 중 중위값 구하기
    public static int practice_4(int a,int b,int c){
        if(a >= b){
            if(b>=c){
                return b;
            }
            else if(a>=c){
                return c;
            }
            else{
                return a;
            }
        }
        else if(a >= c){
            return a;
        }
        else if(b >=c){
            return c;
        }
        else {
            return b;
        }
    }

    //1~10 의 합을 가우스 덧셈 방식으로 구하기
    public static void practice_5(int n){
        int sum = 0;
        sum = (n+1)*(n/2) + (n%2 == 1 ? n/2 + 1 : 0);
        System.out.println(sum);
    }

    //a,b를 포함한 a와 b 사이의 모든 정수의 합 구하기, 가우스 덧셈 방식으로
    public static void practice_6(int a, int b){
        int sum =0;
        if(a>b){
            sum = ((a-b+1) / 2) * (a+b)+ ((a-b+1)%2 == 1?(a+b)/2:0);
        }
        else if(a<b){
            sum = ((b-a+1) / 2) * (a+b)+ ((b-a+1)%2 == 1?(a+b)/2:0);
        }
        //a와 b가 같으니 합은 a가 됨
        else{
            sum = a;
        }
        System.out.println(sum);
    }

    //b-a 출력하기 b가 a보다 작으면 다시 입력받는다
    public static void practice_7(){
        while (true) {
            System.out.print("a값 : ");
            int a = scan.nextInt();
            System.out.print("b값 : ");
            int b = scan.nextInt();
            if (b > a) {
                System.out.println("b-a는 " + (b - a) + " 입니다.");
                break;
            } else {
                System.out.println("b가 a보다 커야합니다.");
            }
        }
    }

    //양의 정수 자리수 출력하기 ex) 123 -> 3자리 1234 -> 4자리
    public static void practice_8(){
        int number = 0;
        do{
            System.out.println("양의 정수를 입력하세요");
            number = scan.nextInt();
        }while (number > 0);
        int digit = 1;
        int n = 10;
        while(true){
            if(number < n) {
                System.out.println(digit + " 자리입니다.");
                break;
            }
            digit++;
            n = n*10;
        }
    }

    //구구단
    public static void practice_9(){
        System.out.print("  |");
        for(int i =1;i<10;i++){
            System.out.printf(" %3d",i);
        }
        System.out.println("\n---+------------------------------------");
        for(int i=1;i<10;i++){
            System.out.print(i+" |");
            for(int j=1;j<10;j++){
                System.out.printf(" %3d",i*j);
            }
            System.out.println();
        }
    }
    
    //구구단 덧셈
    public static void practice_10(){
        System.out.print("  |");
        for(int i =1;i<10;i++){
            System.out.printf(" %3d",i);
        }
        System.out.println("\n---+------------------------------------");
        for(int i=1;i<10;i++){
            System.out.print(i+" |");
            for(int j=1;j<10;j++){
                System.out.printf(" %3d",i+j);
            }
            System.out.println();
        }
    }

    //* 로 정사각형 출력
    public static void practice_11(){
        System.out.print("정사각형을 출력합니다.\n변의 길이 : ");
        int length = scan.nextInt();
        for(int i =0;i<length;i++){
            for(int j =0;j<length;j++){
                System.out.print("*");
            }
            System.out.println();
        }
    }

    //왼쪽 아래가 직각인 직각삼각형 * 로 출력
    public static void practice_12(){
        System.out.print("왼쪽 아래가 직각인 직각삼각형을 출력합니다.\n몇 단 삼각형입니까? : ");
        int n = scan.nextInt();
        for(int i =0;i<n;i++){
            for(int j=0;j<i+1;j++){
                System.out.print("*");
            }
            System.out.println();
        }
    }

    //왼쪽 위가 직각인 직각삼각형 *로 출력
    public static void practice_13(){
        System.out.print("왼쪽 위가 직각인 직각삼각형을 출력합니다.\n몇 단 삼각형입니까? : ");
        int n = scan.nextInt();
        for(int i =0;i<n;i++){
            for(int j=0;j<n-i;j++){
                System.out.print("*");
            }
            System.out.println();
        }
    }

    //오른쪽 아래가 직각인 직각삼각형 * 로 출력
    public static void practice_14(){
        System.out.print("오른쪽 아래가 직각인 직각삼각형을 출력합니다.\n몇 단 삼각형입니까? : ");
        int n = scan.nextInt();
        for(int i =1;i<n+1;i++){
            for(int j=0;j<n-i;j++){
                System.out.print(" ");
            }
            for(int j=n-i;j<n;j++){
                System.out.print("*");
            }
            System.out.println();
        }
    }

    //오른쪽 위가 직각인 직각삼각형 * 로 출력
    public static void practice_15(){
        System.out.print("오른쪽 위가 직각인 직각삼각형을 출력합니다.\n몇 단 삼각형입니까? : ");
        int n = scan.nextInt();
        for(int i =0;i<n;i++){
            for(int j=n;j>n-i;j--){
                System.out.print(" ");
            }
            for(int j=0;j<n-i;j++){
                System.out.print("*");
            }
            System.out.println();
        }
    }

    //n단의 * 피라미드 출력
    public static void practice_16(){
        System.out.print("n단의 * 피라미드를 출력합니다.\n몇 단 피라미드입니까? : ");
        int n = scan.nextInt();
        for(int i=1;i<=n;i++){
            for(int j=1;j<=n-i;j++){
                System.out.print(" ");
            }
            for(int j=1;j<=2*i-1;j++){
                System.out.print("*");
            }
            System.out.println("");
        }
    }
    
    //n단의 숫자 피라미드 출력
    public static void practice_17(){
        System.out.print("n단의 숫자 피라미드를 출력합니다.\n몇 단 피라미드입니까? : ");
        int n = scan.nextInt();
        for(int i=1;i<=n;i++){
            for(int j=1;j<=n-i;j++){
                System.out.print(" ");
            }
            for(int j=1;j<=2*i-1;j++){
                System.out.printf("%d",i);
            }
            System.out.println("");
        }
    }


    public static void main(String[] args) {


    }
}
