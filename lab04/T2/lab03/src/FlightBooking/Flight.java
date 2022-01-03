package FlightBooking;
import java.util.HashMap;
public class Flight{
  private String flightCode;
  private Plane plane;
  private HashMap<Integer, Reservation> res = new HashMap<>();

  public Flight(String flightCode, String executiveConfiguration, String touristConfiguration){
    this.plane = new  Plane(executiveConfiguration, touristConfiguration);
    this.flightCode = flightCode;
  }
  public Flight(String flightCode,  String touristConfiguration){
    this.plane = new  Plane( touristConfiguration);
    this.flightCode = flightCode;
  }

  public boolean makeReservation(int n , char c ){
    if(this.plane.hasSeats(n, c)){
      Reservation r = new Reservation(c , this.flightCode);
      res.put(r.getReservationNumber(), r);
      this.plane.makeReservation(n,c, r);
      System.out.println( r );
      return true;
    }
    return false;
  }

  public void cancelReservation(int resN){
    // percorrer row
    // percorrer seat
    // eliminate res if equal
    // pop res from list
    Reservation r = this.res.get( resN );
    for (Row rw: r.getRows()){
      for (Seat s: r.getSeats()){
        Seat[] seatsRW = rw.getSeats();
        for (int i = 0; i < rw.getnSeats(); i++){
          if (s.equals(seatsRW[i])){
            rw.unoccupy( i );
          }
        }
      }
    }
    return;
  }
  
  @Override public String toString() {
    return "Flight{" +
      "flightCode='" + flightCode + '\'' +
      ", plane=" + plane +
      ", res=" + res +
      '}';
  }
}
