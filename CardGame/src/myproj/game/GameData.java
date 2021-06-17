package myproj.game;

import java.util.*;

public class GameData {
	List<String> hand;
	int Points[];
	int winPlayerID;
	CreateCards rank;
	int bidder;
	int highestBid;
	
	
	public GameData() {
		this.highestBid = 0;
	}

	public int getHighestBid() {
		return highestBid;
	}

	public void setHighestBid(int highestBid) {
		if(highestBid > this.highestBid)
		this.highestBid = highestBid;
	}

	public List<String> getHand() {
		return hand;
	}
	
	public void setHand(List<String> hand) {
		this.hand = hand;
	}
	
	public void setHandPoints() {
		int pIndex = (this.winPlayerID)%2;
		var rank = new CreateCards();
		var pointMatrix = rank.cardRank();
		for(int i=0; i<4; i++) {
			Points[pIndex] += pointMatrix.get(this.hand.get(i)); 
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

