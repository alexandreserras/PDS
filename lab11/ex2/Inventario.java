package lab11.ex2;

public class Inventario implements State{

    @Override
    public boolean register(Livros l) {
        // TODO Auto-generated method stub
        l.setState(new Disponivel());
        return true;
    }

    @Override
    public boolean giveBack(Livros l) {
        // TODO Auto-generated method stub
        System.err.println("Operação não disponível");
        return false;
    }

    @Override
    public boolean canelReserve(Livros l) {
        // TODO Auto-generated method stub
        System.err.println("Operação não disponível");
        return false;
        
    }

    @Override
    public boolean take(Livros l) {
        // TODO Auto-generated method stub
        System.err.println("Operação não disponível");
        return false;
        
    }

    @Override
    public boolean reserve(Livros l) {
        // TODO Auto-generated method stub
        System.err.println("Operação não disponível");
        return false;
        
    }


    @Override
    public String toString() {
        return "Inventário";
    }

    
}
