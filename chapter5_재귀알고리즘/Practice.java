package chapter5_재귀알고리즘;

public class Practice {

    //팩토리얼 구하기, 재귀
    public static int factorial(int n){
        if(n <= 1)
            return 1;
        return n*factorial(n-1);
    }
    
    //유클리드 호재법, 최대공약수 알고리즘, 재귀
    public static int gcd(int x,int y){
        System.out.println("call : "+x+" "+y);
        int remainder = x%y;
        if(remainder == 0){
            return y;
        }
        return gcd(y,remainder);
    }

    //팩토리얼 구하기
    public static int factorial2(int n){
        int result = 1;
        for(int i=2;i<=n;i++){
            result *= i;
        }
        return result;
    }

    //유클리드 호재법, 최대공약수 알고리즘
    public static int gcd2(int x, int y){
        while (x%y != 0){
            int temp = y;
            y = x%y;
            x = temp;
        }
        return y;
    }

    //배열의 모든 요소의 최대공약수 구하기 재귀 사용
    static int gcdArray(int a[], int start, int no) {
        if (no == 1)
            return a[start];
        else if (no == 2)
            return gcd(a[start], a[start + 1]);
        else
            return gcd(a[start], gcdArray(a, start + 1, no - 1));
    }


    //배열의 모든 요소의 최대공약수 구하기 재귀 미사용
    public static int gcdArray(int[] a){
        int gcd = a[0]; // x
        int element; // y
        //최대공약수 구하기
        for(int i=1;i<a.length;i++){
            element = a[i];
            while (gcd%element != 0){
                int temp = element;
                element = gcd%element;
                gcd = temp;
            }
            gcd = element;
            System.out.println("최대 공약수 : "+gcd);
        }
        return gcd;
    }

    //하노이탑 f(n) = 2f(n-1) +2 C B A 순으로 쌓여있다.
    public static void honoi(int number,int x,int y){
        if(number > 1){
            honoi(number-1,x,6-x-y);
        }
        String a = "";
        switch (number){
            case 1 :
                a = "A기둥";
                break;
            case 2 :
                a = "B기둥";
                break;
            case 3 :
                a = "C기둥";
                break;
        }
        System.out.printf("[%s]기둥을 %d에서 %d로 옮겨줍니다.\n",a,x,y);
        if(number > 1){
            honoi(number-1,6-x-y,y);
        }
    }

    public static void main(String[] args) {
        QueenB.set(0);
    }


}
