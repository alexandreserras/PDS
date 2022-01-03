package FlightBooking;

public class Row{
  private final int ID;
  private final int nSeats;
  private int freeSeats;
  private Seat[] s;

  public Row(int nSeats, int id ){
    this.s = new Seat[nSeats];
    this.ID = id;
    this.freeSeats = nSeats;
    this.nSeats = nSeats;
    for( int i = 0 ; i < nSeats; i++){
      this.s[i] = new Seat(id, (char)('A' + i));
    }
  }

  public int getnSeats() {
    return nSeats;
  }

  public Seat[] getSeats() {
    return s;
  }

  public boolean isEmpty(){
    return this.freeSeats == 0;
  }

  public boolean hasSeats(){
    return this.freeSeats > 0;
  }
  public int firstEmptySeat(){
    return this.nSeats - this.freeSeats ;
  }

  public boolean reserve(int n, Reservation r){
    for( int i = this.firstEmptySeat() ; i < this.nSeats ; i++){
      System.out.println(i);
      this.s[i].occupy(r.getReservationNumber());
        r.addSeat(this.s[i]);
        r.addRow( this );
        this.freeSeats--;
        return true;
    }
    return true;
  }
  public String toString(){
    return "ID" + this.ID +  "NSeats" + this.nSeats;
  }

  public int getFreeSeats() {
    return this.freeSeats;
  }
  public void unoccupy(int i){
    this.freeSeats++;
    this.s[i].unoccupy();
  }
}
