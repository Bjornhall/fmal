package p1;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Pattern;

public class Lexer {
	
	public static ArrayList<Token> nextToken(String input){
		
		ArrayList<Token> tokens = new ArrayList<Token>();
		
		Scanner scanner = new Scanner(input);
		
		while(scanner.hasNext()){
			if (scanner.hasNext(Pattern.compile("[0-9]+"))) {
				tokens.add(new Token(Token.TokenCode.INT, scanner.next()));
			} else if (scanner.hasNext(Pattern.compile("\\+"))) {
				tokens.add(new Token(Token.TokenCode.PLUS, scanner.next()));
			} else if (scanner.hasNext(Pattern.compile("\\-"))) {
				tokens.add(new Token(Token.TokenCode.MINUS, scanner.next()));
			} else if (scanner.hasNext(Pattern.compile("\\*"))) {
				tokens.add(new Token(Token.TokenCode.MULT, scanner.next()));
			} else if (scanner.hasNext(Pattern.compile("\\="))) {
				tokens.add(new Token(Token.TokenCode.ASSIGN, scanner.next()));
			} else if (scanner.hasNext(Pattern.compile("\\("))) {
				tokens.add(new Token(Token.TokenCode.LPAREN, scanner.next()));
			} else if (scanner.hasNext(Pattern.compile("\\)"))) {
				tokens.add(new Token(Token.TokenCode.RPAREN, scanner.next()));
			} else if (scanner.hasNext(Pattern.compile("\\;"))) {
				tokens.add(new Token(Token.TokenCode.SEMICOL, scanner.next()));
			} else if (scanner.hasNext(Pattern.quote("end"))) {
				tokens.add(new Token(Token.TokenCode.END, scanner.next()));
			} else if (scanner.hasNext(Pattern.quote("print"))) {
				tokens.add(new Token(Token.TokenCode.PRINT, scanner.next()));
			} else if (scanner.hasNext(Pattern.compile("[A-Za-z]+"))) {
				tokens.add(new Token(Token.TokenCode.ID, scanner.next()));
			} else if (scanner.hasNext(Pattern.compile("[\t\f\r\n]+"))) {
				scanner.next();
			} else {
				tokens.add(new Token(Token.TokenCode.ERROR, scanner.next()));
			}
		}
		
		scanner.close();
		
		return tokens;
	}
}
