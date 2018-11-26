import java.util.ArrayList;
import java.util.Scanner;

//Booking of tickets, for a specific seat number in a cinmea hall
//in a specific cinema, for a specific movie (a specific date and time?)
public class BookingSystem {
  //Storing all cinemas in an ArrayList
  private static ArrayList<Cinema> cinemaList = new ArrayList<Cinema>();
  static int selectedCinema;
  static int selectedMovie;

  //Variables for "easy storage"
  public static Cinema cinema   = new Cinema();
  public static Movie movie     = new Movie();
  public static CinemaHall hall = new CinemaHall();
  public static Seat seat       = new Seat();

  //Temporary method to create meta data to run the booking system.
  //Replace with a new class (outside of BookingSystem) in future version.
  private static void createMetaData(){
    //Create Cinema with name "Filmstaden" - a Cinema with 2 movies and 2 halls
    cinemaList.add(new Cinema("Filmstaden"));
    //Add movies for cinema - ("Name of Movie", length in seconds)
    cinemaList.get(0).addMovie("Lord of the Rings", 10800);
    cinemaList.get(0).addMovie("The Hobbit", 10700);
    //Add Cinema Halls for movies - (number of seats, number of rows)
    cinemaList.get(0).getMovies().get(0).addHall(5, 1);
    cinemaList.get(0).getMovies().get(1).addHall(21, 3);
    cinemaList.get(0).getMovies().get(1).addHall(18, 3);

    //Create Cinema with name "CNEMA" - a Cinema with 2 movies and 2 halls
    cinemaList.add(new Cinema("CNEMA"));
    //Add movies for cinema - ("Name of Movie", length in seconds)
    cinemaList.get(1).addMovie("Lord of the Rings", 10800);
    cinemaList.get(1).addMovie("The Mask", 5400);
    //Add Cinema Halls for movies - (number of seats, number of rows)
    cinemaList.get(1).getMovies().get(0).addHall(10, 2);
    cinemaList.get(1).getMovies().get(1).addHall(18, 3);

    //Create Cinema with name "Biostaden" - a Cinema with 1 movie and 3 halls
    cinemaList.add(new Cinema("Biostaden"));
    //Add movie for cinema - ("Name of Movie", length in seconds)
    cinemaList.get(2).addMovie("Boss Baby", 5200);
    //Add Cinema Halls for movie - (number of seats, number of rows)
    cinemaList.get(2).getMovies().get(0).addHall(10, 2);
    cinemaList.get(2).getMovies().get(0).addHall(10, 2);
    cinemaList.get(2).getMovies().get(0).addHall(15, 3);
  }

  public static void main(String[] args){
    int seatNumber;
    Scanner scan = new Scanner(System.in);

    //Temp. creation of meta data
    createMetaData();

    //Booking System will run forever!
    //When one customer has booked a ticket, the system awaits a new customer.
    while(true){
      //Print welcome message!
      System.out.println("Welcome to our booking system!");
      //Print options -- cinema, movie, (date?, time?), seatNumber
        //Print 0: cinemaName
      System.out.println("\nAvailable cinemas: ");
      for(int i=0; i < cinemaList.size(); i++){
        System.out.println((i+1) + ". " + cinemaList.get(i).name);
      }
      System.out.println("Select your cinema: ");
      selectedCinema = scan.nextInt();
      cinema = cinemaList.get(selectedCinema-1);
        //Print 1: movie
      System.out.println("\nAvailable movies: ");
      for(int i=0; i < cinema.movieList.size(); i++){
        if(cinema.movieList.get(i).hasFreeSeats()){
          System.out.println((i+1) + ". " +
                   cinema.movieList.get(i).name);
        }
      }
      System.out.println("Select your movie: ");
      selectedMovie = scan.nextInt();
      movie  = cinema.movieList.get(selectedMovie-1);
        //Print 2: date
        //Print 3: time

        //Print 4: seatNumber
      hall   = movie.getFreeHall();
      seat   = movie.bookSeat();
      //Handle input
      //Print receipt
      System.out.println("\nThank you for your booking!");
      System.out.println("You have booked: ");
      System.out.println("Cinema: " + cinema.name);
      System.out.println("Movie: " + movie.name);
      System.out.println("Hall: " + hall.hallNumber +
                        ". Row: " + seat.row +
                       ", seat: " + seat.number);
    }
  }
}
