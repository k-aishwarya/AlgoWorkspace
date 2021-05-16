package Concurrency;

import java.util.concurrent.*;

public class AwaitTermination {

    public static void main(String[] args) throws InterruptedException, ExecutionException {

        ExecutorService service = null;
        try{
            service = Executors.newSingleThreadExecutor();
            Future<Integer> result = service.submit(()->{
                System.out.println("Started waiting...");
                Thread.sleep(10000);
                System.out.println("Waiting done!");
                return 8+7;
            });
//            System.out.println(result.get());
        }finally {
            if(service!=null) service.shutdown();
        }
        if(service!=null){
            System.out.println("Waiting again...");
            service.awaitTermination(1, TimeUnit.MILLISECONDS);
            System.out.println("Waiting again done!");
            if(service.isTerminated()) System.out.println("All tasks are finished");
            else System.out.println("At least one task is still running");
        }

    }
}
