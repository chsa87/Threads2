package ru.threads;


public class Store {   // Store store = new Store();

   private int product;

    public synchronized Product get() {
        while (product < 1) {
            try {
                System.out.println("Покупатель ожидает пополнение склада");
                wait();
            } catch (InterruptedException e) {
            }
        }
        product--;
        System.out.println("Покупатель купил 1 товар");
        System.out.println("Товаров на складе: " + product);
        notifyAll();
        return new Product("Kefir");
    }


    public synchronized void put() {  //t1
        while (product >= 3) {
            try {
                System.out.println("Производитель ожидает освобождение магазина");
                wait();  // t2
            } catch (InterruptedException e) {
            }
        }
        product++;
        System.out.println("Производитель добавил 1 товар");
        System.out.println("Товаров на складе: " + product);
        notifyAll();
    }

    public synchronized void putButch(int products) {  //t1
        while (product >= 3) {
            try {
                System.out.println("Производитель ожидает освобождение магазина");
                wait();  // t2
            } catch (InterruptedException e) {
            }
        }
        product = product + products;
        System.out.println("Производитель добавил 1 товар");
        System.out.println("Товаров на складе: " + product);
        notifyAll();
    }
}


