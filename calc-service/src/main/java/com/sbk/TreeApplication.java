package com.sbk;

import com.sbk.service.priorityheap.PriorityQueue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TreeApplication {
	@Autowired
	private PriorityQueue<Integer, Integer> priorityQueue;

	public static void main(String[] args) {
		SpringApplication.run(TreeApplication.class, args);
	}
}
