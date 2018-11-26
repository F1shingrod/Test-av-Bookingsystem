import java.util.ArrayList;

public class Movie {
  public String name;//movie title
  public int length; //length in seconds
  public ArrayList<CinemaHall> cinemaHallList = new ArrayList<CinemaHall>();

  public Movie(){
    name = "-1";
    length = -1;
  }

  public Movie(String iName, int iLength){
    name = iName;
    length = iLength;
  }

  public void addHall(int seats, int rows){
    cinemaHallList.add(new CinemaHall(cinemaHallList.size()+1, seats, rows));
  }

  public ArrayList<CinemaHall> getCinemaHall(){
    return cinemaHallList;
  }

  public boolean hasFreeSeats(){
    for(int i=0;i<cinemaHallList.size();i++){
      if(cinemaHallList.get(i).hasFreeSeat()){
        return true;
      }
    }
    return false;
  }

  public CinemaHall getFreeHall(){
    CinemaHall tempHall = new CinemaHall();
    for(int i=0;i<cinemaHallList.size();i++){
      if(cinemaHallList.get(i).hasFreeSeat()){
        tempHall = cinemaHallList.get(i);
      }
    }
    return tempHall;
  }

  public Seat bookSeat(){
    Seat seat = new Seat();
    for(int i=0;i<cinemaHallList.size();i++){
      if(cinemaHallList.get(i).hasFreeSeat()){
        seat = cinemaHallList.get(i).bookSeat();
        break;
      }
    }
    return seat;
  }

}
