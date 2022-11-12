package chapter2_기본자료구조;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Practice {

    public static Scanner scan = new Scanner(System.in);

    //난수를 사용하기
    public static void practice_1(){
        Random random = new Random();
        int num = random.nextInt(100)+1;
        int[] height = new int[num];
        System.out.println("키의 최대값을 구합니다.");
        System.out.println("키의 값은 아래와 같습니다.");
        for(int i=0;i<num;i++) {
            height[i] = 100 + random.nextInt(90);
            System.out.println("height["+i+"] : "+height[i]);
        }
        int max = height[0];
        for(int i=0;i<num;i++){
            if(max < height[i])
                max = height[i];
        }
        System.out.println("최댓값은 "+max+" 입니다.");
    }

    //배열의 요소들을 역순으로 정렬하기
    public static void practice_2(){
        System.out.print("요소의 개수를 입력하세요 : ");
        int array[] = new int[scan.nextInt()];
        for(int i=0;i< array.length;i++){
            System.out.print("x["+i+"] : ");
            array[i] = scan.nextInt();
        }
        for(int i =0;i< array.length/2;i++){
            System.out.println(Arrays.toString(array)+"\na["+i+"]과 a["+(array.length-1-i)+"]을 교환합니다.");
            int temp = array[i];
            array[i] = array[array.length-1-i];
            array[array.length-1-i] = temp;
        }
        System.out.println("역순 정렬을 마쳤습니다.");
    }

    //배열의 모든 요소 더하기
    public static void practice_3(int [] a){
        int sum = 0;
        for(int i :a){
            sum += i;
        }
        System.out.println(sum);
    }

    //배열 복사하기
    public static void practice_4(int[] a,int[] b){
        if(a.length == 1){
            b[0] = a[0];
        }
        for(int i=0;i<a.length/2;i++){
            b[i] = a[i];
            b[a.length-1-i] = a[a.length-1-i];
        }
        if(a.length %2 == 1){
            b[a.length/2] = b[a.length/2];
        }
        System.out.println(Arrays.toString(b));
    }

    //배열 역순으로 복사하기
    public static void practice_5(int[] a,int[] b){
        if(a.length == 1){
            b[0] = a[0];
        }
        for(int i=0;i<a.length/2;i++){
            b[i] = a[a.length-1-i];
            b[a.length-1-i] = a[i];
        }
        if(a.length %2 == 1){
            b[a.length/2] = a[a.length/2];
        }
        System.out.println(Arrays.toString(b));
    }

    //10진수 기수 변환하기
    public static void practice_6(){
        long number;
        int notation;
        int length = 0;
        String dchar = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        char[] digits = new char[19];
        System.out.println("10진수를 기수 변환합니다.");
        System.out.println("변환하는 음이 아닌 정수");
        number = scan.nextInt();
        System.out.println("어떤 진수로 변환할까요?(2~36)");
        notation = scan.nextInt();
        System.out.printf("%d | %10d\n",notation,number);
        System.out.println("  + ----------");
        do {
            long quotient = number/notation;
            int remainder = (int) (number%notation);
            digits[length++] = dchar.charAt(remainder);
            number = quotient;
            System.out.printf("%d | %10d ''' %d\n",notation,quotient,remainder);
            System.out.println("  + ----------");
        }while (number != 0);
        for(int i =0;i<length/2;i++){
            char temp = digits[i];
            digits[i] = digits[length-1-i];
            digits[length-1-i] = temp;
        }
        System.out.printf(notation+"진수로 ");
        for(int i=0;i<length;i++){
            System.out.print(digits[i]);
        }
    }

    //소수 구하기
    public static void practice_7(){
        int count = 0;
        int ptr = 0;
        int primeNumber[] = new int[500];
        primeNumber[ptr++] = 2;
        for(int i=3;i<1000;i+=2){
            int n =(int) Math.sqrt(i);
            count++;
            int j;
            boolean flag = true;
            for(j=0;primeNumber[j]<=n;j++){
                count++;
                if(i % primeNumber[j] == 0){
                    flag = false;
                    break;
                }
            }
            if(flag == true){
                primeNumber[ptr++] = i;
            }
        }
        System.out.println("총 나눈 횟수 "+count);
    }

    public static void main(String[] args) {
        YMD ymd = new YMD(2022,5,3);
        ymd.before(100);
        System.out.println("년 : "+ymd.year+" 월 : "+ymd.month+" 일 : "+ymd.day);

    }
}
