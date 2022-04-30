package com.mgraca.project.taskthree;

import java.util.Scanner;
import java.util.Arrays;

public class LogicalBlockDriver{
  public static void main (String[] args){
    Scanner input = new Scanner(System.in);
    System.out.print("Enter a logical block number: ");
    int logicalBlockNumber = input.nextInt();
    System.out.print("Enter HD number of cylinders: ");
    int cylinders = input.nextInt();
    System.out.print("Enter HD number of tracks: ");
    int tracks = input.nextInt();
    System.out.print("Enter HD number of sectors: ");
    int sectors = input.nextInt();
    System.out.println("The logical block number " + logicalBlockNumber + " is located at " + Arrays.toString(LogicalBlock.calculateHDLocation(logicalBlockNumber, cylinders, tracks, sectors)));
  }
}
