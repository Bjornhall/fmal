package p1;

import java.util.ArrayList;

public class Interpreter {
	public static void main(String[] args){
		
		String input = "1 + 22 + ( 123 ) - 2 ; = 12 print end geggjadID";
		
		ArrayList<Token> tokens = Lexer.nextToken(input);
		for(Token token : tokens){
			System.out.println(token.code + " --> " + token.data);
		}
	}
}
