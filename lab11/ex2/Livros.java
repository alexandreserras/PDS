package lab11.ex2;

public class Livros{
    private String titulo, autor, Isbn;
    private int ano;

    private State s;



    public Livros(String titulo, String autor, String Isbn, int ano) {
        this.titulo = titulo;
        this.autor = autor;
        this.Isbn = Isbn;
        this.ano = ano;
        this.s = new Inventario ();
    }

    public String getTitulo() {
        return this.titulo;
    }

    public String getAutor() {
        return this.autor;
    }

    public String getIsbn() {
        return this.Isbn;
    }

    public int getAno() {
        return this.ano;
    }

    public State getS() {
        return this.s;
    }



    public void setState(State s){
        this.s=s;
    }

    public boolean register(){
        return s.register(this);
        
    }
    public boolean giveBack(){
        return s.giveBack(this);
    }
    public boolean canelReserve(){
        return s.canelReserve(this);
    }
    public boolean take(){
        return s.take(this);
    }
    public boolean reserve(){
        return s.reserve(this);
    }


    @Override
    public String toString() {
        return getTitulo() + "\t" +getAutor()+ "\t[" + getS()+"]";
    }

}
