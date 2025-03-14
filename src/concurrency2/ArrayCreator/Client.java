package src.concurrency2.ArrayCreator;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.concurrent.*;

public class Client {

    public static void main(String... args) throws ExecutionException, InterruptedException {
        Scanner scanner = new Scanner(System.in);
        int size = scanner.nextInt();

        ArrayCreator creator = new ArrayCreator(size);
        
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        Future<ArrayList<Integer>> answer = executorService.submit(creator);
        System.out.println(answer.get());
    }
}