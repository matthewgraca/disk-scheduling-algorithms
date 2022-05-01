package com.mgraca.project.tasktwo;

import static org.junit.Assert.assertTrue;

import org.junit.Test;
import java.util.Arrays;

public class DiskSchedulerTest{
  @Test
  public void testCSCANExample1(){
    int head = 53;
    int[] queue = {98,183,37,122,14,124,65,67};
    int[] expected = {9982, 2};
    int[] actual = CSCAN.calculate(head, queue); 
    String errorMsg = "Expected: " + Arrays.toString(expected) + ", returned: " + Arrays.toString(actual);

    assertTrue(errorMsg, Arrays.equals(expected, actual));
  }

  @Test
  public void testCSCANWithNoWrapAround(){
    int head = 53;
    int[] queue = {98,183,122,124,65,67};
    int[] expected = {130, 0};
    int[] actual = CSCAN.calculate(head, queue); 
    String errorMsg = "Expected: " + Arrays.toString(expected) + ", returned: " + Arrays.toString(actual);

    assertTrue(errorMsg, Arrays.equals(expected, actual));
  }
  @Test
  public void testFCFSExample1(){
    int head = 53;
    int[] queue = {98,183,37,122,14,124,65,67};
    int[] expected = {640, 6};
    int[] actual = FCFS.calculate(head, queue); 
    String errorMsg = "Expected: " + Arrays.toString(expected) + ", returned: " + Arrays.toString(actual);

    assertTrue(errorMsg, Arrays.equals(expected, actual));
  }

  @Test
  public void testSCANExample1(){
    int head = 53;
    int[] queue = {98,183,37,122,14,124,65,67};
    int[] expected = {236, 1};
    int[] actual = SCAN.calculate(head, queue); 
    String errorMsg = "Expected: " + Arrays.toString(expected) + ", returned: " + Arrays.toString(actual);

    assertTrue(errorMsg, Arrays.equals(expected, actual));
  }

  @Test
  public void testSCANWithNoWrapAround(){
    int head = 53;
    int[] queue = {37,14};
    int[] expected = {39, 0};
    int[] actual = SCAN.calculate(head, queue); 
    String errorMsg = "Expected: " + Arrays.toString(expected) + ", returned: " + Arrays.toString(actual);

    assertTrue(errorMsg, Arrays.equals(expected, actual));

  }
  @Test
  public void testSSTFExample1(){
    int head = 53;
    int[] queue = {98,183,37,122,14,124,65,67};
    int[] expected = {236, 2};
    int[] actual = SSTF.calculate(head, queue); 
    String errorMsg = "Expected: " + Arrays.toString(expected) + ", returned: " + Arrays.toString(actual);

    assertTrue(errorMsg, Arrays.equals(expected, actual));
  }
}
