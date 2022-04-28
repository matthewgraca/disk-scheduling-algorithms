package com.mgraca.project;

public class AddressTranslator{
  /**
   * computes the page number of an address
   * @param pageSize the size of the page, in kilobytes
   * @param address  the address
   * @return  the page number
   */
  public static int computePageNumber(int pageSize, int address){
    int fullPageSize = pageSize * 1024; // page size in KB
    return address / fullPageSize;
  }

  /**
   * computes the offset of an address
   * @param pageSize the size of the page, in kilobytes
   * @param address  the address
   * @return  the offset of the page 
   */
  public static int computeOffset(int pageSize, int address){
    int fullPageSize = pageSize * 1024; // page size in KB
    return address % fullPageSize;
  }
}
