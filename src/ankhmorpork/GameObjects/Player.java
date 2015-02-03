package ankhmorpork.GameObjects;
import java.util.ArrayList;

import ankhmorpork.GameConstants.Constants;

public class Player {

	Integer player_id;
	String player_name;
	Boolean player_active;
	String player_color;
	Float player_amount;
	Integer player_personality_card_id;
	public ArrayList<Minion> lstMinions = new ArrayList<Minion>();
	public ArrayList<Building> lstBuildings = new ArrayList<Building>();	
	public Coins objGoldCoin = new Coins(Constants.GoldCoin());
	public Coins objSilverCoin = new Coins(Constants.SilverCoin());
	//public ArrayList<Coins> lstGoldCoin = new ArrayList<Coins>();
	//public ArrayList<Coins> lstSilverCoin = new ArrayList<Coins>();
	
	public Integer getPlayer_id() {
		return player_id;
	}
	public void setPlayer_id(Integer player_id) {
		this.player_id = player_id;
	}
	public String getPlayer_name() {
		return player_name;
	}
	public void setPlayer_name(String player_name) {
		this.player_name = player_name;
	}
	public Boolean getPlayer_active() {
		return player_active;
	}
	public void setPlayer_active(Boolean player_active) {
		this.player_active = player_active;
	}
	public String getPlayer_color() {
		return player_color;
	}
	public void setPlayer_color(String player_color) {
		this.player_color = player_color;
	}
	
	public Float getPlayer_amount() {
		return player_amount;
	}
	public void setPlayer_amount(Float player_amount) {
		this.player_amount = player_amount;
	}
	
	public Integer getPlayer_personality_card_id() {
		return player_personality_card_id;
	}
	public void setPlayer_personality_card_id(Integer player_personality_card_id) {
		this.player_personality_card_id = player_personality_card_id;
	}
	
	
	//Constructor
	public Player(Integer PlayerID, String PlayerName, String PlayerColour)
	{
		this.setPlayer_id(PlayerID);
		this.setPlayer_name(PlayerName);
		this.setPlayer_color(PlayerColour);
		this.setPlayer_active(true);
		
		//Create minions for this Player
		for(int i=1; i<=Constants.MinionsPerPlayer();i++)
		{
			Integer MinionID = 100*PlayerID + i;
			Integer BuildingID = MinionID;
			Integer AreaCode = 0;
			if(i<4)
			{
				if(i==1)
				{
					AreaCode=1;
				}
				else if(i==2)
				{
					AreaCode=5;
				}
				else if(i==3)
				{
					AreaCode=7;
				}
			}
			Minion objMinion = new Minion(MinionID,PlayerColour,AreaCode,PlayerID);
			this.lstMinions.add(objMinion);
			Building objBuilding = new Building(BuildingID,PlayerColour,0,PlayerID);
			this.lstBuildings.add(objBuilding);
		}
	
//		Coins GoldCoin = new Coins(Constants.GoldCoin());
//		this.lstGoldCoin.add(GoldCoin);
//		Coins SilverCoin = new Coins(Constants.SilverCoin());
//		this.lstSilverCoin.add(SilverCoin);
	
	}
	
	
	
	public Player() {
		// TODO Auto-generated constructor stub
	}
	
	
	
	
	
	
	
	
	
	
	
	
}
