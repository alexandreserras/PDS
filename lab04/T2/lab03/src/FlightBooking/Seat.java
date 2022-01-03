package FlightBooking;

import java.util.Objects;

public class Seat{
  private String ID;
  private boolean occupied = false;
  private int reservationNumber;

  public Seat(int rN, char id){
    this.ID = new StringBuilder().append( rN ).append( id ).toString();
  }

  public boolean occupy(int reservationNumber){
    if(this.occupied){
      return false;
    }else{
      this.reservationNumber = reservationNumber;
      this.occupied = true;
      return true;
    }
  }
  
  @Override public boolean equals( Object o ) {
    if ( this == o ) return true;
    if ( o == null || getClass() != o.getClass() ) return false;
    Seat seat = (Seat) o;
    return ID == seat.ID && occupied == seat.occupied && reservationNumber == seat.reservationNumber;
  }
  
  @Override public int hashCode() {
    return Objects.hash( ID, occupied, reservationNumber );
  }
  
  public void unoccupy(){
    this.occupied = false;
    this.reservationNumber = -1;
  }

  public String toString(){
    return  this.ID ;
  }
}
