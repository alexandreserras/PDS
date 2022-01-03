import java.util.Objects;

public class Resposta{
    private Coordenadas valores;
    private Direcoes direcao;
    
    public Resposta(Coordenadas valores, Direcoes direcao){
        this.direcao=direcao;
        this.valores=valores;
    }

    public Coordenadas getValores() {
        return this.valores;
    }
    public Direcoes getDirecao() {
        return this.direcao;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Resposta)) {
            return false;
        }
        Resposta resposta = (Resposta) o;
        return Objects.equals(valores, resposta.valores) && Objects.equals(direcao, resposta.direcao);
    }

    @Override
    public int hashCode() {
        return Objects.hash(valores, direcao);
    }

    @Override
    public String toString() {
        return 
             getValores() + "'" +
            ", direcao='" + getDirecao() + "'" +
            "}";
    }



    


}