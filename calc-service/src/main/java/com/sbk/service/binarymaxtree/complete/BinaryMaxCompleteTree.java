package com.sbk.service.binarymaxtree.complete;

import com.sbk.service.binarymaxtree.BinaryMaxTree;

public interface BinaryMaxCompleteTree<K, V> extends BinaryMaxTree<K, V> {
    void siftUp(K key);
    void siftDown(K key);
}
