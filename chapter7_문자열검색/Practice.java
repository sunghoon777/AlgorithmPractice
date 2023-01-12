package chapter7_문자열검색;

import java.io.UnsupportedEncodingException;
import java.util.Arrays;

public class Practice {

    //브루트-포스법
    public static int BF(String text, String pattern){
        int patternLength = pattern.length();
        int index = 0;
        int end = text.length()-pattern.length();
        while (index<=end){
            boolean equalFlag = true;
            for(int i=0;i<patternLength;i++){
                if(text.charAt(i+index) != pattern.charAt(i)){
                    equalFlag = false;
                    break;
                }
            }
            if(equalFlag){
                break;
            }
            index++;
        }
        return (index<=end)?index:-1;
    }

    //패턴의 실페 최대 경계길이 배열 만들기
    public static int[] makePatternFailureArray(String pattern){
        int n = pattern.length();
        int[] failureArray = new int[n];
        failureArray [0] = 0;
        int i=1; // 접미사 맨끝 포인터
        int j=0; // 접두사 맨끝 포인터
        //i 가 pattern 끝까지 도달할 때까지 반복
        while (i<n){
            //글자가 같으면 접두사 접미사 같다는 뜻
            if(pattern.charAt(i) == pattern.charAt(j)){
                failureArray[i++] = ++j;
            }
            else if(j == 0){
                failureArray[i++] = 0;
            }
            else{
                j = failureArray[j-1];
            }
        }
        return failureArray;
    }

    //KMP
    public static int KMP(String text, String pattern){
        int [] failureArray = makePatternFailureArray(pattern);
        int index = 0;
        int patternLength = pattern.length();
        int end = text.length() - patternLength;
        while (index <= end){
            int i;
            boolean equalFlag = true;
            for(i=0;i<patternLength;i++){
                if(pattern.charAt(i) != text.charAt(index+i)){
                    equalFlag = false;
                    break;
                }
            }
            if(equalFlag == true){
                break;
            }
            //움직일 거리 = 일치 길이 - 경계값
            //하나도 일치하지 않으면 그냥 index 1 증가
            if(i == 0){
                index++;
            }
            //아니면 일치길이-경계값 만큼 움직인다.
            else{
                int move = i - failureArray[i-1];
                index += move;
            }
        }
        return (index<=end)?index:-1;
    }

    //보이어 무어, text 와 pattern 이 아스키 코드안에 있는 문자로만 구성되야 알고리즘이 적용됨
    public static int BM(String text, String pattern){
        int patternLength = pattern.length();
        int textLength = text.length();
        int patternPointer = patternLength - 1;
        int textPointer = patternLength - 1;
        //건너뛰기 표 만들기 , 0 - 127 까지 값을 담아야하므로 128크기여야함
        int [] skip = new int[Character.MAX_VALUE+1]; 
        //처음에는 모두 patternLength 으로 초기화
        for(int i=0;i<skip.length;i++){
            skip[i] = patternLength;
        }
        // 0 ~ patternLength -2 인덱스에 해당되는 패턴 문자만 갱신해주면됨 , 패턴의 마지막 문자는 어차피 n임
        for(int i=0;i<patternLength-1;i++){
            skip[pattern.charAt(i)] = patternLength-i-1;
        }
        //검색
        while (textPointer < textLength){
            while (true){
                System.out.printf("textPointer : %d , patterPointer : %d\t",textPointer,patternPointer);
                if(pattern.charAt(patternPointer) != text.charAt(textPointer)){
                    break;
                }
                else if(patternPointer == 0){
                    //찾기 성공
                    return textPointer;
                }
                textPointer--;
                patternPointer--;
            }
            System.out.println("\n"+text.charAt(textPointer));
            textPointer += skip[text.charAt(textPointer)];
            patternPointer = patternLength-1;
            System.out.println("textPointer : "+textPointer);
        }
        //찾기 실패
        return -1;
    }


    public static void main(String[] args) {
        String text = "ABCXDEZCABACABAC";
        String pattern = "ABAC";
        System.out.println("\n"+BM(text,pattern));
    }
}
