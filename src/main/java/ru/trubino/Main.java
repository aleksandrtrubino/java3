package ru.trubino;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.function.BiConsumer;

/**
 * The Main class measures the performance of various operations on different types of List implementations.
 */
public class Main {

    /**
     * Measures the performance of add, get, and remove operations on a given list.
     *
     * @param list the list to be tested
     * @param iterationNum the number of iterations to perform
     */
    private static void measurePerformance(List<Integer> list, int iterationNum) {
        long addTime = measureTime(list, iterationNum, List::add);
        long getTime = measureTime(list, iterationNum, List::get);
        long deleteTime = measureTime(list, iterationNum, List::remove);

        System.out.println(list.getClass().getSimpleName() + ":add\t\t" + iterationNum + "\t\t" + addTime);
        System.out.println(list.getClass().getSimpleName() + ":get\t\t" + iterationNum + "\t\t" + getTime);
        System.out.println(list.getClass().getSimpleName() + ":remove\t" + iterationNum + "\t\t" + deleteTime);
    }

    /**
     * Measures the time taken to perform a specified action on a list for a given number of iterations.
     *
     * @param list the list on which the action is performed
     * @param iterations the number of iterations to perform
     * @param action the action to be performed
     * @return the time taken in nanoseconds
     */
    private static long measureTime(List<Integer> list, int iterations, BiConsumer<List<Integer>, Integer> action) {
        long startTime = System.nanoTime();
        for (int i = 0; i < iterations; i++) {
            action.accept(list, i);
        }
        return System.nanoTime() - startTime;
    }

    /**
     * The main method that sets up the lists and calls the measurePerformance method for each list.
     *
     * @param args command-line arguments (not used)
     */
    public static void main(String[] args) {
        final int ITERATION_NUM = 1000;

        ArrayList<Integer> arrayList = new ArrayList<>();
        LinkedList<Integer> linkedList = new LinkedList<>();
        System.out.println("Method\t\t\tIterations\tTime (ns)");
        measurePerformance(arrayList, ITERATION_NUM);
        measurePerformance(linkedList, ITERATION_NUM);
    }
}
