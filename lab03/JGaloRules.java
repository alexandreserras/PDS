package lab03;



public class JGaloRules implements JGaloInterface{

    private char[][] tabuleiro;
    private boolean endGame;
    private char player;
    private char winner;


    public JGaloRules(char player) {
        this.tabuleiro = new char [3][3];
        this.player = player;
        this.endGame=false;
    }

    public char getActualPlayer(){
        return this.player;
    }

    public boolean setJogada(int linha, int coluna){
        if (this.tabuleiro[linha-1][coluna-1]=='\u0000'){
            this.tabuleiro[linha-1][coluna-1]=player;
            return true;
        }
        return false;
    }

    public boolean isFinished(){

        // Verificar se já ganhou nas diagonais
        if (this.tabuleiro[1][1]!='\u0000'){
            if ((this.tabuleiro[0][0]==this.tabuleiro[1][1] && this.tabuleiro[0][0]==this.tabuleiro[2][2]) || (this.tabuleiro[1][1]==this.tabuleiro[0][2] && this.tabuleiro[1][1]==this.tabuleiro[2][0])){
                this.endGame=true;
                this.winner = this.tabuleiro[1][1];
                return true;
            }
        }

        for (int i=0; i<3;i++){
            for (int j=0; j<3;j++){
                if (this.tabuleiro[i][0]!='\u0000'){
                    if ((this.tabuleiro[i][0] == this.tabuleiro[i][1]) && (this.tabuleiro[i][0] == this.tabuleiro[i][2])){
                        this.winner=this.tabuleiro[0][i];
                        this.endGame=true;
                        return true;
                    }
                }
                if (this.tabuleiro[0][i]!='\u0000'){
                    if ((this.tabuleiro[0][i] == this.tabuleiro[1][i]) && (this.tabuleiro[0][i] == this.tabuleiro[2][i])){
                        this.winner=this.tabuleiro[0][i];
                        this.endGame=true;
                        return true;
                    }
                }
            }
        }


        for (int i=0; i<3; i++){
            for (int j=0; j<3; j++){
                if (this.tabuleiro[i][j] == '\u0000'){
                    if(this.player== 'o'){
                        this.player= 'x';
                    }
                    else{
                        this.player= 'o';
                    }
                    return false;
                }
            }
        }
        return true;

        
    }
    public char checkResult(){
        if (this.endGame)
            return this.player;
        else
            return ' ';
    }

}
