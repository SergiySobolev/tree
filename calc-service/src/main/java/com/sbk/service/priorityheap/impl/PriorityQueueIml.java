package com.sbk.service.priorityheap.impl;

import com.sbk.model.Element;
import com.sbk.service.binarymaxtree.complete.BinaryMaxCompleteTree;
import com.sbk.service.priorityheap.PriorityQueue;
import org.springframework.stereotype.Service;

@Service
public class PriorityQueueIml<K extends Comparable<K>, V extends Comparable<V>>
        implements PriorityQueue<K, V> {

    private final BinaryMaxCompleteTree<K, V> service;

    public PriorityQueueIml(BinaryMaxCompleteTree service) {
        this.service = service;
    }

    @Override
    public Element<K, V> extractMax() {
        return null;
    }

    @Override
    public void insert(Element<K, V> newElement) {

    }
}
