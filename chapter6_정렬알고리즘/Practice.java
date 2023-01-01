package chapter6_정렬알고리즘;

import chpater4_스택과큐.Stack;

import java.util.Arrays;

public class Practice {

    public static void bubbleSort(int a[]){
        int n = a.length;
        for(int i=0;i<n-1;i++){
            for(int j=n-1;j>i;j--){
                if(a[j] < a[j-1]){
                    int temp = a[j-1];
                    a[j-1] = a[j];
                    a[j] = temp;
                }
            }
        }
        System.out.println(Arrays.toString(a));
    }

    //교환이 일어나지 않을 때를 판단하는 bubbleSort
    public static void bubbleSort2(int a[]){
        int n = a.length;
        for(int i=0;i<n-1;i++){
            boolean swap = false;
            for(int j=n-1;j>i;j--){
                if(a[j] < a[j-1]){
                    int temp = a[j-1];
                    a[j-1] = a[j];
                    a[j] = temp;
                    swap = true;
                }
            }
            if(swap == false){
                break;
            }
        }
        System.out.println(Arrays.toString(a));
    }

    //마지막 교환 시점을 저장하여 개선한 bubbleSort
    public static void bubbleSort3(int a[]){
        int n = a.length;
        int i = 0;
        while (i < n-1){
            int last = n-1;
            for(int j=n-1;j>i;j--){
                if(a[j] < a[j-1]){
                    int temp = a[j-1];
                    a[j-1] = a[j];
                    a[j] = temp;
                    last = j-1;
                }
            }
            i = last;
        }
        System.out.println(Arrays.toString(a));
    }

    //선택 정렬
    public static void selectionSort(int a[]){
        int n = a.length;
        for(int i=0;i<n-1;i++){
            int min = n-1;
            for(int j=n-2;j>=i;j--){
                if(a[min] > a[j]){
                    min = j;
                }
            }
            //min 과 i 를 교환
            int temp = a[min];
            a[min] = a[i];
            a[i] = temp;
        }
        System.out.println(Arrays.toString(a));
    }
    
    //삽입 정렬
    public static void insertionSort(int a[]){
        int n = a.length;
        //총 n-1 번의 패스가 일어남
        for(int i=0;i<n-1;i++){
            int j;
            int k = a[i+1];
            for(j=i;j>=0;j--){
                if(a[j] > k){
                    a[j+1] = a[j];
                }
                else
                    break;
            }
            a[j+1] = k;
        }
        System.out.println(Arrays.toString(a));
    }

    //쉘 정렬
    public static void shellSort(int a[]){
        int n = a.length;
        //h가 1이 될 때까지 반복
        for(int h=n/2;h>=1;h/=2){
            // i i-h i-2h .. 그룹 정렬,
            for(int i=h;i<n;i++){
               int k = a[i];
               int j;
               for(j=i-h;j>=0;j-=h){
                   if(k < a[j]){
                       a[j+h] = a[j];
                   }
                   else
                       break;
               }
               a[j+h] = k;
            }
        }
        System.out.println(Arrays.toString(a));
    }

    //쉘 정렬2
    public static void shellSort2(int a[]){
        int n = a.length;
        int h;
        //h 초기값 구하기

        for(h=1;h<n;h=3*h+1);
        //h가 1이 될 때까지 반복
        for(;h>=1;h/=3){
            // i i-h i-2h .. 그룹 정렬,
            for(int i=h;i<n;i++){
                int k = a[i];
                int j;
                for(j=i-h;j>=0;j-=h){
                    if(k < a[j]){
                        a[j+h] = a[j];
                    }
                    else
                        break;
                }
                a[j+h] = k;
            }
        }
        System.out.println(Arrays.toString(a));
    }

    //퀵정렬
    public static void quickSort(int a[],int left,int right){
        int pl = left;
        int pr = right;
        int pivot = a[(right+left)/2];
        //그룹 나누기
        //pl 과 pr이 교차할때까지 반복
        while (pl <= pr){
            //pivot 이랑같거나 큰 값 만나면 pl 움직이기 멈추기
            while (a[pl]<pivot){
                pl++;
            }
            //pivot 이랑같거나 작은 값 만나면 pr 움직이기 멈추기
            while (a[pr]>pivot){
                pr--;
            }
            //교환
            if(pl <= pr){
                int temp = a[pr];
                a[pr] = a[pl];
                a[pl] = temp;
                pl++;
                pr--;
            }
        }
        if(left < pr){
            quickSort(a,left,pr);
        }
        if(pl < right){
            quickSort(a,pl,right);
        }
    }

