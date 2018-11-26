//import java.util.Calendar;
import java.util.ArrayList;

public class CinemaHall {
  public int numberOfSeats;
  public int numberOfRows;
  public int hallNumber;
  private static ArrayList<Seat> seatList = new ArrayList<Seat>();
  //date
  //time

  public CinemaHall(){
    hallNumber    = -1;
    numberOfSeats = -1;
    numberOfRows  = -1;
  }

  public CinemaHall(int iHallNumber, int iNumberOfSeats, int iNumberOfRows){
    hallNumber = iHallNumber;
    numberOfSeats = iNumberOfSeats;
    numberOfRows = iNumberOfRows;
    int currentRow = 1;
    for(int currentNumber=1; currentNumber <= numberOfSeats; currentNumber++){
      seatList.add(new Seat(currentRow, currentNumber));
      if (currentNumber%(numberOfSeats/numberOfRows)==0){
        currentRow++;
      }
    }
  }

  public boolean hasFreeSeat(){
    for(int i=0;i<seatList.size();i++){
      if(!seatList.get(i).booked){
        return true;
      }
    }
    return false;
  }

  public int getFreeSeat(){
    int total = 0;
    for(int i=0;i<seatList.size();i++){
      if(!seatList.get(i).booked){
        total++;
      }
    }
    return total;
  }

  public Seat bookSeat(){
    Seat seat = new Seat();
    for(int i=0;i<seatList.size();i++){
      if(!seatList.get(i).booked){
        seat = seatList.get(i);
        seat.book();
        break;
      }
    }
    return seat;
  }

}
