package ex2;
public class Place {
    private String lugar;
    private int latitude,longitude;


    public Place(String lugar, int latitude, int longitude) {
        this.lugar = lugar;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public String getLugar() {
        return this.lugar;
    }

    public void setLugar(String lugar) {
        this.lugar = lugar;
    }

    public int getLatitude() {
        return this.latitude;
    }

    public void setLatitude(int latitude) {
        this.latitude = latitude;
    }

    public int getLongitude() {
        return this.longitude;
    }

    public void setLongitude(int longitude) {
        this.longitude = longitude;
    }

    @Override
    public String toString() {
        return "{" +
            " lugar='" + getLugar() + "'" +
            ", latitude='" + getLatitude() + "'" +
            ", longitude='" + getLongitude() + "'" +
            "}";
    }

}
