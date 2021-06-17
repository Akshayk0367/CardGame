package myproj.game;
import java.util.*;


public class CardUtil {
	
	public static void shuffleCard(List<String> cards, List<Player> players) {

		Collections.shuffle(cards);
		System.out.println("Shuffling cards...");
		
		for(int i=0; i<4; i++) {
			players.add(new Player(cards.subList(i*8, i*8+8)));
			players.get(i).setPlayerID(i+1);
			System.out.println("cards of Player "+ players.get(i).playerID + players.get(i).getCardLeft().subList(0, 4));
			
		}
		System.out.println();
	}
}
