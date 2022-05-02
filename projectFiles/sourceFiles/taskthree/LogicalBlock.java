public class LogicalBlock{
  /**
   *  calculates the hard disk location of a logical block address
   *  @param  lba the logical block address
   *  @param  cylinders the number of cylinders in the disk
   *  @param  tracks  the number of tracks in the disk
   *  @param  sectors the number of sectors in the disk
   *  @return the location of the logical block address in the hard disk
   */
  public static int[] calculateHDLocation(int lba, int cylinders, int tracks, int sectors){
    /* note that real-world implementations start at <0,0,1>, but ours starts at <0,0,0>,
    thus we don't need to add 1 to sectorNum*/
    int cylinderNum = lba / (tracks * sectors);
    int trackNum = lba / sectors % tracks;
    int sectorNum = lba % sectors;
    return new int[] {cylinderNum, trackNum, sectorNum};
  }
}
