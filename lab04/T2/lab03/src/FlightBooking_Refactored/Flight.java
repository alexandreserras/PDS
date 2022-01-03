package FlightBooking_Refactored;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Locale;

public class Flight {
  
  private final String flightCode;
  private Plane plane;
  private HashMap<Integer, Reservation> reservations = new HashMap<>();
  
  public Flight( String flightCode, int rowsExecutive, int seatsExecutive, int rowsTourist, int seatsTourist ) {
    this.flightCode = flightCode;
    this.plane = new Plane( rowsExecutive, seatsExecutive, rowsTourist, seatsTourist );
    
  }
  
  
  public Reservation addReservation( String rowType, int numSeats ) {
    if ( rowType.toUpperCase( Locale.ROOT ).matches( "^T" ) ) {
      System.out.print( "\n Tourist \n" );
      if ( this.plane.freeTouristSeats() >= numSeats ) {
        // Should be safe to say that we can make a Reservation
        Reservation r = new Reservation( this.flightCode );
        this.plane.reserve( 'T', numSeats, r );
        this.reservations.put( r.getReservationNumber(), r );
        return r;
      }
      else {
        return null;
      }
    }
    if ( rowType.toUpperCase( Locale.ROOT ).matches( "^E" ) ) {
      if ( this.plane.freeExecutiveSeats() >= numSeats ) {
        // Should be safe to say that we can make a Reservation
        Reservation r = new Reservation( this.flightCode );
        this.plane.reserve( 'E', numSeats, r );
        this.reservations.put( r.getReservationNumber(), r );
        return r;
      }
      else {
        return null;
      }
    }
    //not enough Seats
    return null;
  }
  
  public void showReservationMap() {
    ArrayList<Row> rowsPlane = this.plane.getRows();
    ArrayList<Seat> seatPlane = new ArrayList<>();
    int nRowsExecutive = this.plane.getnRowsExecutive();
    int nRowsTourist = this.plane.getnRowsTourist();
    int nRows = this.plane.getnRows();
    int nSeats = this.plane.getnSeats();
    int nSeatsExecutive = this.plane.getnSeatsExecutive();
    int nSeatsTourist = this.plane.getnSeatsTourist();
    int i;
    Seat s;
    
    System.out.print( "\n     " );
    for (i = 0; i <= nRows ; i++) {
      System.out.print( " " + i + " " );
    }
    System.out.println();
    for (int j = 0 ; j < nSeatsTourist ; j++) {
      System.out.print( (char) ( 'A' + j ) + "" );
      for (i = 0; i <= nRows ; i++) {
        s = this.plane.findSeat( (char) ( 'A' + j ), i );
        if ( s != null ) {
          System.out.print( " " + s.getResNumber() + "  " );
        }
        else {
          System.out.print( "    " );
        }
      }
      System.out.print( "\n" );
    }
    
  }
  
  @Override public String toString() {
    return "Flight{" +
      "flightCode='" + flightCode + '\'' +
      ", plane=" + plane +
      ", reservations=" + reservations +
      '}';
  }
}
