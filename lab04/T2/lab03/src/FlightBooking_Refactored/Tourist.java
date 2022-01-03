package FlightBooking_Refactored;

public class Tourist extends Row{
  private final int nSeats;
  public Tourist(int ID, int nSeats){
    super(ID);
    this.nSeats = nSeats;
    for( int i = 0 ; i < nSeats; i++){
      this.addSeat(new Seat( (char) ('A' + i) , ID, false));
    }
  }



}
