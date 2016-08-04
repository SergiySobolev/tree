package com.sbk.service.util;

import org.junit.Test;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.*;

public class HeapUtilTest {
    @Test
    public void siftDown() throws Exception {
        int[] a = new int[] {2,5,4,3,1};
        HeapUtil.siftDown(a, 0, a.length);
        assertThat(a, equalTo(new int[] {5,3,4,2,1}));
    }
    @Test
    public void buildHeap() throws Exception {
        int[] a = new int[] {2,5,4,3,1};
        HeapUtil.buildHeap(a);
        assertThat(a, equalTo(new int[] {5,3,4,2,1}));
    }
    @Test
    public void buildHeap_2() throws Exception {
        int[] a = new int[] {2,5,4,3,1,7,9,11,12,9,0};
        HeapUtil.buildHeap(a);
        assertThat(a, equalTo(new int[] {12,11,9,5,9,7,4,2,3,1,0}));
    }
    @Test
    public void heapSort() throws Exception {
        int[] a = new int[] {2,5,4,3,1,7,9,11,2,9,0};
        HeapUtil.heapSort(a);
        assertThat(a, equalTo(new int[] {0,1,2,2,3,4,5,7,9,9,11}));
    }
    @Test
    public void heapSort_1() throws Exception {
        int[] a = new int[] {2,5,4,3,1};
        HeapUtil.heapSort(a);
        assertThat(a, equalTo(new int[] {1,2,3,4,5}));
    }

}