package 힙;

import java.text.BreakIterator;
import java.util.Arrays;
import java.util.Scanner;

//힙정렬 구현
public class HeapSort {

    //힙정렬
    public static void sort(int a[]){
        int n = a.length;
        //크기가 1이하이면 정렬 할 필요가 없음
        if(a.length < 2){
            return;
        }
        //마지막 index 의 parent 서브트리부터 root 까지를 heap 으로 만든다.
        for(int i=(n-2)/2;i>=0;i--){
            downHeap(a,i,n-1);
        }
        //n-1 번 반복
        for(int i=n-1;i>=0;i--){
            //root 가 가장 큰 값이기 때문에 맨 뒤로 둔다.
            int temp = a[0];
            a[0] = a[i];
            a[i] = temp;
            //그리고 다시 0 - i-1 을 heap 상태로 만든다.
            downHeap(a,0,i-1);
        }

    }

    //서브 트리를 heap 으로 만든다.
    public static void downHeap(int a[],int parentIndex, int lastIndex){
        //부모의 왼쪽 자식 인덱스가 마지막 인덱스보다 작거나 같을때까지 반복한다.
        //최대 logN 만큼 비교
        while((parentIndex*2 +1)<=lastIndex){
            //우선 부모 인덱스를 가장 큰 인덱스로 둔다.
            int largestIndex = parentIndex;
            int leftChild = (parentIndex*2+1);
            int rightChild = (parentIndex*2+2);
            if(a[leftChild] > a[largestIndex]){
                largestIndex = leftChild;
            }
            if(rightChild <= lastIndex && a[rightChild] > a[largestIndex]){
                largestIndex = rightChild;
            }
            //heap 상태가 아님.
            if(parentIndex != largestIndex){
                //교환
                int temp = a[parentIndex];
                a[parentIndex] = a[largestIndex];
                a[largestIndex] = temp;
                //parentIndex 를 교환된 자식 index(largestIndex) 로 갱신
                parentIndex = largestIndex;
            }
            //heap 상태임
            else{
                break;
            }
        }
    }


    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("총 개수");
        int a[] = new int[Integer.parseInt(scan.nextLine())];
        for(int i=0;i<a.length;i++){
            System.out.println("입력하세요");
            a[i] = Integer.parseInt(scan.nextLine());
        }
        System.out.print("정렬 전 >> ");
        System.out.println(Arrays.toString(a));
        sort(a);
        System.out.print("정렬 후 >> ");
        System.out.println(Arrays.toString(a));
    }
}