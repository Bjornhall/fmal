package p1;
 
public class Parser {
	
	private static Token token;
	private static Lexer lexer;
	
	public Parser(Lexer l){
		lexer = l;
	}
	
	private static void ParserError() {
		System.out.println ("Syntax error!");
		System.exit(0);
	}
	
 
	public static void parse() {
		token = lexer.nextToken();
		 // System.out.println(" THIS IS A NEW GUY --> "+ token.code + " " + token.data);
		// if the nextToken has TokenCode ERROR
		if(token.code == Token.TokenCode.ERROR) {
			ParserError();
		}
		
		if(token.code == Token.TokenCode.END){
			//the end
			//System.out.println("THE END");
			System.exit(0);
		}
		
		if(token.code == Token.TokenCode.SEMICOL) {
			token = lexer.nextToken();
			//System.out.println("printing semicol");
			parse();
		}
		else {
			Statement();
			parse();
		}
	}
	public static void Statement(){
		// if the nextToken has TokenCode ERROR
		if(token.code == Token.TokenCode.ERROR) {
			ParserError();				
		}
		
		if(token.code == Token.TokenCode.PRINT){
			token = lexer.nextToken();
			System.out.println("PUSH " + token.data);
			System.out.println("PRINT");
			token = lexer.nextToken();
			
		}
		
		if(token.code == Token.TokenCode.ID) {
			//Factor();
			Expr();
			token = lexer.nextToken();
			if(token.code == Token.TokenCode.ASSIGN) {
				token = lexer.nextToken();
				Expr();
				System.out.println("ASSIGN");
				//System.out.println(token.code + token.data);
				// token = lexer.nextToken();
			}
			else {
				// handle var INT ....
				ParserError();
			}
		}
		if(token.code == Token.TokenCode.SEMICOL) {
			//do nothing
		}
		
		else if(token.code != Token.TokenCode.ID || token.code != Token.TokenCode.PRINT || token.code != Token.TokenCode.SEMICOL){
			ParserError();
		}
	}
	
	// Expr -> Term | Term + Expr | Term - Expr
	public static void Expr() {
		// if the nextToken has TokenCode ERROR
		if(token.code == Token.TokenCode.ERROR) {
			ParserError();
		}
		
		Term();
		
		if(token.code == Token.TokenCode.PLUS) {
			// do stuff with plus
			token = lexer.nextToken();
			Expr();
			System.out.println("A");
		}
		if(token.code == Token.TokenCode.MINUS) {
			// System.out.println("before sub" + " " + token.data); ************
			// System.out.println("inside minus" + " " + token.data);
			token = lexer.nextToken();
			Expr();
			token = lexer.nextToken();
			System.out.println("SUB");
		}
	}
	public static void Term() {
		// if the nextToken has TokenCode ERROR
		if(token.code == Token.TokenCode.ERROR) {
			ParserError();
		}
		
		// System.out.println("im inside before FActor...." + token.data);
		Factor();
		
		//token = lexer.nextToken();
		 //System.out.println("This inside Term  and my T is: " + token.data);
		
		if(token.code == Token.TokenCode.MULT){
			//System.out.println("before mult " + token.data);
			token = lexer.nextToken();
		//	System.out.println("after mult " + token.data);
			Term();
			//Factor();
			//System.out.println("after factor " + token.data);
			System.out.println("MULT");
		}
	}
	public static void Factor() {
		// if the nextToken has TokenCode ERROR
		if(token.code == Token.TokenCode.ERROR) {
			ParserError();
		}
		
		if(token.code == Token.TokenCode.INT) {
			//do stuff with INT
			//System.out.println("This inside Factor and my INT is: " + token.data);
			System.out.println("PUSH " + token.data);
			token = lexer.nextToken();
		}
		if(token.code == Token.TokenCode.ID) {
			//do stuff with ID
			//System.out.println("PUSH " + token.data); ********************************+
			System.out.println("PUSH " + token.data);
		}
		if(token.code == Token.TokenCode.LPAREN) {
			// switch to next token
			//System.out.println("This inside LPAREN " + token.data);
			
			//System.out.println("This inside Lparen and my is: " + token.data);
			token = lexer.nextToken();
			Expr();
			if(token.code == Token.TokenCode.RPAREN) {
				//System.out.println("This is inside " + token.code + "  and my is: " + token.data);
				token = lexer.nextToken();
			}
			else {
				//return error
				ParserError();
			}
		}
	}
}