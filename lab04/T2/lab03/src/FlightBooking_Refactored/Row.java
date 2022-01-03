package FlightBooking_Refactored;

import  java.util.ArrayList;
public class Row{
  int rowID;
  private ArrayList<Seat> seats = new ArrayList<>();

  protected Row(int number){
    this.rowID = number;
  }

  public void addSeat(Seat s){
    this.seats.add(s);
  }
  
  public ArrayList<Seat> getSeats() {
    return seats;
  }
  
  public boolean isEmpty(){
    for(Seat s : this.seats){
      if(s.isOccupied()){
        //Row as at least one seat occupied
        return false;
      }
    }
    // Row empty
    return true;
  }

  public int freeSeats(){
    int count = 0;
    for(Seat s : this.seats){
      if( !s.isOccupied()){
        // seat was not occupied
        count++;
      }
    }
    return count;
  }

  //occupies as many seats as possible
  // returns how many where there reserved
  public int reserve(int seats, Reservation reserve){
    int occupiedSeats = 0;
    for(Seat s : this.seats){
      if(seats == 0){
        return occupiedSeats;
      }
      if(!s.isOccupied()){
        s.occupy(reserve.getReservationNumber());
        occupiedSeats++;
        reserve.addSeat(s);
        seats--;
      }
    }
    return occupiedSeats;
  }
  
  public int getRowID() {
    return rowID;
  }
  
  public Seat findSeat(char ID){
    for (Seat s: this.getSeats()) {
      if(Character.compare( ID, s.getID()) == 0 ) {
        return s;
      }
    }
    return null;
  }
  
  @Override public String toString() {
    return "Row{" +
      "rowID=" + rowID +
      ", seats=" + seats +
      '}';
  }
}
