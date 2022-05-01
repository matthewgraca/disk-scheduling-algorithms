package com.mgraca.project.tasktwo;

public class FCFS{
  /**
   * calcuates the total head movement and amount of pivots
   * @param head  the initial position of the disk head
   * @param queue the given cylinder requests
   * @return  an array where the first value is the total head movement and the second value is the amount of pivots
   */
  public static int[] calculate(int head, int[] queue){
    // empty queue
    if (queue.length == 0){
      return new int[]{0, 0};
    }
    // queue with 1 item
    else if (queue.length == 1){
      return new int[]{Math.abs(head - queue[0]), 0};
    }
    // queue with > 1 item
    else{
      int sum = Math.abs(queue[0] - head);
      boolean pathRight = head - queue[0] > 0; // if path is going right, 1. if path goes left, 0
      int pivots = 0;
      for (int i = 0; i < queue.length - 1; i++){
        // if path is right and the trajectory is left, or the path is left and the trajectory is right then pivot
        if (pathRight && queue[i] - queue[i+1] < 0 || !pathRight && queue[i] - queue[i+1] > 0){
          pivots++;
          pathRight = !pathRight;
        }
        sum += Math.abs(queue[i] - queue[i+1]);
      }
      return new int[]{sum, pivots};
    }
  }
}
