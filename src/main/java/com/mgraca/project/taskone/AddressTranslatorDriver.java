package com.mgraca.project.taskone;

import java.util.Scanner;

public class AddressTranslatorDriver{
  public static void main (String[] args){
    Scanner input = new Scanner(System.in);
    System.out.print("Enter page size: ");
    int pageSize = input.nextInt();
    System.out.print("Enter a virtual address: ");
    int address = input.nextInt();
    System.out.println("The address " + address + " contains: " + "page number = " + AddressTranslator.computePageNumber(pageSize, address) + " offset = " + AddressTranslator.computeOffset(pageSize, address)); 
  }
}
