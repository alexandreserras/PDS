import java.util.Objects;

public class Coordenadas {
    private int altura;
    private int comprimento;

    public Coordenadas(int altura, int comprimento){
        this.altura=altura;
        this.comprimento=comprimento;
    }

    public int getAltura() {
        return this.altura;
    }

    

    public int getComprimento() {
        return this.comprimento;
    }


    @Override
    public String toString() {
        return getAltura()+","+getComprimento();
    }
    

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Coordenadas)) {
            return false;
        }
        Coordenadas coordenadas = (Coordenadas) o;
        return altura == coordenadas.altura && comprimento == coordenadas.comprimento;
    }

    @Override
    public int hashCode() {
        return Objects.hash(altura, comprimento);
    }

    

}
