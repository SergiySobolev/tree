package com.sbk.service.priorityheap;

import com.sbk.model.Element;

public interface PriorityQueue<K extends Comparable<K>, V extends Comparable<V>> {
    Element<K,V> extractMax();
    void insert(Element<K,V> newElement);
}
