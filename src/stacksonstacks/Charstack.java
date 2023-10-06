package stacksonstacks.src.stacksonstacks;

import java.util.*;

public class Charstack {
	 //static LinkedList <Character> stuff = new LinkedList<Character>();
	 static ArrayList <Character> stuff = new ArrayList<Character>();
	 static Scanner scnr = new Scanner(System.in);
	
	
	
	public static void insert(String x) {
		x = scnr.nextLine();
		char chars = x.charAt(0);
		stuff.add(chars);
	}
	public static char past() {
		//see last input, something that shows the index and prompts the input of the one before
		//char last = stuff.getLast();
		char last = stuff.get(stuff.size()-1);
		return last;
	}
	public static char peektop() {
		//to show the top of the list or the last input made 
		//char top = stuff.getFirst();
		char top = stuff.get(0);
		return top;
	}
	
	public static boolean checkyes() {
		boolean yes = stuff.isEmpty();
		return yes;
		}
	public static void main (String[]arg) {
		if (checkyes()== true) {
			System.out.println("Stack is currently empty. Please enter 5 character class entries: ");
		}
		else {
			System.out.println("Stack is currently not empty.");
		}
	
		insert(null);
		insert(null);
		insert(null);
		insert(null);
		insert(null);
		System.out.println(past());
		System.out.println(peektop());
	
		if (checkyes()== true) {
			System.out.println("Stack is currently empty.Entries did not work.");
		}
		else {
			System.out.println("Stack is currently not empty. Entry sucessful!");
		}
	
	}
	
	
}
