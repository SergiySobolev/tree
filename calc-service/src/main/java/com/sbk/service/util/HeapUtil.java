package com.sbk.service.util;

import org.springframework.util.Assert;

public class HeapUtil {
    public static void heapSort(int[] a) {
        buildHeap(a);
        for(int i=0;i<a.length;i++){
            swap(a, 0, a.length-1-i);
            siftDown(a,0, a.length-1-i);
        }
    }
    public static void buildHeap(int[] a) {
        for(int i = a.length/2; i>=0; i--) {
            siftDown(a,i, a.length);
        }
    }

    public static void siftDown(int[] a, int key, int size) {
        int leftChildKey = leftChild(key);
        int rightChildKey = rightChild(key);
        if(leftChildKey >= size) {
            return;
        }
        int keyToSwap = (a[leftChildKey] > a[rightChildKey]) || rightChildKey == size
                        ? leftChildKey
                        : rightChildKey;
        if(a[keyToSwap] > a[key]){
            swap(a, keyToSwap, key);
            siftDown(a, keyToSwap, size);
        }

    }
    public static void swap(int[] a, int i, int j){
        Assert.isTrue(i<a.length && j<a.length);
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
    public static  int parent(int key){
        Assert.isTrue(key != 0);
        return (key+1)/2-1;
    }
    public static int leftChild(int key){
        return 2*key + 1;
    }
    public static int rightChild(int key) {
        return 2*key + 2;
    }
}
