package FlightBooking;

import java.util.*;
import java.util.stream.Collectors;

public class UserInterface {
  static Scanner sc = new Scanner( System.in );
  private HashMap<String, Flight> flights = new HashMap<>();
  public static String helpMenu = "'H':// Show help  \n" +
    "I:// Reads file flight info\n" +
    "M://show reservations\n" +
    "'F://Creates a new Flight \n" +
    "R://Make a reservation\n" +
    "C:// cancels a reservation\n" +
    "Q Quits";

  public UserInterface() {

  }

  public void parseOption( ArrayList<String> optionValues ) {
    String flightCode, executiveConf = "", touristConf;
    char opt = optionValues.get( 0 ).toUpperCase( Locale.ROOT ).charAt( 0 );
    switch (Character.toUpperCase( opt )) {
      case 'H':// Show help
        System.out.println( helpMenu );
        break;
      case 'I':// Reads file flight info takes a filename
        System.out.println("Not Implemented");
        break;
      case 'M'://show reservations /takes a flight code
        System.out.println("Not Implemented");
        //flightCode = optionValues.get( 1 );
        //System.out.println( this.flights.get( flightCode ) );
        break;
      case 'F'://Creates a new Flight takes a flight code num of seats for each class
        flightCode = optionValues.get( 1 );
        if ( optionValues.size() == 4 ) {
          executiveConf = optionValues.get( 2 );
          touristConf = optionValues.get( 3 );
        }
        else {
          touristConf = optionValues.get( 2 );
        }
        this.addFlight( flightCode, touristConf, executiveConf );
        System.out.println( this.flights );
        break;
      case 'R'://Make a reservation takes flight code and number seats
        System.out.println("Does not Work");
        flightCode = optionValues.get( 1 );
        char classT = optionValues.get( 2 ).charAt( 0 );
        int nSeats = Integer.parseInt( optionValues.get( 3 ) );
        this.makeReservation( flightCode, nSeats, classT );
        break;
      case 'C':// cancels a reservation takes a reservation code
        System.out.println("Not Implemented");
        break;
      case 'Q':
        System.out.println("Not Implemented");
        System.exit( 0 );
      default:
        System.err.println( "Invalid Option" );
        System.out.println( this.helpMenu );
    }
  }

  public boolean addFlight( String flightCode, String seatsTourist, String seatsExecutive ) {
    Flight fl;
    String[] touristConfiguration = seatsTourist.split( "x" );
    if ( seatsExecutive.isEmpty() ) {
      System.out.println( "WAS EMPTY" );
      fl = new Flight(flightCode, seatsTourist);
      if ( ! this.flights.containsValue( fl ) ) {
        this.flights.put( flightCode, fl );
        return true;
      }
      else {
        return false;
      }
    }
    String[] executiveConfiguration = seatsExecutive.split( "x" );
    fl = new Flight(flightCode, seatsExecutive, seatsTourist);
    if ( ! this.flights.containsValue( fl ) ) {
      this.flights.put( flightCode, fl );
      return true;
    }
    else {
      return false;
    }
  }

  public boolean makeReservation( String flightCode, int numSeats, char classT ) {
    Reservation res = new Reservation( classT ,flightCode );
    this.flights.get( flightCode ).makeReservation( numSeats, classT);
    return true;
  }

  public void addFlightInfo( List<String> fileLines ) {
    if ( ! fileLines.get( 0 ).matches( "^>.*$" ) ) {
      System.err.println( "This File is not correct.\n" +
        "You should insert a '>' before The flight code" );
      System.exit( - 1 );
    }
    //fligthInfo:
    //[FlightCode, seatsExecutive, seats Tourist] split at space
    String[] flinghtInfo = fileLines.get( 0 ).substring( 1 ).split( "\\s+" );
    if ( ! this.addFlight( flinghtInfo[0], flinghtInfo[1], flinghtInfo[2] ) ) {
      System.err.println( "Flight wasnt added maybe one using the same code already exists" );
    }

    //Reservations
    String[] reservationInfo;
    Reservation reservation;
    for (int i = 1 ; i < fileLines.size() ; i++) {
      if ( fileLines.get( i ).matches( "^[T|E]\\s+[0-9]+" ) ) {
        reservationInfo = fileLines.get( i ).split( "\\s+" );
        Reservation r = new Reservation( reservationInfo[1].charAt( 0 ) ,flinghtInfo[0]   );
        this.flights.get( flinghtInfo[0] ).makeReservation( Integer.parseInt(  reservationInfo[2] ),
        reservationInfo[1].charAt( 0 ));
      }
    }
  }

  @Override public String toString() {
    return "Escolha uma Opcao: (H para Help)\n";
  }

  public static void main( String args[] ) {
    UserInterface ui = new UserInterface();
    String line;
    ArrayList<String> optionVals = new ArrayList<>();
    while (true){
      line = sc.nextLine();
      optionVals = (ArrayList<String>) Arrays.stream( line.split( "\\s+" ) ).collect( Collectors.toList() );
      ui.parseOption( optionVals );
    }
  }
}
