//
// @author Yijun He
//
 public class PokerHand implements Comparable<PokerHand> {
	 private Card card[]=new Card[5];
	 private int typeNum[] = {5,4,3,3,2,5,2,2,2};
	 private int type = 0;
	 private boolean sameColor = false;
	 private int value[] = new int[5];	 
	 private int valueWithoutColor[] = new int[5];
	 private int[] judge = new int[5];
	 public  PokerHand(Card card1,Card card2,Card card3,Card card4,Card card5)
	 {

		 this.card[0]=card1;
		 this.card[1]=card2;
		 this.card[2]=card3;
		 this.card[3]=card4;
		 this.card[4]=card5;
		 if(card1.suit == card2.suit && card2.suit == card3.suit && card3.suit == card4.suit && card4.suit == card5.suit)
		 {
			 sameColor=true;
			 type=5;
		 }//make sure the first statement, 5 cards are same color
		 sort();	
		 getvalue();
		 throwException();
		 getType();
	 }
	 void throwException()
	 {		 
		 for(int i=0;i<5;i++)
		 {
			 for(int j=i+1;j<5;j++)//compare 5 cards
			 {
				 if(value[i]==value[j])
				 {
				 DuplicateCardException myException=new DuplicateCardException();
				 throw myException;  
				 }
			 }
		 }
	 }//if 5 cards has same card, throw exception
	 void sort()
	 {
		 int j=0;
		 for(int i=0;i<5;i++)
		 {
			 for(j=0;j<5-i-1;j++)
			 {
				 if((card[j].rankTranstoInt(card[j].rank))<card[j+1].rankTranstoInt(card[j+1].rank))
				 {
					 Card tempCard=card[j];
					 card[j]=card[j+1];
					 card[j+1]=tempCard;
				 }
			 }
		 }
	 }//sort them, will easy to compare
	 void getvalue()
	 {
		 for(int i=0;i<5;i++)
		 {
			 value[i]=card[i].rankTranstoInt(card[i].rank)+card[i].suitTranstoInt(card[i].suit)*13;	
			 valueWithoutColor[i]=card[i].rankTranstoInt(card[i].rank);
		 }
	 }
	 void getType()
	 {
		 if((valueWithoutColor[0]-valueWithoutColor[1]==1||(valueWithoutColor[0]==12&&valueWithoutColor[4]==2))&&valueWithoutColor[1]-valueWithoutColor[2]==1&&valueWithoutColor[2]-valueWithoutColor[3]==1&&valueWithoutColor[3]-valueWithoutColor[4]==1)
		 {
			 if(sameColor==true)
			 {
				 type=9;
				 judge[0]=valueWithoutColor[0];
				 judge[1]=valueWithoutColor[1];
			 }
			 else
			 {
				 type=4;	
				 for(int i=0;i<5;i++)
				 {
					 judge[i]=valueWithoutColor[i];
				 }
			 }
		 }
		 else if(valueWithoutColor[0]==valueWithoutColor[1]&&valueWithoutColor[1]==valueWithoutColor[2]&&valueWithoutColor[2]==valueWithoutColor[3])
		 {
			 judge[0]=valueWithoutColor[0];
			 judge[1]=valueWithoutColor[4];
			 type=8;
		 }
		 else if(valueWithoutColor[1]==valueWithoutColor[2]&&valueWithoutColor[2]==valueWithoutColor[3]&&valueWithoutColor[3]==valueWithoutColor[4])
		 {
			 
			 judge[0]=valueWithoutColor[4];
			 judge[1]=valueWithoutColor[0];
				 type=8;	
		 }
		 else if(valueWithoutColor[3]==valueWithoutColor[2]&&valueWithoutColor[3]==valueWithoutColor[4])
		 {
			 if(valueWithoutColor[0]==valueWithoutColor[1])
			 {
				 judge[0]=valueWithoutColor[4];
				 judge[1]=valueWithoutColor[0];
				 type=7;
			 }
			 else
			 {
				 judge[0]=valueWithoutColor[4];
				 judge[1]=valueWithoutColor[0];
				 judge[2]=valueWithoutColor[1];
				 type=3;
			 }
			
		 }
		 else if(valueWithoutColor[0]==valueWithoutColor[1]&&valueWithoutColor[1]==valueWithoutColor[2])
		 {
			 if(valueWithoutColor[3]==valueWithoutColor[4])
			 {
				 judge[0]=valueWithoutColor[0];
				 judge[1]=valueWithoutColor[4];
				 type=7;
			 }
			 else
			 {
				 judge[0]=valueWithoutColor[0];
				 judge[1]=valueWithoutColor[3];
				 judge[2]=valueWithoutColor[4];
				 type=3;
			 }			
		 }
		 else if(valueWithoutColor[1]==valueWithoutColor[2]&&valueWithoutColor[2]==valueWithoutColor[3])
		 {
			 judge[0]=valueWithoutColor[1];
			 judge[1]=valueWithoutColor[0];
			 judge[2]=valueWithoutColor[4];
			 type=3;
		 }
		 else if(valueWithoutColor[0]==valueWithoutColor[1]&&valueWithoutColor[2]==valueWithoutColor[3])
		 {
			 judge[0]=valueWithoutColor[0];
			 judge[1]=valueWithoutColor[2];
			 judge[2]=valueWithoutColor[4];
			 type=2;
		 }
		 else if(valueWithoutColor[0]==valueWithoutColor[1]&&valueWithoutColor[4]==valueWithoutColor[3])
		 {
			 judge[0]=valueWithoutColor[0];
			 judge[1]=valueWithoutColor[4];
			 judge[2]=valueWithoutColor[2];
			 type=2;
		 }
		 else if(valueWithoutColor[1]==valueWithoutColor[2]&&valueWithoutColor[3]==valueWithoutColor[4])
		 {
			 judge[0]=valueWithoutColor[1];
			 judge[1]=valueWithoutColor[4];
			 judge[2]=valueWithoutColor[0];
			 type=2;
		 }
		 else if(valueWithoutColor[0]!=valueWithoutColor[1]&&valueWithoutColor[1]!=valueWithoutColor[2]&&valueWithoutColor[2]!=valueWithoutColor[3]&&valueWithoutColor[3]!=valueWithoutColor[4])
		 {
			 for(int i=0;i<5;i++)
			 {
				 judge[i]=valueWithoutColor[i];
			 }
			 type=0;
		 }
		 else 
		 {
			 for(int i=0;i<4;i++)
			 {
				 if(valueWithoutColor[i]==valueWithoutColor[i+1])
				 {
					 judge[0]=valueWithoutColor[i];
					 int k=1;
					 for(int j=0;j<5;j++)
					 {
						 if(j==i)
						 {
							 j=j+1;
						 }
						 else
						 {
							 judge[k++]=valueWithoutColor[j];
						 }
					 }
				 }
				 break;
			 }
			 type=1;
		 }
	 }
	 public int compareTo(PokerHand Other)
	 {
		 int res=-1;
		 for(int i=0;i<5;i++)
		 {
			 for(int j=i;j<5;j++)
			 {
				 if(value[i]==Other.value[j])
				 {
					 DuplicateCardException myException=new DuplicateCardException();
					 throw myException;  
				 }
			 }
		 }		 
		 if(type>Other.type)
		 {
			 res=1;
		 }
		 else if(type==Other.type)
		 {
			 if(type==4)
			 {
				 if(Other.valueWithoutColor[0]==valueWithoutColor[0]&&Other.valueWithoutColor[1]==valueWithoutColor[1])
				    res=0;
				 else if(Other.valueWithoutColor[0]<valueWithoutColor[0]&&Other.valueWithoutColor[1]<valueWithoutColor[1])
					 res=1;
				 else if(Other.valueWithoutColor[0]<valueWithoutColor[0]&&valueWithoutColor[0]==12)
					 res=-1;
				 else
					 res=-1;
			 }
			 else
			 {
			 int i=0;
			 for(i=0;i<typeNum[type];i++)
			 {
				 if(judge[i]>Other.judge[i])
				 {
					 res=1;
					 break;
				 }
				 if(judge[i]<Other.judge[i])
				 {
					 res=-1;
					 break;
				 }
			 }
			 if(i==typeNum[type])
			 {
				 res=0;
			 }
			 }
		 }	 
		 else
			 res=-1;
		 return res;
	 }
}
