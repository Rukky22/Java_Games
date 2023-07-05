package Dice_Game;

import java.util.Random;

public class PlaceDiceGame {
	private Random random = new Random();
	
	private enum status {
		CONTINUE, WON, LOST
	}
	
	private static final int MONKEY_TAIL = 2;
	private static final int TRIPPLE = 3;
	private static final int SEVILLY = 7;
	private static final int MY_VENLY = 11;
	private static final int BLACK_BOX = 12;
	
	public void playGame() {
		int storedPoint = 0;
		status gameStatus;
		
		int sumOfDice = rollDice();
		switch(sumOfDice) {
		case SEVILLY:
		case MY_VENLY:
			gameStatus = status.WON; // If a player has 7 or 11 rolls in first roll
			break;
			
		case MONKEY_TAIL:
		case TRIPPLE:
		case BLACK_BOX:
			gameStatus = status.LOST; // If a player has either of 2, 3 or 12 in his/her first roll
			break;
			
		default:
			gameStatus = status.CONTINUE; // Play didn't win nor lost the game has to continue
			storedPoint = sumOfDice;
			System.out.printf("Current Point is %d\n", storedPoint);
			break;
		}
		while(gameStatus == status.CONTINUE) {
			sumOfDice = rollDice();
			//Determine gamestatus
			if(sumOfDice == storedPoint) {
				gameStatus = status.WON;
			}
			else if (sumOfDice == SEVILLY) {
				gameStatus = status.LOST;
			}
			
		}
			// Display win or lost message to user
			if(gameStatus == status.WON) {
				System.out.println("Player wins");
			}
			else if(gameStatus == status.LOST) {
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
