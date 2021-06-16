package com.hjp.javaSource.JUC;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;

public class CallableTest {

    public static void main(String[] args) {
        List<Future<List<String>>> tasks = new ArrayList<>();
        for (int i=0; i<5; i++){
            String param = String.valueOf(i);
            DemoCallable<String, List<String>> callable = new DemoCallable<String, List<String>>(param) {
                @Override
                protected List<String> execute(String param) {
                    return Collections.singletonList(param);
                }
            };
            FutureTask<List<String>> task = new FutureTask<>(callable);
            // 为了保证顺序
            tasks.add(i, task);
            new Thread(task).start();
        }

        // 统一处理结果
        List<String> result = new ArrayList<>();
        tasks.forEach(each -> {
            try {
                result.addAll(each.get());
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
        });

        System.out.println(result);
    }
}
