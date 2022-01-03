package lab07.ex2;

public abstract class Text_abstract implements Text_interface{
    protected Text_interface t;

    Text_abstract(Text_interface t) {this.t=t;}

    public boolean hasNext(){
        return this.t.hasNext();
    };
    
    public String next(){
        return this.t.next();
    };

}
