package ankhmorpork.GameObjects;
import java.util.ArrayList;

import PresentationUtilityCommon.PresentationUtility;
import ankhmorpork.GameConstants.Constants;

public class Player {

	Integer player_id;
	String player_name;
	Boolean player_active;
	String player_color;
//	Float player_amount;
	Integer player_personality_card_id;
	String brownCardListCommaSeparated;
	String greenCardListCommaSeparated;
	String cityAreaCardsListCommaSeparated;
	String personalityCardListCommaSeparated;
	public Coins objGoldCoin = new Coins(Constants.GoldCoin());
	public Coins objSilverCoin = new Coins(Constants.SilverCoin());
	
	public String getBrownCardListCommaSeparated() {
		return brownCardListCommaSeparated;
	}
	public void setBrownCardListCommaSeparated(String brownCardListCommaSeparated) {
		this.brownCardListCommaSeparated = brownCardListCommaSeparated;
	}
	public String getGreenCardListCommaSeparated() {
		return greenCardListCommaSeparated;
	}
	public void setGreenCardListCommaSeparated(String greenCardListCommaSeparated) {
		this.greenCardListCommaSeparated = greenCardListCommaSeparated;
	}
	public String getCityAreaCardsListCommaSeparated() {
		return cityAreaCardsListCommaSeparated;
	}
	public void setCityAreaCardsListCommaSeparated(
			String cityAreaCardsListCommaSeparated) {
		this.cityAreaCardsListCommaSeparated = cityAreaCardsListCommaSeparated;
	}
	public String getPersonalityCardListCommaSeparated() {
		return personalityCardListCommaSeparated;
	}
	public void setPersonalityCardListCommaSeparated(
			String personalityCardListCommaSeparated) {
		this.personalityCardListCommaSeparated = personalityCardListCommaSeparated;
	}

	public ArrayList<Minion> lstMinions = new ArrayList<Minion>();
	public ArrayList<Building> lstBuildings = new ArrayList<Building>();
	public ArrayList<Demon> lstDemons = new ArrayList<Demon>();
	public ArrayList<Troll> lststTrolls = new ArrayList<Troll>();
	
	ArrayList<Integer> initializingBrownCardsArr = PresentationUtility.initializeAArrayWithValue(53);
	ArrayList<Integer> initializingGreenCardsArr = PresentationUtility.initializeAArrayWithValue(48);
	ArrayList<Integer> initializingCityAreaCardsArr = PresentationUtility.initializeAArrayWithValue(12);
	ArrayList<Integer> initializingPersonalityArr = PresentationUtility.initializeAArrayWithValue(7);
	
	//HashMap<Integer, Boolean> initializingBrownCards = PresentationUtility.initializeAHashmapWithValue(53);
	//HashMap<Integer, Boolean> initializingGreenCards = PresentationUtility.initializeAHashmapWithValue(48);
	//HashMap<Integer, Boolean> initializingCityAreaCards = PresentationUtility.initializeAHashmapWithValue(12);
	//HashMap<Integer, Boolean> initializingPersonalityCards = PresentationUtility.initializeAHashmapWithValue(7);
	
	String getFiveDifferentBrownNumbers = "", getFiveDifferentGreenNumbers = "";
	Integer getOneDifferentPersonalityCard;
	public ArrayList<Coins> lstGoldCoin = new ArrayList<Coins>();
	public ArrayList<Coins> lstSilverCoin = new ArrayList<Coins>();
	
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
//	public Float getPlayer_amount() {
//		return player_amount;
//	}
//	public void setPlayer_amount(Float player_amount) {
//		this.player_amount = player_amount;
//	}
	
	public Integer getPlayer_personality_card_id() {
		return player_personality_card_id;
	}
	public void setPlayer_personality_card_id(Integer player_personality_card_id) {
		this.player_personality_card_id = player_personality_card_id;
	}
	
