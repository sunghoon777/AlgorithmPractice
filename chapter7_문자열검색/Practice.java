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

    //보이어 무어
    public static int BM(String text, String pattern){
        //0 ~ max 까지 이므로 max+1 개 배열 하지만 한글은 저장 못한다...
        int[] skip = new int[Character.MAX_VALUE+1];
        int patternLength = pattern.length();
        int textLength = text.length();
        int patternPointer = patternLength-1;
        int textPointer = patternLength-1;
        //skip table 만들기
        for(int i=0;i<=Character.MAX_VALUE;i++){
            skip[i] = patternLength;
        }
        //마지막 문자는 할필요 없음 어차피 patternLength 넣어야함.
        for(int i=0;i<patternLength-1;i++){
            skip[pattern.charAt(i)] = patternLength-i-1;
        }
        //검색
        while (textPointer < textLength){
            boolean equalFlag = true;
            int i = textPointer;
            int j = patternPointer;
            //같은지 비교

        }
        return 0;
    }


    public static void main(String[] args) {
        String pattern = "엄준식엄";
        String text = "꼴랑이임엄죽식엄준식엄";
        int a = '가';
        //1114112
        System.out.printf("%d",a);
    }
}
