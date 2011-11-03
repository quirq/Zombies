/*
 * Game over method handles Game Over situations.
 * It takes 3 parameters:
 * 
 * 1. placeName - Where the Player died
 * *2. playerName - What is the Player Name
 * 3. reason - How did the Player die
 * 
 * *playerName is default to Austin. It might be customizable later.
 */

package core;

import java.util.Scanner;

public class GameOver {

	//Game over Method
	public void gameOver(String placeName, String playerName, String reason){
	
		log("==========[OH NO]==========");
		log("You have died at: " + placeName);
		log("Because you got " + reason);
		log("I am sorry " + playerName + " the game is over");
		log("Press [ENTER] to terminate program"); //Terminates program
		Scanner scan = new Scanner(System.in);
		scan.nextLine();
		
	}
	
	public void log(String info){
		System.out.println(info);
	}
	
}
