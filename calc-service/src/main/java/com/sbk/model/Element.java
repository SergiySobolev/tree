package com.sbk.model;

public class Element<K extends Comparable<K>, V extends Comparable<V>>
        implements Comparable<Element<K, V>> {
    private K key;
    private V value;
    public Element(K key, V value){
        this.key = key;
        this.value = value;
    }
    public String toString() {
        return "[key:" + key + ", value:"+ value+ "]";
    }

    @Override
    public int compareTo(Element<K, V>  element) {
        V value = element.getValue();
        return this.value.compareTo(value);
    }

    public K getKey() {
        return key;
    }

    public V getValue() {
        return value;
    }
}
