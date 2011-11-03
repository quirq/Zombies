/** ===============================
 * COMBAT SYSTEM
 * ===============================
 * 
 * The combat system revolves around the HITCHANCE.
 * First, we have a prepareStats method which, based on the provided
 * name parameter, identifies and prepares the stats of a mob.
 * The battle system is turn based, revolving around user hitting [ENTER] to proceed
 * to the next turn.
 * 
 * Mob has the following stats:
 * 
 * Strength - A generated value that determines how hard the enemy hits
 * 
 * IQ - The hit chance of mobs
 * 
 * Attack - A bonus added on to hit Point
 * 
 * Defense - Currently unused, perhaps will have defense
 * 
 * Health - A randomly generated number that represents the HP
 * 
 */



package core;

import java.util.Random;
import java.util.Scanner;

public class Combat {

	//Here we prepare the player's status, since the game does not save
	//player properties has to be passed on from the classes which contains
	//player information.
	
	public void prepareStats(String mobName, int playerHP, int playerSTR,
			int playerIQ) {

		boolean victory = false;
		
		log("0o----------[COMBAT]----------o0");
		log("You are entering combat with a " + mobName);
		log("");

		if (mobName.equalsIgnoreCase("Zombie")) {
			
			//Randomly generates the mob stats
			
			//HP cannot be lower than 5 and cannot be greater than 29
			int health = (int) (Math.random() * 24) + 5;
			int atk = (int) (Math.random() * 5 + 2);
			int def = (int) (Math.random() * 1 + 1);
			int intel = 1;
			int hitPoint; //Unused


			log("Enemy zombie has stats of the following:");
			log("HP: " + health);
			log("Attack: " + atk);
			log("Defense: " + def);
			log("IQ: " + intel);
			log("");

			pause();
			
			//Enters combat with the specified mob, in this case, a Zombie.
			combatZombie(playerHP, playerSTR, playerIQ, health, atk, def, intel);
		}

	}


	int health = (int) (Math.random() * 24) + 5;
	int atk = (int) (Math.random() * 5 + 2);
	int def = (int) (Math.random() * 1 + 1);
	int intel = 1;
	int hitPoint;
	int hitChance;
	
	/*
	 * After the game recognizes the mob, battle will be initiated...
	 */

	//Battle with zombie
	public void combatZombie(int hp, int str, int iq, int mobHP, int mobATK,
			int mobDEF, int intel) {

		boolean victory = false;
		log("You tried to hit the zombie");
		pause();

		/*
		 * Calculates the Hit Chance Chances are calculated based on:
		 * 
		 * Strength: How hard it hits IQ: Hit chance
		 */
		Random random = new Random();

		//Make sure the mob HP is higher than 0 or else
		//the HP will go into negatives and the battle
		//will go on forever
			if (health != 0 && health >= 0) {
				// reportStats(health); /* =====[DEBUG]===== */
				if (str < 3 && iq < 20 && health != 0 && health < 0) {

					hitChance = random.nextInt(10) + 1;
					if (hitChance >= 5.5) {
						hitPoint = random.nextInt(10) + 1;

						health = hitMob(hitPoint, health, "Zombie", 1);
						if(health <= 0){
							return;
						}
						pause();
						// log("You have dealt " + hitPoint + "HP to" +
						// " Zombie");
						combatZombie(hp, str, iq, health, atk, def, intel);

					}

					else {
						log("You missed!");
						pause();
						combatZombie(hp, str, iq, health, atk, def, intel);
					}
				}

				else if (str < 5 && str > 3 && iq > 20 && iq < 45
						&& health != 0 && health < 0) {

					hitChance = (int) (Math.random() * 10 + 1);
					if (hitChance >= 4.5) {
						hitPoint = (int) (Math.random() * 14 + 3);

						health = hitMob(hitPoint, health, "Zombie", 1);
						if(health <= 0){
							return;
						}
						pause();
						// log("You have dealt " + hitPoint + "HP to" +
						// " Zombie");
						combatZombie(hp, str, iq, health, atk, def, intel);
					} else {
						log("You missed!");
						pause();
						combatZombie(hp, str, iq, health, atk, def, intel);
					}
				}

				else if (str < 7 && str > 5 && iq > 45 && iq < 70
						&& health != 0 && health < 0) {

					hitChance = random.nextInt(10) + 1;
					if (hitChance >= 3.5) {
						hitPoint = random.nextInt(17) + 3;

						health = hitMob(hitPoint, health, "Zombie", 1);
						pause();
						// log("You have dealt " + hitPoint + "HP to" +
						// " Zombie");
						combatZombie(hp, str, iq, health, atk, def, intel);
					}

					else {
						log("You missed!");
						pause();
						combatZombie(hp, str, iq, health, atk, def, intel);
					}
				} else {

					hitChance = random.nextInt(10) + 1;
					if (hitChance >= 5.5) {
						hitPoint = random.nextInt(10) + 2;

						health = hitMob(hitPoint, health, "Zombie", 1);
						pause();
						// log("You have dealt " + hitPoint + "HP to" +
						// " Zombie");
						combatZombie(hp, str, iq, health, atk, def, intel);
					} else {
						log("You missed!");
						pause();
						combatZombie(hp, str, iq, health, atk, def, intel);
					}
				}
			} else {
				log("Congratulations! You are victorious!");
				pause();
			}
	}

	/* Press ENTER to continue method */
	public void pause() {
		Scanner scan = new Scanner(System.in);

		log("");
		scan.nextLine();
		log("");
	}

	//The following 3 methods overloads one log method
	//So that it can print String, Integer and Boolean
	public void log(String info) {
		System.out.println(info);
	}
	
	public void log(int num){
		System.out.println(num);
	}
	
	public void log(boolean bool){
		System.out.println(bool);
	}

	// The following parameters determine how many HP does the mob have, how
	// many health does the hit take away and the enemy name
	// Current mobs are
	/* Zombies HP ranging from 1 to 29*/
	public int hitMob(int hitPoint, int enemyHealth, String enemyName, int ID) {

		log("You hit the " + enemyName + "!");
		enemyHealth = enemyHealth - hitPoint;
		log("[" + enemyName + "] Has only " + enemyHealth + " HP left!");
		if (enemyHealth <= 0) {
			//When mob dies, determine what situation is it in
			/* For a list of avaliable situations, check the Situations.info file*/
			if(ID == 1){
				log("");
			}
		}
		return enemyHealth;

	}

	// Creates a method for debugging. Checks all variables and prints to
	// console if this is toggled.

	public void reportStats(int health){
		log(health);
	}
}
//End of Class