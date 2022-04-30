package com.mgraca.project.taskthree;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import java.util.Arrays;

public class LogicalBlockTest{
  @Test
  public void example1(){
    int[] expected = {0, 16, 33};
    int[] actual = LogicalBlock.calculateHDLocation(1041, 1000, 20, 63); 
    String errorMsg = "Expected: " + Arrays.toString(expected) + ", returned: " + Arrays.toString(actual);
    assertTrue(errorMsg, Arrays.equals(expected, actual));
  }
}
