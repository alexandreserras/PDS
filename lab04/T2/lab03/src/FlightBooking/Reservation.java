package FlightBooking;
import java.util.ArrayList;
import java.util.Set;
import java.util.TreeSet;


public class Reservation{
  public char classT;
  public static int reservation_number = 0;
  public ArrayList<Seat> seats = new ArrayList<Seat>();
  public ArrayList<Row> rows = new ArrayList<>();
  public  String flightCode;

  public Reservation(char c,String fc){
    this.classT = c;
    this.flightCode = fc;
    reservation_number++;
  }

  public void addRow(Row r){
    this.rows.add(r);
  }
  public void addSeat(Seat s){
    this.seats.add(s);
  }
  public String toString(){
    return "" + this.flightCode + ":"  + this.getReservationNumber() + " = " + this.getSeats();
  }
  public int getReservationNumber(){
    return this.reservation_number;
  }

  public ArrayList<Row> getRows() {
    return rows;
  }

  public ArrayList<Seat> getSeats() {
    return seats;
  }
  
  
}
