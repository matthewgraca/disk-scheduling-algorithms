package com.mgraca.project.tasktwo;

import java.util.Random;
import java.util.Arrays;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import java.util.ArrayList;

public class DiskSchedulerDriver{
  public static void main(String[] args){
    int head = Integer.parseInt(args[0]);

    // generate random requests and service them
    System.out.println("Generating a list of random cylinder requests...");
    int[] requests = generateRandomRequests();
    //System.out.println(Arrays.toString(requests));
    System.out.println("Servicing requests...");
    serviceRequests(head, requests);

    // gather requests from an input file and service them
    System.out.println("\nGenerating a list of cylinder requests from input.txt...");
    requests = getRequestsFromFile();
    //System.out.println(Arrays.toString(requests));
    System.out.println("Servicing requests...");
    serviceRequests(head, requests);
  }

  /**
   * generates 1000 random cylinder requests from [0, 4999]
   * @return  an array containing the 1000 random numbers
   */
  private static int[] generateRandomRequests(){
    int[] requests = new int[1000];
    Random rng = new Random();
    for (int i = 0; i < requests.length; i++){
      requests[i] = rng.nextInt(5000);
    }
    return requests;
  }

  /**
   * services requests with all four algorithms, and prints out the results
   */
  private static void serviceRequests(int head, int[] requests){
    int[] ans;
    ans = FCFS.calculate(head, requests);
    System.out.println("FCFS  - Total head movement: " + ans[0] + "\tNumber of direction changes: " + ans[1]);
    ans = SSTF.calculate(head, requests);
    System.out.println("SSTF  - Total head movement: " + ans[0] + "\tNumber of direction changes: " + ans[1]);
    ans = SCAN.calculate(head, requests);
    System.out.println("SCAN  - Total head movement: " + ans[0] + "\tNumber of direction changes: " + ans[1]);
    ans = CSCAN.calculate(head, requests);
    System.out.println("CSCAN - Total head movement: " + ans[0] + "\tNumber of direction changes: " + ans[1]);
  }

  /**
   * gets cylinder requests from a given input file
   * @return  an array of the requests
   */
  private static int[] getRequestsFromFile(){
    ArrayList<Integer> userRequests = new ArrayList<>();
    try{
      File file = new File("input.txt");
      Scanner scanner = new Scanner(file);
      while (scanner.hasNextInt()){
        userRequests.add(scanner.nextInt());
      }
      scanner.close();
    }
    catch (IOException e){
      e.printStackTrace();
    }
    return DiskSchedulerUtility.listToIntArray(userRequests);
  }
}
