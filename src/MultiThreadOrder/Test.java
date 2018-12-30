package MultiThreadOrder;

import java.util.Deque;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

public class Test {
    public static void main(String[] args) {
        ExecutorService pool = Executors.newFixedThreadPool(10);
        System.out.println("\n ----- START FULFILLMENT (Asynchronously) ----- \n");
        Worker worker =  new Worker();
        int id = 1;
        Deque<Order> queue = worker.queue;
        List<Order> list = worker.list;

        while (id <= 10) {
            new Worker().new create(id++,queue, list).run();
//            pool.execute(new Worker().new create(id++,queue, list));
        }


        System.out.println("\n ----- START FULFILLMENT (Concurrently) ----- \n");



        int index = 0;
        while (index < 10) {
//            new Worker().new fulFill(index++, queue, list).run();
            pool.execute(new Worker().new fulFill(index++, queue, list));
        }


        pool.shutdown();
    }
}
