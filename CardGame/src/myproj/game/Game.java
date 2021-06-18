package myproj.game;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

//UD09042progress
public class Game {

	public static void main(String[] args) {
		
		List<Card> hand = new ArrayList<Card>();
		List<String> prevHand = new ArrayList<String>();
		System.out.println("                                  **************Welcome**************");
		boolean endOfGame = false;
		var CreateCards = new Card();
		var cards = CreateCards.getCardList();
		
		var GameData = new GameData();
		
		List<Player> Players = new ArrayList<>();
		CardUtil.shuffleCard(cards, Players);
		int n = 0;
		int winPlayer=0;
		
		startGame.bidding(Players,GameData);
		String Trump = startGame.setTrump(GameData);
		
		while(n<8) {
//			if(Players[0].getCardLeft().isEmpty()) {
//				endOfGame = true;
//			}
			
			for(int i = winPlayer, j=0; j<4; j++, i = (i+1)%4) {
				
				System.out.println("player " + Players.get(i).getPlayerID() + " choose your card to play");
//				System.out.println(Players.get(i).cardSet);
				CardUtil.printCards(Players.get(i).allCards);
				Scanner sc = new Scanner(System.in);
				var input = sc.next();
				if(input == "trump") {
					if(GameData.isTrumpOpen) {
						System.out.println("trump is already opened. trump is:\t" + Trump);
					}else {
						CardUtil.openTrump(Players,Trump);
						GameData.isTrumpOpen = true;
					}
				}
				else {
					var ChoosenCardIndex = Integer.parseInt(input);
					hand.add(Players.get(i).setCurrCard(ChoosenCardIndex));    	
					//Players.get(i).updateCard(Players.get(i).currentCard);
				}
			}
			GameData.setHand(hand);
			GameData.setHandPoints();
			winPlayer = findWinnerOfHand(Players);
			
			hand.clear();
			//endOfGame = true;
			n++;
		}
		DeclareWinner(GameData.getPoints());
	}
	private static void DeclareWinner(int[] points) {
		if(points[0] >= points[1]) {
			System.out.println("Team2: Player2 annd Player4 wins");
		}
		else {
			System.out.println("Team1: Player1 and Player3 wins");
		}
		
	}
	private static void updateWinner(List<Player> players, int winID) {
		
		for (int i=0; i<4; i++) {
			if (players.get(i).getPlayerID() == winID) {
				players.get(i).setWin(true);
			}
			else {
				players.get(i).setWin(false);
			}
		}
		
	}
	private static void print(List<Player> players) {
		for(int i=0; i<players.size(); i++) {
			System.out.println(players.get(i).CurrCard + "  " +  players.get(i).playerID);
		}
		
	}
	
	private static  int findWinnerOfHand(List<Player> Players) {
		List<Player> temp = new ArrayList<Player>(Players);
		Collections.sort(temp, new CardPlay());
		int winID = temp.get(0).getPlayerID();
		updateWinner(Players,winID);
		return winID-1;
 	}
}
