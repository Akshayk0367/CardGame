package myproj.game;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;





public class startGame {
	

	public static void bidding(List<Player> players, GameData gameData) {
		int p[] = {1,2};
		int temp1=0,temp2=0;
		Scanner sc = new Scanner(System.in);
		for(int i=0; i<3; i++) {
			System.out.println("Bidding start b/w player " + p[0] + " and player " + p[1] + ". Bid to continue or -1 to pass.");
			if(i>0) {
				System.out.println("highest bid till now is: "+ gameData.getHighestBid() + ", made by Player " + gameData.getBidder());
			}
			boolean p1pass=true, p2pass = true, flag = true;
			while(p1pass && p2pass) {
				if(flag) {
					System.out.print("\nPlayer "+ p[0] + ": \t");
					temp1 = sc.nextInt();
					if(!check(temp1,gameData)) {
						gameData.setHighestBid(temp1);
						if(temp1 == -1) {
							p1pass = false;
							gameData.setHighestBid(temp2);
							gameData.setBidder(p[1]);
							p[0] = p[0]>p[1]? p[0]+1 : p[1]+1;
							break;
						}
					}else {
						continue;
					}
				}
				
				
				System.out.print("Player "+ p[1] + ": \t");
				temp2 = sc.nextInt();
				if(!check(temp2,gameData)) {
					if(temp2 == -1) {
						p2pass = false;
						gameData.setHighestBid(temp1);
						gameData.setBidder(p[0]);
						var k = p[1];
						p[1] = p[0];
						p[0] = p[0]>k? p[0]+1 : k+1;
						flag = true;
					}
				}
				else{
					flag = false;
				}
			}
		}
		System.out.println("Player " + gameData.getBidder() + "choose the highest bid: " + gameData.getHighestBid());
	}

	private static boolean check(int bid, GameData gameData) {
		if(bid <= 15 && bid >=0 || bid > 29) {
			System.out.println("Bidding range b/w 16 to 29");
			return true;
		}
		else if(bid <= gameData.getHighestBid() && bid != -1) {
			System.out.println("Invalid input. Bid value must be greater that the highest bid.");
			return true;
		}
		return false;
		
	}
}
