package p1;

import java.util.Scanner;

public class Lexer {
	
	private static String inputString;
	private static Scanner scanner = new Scanner(System.in);
	private int index = 0;
	private int length = 0;
	
	public Lexer() {
		String whiteSpace = getInput();
		inputString = whiteSpace.replaceAll("\\s", "");
		// System.out.println(inputString);
		length = inputString.length();
	}
	
	public Token nextToken() {
		
		if(index < length) {
			Character check = inputString.charAt(index);
			
			if(check.equals('+')){
				index++;
				return new Token(Token.TokenCode.PLUS, check.toString());
			} else if (check.equals('-')) {
				index++;
				return new Token(Token.TokenCode.MINUS, check.toString());
			} else if (check.equals('*')) {
				index++;
				return new Token(Token.TokenCode.MULT, check.toString());
			} else if (check.equals('=')) {
				index++;
				return new Token(Token.TokenCode.ASSIGN, check.toString());
			} else if (check.equals('(')) {
				index++;
				return new Token(Token.TokenCode.LPAREN, check.toString());
			} else if (check.equals(')')) {
				index++;
				return new Token(Token.TokenCode.RPAREN, check.toString());
			} else if (check.equals(';')) {
				index++;
				return new Token(Token.TokenCode.SEMICOL, check.toString());
			} else if (Character.isDigit(check)) {
				return new Token(Token.TokenCode.INT, toNum());
			} else if (Character.isLetter(check)){
				String id = toId();
				if(id.contains("end")) {
					return new Token(Token.TokenCode.END, id);
				} else if (id.contains("print")) {
					return new Token(Token.TokenCode.PRINT, id);
				} else {
					return new Token(Token.TokenCode.ID, id);	
				}
			} else {
				return new Token(Token.TokenCode.ERROR, "error");
			}
		}
		
		return new Token(Token.TokenCode.ERROR, "end of string token");
	}
	
	private String toNum() {
		Character numbers = inputString.charAt(index);
		String returnNum = numbers.toString();
		if(!isEnd()){
			index++;
			if(isEnd()){
				Character lastNum = inputString.charAt(index);
				returnNum += lastNum;
				return returnNum;
			}
			while (Character.isDigit(inputString.charAt(index)) && !isEnd()) {
				Character next = inputString.charAt(index);
				returnNum += next;
				index++;
				if(isEnd()){
					Character lastNum = inputString.charAt(index);
					returnNum += lastNum;
					return returnNum;
				}
			}	
		}
		return returnNum;	
	}
	
	private String toId(){
		Character id = inputString.charAt(index);
		String returnId = id.toString();
		if(!isEnd()){
			index++;
			if(isEnd()){
				Character lastLet = inputString.charAt(index);
				returnId += lastLet;
				return returnId;
			}
			while(Character.isLetter(inputString.charAt(index)) && !isEnd()) {
				Character next = inputString.charAt(index);
				returnId += next;
				index++;
				if(isEnd()){
					Character lastLet = inputString.charAt(index);
					returnId += lastLet;
					return returnId;
				}
				if(returnId.contains("print")){
					return returnId;
				}
				if(returnId.contains("end")){
					return returnId;
				}
			}	
		}
		return returnId;
	}
	
	/*
	private void error(){
		System.out.println("Lexical Error!");
	}
	*/
	
	private String getInput(){
		String input = "";
		while(scanner.hasNext()) {
			input += scanner.next();
		}
		return input;
	}
	
	private boolean isEnd(){
		if(index  + 1 == length || index > length){
			return true;
		} else {
			return false;
		}
	}
}
