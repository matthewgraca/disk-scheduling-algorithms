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
    ArrayList<Integer> seekOrder = new ArrayList<>(queue.length + 1);
    for (int i : queue){
      seekOrder.add(i);
    }
    seekOrder.add(0);
    Collections.sort(seekOrder, Collections.reverseOrder());

    // find the index where the head begins scanning from
    boolean scan = true;
    int i = 0;
    while (scan){
      if (seekOrder.get(i) <= head){
        scan = false;
      }
      else{
        i++;
      }
    }
    
    // split the array at that index; sort by ascending the left array and append it to the right array
    List<Integer> right = seekOrder.subList(i, seekOrder.size());
    List<Integer> left = seekOrder.subList(0, i);
    Collections.sort(left);
    right.addAll(left); // right now contains the proper SCAN order

    // marshall parameters so we can use FCFS 
    int[] sequence = new int[right.size()];
    for (int j = 0; j < right.size(); j++){
      sequence[j] = right.get(j);
    }
    return FCFSDiskScheduler.calculate(head, sequence);
  }
}
