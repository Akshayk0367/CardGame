package myproj.game;

import java.util.Comparator;



public class CardPlay implements Comparator<Player> {

//	Card rank;
	
	public int compare(Player o1, Player o2) {
//		var rank = new Card();
//		var pointMatrix = rank.cardRank();
//		Card card1 = o1.getCurrCard();
//		Card card2 = o1.getCurrCard();
		
//		return pointMatrix.get(o1.getCurrCard()).compareTo(pointMatrix.get(o2.getCurrCard()));
		
		
		if(o1.currentCard.isTrump && !o2.currentCard.isTrump) {
			return -1;
		}
		else if(!o1.currentCard.isTrump && o2.currentCard.isTrump) {
			return 1;
		}
		else {
			if(o1.currentCard.cardValue == o2.currentCard.cardValue) {
				return 0;
			}
			else if(o1.currentCard.cardValue >= o2.currentCard.cardValue) {
				return -1;
			}
			else
				return 1;
		}
		
	}
	
	
	/*
	 * Card
	 * 	isTrump: bool
	 *  point: int
	 *  name: string (1A)
	 *  suite
	 * */
	

}
