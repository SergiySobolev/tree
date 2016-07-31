package com.sbk.model;

import lombok.Data;

@Data
public class Element<K, V> {
    K key;
    V value;
}
