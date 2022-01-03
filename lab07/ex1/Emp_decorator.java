
package lab07.ex1;

public abstract class Emp_decorator implements Jobs{
    protected Jobs j;
    protected Date inicial, termino;
    Emp_decorator(Jobs j){this.j=j;}

    public void start(Date aDate){
        j.start(aDate);
        this.inicial=aDate;
    }


    public void terminate(Date aDate){
        j.terminate(aDate);
        this.termino = aDate;
    }

    public void work(){
        j.work();
    }
}
