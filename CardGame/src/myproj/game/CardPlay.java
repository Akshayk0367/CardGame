package myproj.game;

import java.util.Comparator;



public class CardPlay implements Comparator<Player> {

	CreateCards rank;
	@Override
	public int compare(Player o1, Player o2) {
		var rank = new CreateCards();
		var pointMatrix = rank.cardRank();
		
//		return pointMatrix.get(o1.getCurrCard()).compareTo(pointMatrix.get(o2.getCurrCard()));
		
		if (pointMatrix.get(o1.getCurrCard())  == pointMatrix.get(o2.getCurrCard()) ) {
			return 0;
		}
		else if(pointMatrix.get(o1.getCurrCard())  >= pointMatrix.get(o2.getCurrCard())) {
			return -1;
		}
		else {
			return 1;
		}
	}
	

}
