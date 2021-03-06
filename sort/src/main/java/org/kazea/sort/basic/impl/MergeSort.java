package org.kazea.sort.basic.impl;

import org.kazea.sort.basic.Sort;

/**
 * 归并排序
 */
public class MergeSort<T extends Comparable> implements Sort<T> {
    @Override
    public void sort(T[] array) {
        System.out.println("use MergeSort");
        sort(array, 0, array.length-1);
    }

    private void sort(T[] array, int start, int end){

        if(start >= end) return;

        int middle = (start + end)/2;

        sort(array, start, middle);
        sort(array, middle + 1, end);
        merge(array, start, middle, end);

    }

    private void merge(T[] array, int start, int middle, int end){

        Object[] tempArray = new Object[end-start+1];
        int index = 0;

        int left = start;
        int right = middle+1;

        while(left <= middle && right <= end){
            if(array[left].compareTo(array[right]) < 0) {
                tempArray[index++] = array[left++];
            } else {
                tempArray[index++] = array[right++];
            }
        }

        while(left <= middle) tempArray[index++] = array[left++];

        while(right <= end)   tempArray[index++] = array[right++];

        for(int temp=0; temp <= (end-start); temp++){
            array[start + temp] = (T)tempArray[temp];
        }

    }

}
