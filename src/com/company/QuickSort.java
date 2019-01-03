package com.company;

import java.util.Random;

public class QuickSort {

    private static int[] arr;
    private static int arrSize;

    public QuickSort(int size){
        arrSize = size;
        arr = new int[arrSize];
        generateRandom();
    }

    private void generateRandom(){
        Random rand = new Random();
        for (int i=0; i< arrSize; i++){
            arr[i] = rand.nextInt();
        }
    }

    private void print(){
        for (int i=0; i< arrSize; i++){
            System.out.print(" "+arr[i]);
        }
        System.out.println();
    }


    public void sort(int start, int end){
        if(start>=end){
            return;
        }

        int i = start;
        int j = end;
        int cur = i - (i-j)/2;

        while (i < j){
            while ( (i < cur) && (arr[i]<= arr[cur])){
                i++;
            }
            while ( (j > cur) && (arr[cur]<= arr[j])){
                j--;
            }

            if (i<j){
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
                if(i == cur){
                    cur = j;
                 } else {
                    if (j==cur){
                        cur = i;
                    }
                }
            }
        }
        sort(start,cur);
        sort(cur+1, end);
    }

    public static void main(String[] args) {
	    QuickSort list = new QuickSort(10);
	    list.print();
	    list.sort(0,arrSize-1);
        list.print();
    }
}
