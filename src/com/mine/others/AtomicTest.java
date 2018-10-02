package com.mine.others;

import java.util.concurrent.atomic.AtomicInteger;

public class AtomicTest {
	
	public static void main(String ... args){
        Printer print = new Printer(false);
        Thread t1 = new Thread(new TaskEvenOdd(print, "Thread1", new AtomicInteger(1)));
        Thread t2 = new Thread(new TaskEvenOdd(print,"Thread2" , new AtomicInteger(2)));
        t1.start();
        t2.start();
    }
}

class TaskEvenOdd implements Runnable {
    Printer print;
    String name;
    AtomicInteger number;
    TaskEvenOdd(Printer print, String name, AtomicInteger number){
        this.print = print;
        this.name = name;
        this.number = number;
    }

    @Override
    public void run() {

        System.out.println("Run method");
        
        while(number.get()<20){

            if(number.get()%2 == 0){
                print.printEven(number.get(),name);
            }
            else {
                print.printOdd(number.get(),name);
            }
            number.addAndGet(2);
        }

      }

    }



class Printer {
    boolean isEven;

    public Printer() {  }

    public Printer(boolean isEven) {
        this.isEven = isEven;
    }

    synchronized void printEven(int number, String name) {

        while (!isEven) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println(name+": Even:" + number);
        isEven = false;
        notifyAll();
    }

    synchronized void printOdd(int number, String name) {
        while (isEven) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println(name+": Odd:" + number);
        isEven = true;
        notifyAll();
    }
}
