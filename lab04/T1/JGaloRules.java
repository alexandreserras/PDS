package T1;

import java.util.Scanner;

public class JGaloRules implements JGaloInterface{
	static char p1 = 'X';
	static char p2 = 'O';
	static char current = p1;
	static int numPlays = 0;
	char[][] plays = new char[3][3];
	static char winner = ' ';
	int countO;
	int countX;
	
	
	public JGaloRules() {
		char player1 = p1;
		char player2 = p2;
	}

	public JGaloRules(char c1){
		if (p1==c1){
			char player1 = p1;
			char player2 = p2;
		}
		else{
			char player1 = p2;
			char player2 = p1;
		}
	}

	public static char getP1() {
		return p1;
	}

//	public static void setP1(char p1) {
//		JGaloRules.p1 = p1;
//	}

	public static char getP2() {
		return p2;
	}

	//public static void setP2(char p2) {
//		JGaloRules.p2 = p2;
//	}

	@Override
	public char getActualPlayer() {
		if(current == p1) {
			current = p2;
			return p2;
		}
		else {
			current = p1;
			return p1;
		}
	}

	@Override
	public boolean setJogada(int lin, int col) {
		numPlays++;
		plays[lin-1][col-1] = current;

		return false;
	}

	@Override
	public boolean isFinished() {
		
		for(int i= 0; i<3; i++) {
			countO = 0;
			countX = 0;
			for(int z = 0; z<3; z++) {
				if(plays[i][z] == 'O') {
					countO++;
				}
				if(plays[i][z] == 'X') {
					countX++;
				}
			}
			if(countO == 3) {
				winner = 'O';
				return true;
			}
			if(countX == 3) {
				winner = 'X';
				return true;
			}
		}
		
		for(int i= 0; i<3; i++) {
			countO = 0;
			countX = 0;
			for(int z = 0; z<3; z++) {
				if(plays[z][i] == 'O') {
					countO++;
				}
				if(plays[z][i] == 'X') {
					countX++;
				}
			}
			if(countO == 3) {
				winner = 'O';
				return true;
			}
			if(countX == 3) {
				winner = 'X';
				return true;
			}
		}
		
		countX = 0;
		countO = 0;
		for(int i = 0; i<3; i++) {
			if(plays[i][i] == 'X')
				countX++;
			if(plays[i][i] == 'O') {
				countO++;
			}
		}
		if(countO == 3) {
			winner = 'O';
			return true;
		}
		if(countX == 3) {
			winner = 'X';
			return true;
		}
		

		countX = 0;
		countO = 0;		
		
		if(plays[0][2] == plays[1][1] && plays[2][0] == plays[1][1]) {
			if(plays[1][1] != 0) {
				winner = plays[1][1];
				return true;
			}
		}
		
		if(numPlays == 9) {
			return true;
		}
		
		return false;
	}

	@Override
	public char checkResult() {
		return winner;
	}
	

}
