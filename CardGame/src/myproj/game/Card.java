package myproj.game;

import java.util.*;

public class Card {
	
	int cardNumber;
	String cardFaceName;
	Suite suite;
	int cardValue;
	boolean isTrump;
	
	public Card() {}
	
	public Card(int cardNumber, Suite suite, boolean isTrump) {
		this.cardNumber = cardNumber;
		this.suite = suite;
		this.isTrump = isTrump;
		this.cardFaceName = CardUtil.calculateCardFaceName(cardNumber, suite);
		this.cardValue = CardUtil.calculateCardValue(cardNumber);
	}
	
	public Card(int cardNumber, Suite suite) {
		this(cardNumber, suite, false);
	}
	
	
	String[] cards = {"7C", "8C", "9C", "10C", "JC", "QC", "KC","1C",
			"7D", "8D", "9D", "10D", "JD", "QD", "KD","1D",
			"7H", "8H", "9H", "10H", "JH", "QH", "KH","1H",
			"7S", "8S", "9S", "10S", "JS", "QS", "KS","1S"};

	List<String> cardList = Arrays.asList(cards);
	String trump;
	
	
	public String getTrump() {
		return trump;
	}

	public void setTrump(String trump) {
		this.trump = trump;
	}

	public Set<String> createList(){
		Set<String> setList = new HashSet<String>();
		
		for (int i=0; i<32; i++) {
			setList.add(this.cards[i]);
		}
		return setList;
	}

	public List<String> getCardList() {
		return cardList;
	}

	public void setCardList(List<String> cardList) {
		this.cardList = cardList;
	}
	
} 
