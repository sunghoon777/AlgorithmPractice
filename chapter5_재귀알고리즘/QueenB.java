package chapter5_재귀알고리즘;

public class QueenB {

    static int[] pos = new int[8];
    static boolean[] flag_a = new boolean[8];
    static boolean[] flag_b = new boolean[15];
    static boolean[] flag_c = new boolean[15];

    static void print(){
        for(int i=0;i<8;i++){
            System.out.printf("%2d",pos[i]);
        }
        System.out.println();
    }

    //재귀
    static void set(int i){
        for(int j=0;j<8;j++){
            if(flag_a[j] == false && flag_b[i+j] == false && flag_c[i-j+7] == false){
                pos[i] = j;
                if(i == 7)
                    print();
                else{
                    flag_b[j] = flag_a[i+j] = flag_c[i-j+7] = true;
                    set(i+1);
                    flag_b[j] = flag_a[i+j] = flag_c[i-j+7] = false;
                }
            }
        }
    }

    //비재귀
    static void set2(){
        for(int a=0;a<8;a++){
            pos[a] = -1;
        }
        int i = 0;
        while (true){
            int j=0;

        }
    }

}
