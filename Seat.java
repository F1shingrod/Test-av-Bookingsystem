public class Seat {
  public boolean booked = false;
  public int row;
  public int number;

  public Seat(){
    row = -1;
    number = -1;
  }

  public Seat(int iRow, int iNumber){
    row = iRow;
    number = iNumber;
  }

  public void book(){
    booked = true;
  }
}
