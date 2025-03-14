package src.concurrency2.ArrayCreator;

import java.util.ArrayList;
import java.util.concurrent.Callable;

public class ArrayCreator implements Callable<ArrayList<Integer>> {

    private int length;

    public ArrayCreator (int length) {
        this.length = length;
    }

    public ArrayList<Integer> call () {
        ArrayList<Integer> list = new ArrayList<>();
        for (int i=1;i<length;i++) {
            list.add(i);
        }
        return list;
    }
}