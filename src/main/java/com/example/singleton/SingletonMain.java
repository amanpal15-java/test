package com.example.singleton;

public class SingletonMain {

    public static void main(String args[]){
//        Singleton singleton = Singleton.getInstance();
//        singleton.showMessage();

        Runnable task = () -> {
            MySingleton singleton = MySingleton.INSTANCE;
            System.out.println("Instance hash " + singleton.hashCode());
        };

        Thread thread1 = new Thread(task);
        Thread thread2 = new Thread(task);
        Thread thread3 = new Thread(task);

        thread1.start();
        thread2.start();
        thread3.start();

    }
}
