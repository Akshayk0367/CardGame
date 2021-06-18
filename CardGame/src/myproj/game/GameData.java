package myproj.game;

import java.util.*;

public class GameData {
	List<Card> hand;
	int Points[];
	int winPlayerID;
	int bidder;
	int highestBid;
	String trump;
	boolean isTrumpOpen;
	
	
	public GameData() {
		this.highestBid = 0;
		this.isTrumpOpen = false;
		this.Points = new int[2];
		this.Points[0] = 0;
		this.Points[1] = 0;
	}

	public String getTrump() {
		return trump;
	}

	public void setTrump(String string) {
		this.trump = string;
	}


	public int getHighestBid() {
		return highestBid;
	}

	public void setHighestBid(int highestBid) {
		if(highestBid > this.highestBid)
		this.highestBid = highestBid;
	}

	public List<Card> getHand() {
		return hand;
	}
	
	public void setHand(List<Card> hand) {
		this.hand = hand;
	}
	
	public void setHandPoints() {
		int pIndex = (this.winPlayerID)%2;
		
		for(int i=0; i<4; i++) {
			Points[pIndex] += this.hand.get(i).cardValue;
		}
	}
	public int getWinPlayerID() {
		return winPlayerID;
	}
	public void setWinPlayerID(int winPlayerID) {
		this.winPlayerID = winPlayerID;
	}

	public int[] getPoints() {
		return Points;
	}

	public int getBidder() {
		return bidder;
	}

	public void setBidder(int bidder) {
		this.bidder = bidder;
	}
	
	
	
	
}

