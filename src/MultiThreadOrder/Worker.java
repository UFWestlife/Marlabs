package MultiThreadOrder;

import java.lang.reflect.Array;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

import MultiThreadOrder.Order.State;

public class Worker {
    Deque<Order> queue;
    List<Order> list;


    public Worker() {
        this.queue = new ArrayDeque<>(5);
        this.list = new ArrayList<>();
    }


    public class create implements Runnable {
        private ReadWriteLock readWriteLock =  new ReentrantReadWriteLock();
        Deque<Order> queue;
        List<Order> list;
        int orderID;

        public create(int id, Deque<Order> queue, List<Order> list){
            this.queue = queue;
            this.list = list;
            this.orderID = id;
        }

        @Override
        public void run() {
            String threadName = Thread.currentThread().getName();
            try {
                readWriteLock.readLock().lock();
                Order order = new Order(orderID);
                list.add(order);
                System.out.println("Thread Name: " + threadName + " is creating Order " +
                        "with ID = " + orderID + ", State = " + order.state.getState() + ".");
                Thread.sleep(200);
            } catch (InterruptedException | NullPointerException e) {
                e.printStackTrace();
            }finally {
                readWriteLock.readLock().unlock();
            }
        }
    }


    public class fulFill implements Runnable {
        private ReadWriteLock readWriteLock =  new ReentrantReadWriteLock();
        Deque<Order> queue;
        List<Order> list;
        int orderID;
        Order order;

        public fulFill(int index, Deque<Order> queue, List<Order> list){
            this.queue = queue;
            this.list = list;
            this.orderID = list.get(index).id;
            order = list.get(index);
        }
        @Override
        public void run(){
            try {
                readWriteLock.writeLock().lock();
                String threadName = Thread.currentThread().getName();
                if (queue.size() == 5) {
                    while (!queue.isEmpty()) {
                        Order temp = queue.poll();
                        temp.state = State.FULFILLED;
                        Thread.sleep(300);
                        System.out.println("Order " +
                                "with ID = " + temp.id + "in Queue has State = " + temp.state.getState() + " now.");
                    }
                }

                System.out.println("Thread Name: " + threadName + " is processing Order " +
                        "with ID = " + orderID + " --> offering to Queue");
                queue.offer(order);

                if (queue.size() <= 5) {
                    while (!queue.isEmpty()) {
                        Order temp = queue.poll();
                        temp.state = State.FULFILLED;

                        System.out.println("Order " +
                                "with ID = " + temp.id + " in Queue has State = " + temp.state.getState() + " now.");
                    }
                }


            } catch (InterruptedException | NullPointerException e) {
                e.printStackTrace();
            } finally {
                readWriteLock.writeLock().unlock();
            }

        }
    }



}
