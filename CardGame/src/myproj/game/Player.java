package myproj.game;

import java.util.*;

public class Player {
	
	List<String> cardLeft;
	Set<String> cardSet;
	int playerID;
	String CurrCard;
	boolean win;
	Card currentCard;
	List<Card> allCards;
	
	
	public Player() {
		this.cardLeft.add(null);
		this.win = false;
	}

	

	public Player(List<String> cardLeft) {
		this.cardLeft = cardLeft;
		Set<String> cardSet = new HashSet<String>();
		for(int i=0; i<8; i++) {
			cardSet.add(cardLeft.get(i));
		}
		this.cardSet = cardSet;
		this.win = false;
	}



	public List<String> getCardLeft() {
		return cardLeft;
	}

	public void setCardLeft(List<String> cardLeft) {
		this.cardLeft = cardLeft;
	}
	
	public void updateCard(Card card) {
		
		 
	}

	public Set<String> getCardSet() {
		return cardSet;
	}

	public boolean isWin() {
		return win;
	}

	public void setWin(boolean win) {
		this.win = win;
	}



	public int getPlayerID() {
		return playerID;
	}
	public String getCurrCard() {
		return CurrCard;
	}
	public void setPlayerID(int playerID) {
		this.playerID = playerID;
	}
	public Card setCurrCard(int cardIndex) {
		currentCard = this.allCards.get(cardIndex-1);
		this.allCards.get(cardIndex-1).cardFaceName = " ** ";
		return currentCard; 
	}



	public void addCards(List<Card> subList) {
		allCards = subList;
	}
	
	
	


}
