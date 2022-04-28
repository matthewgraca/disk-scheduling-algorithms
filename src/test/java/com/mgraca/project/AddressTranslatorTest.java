package com.mgraca.project;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class AddressTranslatorTest{
  @Test
  public void example1(){
    int actualPageNumber = AddressTranslator.computePageNumber(2, 10500);
    int actualOffset = AddressTranslator.computeOffset(2, 10500); 
    int expectedPageNumber = 5;
    int expectedOffset = 260;

    boolean compare = (actualPageNumber == expectedPageNumber) && (expectedOffset == actualOffset);
    String errorMsg = "Expected page number " + expectedPageNumber + " and offset " + expectedOffset + 
    ", returned " + actualPageNumber + " and " + actualOffset;
    assertTrue(errorMsg, compare);
  }
}
