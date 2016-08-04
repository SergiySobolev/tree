package com.sbk.service.binarymaxtree.complete;

import com.sbk.service.binarymaxtree.BinaryMaxTree;

import java.util.List;

public interface BinaryMaxCompleteTree<K extends Comparable<K>, V extends Comparable<V>>
        extends BinaryMaxTree<K, V> {
    void siftUp(int key);
    void siftDown(int key);
    void print();
    List<K> getKeys();
}
