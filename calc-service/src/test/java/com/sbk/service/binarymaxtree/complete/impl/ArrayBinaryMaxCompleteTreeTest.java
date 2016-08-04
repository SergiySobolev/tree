package com.sbk.service.binarymaxtree.complete.impl;

import com.sbk.model.Element;
import com.sbk.service.binarymaxtree.complete.BinaryMaxCompleteTree;
import org.assertj.core.util.Lists;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
public class ArrayBinaryMaxCompleteTreeTest {

    @Autowired
    private BinaryMaxCompleteTree<Integer, Integer> tree;


    @Test
    public void insert_1() throws Exception {
        tree.insert(1, 1);
        tree.insert(2, 2);
        tree.insert(3, 3);
        assertThat(tree.getKeys(), equalTo(Lists.newArrayList(3,1,2)));
    }

    @Test
    public void insert_2() throws Exception {
        tree.insert(1, 1);
        tree.insert(2, 2);
        tree.insert(3, 3);
        tree.insert(4, 4);
        tree.insert(5, 5);
        assertThat(tree.getKeys(), equalTo(Lists.newArrayList(5, 4, 2, 1, 3)));
    }

    @Test
    public void insert_3() throws Exception {
        tree.insert(1, 1);
        tree.insert(2, 2);
        tree.insert(3, 3);
        tree.insert(4, 4);
        tree.insert(5, 5);
        tree.insert(6, 6);
        assertThat(tree.getKeys(), equalTo(Lists.newArrayList(6, 4, 5, 1, 3, 2)));
    }

    @Test
    public void insert_4() throws Exception {
        tree.insert(1, 1);
        tree.insert(2, 2);
        tree.insert(3, 3);
        tree.insert(4, 4);
        tree.insert(5, 5);
        tree.insert(6, 6);
        tree.insert(6, 6);
        assertThat(tree.getKeys(), equalTo(Lists.newArrayList(6, 4, 6, 1, 3, 2, 5)));
    }

    @Test
    public void extract_1() throws Exception {
        tree.insert(1, 1);
        tree.insert(2, 2);
        tree.insert(3, 3);
        assertThat(tree.getKeys(), equalTo(Lists.newArrayList(3,1,2)));
        Element<Integer, Integer> max = tree.extractMax();
        assertThat(max.getKey(), equalTo(3));
        assertThat(tree.getKeys(), equalTo(Lists.newArrayList(2,1)));
    }

    @Test
    public void extract_2() throws Exception {
        tree.insert(1, 1);
        tree.insert(2, 2);
        tree.insert(3, 3);
        tree.insert(4, 4);
        tree.insert(5, 5);
        tree.insert(6, 6);
        assertThat(tree.getKeys(), equalTo(Lists.newArrayList(6, 4, 5, 1, 3, 2)));
        Element<Integer, Integer> max = tree.extractMax();
        assertThat(max.getKey(), equalTo(6));
        assertThat(tree.getKeys(), equalTo(Lists.newArrayList(5, 4, 2, 1, 3)));
    }

    @Test
    public void sort() throws Exception {
        tree.insert(1, 1);
        tree.insert(2, 2);
        tree.insert(3, 3);
        tree.insert(4, 4);
        tree.insert(5, 5);
        tree.insert(6, 6);
        assertThat(tree.getKeys(), equalTo(Lists.newArrayList(6, 4, 5, 1, 3, 2)));
        List<Element<Integer, Integer>> sorted = new ArrayList<>();
        sorted.add(sorted.size(), tree.extractMax());
        sorted.add(sorted.size(), tree.extractMax());
        sorted.add(sorted.size(), tree.extractMax());
        sorted.add(sorted.size(), tree.extractMax());
        sorted.add(sorted.size(), tree.extractMax());
        sorted.add(sorted.size(), tree.extractMax());

        assertThat(sorted.stream().map(Element::getKey).collect(Collectors.toList()),
                equalTo(Lists.newArrayList(6,5,4,3,2,1)));
    }


    @Test
    public void siftUp() throws Exception {

    }

    @Test
    public void siftDown() throws Exception {

    }

    @Test
    public void extractMax() throws Exception {

    }


}