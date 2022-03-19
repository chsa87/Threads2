package ru.threads;

import java.util.List;
import java.util.concurrent.Callable;

public class ConsumerWithResult implements Callable<List<Product>> {

    private Store store;


    public ConsumerWithResult(Store store) {
        this.store = store;
    }

    public List<Product> call() throws Exception {
       return List.of(store.get());
    }
}
