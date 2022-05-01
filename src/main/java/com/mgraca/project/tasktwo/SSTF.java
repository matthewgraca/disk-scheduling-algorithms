package com.mgraca.project.tasktwo;

import java.util.Arrays;

public class SSTF{
  /**
   * calcuates the total head movement and amount of pivots
   * @param head  the initial position of the disk head
   * @param queue the given cylinder requests
   * @return  an array where the first value is the total head movement and the second value is the amount of pivots
   */
  public static int[] calculate(int head, int[] queue){
    int n = queue.length;
    if (n == 0){
      return new int[]{0,0};
    }
    else if (n == 1){
      return new int[]{Math.abs(head - queue[0]), 0};
    }
    else{
      int[] sequence = Arrays.copyOf(queue, n);
      // sort the array by shortest seek time, then apply FCFS
      int currHead = head;
      for (int i = 0; i < n; i++){
        int j = smallestDistanceIndex(currHead, i, sequence);
        swap(i, j, sequence);
        currHead = sequence[i];
      }
      return FCFS.calculate(head, sequence);
    }
  }

  /**
   * searches the array for the value closest to a given number
   * @param num the number being compared to
   * @param start the index where the scan begins
   * @param arr the array of values whose distance we're comparing with
   * @return  the index of the array that contains the value closest to num, -1 if the array is empty
   */
  private static int smallestDistanceIndex(int num, int start, int[] arr){
    if (arr.length == 0){
      return -1;
    }
    else{
      int minDistance = Integer.MAX_VALUE;
      int index = -1;
      for (int i = start; i < arr.length; i++){
        if (Math.abs(num - arr[i]) < minDistance){
          minDistance = Math.abs(num - arr[i]);
          index = i;
        }
      }
      return index;
    }
  }

  /**
   * swaps the values of the given indeces of an array
   * @param i index of the array
   * @param j index of the array
   * @param arr array whose content is being swapped
   */
  private static void swap(int i, int j, int[] arr){
    int temp = arr[i];
    arr[i] = arr[j];
    arr[j] = temp;
  }
}
