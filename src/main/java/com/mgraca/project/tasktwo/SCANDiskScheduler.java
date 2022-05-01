package com.mgraca.project.tasktwo;

import java.util.Collections;
import java.util.ArrayList;
import java.util.List;

public class SCANDiskScheduler extends SCAN{
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
}
