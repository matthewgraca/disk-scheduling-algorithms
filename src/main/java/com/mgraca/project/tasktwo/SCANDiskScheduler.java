package com.mgraca.project.tasktwo;

import java.util.Collections;
import java.util.ArrayList;
import java.util.List;

public class SCANDiskScheduler{
  /**
   * calcuates the total head movement and amount of pivots
   * @param head  the initial position of the disk head
   * @param queue the given cylinder requests
   * @return  an array where the first value is the total head movement and the second value is the amount of pivots
   */
  public static int[] calculate(int head, int[] queue){
    // add a 0 and sort the seek sequence in descending order
    ArrayList<Integer> seekOrder = initSeekOrder(queue);
    seekOrder.add(0);
    Collections.sort(seekOrder, Collections.reverseOrder());

    int i = findStartScanIndex(seekOrder, head);
    List<Integer> finalSeekOrder = setSeekOrder(seekOrder, i);
    int[] sequence = listToIntArray(finalSeekOrder);

    return FCFSDiskScheduler.calculate(head, sequence);
  }

  /**
   * get the index where the scan should begin
   * @param head  where the scan begins
   * @param arr   the array being scanned
   * @return  the index where the scan algo should begin
   */
  private static int findStartScanIndex(ArrayList<Integer> arr, int head){
    boolean scan = true;
    int i = 0;
    while (scan){
      if (arr.get(i) <= head){
        scan = false;
      }
      else{
        i++;
      }
    }
    return i;
  }

  /**
   * prepares the seek order list from a given queue
   * @param queue the array being converted to an arraylist
   * @return  the arraylist version of the queue, with a 0 added
   */
  private static ArrayList<Integer> initSeekOrder(int[] queue){
    ArrayList<Integer> seekOrder = new ArrayList<>(queue.length + 1);
    for (int i : queue){
      seekOrder.add(i);
    }
    return seekOrder;
  }

  /**
   * establishes the final seek order; assumes the list is properly set up
   * @param seekOrder the current seek order being prepared
   * @param i         the index where the list is being split
   * @return  an arraylist with the proper seek order
   */
  private static List<Integer> setSeekOrder(ArrayList<Integer> seekOrder, int i){
    // split the array at that index; sort by ascending the left array and append it to the right array
    List<Integer> right = seekOrder.subList(i, seekOrder.size());
    List<Integer> left = seekOrder.subList(0, i);
    Collections.sort(left);
    right.addAll(left); // right now contains the proper SCAN order
    return right;
  }

  /**
   * takes the final scan order and makes it an array of primitives so FCFS can work on it
   * @param seekOrder the final scan order
   * @return  an array containing the final scan order
   */
  private static int[] listToIntArray(List<Integer> seekOrder){
    // marshall parameters so that FCFS can use this
    int[] sequence = new int[seekOrder.size()];
    for (int j = 0; j < seekOrder.size(); j++){
      sequence[j] = seekOrder.get(j);
    }
    return sequence;
  }
}
