package com.example.demo.test;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TestLifeCycle {

//    @BeforeEach
//    public void getBeforeEach(){
//        System.out.println("getBeforeEach 호출");
//    }
//
//    @Test
//    public void getHello(){
//        System.out.println("getHello 호출");
//    }
//
//    @Test
//    public void getBye(){
//        System.out.println("getBye 호출");
//    }
//
//    @AfterEach
//    public void getAfterEach(){
//        System.out.println("getAfterEach 호출");
//    }


    // 수제비 모의고사 12회
   /*public static int calc(int arr[]){
       System.out.println("calc 호출");
       int sum=1;
       for (int num : arr) {
           System.out.println("sum += num 진입=" + num);
           sum += num;    // sum = sum + num
           System.out.println("sum += num 누적=" + sum);  // 61
       }
       for (int num : arr){
           if(num%2==0) {
               System.out.println("num%2==0 진입=" + num);
               sum -= num;  // sum = sum - num
               System.out.println("sum 누적" + sum);           }
       }
       return sum;
   }

    @Test
    public void main(){
        int [] arr = new int[5];
        for (int i=0; i<arr.length; i++) {
            arr[i] =i+10;
        }
        System.out.print("calc(arr)= "+ calc(arr));
    }*/


    // 모의고사 13회
    /*@Test
    public void main(){
        int[] arr = {3, 5, 4, 2, 1};
        int i = 0;
        int temp = 0;

        do {
            int j = i;
            System.out.println("j <- i :" + j);

            do {
                // 내림차순
                if(arr[i] > arr[j]){

                    System.out.println("arr[i] > arr[j]");
                    System.out.println("진입 전: temp="+ temp + " arr[i]="+arr[i] +" arr[j]="+arr[j]);

                    temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;

                    System.out.println("진입 후: temp="+ temp + " arr[i]="+arr[i] +" arr[j]="+arr[j]);

                }

                j++;  // j 증가
                System.out.println("j 증가 = "+ j);

            } while (j<5);

            i++; // i 증가
            System.out.println("i 증가 = "+ i);

        } while (i<4);


        for (int j = 0; j < 5; j++) {
            System.out.print(arr[j] + " ");
        }

    }*/


    // 모의고사 13
//    @Test
//    public void ex_20(){
//
//
//        int arr [][] = new int[3][4];
//
//        for (int i = 0; i < 3; i++) {
//            for (int j = 0; j < 4; j++) {
//
//                arr[i][j] = i + j;
//                //System.out.printf("%d\n", arr[i][j]);
//                if(j % 3 == 0){
//                    System.out.println("i ="+ i +", j =" + j +", arr[i][j]=" + arr[i][j]);
//                }
//
//            }
//        }
//    }



}
