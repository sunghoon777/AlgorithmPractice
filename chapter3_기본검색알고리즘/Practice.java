package chapter3_기본검색알고리즘;

import java.util.*;

public class Practice {

    //선형 검색 인자(배열, 요소수, 찾으려는 값)
    static int sequentialSearch(int[] array,int length, int value){
        for(int i=0;i<length;i++){
            if(value == array[i])
                return i;
        }
        return -1;
    }
    //보초법을 사용한 선형 검색, 보초법으로 인해 한번 주기마다 검사가 2번에서 1번으로 줄었음.
    static int sequentialSearch2(int[] array,int length, int value){
        array[length] = value;
        int index = 0;
        while (true){
            System.out.println();
            if(value == array[index])
                break;
            index++;
        }
        return index==length?-1:index;
    }
    //스캐닝 과정을 자세히 출력하는 선형검색
    static int sequentialSearch3(int[] array,int length, int value){
        System.out.printf("  |");
        String arrayToString = "";
        for(int i=0;i<length;i++){
            arrayToString += String.format("%3d",i);
        }
        for(int i=0;i<length;i++){
            System.out.printf("%3d",i);
        }
        System.out.println("\n--+----------------------");
        array[length] = value;
        int index = 0;
        while (true){
            System.out.printf("  |");
            for(int i=0;i<length;i++){
                if(index == i)
                    System.out.printf("%3c",'*');
                else
                    System.out.printf("   ");
            }
            System.out.printf("\n%2d|%s\n",index,arrayToString);
            System.out.println("  |");
            if(value == array[index])
                break;
            index++;
        }
        return index==length?-1:index;
    }
    
    //순차 탐색을 통해 배열 안에 있는 모든 요소를 검색하여 찾으려는 값의 index들을 배열에 저장
    static int sequentialSearch4(int[] array,int length, int value,int [] indexArray){
        array[length] = value;
        int index = 0;
        boolean flag = false;
        for(int i =0;i<length;i++){
            if(array[i] == value){
                indexArray[index++] = i;
                flag = true;
            }
        }
        return flag==false?-1:indexArray[0];
    }


    //이진 탐색 인자(배열, 요소수, 찾으려는 값)
    static int binarySearch(int[] array, int length, int value){
        int first = 0;
        int last = length-1;
        while (true){
            int center = (first+last)/2;
            //찾으려는 값이 현재 center값 보다 작을 때
            System.out.println("first : "+first+" last : "+last+" center : "+center);
            if(value < array[center]){
                last = center -1;
            }
            //찾으려는 값이 현재 center값 보다 클 때
            else if(value > array[center]){
                first = center + 1;
            }
            //찾으려는 값이 현재 center값과 같을 때
            else{
                return center;
            }
            if(first > last)
                return -1;
        }
    }

    //스캐닝 과정을 자세히 출력하는 이진탐색
    static int binarySearch2(int[] array, int length, int value){
        System.out.printf("  |");
        String arrayToString = "";
        for(int i=0;i<length;i++){
            arrayToString += String.format("%3d",array[i]);
        }
        for(int i=0;i<length;i++){
            System.out.printf("%3d",i);
        }
        System.out.println("\n--+----------------------");
        int first = 0;
        int last = length-1;
        while (true){
            int center = (first+last)/2;
            //찾으려는 값이 현재 center값 보다 작을 때
            System.out.printf("  |");
            for(int i=0;i<length;i++){
                if(i == first){
                    System.out.printf("%3s","<-");
                }
                else if(i == center){
                    System.out.printf("%3s","+");
                }
                else if(i == last){
                    System.out.printf("%3s","->");
                }
                else{
                    System.out.printf("   ");
                }
            }
            System.out.printf("\n%2d|%s\n",center,arrayToString);
            if(value < array[center]){
                last = center -1;
            }
            //찾으려는 값이 현재 center값 보다 클 때
            else if(value > array[center]){
                first = center + 1;
            }
            //찾으려는 값이 현재 center값과 같을 때
            else{
                return center;
            }
            if(first > last)
                return -1;
        }
    }

    //이진 탐색 but 찾으려는 값이 여러개 존재하면 가장 처음 값의 index 반환함.
    static int binarySearch3(int[] array, int length, int value){
        int first = 0;
        int last = length-1;
        int valueFirstIndex = -1;
        while (true){
            int center = (first+last)/2;
            //찾으려는 값이 현재 center값 보다 작을 때
            System.out.println("first : "+first+" last : "+last+" center : "+center);
            if(value < array[center]){
                last = center -1;
            }
            //찾으려는 값이 현재 center값 보다 클 때
            else if(value > array[center]){
                first = center + 1;
            }
            //찾으려는 값이 현재 center값과 같을 때
            else{
                valueFirstIndex = center;
                last = center -1;
            }
            if(first > last)
                return  valueFirstIndex;
        }
    }

    //comparator 익명 객체 생성 , 기본 PhysicalExamination은 comparable 을 통해 오름차순으로 정렬했지만 이건 내림차순
    public static final Comparator<PhysicalExamination> PHYSICAL_EXAMINATION_COMPARATOR_HEIGHT_ORDER = new Comparator<PhysicalExamination>() {
        @Override
        public int compare(PhysicalExamination o1, PhysicalExamination o2) {
            return o1.getHeight()-o2.getHeight()>0?-1:(o1.getHeight()-o2.getHeight()<0?1:0);
        }
    };

    public static void main(String[] args) {
        ArrayList<PhysicalExamination> list = new ArrayList<>();
        list.add(new PhysicalExamination("a", 162, 0.3));
        list.add(new PhysicalExamination("b", 178, 0.3));
        list.add(new PhysicalExamination("c", 192, 0.3));
        list.add(new PhysicalExamination("d", 157, 0.3));
        list.add(new PhysicalExamination("e", 174, 0.3));
        for(PhysicalExamination physicalExamination : list){
            System.out.println(physicalExamination);
        }
        System.out.println();
        Collections.sort(list,PHYSICAL_EXAMINATION_COMPARATOR_HEIGHT_ORDER);
        for(PhysicalExamination physicalExamination : list){
            System.out.println(physicalExamination);
        }

    }
}
