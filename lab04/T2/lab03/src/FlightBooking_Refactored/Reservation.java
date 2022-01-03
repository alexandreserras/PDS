package FlightBooking_Refactored;

import java.util.ArrayList;

public class Reservation {
  private ArrayList<Seat> reservedSeats = new ArrayList<>();
  private static int reservationNumber = 0;
  private final String flightCode;
  
  public Reservation(String flightCode){
    reservationNumber++;
    this.flightCode = flightCode;
  }
  
  public String getFlightCode() {
    return flightCode;
  }
  
  public int getReservationNumber() {
    return this.reservationNumber;
  }
  
  public void addSeat(Seat s){
    this.reservedSeats.add( s );
  }
  
  @Override public String toString() {
    return this.flightCode + ":" + this.getReservationNumber() + " =" + this.reservedSeats.toString();
  }
  
  public boolean contains(Seat s){
    return this.reservedSeats.contains( s );
  }
}
