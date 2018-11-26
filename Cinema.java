import java.util.ArrayList;

public class Cinema {
  public String name;
  public ArrayList<Movie> movieList = new ArrayList<Movie>();
  //public ArrayList<CinemaHall> cinemaHallList = new ArrayList<CinemaHall>();

  public Cinema(){
    name = "-1";
  }

  public Cinema(String iName){
    name = iName;
  }

  public void addMovie(String iName, int iLength){
    movieList.add(new Movie(iName, iLength));
  }

  public ArrayList<Movie> getMovies(){
    return movieList;
  }
}
