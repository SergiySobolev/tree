package com.sbk.service.binarymaxtree.complete.impl;

import com.sbk.model.Element;
import com.sbk.service.binarymaxtree.complete.BinaryMaxCompleteTree;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Component
@Slf4j
public class ArrayBinaryMaxCompleteTree<K extends Comparable<K>, V extends Comparable<V>> implements BinaryMaxCompleteTree<K, V> {

    private List<Element<K,V>> elements = new ArrayList<>();
    private int size = 0;

    @Override
    public void siftUp(int key) {
        if(key == 0) return;
        int parent = parent(key);
        Element<K,V> keyElement = elements.get(key);
        Element<K,V> parentElement = elements.get(parent);
        if(keyElement.compareTo(parentElement) > 0) {
            swap(key, parent);
            siftUp(parent);
        }
    }

    @Override
    public void siftDown(int key) {
        int leftKey = leftChild(key);
        int rightKey = rightChild(key);
        boolean hasLeft = leftKey < size;
        boolean hasRight = rightKey < size;
        boolean noChildren = !hasLeft && !hasRight;
        if(noChildren) return;
        int keyToSwap = hasRight
                  ?  compareKeys(leftKey, rightKey) > 0 ? leftKey : rightKey
                  :  leftKey;
        if(compareKeys(keyToSwap, key) > 0) {
            swap(keyToSwap, key);
            siftDown(keyToSwap);
        }
    }

    @Override
    public void print() {
        elements.forEach(System.out::println);
    }

    @Override
    public List<K> getKeys() {
        return elements.stream()
                .map(Element::getKey).collect(Collectors.toList());
    }

    @Override
    public Element<K, V> extractMax() {
        if(size == 0) {
            return null;
        }
        if(size == 1) {
            size--;
            return elements.remove(0);
        }
        swap(0, size-1);
        Element<K, V> elementToReturn = elements.remove(size-1);
        size--;
        siftDown(0);
        return elementToReturn;
    }

    @Override
    public void insert(K k, V v) {
        Element<K, V> e = new Element<>(k, v);
        elements.add(e);
        siftUp(size);
        size++;
    }

    private void swap(int i, int j) {
        Assert.isTrue(i<=size && j<=size, "I or J must be less than size:["+i+", "+j+"]");
        Element<K, V> temp = elements.get(i);
        elements.set(i, elements.get(j));
        elements.set(j, temp);
    }

    private int parent(int i) {
        Assert.isTrue(i>0, "Can't be negative");
        Assert.isTrue(i!=0, "Root haven't parents");
        return (i+1)/2-1;
    }

    private int leftChild(int i) {
        Assert.isTrue(i>=0, "Can't be negative");
        return i*2+1;
    }

    private int rightChild(int i) {
        Assert.isTrue(i>=0, "Can't be negative");
        return i*2+2;
    }

    private int compareKeys(int i, int j) {
        Element<K, V> iElement = elements.get(i);
        Element<K, V> jElement = elements.get(j);
        return iElement.compareTo(jElement);
    }
}
