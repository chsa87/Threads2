package ru.threads;

import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;

public class Program {

    public static void main(String[] args) throws ExecutionException, InterruptedException {

        ExecutorService executor = Executors.newFixedThreadPool(3);

        Store store = new Store();

        Producer producer = new Producer(store);
        Consumer consumer = new Consumer(store);
        ConsumerWithResult consumer2 = new ConsumerWithResult(store);
        FutureTask<List<Product>> ft = new FutureTask(consumer2);

        executor.execute(ft);
        executor.execute(producer);
        executor.execute(consumer);

        while (!ft.isDone()) {
            Thread.sleep(1000);
        }

        delivery(ft.get());

        executor.shutdown();

    }

    private static void delivery(List<Product> products) {

        for (Product p : products) {
            System.out.println("Товар отправлен в доствку: " + p.toString());
        }

    }

}
