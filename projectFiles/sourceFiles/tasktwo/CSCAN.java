import java.util.ArrayList;
import java.util.List;
import java.util.Collections;

public class CSCAN{
  /**
   * calcuates the total head movement and amount of pivots
   * @param head  the initial position of the disk head
   * @param queue the given cylinder requests
   * @return  an array where the first value is the total head movement and the second value is the amount of pivots
   */
  public static int[] calculate(int head, int[] queue){
    if (queue.length == 0){
      return new int[]{0,0};
    }
    else if (queue.length == 1){
      return new int[]{Math.abs(head - queue[0]),0};
    }
    else{
      // add a 0 and 4999 and sort the sequence in ascending order
      ArrayList<Integer> seekOrder = DiskSchedulerUtility.initSeekOrder(queue);
      Collections.sort(seekOrder);
      // ensure that if the sequence wraps around, that the head will hit 0 and 4999
      if (seekOrder.get(0) < head){
        seekOrder.add(0, 0);
        seekOrder.add(4999);
      }

      // find the index where scan starts, then manipulate the arrays to CSCAN order
      int i = findStartScanIndex(seekOrder, head);
      List<Integer> finalSeekOrder = setSeekOrder(seekOrder, i);
      int[] sequence = DiskSchedulerUtility.listToIntArray(finalSeekOrder);

      // marshall the list so that FCFS can use it
      return FCFS.calculate(head, sequence);
    }
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
      if (arr.get(i) > head){
        scan = false;
      }
      else{
        i++;
      }
    }
    return i;
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
    right.addAll(left); // right now contains the final CSCAN order
    return right;
  }
}
