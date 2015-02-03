package Ankh.Cards;

public class Cards {

	private String strCardName;
	private int iCardId;
	private boolean CardPlayed;
	private String strBelongsTo;
	
	//Define Getter Setters
	public String getStrCardName()
	{		
		return strCardName;
	}	
	
	public int getiCardId()
	{		
		return iCardId;
	}
	
	public boolean getCardPlayed()
	{		
		return CardPlayed;
	}
	
	public String getstrBelongsTo()
	{		
		return strBelongsTo;
	}
	
	//Setters
	public void setStrCardName(String strCardName)
	{		
		this.strCardName = strCardName;
	}
	
	public void setiCardId(int iCardId)
	{		
		this.iCardId = iCardId;
	}
	
	public void setCardPlayed(boolean CardPlayed)
	{		
		this.CardPlayed = CardPlayed;
	}
	
	public void setstrBelongsTo(String strBelongsTo)
	{		
		this.strBelongsTo = strBelongsTo;
	}
	
	
}
