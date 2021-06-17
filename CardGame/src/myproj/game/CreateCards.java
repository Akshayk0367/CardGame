package myproj.game;

import java.util.*;

public class CreateCards {
	
	String[] cards = {"7C", "8C", "9C", "10C", "JC", "QC", "KC","1C",
			"7D", "8D", "9D", "10D", "JD", "QD", "KD","1D",
			"7H", "8H", "9H", "10H", "JH", "QH", "KH","1H",
			"7S", "8S", "9S", "10S", "JS", "QS", "KS","1S"};

	List<String> cardList = Arrays.asList(cards);
	
	public Set<String> createList(){
		Set<String> setList = new HashSet<String>();
		
		for (int i=0; i<32; i++) {
			setList.add(this.cards[i]);
		}
		return setList;
	}
	
	public Map<String, Integer> cardRank(){
		Map<String, Integer> cardPoints = new HashMap<>();
		for (int i=0; i<32; i++) {
			if(this.cards[i].contains("J")) {
				cardPoints.put(cards[i], 3);
			}
			else if(this.cards[i].contains("9")) {
				cardPoints.put(cards[i], 2);
			}
			else if(this.cards[i].contains("1")) {
				cardPoints.put(cards[i], 1);
			}
			else if(this.cards[i].contains("10")) {
				cardPoints.put(cards[i], 1);
			}
			else {
				cardPoints.put(cards[i], 0);
			}
		}
		
		return cardPoints;
		
	}

	public List<String> getCardList() {
		return cardList;
	}

	public void setCardList(List<String> cardList) {
		this.cardList = cardList;
	}
	
} 
