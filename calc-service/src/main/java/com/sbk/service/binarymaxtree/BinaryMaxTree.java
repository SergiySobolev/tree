package com.sbk.service.binarymaxtree;

import com.sbk.model.Element;

public interface BinaryMaxTree<K, V> {
    Element<K,V> extractMax();
    void insert(Element<K,V> newElement);
}
