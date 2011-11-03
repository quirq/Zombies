package story;

import java.util.Scanner;

import core.Combat;
import core.GameOver;

public class Chapter1 {

	Scanner scan = new Scanner(System.in);
	boolean dKey = false;
	public void beginGame(int hp, int str, int iq){
		
		
		log("==========[OLD  ROOM]==========");
		log("Nothing much is around you other");
		log("than a dusty bed and an old door.");
		log("You looked around, nothing else");
		log("interests you other than a ancient");
		log("stylish painting of Mona Lisa");
		log("===========[ACTIONS]===========");
		log("[1] Sleep on the Dusty Bed");
		log("[2] Examine the Painting");
		log("[3] Walk out the Door");
		int choice = scan.nextInt();
		
		if(choice == 1){
			
			log("You laid down onto the dusty bed");
			log("Everything is so still and silent");
			log("You gently closed your eyes and fell asleep");
			log("");
			pause();
			pause();
					
			
			log("But this isn't the time to sleep, zombies are");
			log("everywhere, you soon realised this.");
			log("");
			pause();
			
			log("However it is too late, you opened your eyes and...");
			log("");
			pause();
			
			log("Zombies started chewing your brain");
			log("");
			pause();
			GameOver end = new GameOver();
			end.gameOver("Old House", "Austin", "chewed by Zombies");
			
		}
		else if(choice == 2){
			
			if(dKey == false){
				log("You walked up to the painting, there is something");
				log("odd, a corner has been ripped out!");
				log("After a close examination, you found a dirty key");
				log("[WARNING] Do NOT use this OPTION AGAIN");
				log("[OBTAINED] Dirty Key!");
				log("");
				dKey = true;
				log("====================");
				log("Press [ENTER] to leave");
				scan.nextLine();
				scan.nextLine(); 
				beginGame(hp, str, iq);
			}
			else{
				log("");
				log("You walked up to the painting,");
				log("there is nothing special that interests you");
				log("");
				pause();
				pause();
				beginGame(hp, str, iq);
			}
		}
		else if(choice == 3){
			
			if(dKey == false){
				log("You approached the rusty door, thick paint drifed onto");
				log("the ground as you touched its surface");
				log("You tried to open it, but alas, it is locked.");
				log("Perhaps I could use a key?");
				pause();
				pause();
				beginGame(hp, str, iq);
			}
			
			else{
			log("");
			log("You approached the rusty door, inserted the rusty key into");
			log("its key hole, it fitted perfectly");
			log("With some struggle spinning the key around, you managed to");
			log("hear a 'CLICK' sound and the old door opens...");
			
			pause();
			outdoors(hp, str, iq);
			
			}
			
		}
		
		else{
			
		}
	}
	
	/* Outdoor Chapter 1-2 */
	public void outdoors(int hp, int str, int iq){
		
		Combat combat = new Combat();
		
		log("");
		log("==========[OUTDOORS]==========");
		log("You stepped outside, you smelt");
		log("the rottoned flesh of the zombies");
		log("One is approaching you!");
		pause();
		
		combat.prepareStats("Zombie", hp, str, iq);
		
		log("You have won your battle with");
		log("the zombie!");
		log("As it falls to the ground");
		log("you hear a loud thump.");
		pause();
		log("==========[ZOMBIE]==========");
		log("[1] Examine the zombies body");
		log("[2] Scour the land for humans");
		int choice = scan.nextInt();
		
		if(choice == 1){
			log("As you lean down to examine");
			log("the dead zombie, you notice");
			log("");
			
		}
		else if(choice == 2){
			log("You look to your left");
			log("and notice a very large mountain");
			log("covered with spots of red...");
			
			pause();
			
			log("You climb the mountain");
			
			pause();
			pause();
			
			log("As you reach the top");
			log("you notice a small village");
			log("you see a worn out sign covered");
			log("with moss...");
			
			pause();
			
			log("You pull off the moss and");
			log("read the colour faded sign");
			
			pause();
			
			log("SIGN: FORTCHEESEBALLS");
			log("You laugh at the ridiculous");
			log("name for a military fort.");
			
			pause();
			
			log("You feel the ground slip away");
			log("beneath your feet...");
			
			pause();
			
			log("You lose your footing");
			log("and slip off the side of");
			log("the mountain and tumble");
			log("towards your humble doom...");
			
			pause();
			
			GameOver fallDeath = new GameOver();
			fallDeath.gameOver("Mountain", "Austin", "Lost your footing on the moutain");
			
		}
		else{
			
		}
	}
	
	//The global methods(Used Commonly) Make any new classes above these
	public void pause(){
		log("");
		scan.nextLine();
		log("");
	}
	
	public void log(String info){
		System.out.println(info);
	}
}
