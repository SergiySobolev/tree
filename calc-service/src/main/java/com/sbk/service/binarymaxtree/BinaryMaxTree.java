package com.sbk.service.binarymaxtree;

import com.sbk.model.Element;

public interface BinaryMaxTree<K extends Comparable<K>, V extends Comparable<V>> {
    Element<K,V> extractMax();
    void insert(K k, V v);
}