	public int getPlayerAmount()
	{
		int iTotalAmount = 0;
		iTotalAmount = this.objGoldCoin.getCoin_Available()*this.objGoldCoin.getCoin_Val() + this.objSilverCoin.getCoin_Val()*this.objSilverCoin.getCoin_Available();
		return iTotalAmount;
	}
	//Constructor
	public Player(Integer PlayerID, String PlayerName, String PlayerColour){
		this.setPlayer_id(PlayerID);
		this.setPlayer_name(PlayerName);
		this.setPlayer_color(PlayerColour);
		this.setPlayer_active(true);
		
		//Create minions for this Player
		for(int i=1; i<=Constants.MinionsPerPlayer();i++){
			
			Integer MinionID = 100*PlayerID + i;
			Integer BuildingID = MinionID;
			Integer AreaCode = 0;
			if(i<4){
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
		getFiveDifferentBrownNumbers = "";
		getFiveDifferentGreenNumbers = "";
		
		int countBrownCard = 0;
		int countGreenCard = 0;
		/*
		 * while(true){
			Integer randomNumber = PresentationUtility.returnRandomNumber(1, 53);
			if(randomNumber > 0){
				if(initializingBrownCards.containsKey(randomNumber)){
					getFiveDifferentBrownNumbers += randomNumber+",";
					countBrownCard += 1;
					initializingBrownCards.remove(randomNumber);
				}
				if(countBrownCard == 5){
					if (getFiveDifferentBrownNumbers.endsWith(",")) {
						getFiveDifferentBrownNumbers = getFiveDifferentBrownNumbers.substring(0, getFiveDifferentBrownNumbers.length() - 1);
					}
					//Create Brown Card Object and assign cards
					System.out.print("PlayerId : "+ PlayerID + " - Brown Card: " + getFiveDifferentBrownNumbers + "\n");
					break;
				}
			}
		}
		 */
		while(true){
			Integer randomIndexNumber = PresentationUtility.returnRandomNumber(1, initializingBrownCardsArr.size());
			Integer randomNumberAtIndexNumber = initializingBrownCardsArr.get(randomIndexNumber);
			
			if(randomNumberAtIndexNumber > 0){
				getFiveDifferentBrownNumbers += randomNumberAtIndexNumber+",";
				countBrownCard += 1;
				initializingBrownCardsArr.remove(randomNumberAtIndexNumber);
			
				if(countBrownCard == 5){
					if (getFiveDifferentBrownNumbers.endsWith(",")) {
						getFiveDifferentBrownNumbers = getFiveDifferentBrownNumbers.substring(0, getFiveDifferentBrownNumbers.length() - 1);
					}
					
					setBrownCardListCommaSeparated(getFiveDifferentBrownNumbers);
					//Create Brown Card Object and assign cards
					System.out.print("PlayerId : "+ PlayerID + " - Brown Card: " + getFiveDifferentBrownNumbers + "\n");
					break;
				}
			}
		}
		/*
		 * while(true){
			Integer randomNumber = PresentationUtility.returnRandomNumber(1, 48);
			if(randomNumber > 0){
				if(initializingGreenCards.containsKey(randomNumber)){
					getFiveDifferentGreenNumbers += randomNumber+",";
					countGreenCard += 1;
					initializingBrownCards.remove(randomNumber);
				}
				if(countGreenCard == 5){
					if (getFiveDifferentGreenNumbers.endsWith(",")) {
						getFiveDifferentGreenNumbers = getFiveDifferentGreenNumbers.substring(0, getFiveDifferentGreenNumbers.length() - 1);
					}
					System.out.print("PlayerId : "+ PlayerID + " - Green Card: " + getFiveDifferentGreenNumbers + "\n");
					//Create Green Card Object and assign cards
					break;
				}
			}
		}
		
		 */
		
		while(true){
			Integer randomIndexNumber = PresentationUtility.returnRandomNumber(1, initializingGreenCardsArr.size());
			Integer randomNumberAtIndexNumber = initializingGreenCardsArr.get(randomIndexNumber);
			
			if(randomNumberAtIndexNumber > 0){
				getFiveDifferentGreenNumbers += randomNumberAtIndexNumber+",";
				countGreenCard += 1;
				initializingGreenCardsArr.remove(randomNumberAtIndexNumber);
			
				if(countGreenCard == 5){
					if (getFiveDifferentGreenNumbers.endsWith(",")) {
						getFiveDifferentGreenNumbers = getFiveDifferentGreenNumbers.substring(0, getFiveDifferentGreenNumbers.length() - 1);
					}
					setGreenCardListCommaSeparated(getFiveDifferentGreenNumbers);
					//Create Green Card Object and assign cards
					System.out.print("PlayerId : "+ PlayerID + " - Green Card: " + getFiveDifferentGreenNumbers + "\n");
					break;
				}
			}
		}

		Integer randomIndexNumber = PresentationUtility.returnRandomNumber(1, initializingPersonalityArr.size());
		Integer randomNumberAtIndexNumber = initializingPersonalityArr.get(randomIndexNumber);
		
		if(randomNumberAtIndexNumber > 0){
			getOneDifferentPersonalityCard = randomNumberAtIndexNumber;
			initializingPersonalityArr.remove(randomNumberAtIndexNumber);
			setPersonalityCardListCommaSeparated(getOneDifferentPersonalityCard+"");
			//Create One Different Personality Card
			System.out.print("PlayerId : "+ PlayerID + " - Personality Card: " + getOneDifferentPersonalityCard + "\n");
		}
	}
	public Player() {
		// TODO Auto-generated constructor stub
	}
	
	
	
	
	
	
	
	
	
	
	
	
}
