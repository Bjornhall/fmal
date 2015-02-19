package p1;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

public class Interpreter {
	
	private Scanner scanner = new Scanner(System.in);
	private static ArrayList<String> list = new ArrayList<String>();
	private Stack<String> stack = new Stack<String>();
	private int actions = 0;
	
	public Interpreter() {
		getInput();
	}
	// a=2*(31+4); b=5; c=a*b; print c; end
	private void getInput(){
		while(scanner.hasNext()) {
			list.add(scanner.nextLine());
		}
		System.out.println(actions);
	}
	
	private void interprate(){
		for(int i = 0; i < list.size(); i++){
			if (list.get(i).contains("PUSH")){
				
			} else if ((list.get(i).contains("ASSIGN"))){
				
			}
		}
	}
	
	private void error(){
		System.out.println("error");
	}
	
	public static void main(String[] args)
	{
		Interpreter interpreter = new Interpreter();
		for (String s : list){
			System.out.println(s);
		}
	}
}
