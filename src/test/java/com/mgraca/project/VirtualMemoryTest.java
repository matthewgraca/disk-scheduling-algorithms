package com.mgraca.project;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class VirtualMemoryTest{
  @Test
  public void example1(){
    int actualPageNumber = VirtualMemory.computePageNumber(2, 10500);
    int actualOffset = VirtualMemory.computeOffset(2, 10500); 
    int expectedPageNumber = 5;
    int expectedOffset = 260;

    boolean compare = (actualPageNumber == expectedPageNumber) && (expectedOffset == actualOffset);
    String errorMsg = "Expected page number " + expectedPageNumber + " and offset " + expectedOffset + 
    ", returned " + actualPageNumber + " and " + actualOffset;
    assertTrue(errorMsg, compare);
  }
}
