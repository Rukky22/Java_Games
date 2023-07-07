package Dice_Game;

import java.util.Random;

public class PlaceDiceGame {
	private Random random = new Random();
	
	
	private static final int MONKEY_TAIL = 2;
	private static final int TRIPPLE = 3;
	private static final int SEVILLY = 7;
	private static final int MY_VENLY = 11;
	private static final int BLACK_BOX = 12;
	
	public void playGame() {
		int storedPoint = 0;
		STATUS gameSTATUS;
		
		int sumOfDice = rollDice();
		switch(sumOfDice) {
		case SEVILLY:
		case MY_VENLY:
			gameSTATUS = STATUS.WON; // If a player has 7 or 11 rolls in first roll
			break;
			
		case MONKEY_TAIL:
		case TRIPPLE:
		case BLACK_BOX:
			gameSTATUS = STATUS.LOST; // If a player has either of 2, 3 or 12 in his/her first roll
			break;
			
		default:
			gameSTATUS = STATUS.CONTINUE; // Play didn't win nor lost the game has to continue
			storedPoint = sumOfDice;
			System.out.printf("Current Point is %d\n", storedPoint);
			break;
		}
		while(gameSTATUS == STATUS.CONTINUE) {
			sumOfDice = rollDice();
			//Determine gameSTATUS
			if(sumOfDice == storedPoint) {
				gameSTATUS = STATUS.WON;
			}
			else if (sumOfDice == SEVILLY) {
				gameSTATUS = STATUS.LOST;
			}
			
		}
			// Display win or lost message to user
			if(gameSTATUS == STATUS.WON) {
				System.out.println("Player wins");
			}
			else if(gameSTATUS == STATUS.LOST) {
				System.out.println("Player lost");
			}
			else {
				System.out.println("Your chances of winning is alife");
			}
	}

	public  int rollDice() {
		//generate any dice value
		int diceOne = 1 + random.nextInt(6);
		int diceTwo = 1 + random.nextInt(6);
		
		int sum = diceOne + diceTwo;
		
		//Display the result of a roll
		System.out.printf("Player rolled %d + %d = %d\n", diceOne, diceTwo, sum);
		return sum;
	}
	

}
