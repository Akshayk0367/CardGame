package myproj.game;
import java.util.*;


public class CardUtil {
	
	public static void shuffleCard(List<String> cards, List<Player> players) {
		
		List<Card> allPlayableCards = getPlayableCards();
		setCardName(allPlayableCards);
		
		Collections.shuffle(allPlayableCards);
		System.out.println("Shuffling cards...");
		
		for(int i=0; i<4; i++) {
			Player player = new Player(cards.subList(i*8, i*8+8));
			player.addCards(allPlayableCards.subList(i*8, i*8+8));
			players.add(player);
			players.get(i).setPlayerID(i+1);
			printCards(allPlayableCards.subList(i*8, i*8+4));
			
		}
		System.out.println();
	}
	public static void enableTrump(List<Card> allCards, Suite trump) {
		for(int i=0; i<allCards.size(); i++) {
			if(allCards.get(i).suite == trump) {
				allCards.get(i).isTrump = true;
			}
		}
	}
	public static void printCards(List<Card> allPlayableCards) {
		for(int i=0; i<allPlayableCards.size(); i++) {
			System.out.print(allPlayableCards.get(i).cardFaceName +", ");
		}
		System.out.println();
		
	}
	public static void setCardName(List<Card> allcards) {
		for(int i=0; i<32; i++) {
			int cardNumber = allcards.get(i).cardNumber;
			Suite s = allcards.get(i).suite;
			allcards.get(i).cardFaceName = calculateCardFaceName(cardNumber,s);
		}
	}

	private static List<Card> getPlayableCards() {
		List<Card> allCards = new ArrayList<>();
		for(int i=6 ; i<14; i++) {
			int j = i;
			if(j==6) {
				j = 1;
			}
			allCards.add(new Card(j, Suite.CLUB));
			allCards.add(new Card(j, Suite.DIAMOND));
			allCards.add(new Card(j, Suite.HEART));
			allCards.add(new Card(j, Suite.SPADE));
			for(int k=0; k<4; k++) {
				allCards.get(k).cardValue = calculateCardValue(j); // initialize card points.
			}
		}
		
		return allCards;
	}

	public static String calculateCardFaceName(int cardNumber, Suite suite) {
		if(cardNumber >= 2 && cardNumber <= 10) {
			return "" + cardNumber + suite.name().charAt(0);
		}
		else if(cardNumber == 1) {
			return "Ace-" + suite.name().charAt(0);
		}
		else if(cardNumber == 11) {
			return "Jack-" + suite.name().charAt(0);
		}
		else if(cardNumber == 12) {
			return "Queen-" + suite.name().charAt(0);
		}
		else if(cardNumber == 13) {
			return "King-" + suite.name().charAt(0);
		}
		return null;
	}

	public static int calculateCardValue(int cardNumber) {
		if(cardNumber == 1 || cardNumber == 10) {
			return 1;
		} else if (cardNumber == 9) {
			return 2;
		} else if (cardNumber == 11) {
			return 3;
		}
		return 0;
	}
	public static void openTrump(List<Player> players, String trump) {
		for(int i=0; i<players.size(); i++) {
			enableTrump(players.get(i).allCards,Suite.valueOf(trump));
		}
		
	}
	
//	public static void main(String[] args) {
////		System.out.println(calculateCardFaceName(2, Suite.CLUB));
//
//		List<Card> allPlayableCards = getPlayableCards();
//		setCardName(allPlayableCards);
//		for(int i=0; i<4; i++) {
//			printCards(allPlayableCards,i);//
//		}
//		System.out.println("----------");
//	}
	
	
}
