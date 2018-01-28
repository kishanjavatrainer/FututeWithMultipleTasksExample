package com.infotech.client;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class InvokeAnyTaskTest {

	public static void main(String[] args) {

		ExecutorService executorService = null;
		try {
			executorService = Executors.newFixedThreadPool(3);
			Callable<String> task1 = new Callable<String>() {
				public String call() throws Exception {
					Thread.sleep(1000);
					return "Result of Task1";
				}
			};

			Callable<String> task2 = new Callable<String>() {
				public String call() throws Exception {
					Thread.sleep(1000);
					return "Result of Task2";
				}
			};

			Callable<String> task3 = new Callable<String>() {
				public String call() throws Exception {
					Thread.sleep(1500);
					return "Result of Task3";
				}
			};

			List<Callable<String>> taskList = new ArrayList<>();
			taskList.add(task1);
			taskList.add(task2);
			taskList.add(task3);

			String result = executorService.invokeAny(taskList);
			System.out.println(result);
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			if(executorService != null)
			executorService.shutdown();
		}
	
	}
}
