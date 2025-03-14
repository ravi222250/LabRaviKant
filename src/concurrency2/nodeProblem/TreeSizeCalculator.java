package src.concurrency2.nodeProblem;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;

public class TreeSizeCalculator implements Callable<Integer> {

    private Node root;
    private ExecutorService executorService;

    public TreeSizeCalculator(Node root, ExecutorService executorService) {
        this.root = root;
        this.executorService = executorService;
    }

    public Integer call() throws ExecutionException, InterruptedException {
        // base condition
        if (root == null)
            return 0;

        TreeSizeCalculator leftTree = new TreeSizeCalculator (root.getLeftNode(), executorService);
        TreeSizeCalculator rightTree = new TreeSizeCalculator (root.getRightNode(), executorService);

        Future<Integer> leftTreeSize = executorService.submit(leftTree);
        Future<Integer> rightTreeSize = executorService.submit(rightTree);

        return 1 + leftTreeSize.get() + rightTreeSize.get();

    }
}
