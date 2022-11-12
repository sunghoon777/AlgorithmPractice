package chapter2_기본자료구조;

import java.util.Arrays;

public class PhysicalExamination {


    static final int VMAX = 21; //최고 시력은 2.1 최하는 당연히 0.0
    static class PhyscData{
        String name;
        int height;
        double vision;

        public PhyscData(String name, int height, double vision) {
            this.name = name;
            this.height = height;
            this.vision = vision;
        }
    }

    //평균 키 구하기
    static double averageHeight(PhyscData[] dataList){
        int sum = 0;
        for(PhyscData physcData : dataList){
            sum += physcData.height;
        }
        return (double)sum/dataList.length;
    }

    //시력 분포 구하기, distribution에 저장해준다.
    static void distributionVision(PhyscData[] dataList, int[] distribution){
        for(int i = 0;i< dataList.length;i++){
            distribution[(int)(dataList[i].vision*10)]++;
        }
    }

    //신체 데이터 입력받고 시력 분포 출력하기
    public static void main(String[] args) {
        PhyscData[] dataList = {
                new PhyscData("강민하", 162, 0.3),
                new PhyscData("김찬우", 173, 0.7),
                new PhyscData("박준서", 175, 2.0),
                new PhyscData("유서범", 171, 1.5),
                new PhyscData("이수연", 168, 0.4),
                new PhyscData("장경오", 174, 1.2),
                new PhyscData("황지안", 169, 0.8),
        };

        int[] distribution = new int[VMAX];
        System.out.println(Arrays.toString(distribution));
        System.out.println("■ 신체검사 리스트 ■");
        System.out.println(" 이름       키  시력 ");
        System.out.println("--------------------");
        for (int i = 0; i < dataList.length; i++)
            System.out.printf("%-8s%3d%5.1f\n", dataList[i].name, dataList[i].height, dataList[i].vision);

        System.out.printf("\n평균키 : %5.1fcm\n", averageHeight(dataList));
        distributionVision(dataList,distribution);
        System.out.println("\n시력의 분포");
        for (int i = 0; i < VMAX; i++) {
            System.out.printf("%-3.1f ~: ",i/10.0);
            for(int j=0;j<distribution[i];j++){
                System.out.print("*");
            }
            System.out.println();
        }

    }

}
