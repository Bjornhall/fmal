package p1;

public class Token {
	public enum TokenCode {
		ID,	
		INT,
		PLUS,
		MINUS,
		ASSIGN,
		SEMICOL,
		MULT,
		LPAREN,
		RPAREN,
		PRINT,
		END,
		ERROR;
	}
	
	public TokenCode code;
	public String data;
	
	public Token(TokenCode code, String data){
		this.code = code;
		this.data = data;
	}
}