    //비재귀적인 퀵정렬
    public static void quickSort2(int a[],int left,int right){
        //stack 의 공간은 최대 log2(n) 까지 채워진다.
        int capacity = (int) Math.ceil(Math.log(a.length)/Math.log(2));
        Stack<Integer> lStack = new Stack<Integer>(capacity);
        Stack<Integer> rStack = new Stack<Integer>(capacity);
        lStack.push(left);
        rStack.push(right);
        //스택이 비어있을때까지 한다.
        while (lStack.isEmpty()==false){
            int pl = left = lStack.pop();
            int pr = right = rStack.pop();
            int pivot = a[(left+right)/2];
            //그룹 나누기
            //pl 과 pr이 교차할때까지 반복
            while (pl<=pr){
                //pivot 이랑같거나 큰 값 만나면 pl 움직이기 멈추기
                while(a[pl] < pivot){
                    pl++;
                }
                while(a[pr] > pivot){
                    pr--;
                }
                //교환
                if(pl<=pr){
                    int temp = a[pr];
                    a[pr] = a[pl];
                    a[pl] = temp;
                    pl++;
                    pr--;
                }
            }
            //요소가 큰 그룹을 우선 푸시한다. 그래야 stack 공간이 적어진다.
            //{left , pr} 그룹이 더 클 때
            if((pr - left) > (right - pl)){
                if(left < pr){
                    lStack.push(left);
                    rStack.push(pr);
                }
                if(pl < right){
                    lStack.push(pl);
                    rStack.push(right);
                }
            }
            //{pl, right} 그룹이 더 클 때
            else{
                if(pl < right){
                    lStack.push(pl);
                    rStack.push(right);
                }
                if(left < pr){
                    lStack.push(left);
                    rStack.push(pr);
                }
            }
        }
    }

    //pivot 을 가운데값으로 최대한 정하게 해주는 quickSort
    public static void quickSort3(int a[],int left,int right){
        int center = (left+right)/2;
        int pivot;
        // left right center 정렬
        int temp;
        if(a[center] < a[left]){
            temp = a[center];
            a[center] = a[left];
            a[left] = temp;
        }
        if(a[right] < a[center]){
            temp = a[right];
            a[right] = a[center];
            a[center] = temp;
        }
        if(a[center] < a[left]){
            temp = a[center];
            a[center] = a[left];
            a[left] = temp;
        }
        //pivot 을 center 로 설정
        pivot = a[center];
        //center 와 right-1 교환
        temp = a[center];
        a[center] = a[right-1];
        a[right-1] = temp;
        //pl pr 설정
        int pl = left+1;
        int pr = right-2;
        //패스 진행
        while (pl <= pr){
            //pl이 pivot 보다 작을때까지만 오른쪽으로 진행
            while (a[pl] < pivot){
                pl++;
            }
            //pr이 pivot 보다 클때까지만 왼쪽으로 진행
            while (a[pr] > pivot){
                pr--;
            }
            //교환
            if(pl <= pr){
                temp = a[pl];
                a[pl] = a[pr];
                a[pr] = temp;
                pl++;
                pr++;
            }
        }
        //패스 종료
        if(left < pr){
            quickSort3(a,left,pr);
        }
        if(pl < right){
            quickSort3(a,pl,right);
        }
    }


    public static int[] buf;

    //병합 정렬 , 분할 정복
    public static void mergeSort(int a[],int left , int right){
        //left < right 일때만 실행 , 이게 만족못하면 요소가 1이라는 것
        if(left < right){
            int lPointer = left;
            int center = (left+right)/2;
            int rPointer = center+1;
            int pointer = left;
            int buffPointer = 0;
            //왼쪽 리스트 정렬
            mergeSort(a,lPointer,center);
            //오른쪽 리스트 정렬
            mergeSort(a,rPointer,right);
            //buf 에 left ~ center 왼쪽 리스트 복사
            for(int i=left;i<=center;i++){
                buf[buffPointer++] = a[i];
            }
            buffPointer = 0;
            //비교 후 a 에 복사한다.
            while(lPointer <= center & rPointer <= right){
                if(buf[buffPointer] <= a[rPointer]){
                    a[pointer++] = buf[buffPointer++];
                    lPointer++;
                }
                else{
                    a[pointer++] = a[rPointer++];
                }
            }

            //buf 에 남은거 있으면 a 에 다넣는다.
            while (lPointer <= center){
                a[pointer++] = buf[buffPointer++];
                lPointer++;
            }
        }
    }

    //도수 정렬
    public static int[] countingSort(int a[],int min, int max){
        //정렬될 b를 생성
        int b[] = new int[a.length];
        //도수 분포표를 저장할 c 생성, min max 를 -> 0, max - min 으로 매핑
        int c[] = new int[max-min+1];
        //실제값 -> 실제값 - min 으로 매핑하면서 도수분포표 만들기
        for(int i=0;i<a.length;i++){
            c[a[i]-min]++;
        }
        //누적도수분포표 만들기
        for(int i=1;i<=max;i++){
            c[i] += c[i-1];
        }
        //정렬된 b 만들기
        for(int i=a.length-1;i>=0;i--){
            b[--c[a[i]-min]] = a[i];
        }
        a = null;
        return b;
    }

    public static void main(String[] args) {
        int a[] = {1,3,9,4,7,11,10,5,6,2,0,22,77,44};
        buf = new int[a.length];
        a = countingSort(a,0,77);
        System.out.println(Arrays.toString(a));
    }



}

