package ex2;
public class Person {
    private String nome;
    private int NIF;


    public Person(String nome, int NIF) {
        this.nome = nome;
        this.NIF = NIF;
    }

    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getNIF() {
        return this.NIF;
    }

    public void setNIF(int NIF) {
        this.NIF = NIF;
    }

    @Override
    public String toString() {
        return "{" +
            " nome='" + getNome() + "'" +
            ", NIF='" + getNIF() + "'" +
            "}";
    }

}
