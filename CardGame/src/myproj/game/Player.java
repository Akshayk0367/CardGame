package myproj.game;

import java.util.*;

public class Player {
	
	List<String> cardLeft;
	Set<String> cardSet;
	int playerID;
	String CurrCard;
	boolean win;
	
	
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
	
	public void updateCard(String cardID) {
		this.cardSet.remove(cardID); 
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
	public void setCurrCard(String currCard) {
		CurrCard = currCard;
	}
	
	


}
