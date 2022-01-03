package lab11.ex1;

public class Phone {
    private int processador, memoria, camara;
    private double preco;
    private String nome;


    public Phone(int processador, int memoria, int camara, double preco, String nome) {
        this.processador = processador;
        this.memoria = memoria;
        this.camara = camara;
        this.preco = preco;
        this.nome = nome;
    }


    public int getProcessador() {
        return this.processador;
    }

    public int getMemoria() {
        return this.memoria;
    }

    public int getCamara() {
        return this.camara;
    }

    public double getPreco() {
        return this.preco;
    }

    public String getNome() {
        return this.nome;
    }

    @Override
    public String toString() {
        return "{" +
            " processador='" + getProcessador() + "'" +
            ", memoria='" + getMemoria() + "'" +
            ", camara='" + getCamara() + "'" +
            ", preco='" + getPreco() + "'" +
            ", nome='" + getNome() + "'" +
            "}";
    }


}
