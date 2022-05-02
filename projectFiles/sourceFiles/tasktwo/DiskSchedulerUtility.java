import java.util.ArrayList;
import java.util.List;
import java.util.Collections;

/*
 * Common methods used between the SCAN classes
 */
public class DiskSchedulerUtility{
  /**
   * prepares the seek order list from a given queue
   * @param queue the array being converted to an arraylist
   * @return  the arraylist version of the queue, with a 0 added
   */
  public static ArrayList<Integer> initSeekOrder(int[] queue){
    ArrayList<Integer> seekOrder = new ArrayList<>(queue.length);
    for (int i : queue){
      seekOrder.add(i);
    }
    return seekOrder;
  }

  /**
   * takes the final scan order and makes it an array of primitives so FCFS can work on it
   * @param seekOrder the final scan order
   * @return  an array containing the final scan order
   */
  public static int[] listToIntArray(List<Integer> seekOrder){
    // marshall parameters so that FCFS can use this
    int[] sequence = new int[seekOrder.size()];
    for (int j = 0; j < seekOrder.size(); j++){
      sequence[j] = seekOrder.get(j);
    }
    return sequence;
  }
}
