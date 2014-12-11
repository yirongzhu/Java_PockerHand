
public class Card {
	Rank rank;
	Suit suit;
	public Card(Rank rank,Suit suit)
	{
		this.rank=rank;
		this.suit=suit;
	}
	public int suitTranstoInt(Suit suit1)
	{
		if(suit1==Suit.Diamonds)
			return 0;
		else if(suit1==Suit.Clubs)
			return 1;
		else if(suit1==Suit.Hearts)
			return 2;
		else 
			return 3;
	}
	public int rankTranstoInt(Rank rank1)
	{
		int res=0;
		if(rank1==Rank.Deuce)
			res= 0;
		else if(rank1==Rank.Three)
			res= 1;
		else if(rank1==Rank.Four)
			res= 2;
		else if(rank1==Rank.Five)
			res= 3;
		else if(rank1==Rank.Six)
			res= 4;
		else if(rank1==Rank.Seven)
			res= 5;
		else if(rank1==Rank.Eight)
			res= 6;
		else if(rank1==Rank.Nine)
			res= 7;
		else if(rank1==Rank.Ten)
			res= 8;
		else if(rank1==Rank.Jack)
			res= 9;
		else if(rank1==Rank.Queen)
			res= 10;
		else if(rank1==Rank.King)
			res= 11;
		else 	
			res= 12;
		return res;
	}
}
