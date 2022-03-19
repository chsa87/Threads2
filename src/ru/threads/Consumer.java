package ru.threads;

public class Consumer implements Runnable {

    private Store store;

    public Consumer(Store store) {
        this.store = store;
    }

    public void run() {
        store.get();
    }

}
