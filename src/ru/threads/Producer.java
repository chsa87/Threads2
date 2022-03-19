package ru.threads;

public class Producer implements Runnable {

    private Store store;

    public Producer(Store store) {
        this.store = store;
    }

    public void run() {

        for (int i = 0; i < 2; i++)
            store.put();

    }
}
