package core;

import java.util.Random;
import java.util.Scanner;

import story.Chapter1;

public class Introduction {

	//Global Constructors
	
	static int iq, str;
	static int hp = 100;
	
	public static void main(String[] args){
		
		//Defining Java 2 SE Classes
		//Below defined objects are all STATIC

		Scanner scan = new Scanner(System.in);
		
		//Logs Main Menu messages
	    log("==========[ZOMBIES]==========");
	    log("Welcome to ZOMBIES, this game is made by DeathJockey");
	    log("This is a Adventure game, it is designed to be brain");
	    log("boggling and purely challenging");
	    log("Game does NOT save, so you have to complete the game");
	    log("on your first try.");
	    log("[WARNING] You may fail");
	    log("=============================");
	    log("[1] Play Game");
	    log("[2] About");
	    System.out.print("Enter your input <1, 2> :");
	    int choice = scan.nextInt();
	    log("");
	    log("Oo-=-=-=-=-=-=-=-=-=-=-=-=-oO");
	    log("");
	    
	    //Handles user inputs
	    if(choice == 1){
	    	
	    	log("Your Name is Austin and 20 Years of Age");
	    	pause();
	    	rollTrait();
	    	
	    }
	    else if(choice == 2){
	    	
	    	log("==========[ABOUT]==========");
	    	log("You have selected the about menu");
	    	log("This game was made by DeathJockey");
	    	log("With some help from Quirq ;)");
	    	log("© DeathJockey 2011");
	    	pause();
	    	main(null);
	    }
	    else{
	    	
	    }
	    
	}
	
	
	//Rolls Player Attributes
	public static void rollTrait(){
		
		Scanner scan = new Scanner(System.in);
		Random generator = new Random();
		String satisfied = "N";
		do{
			log("==========[GENERATING TRAIT]==========");
			log("[Rolling]");
			iq = generator.nextInt(80) + 20;
			str = generator.nextInt(5) + 5;
			log("Your IQ is: " + iq);
			log("Your Strength is: " + str);
			log("[INFO] Bashing doors require Strength of 6");
			log("[INFO] Lock Picking require IQ of 60");
			log("");
			
			/* The following determines the Players Grades */
			if(iq > 8 && str > 8 ){
				log("Character Raing: [S]");
			}
			else if(iq > 7 && str > 6){
				log("Character Rating: [A]");
			}
			else if(iq > 5 && str > 4){
				log("Character Rating: [B]");
				
			}
			else if(iq < 4 || str < 3){
				log("Character Rating: [C]");
			}
			
			log("");
			log("Are you satisfied with this trait? <T / N>");
			satisfied = scan.next();
			log("");
			log("");
		}
		while(satisfied.equalsIgnoreCase("N"));
		
		Chapter1 ch1 = new Chapter1();
		ch1.beginGame(hp, str, iq);
	}
	
	
	/*Creates a 'PRESS ENTER TO CONTINUE' method */
	
	public static void pause(){
		
		Scanner scan = new Scanner(System.in);
		
		log("");
		scan.nextLine();
		log("");
		
	}
	/* Creates a 'LOG' method for easy output*/
	public static void log(String message) {
		
		System.out.println(message);
		
	}
}
