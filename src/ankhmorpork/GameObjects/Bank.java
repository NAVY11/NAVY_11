package ankhmorpork.GameObjects;

import ankhmorpork.GameConstants.Constants;

public class Bank {
	Float player_amount;
	Integer player_personality_card_id;	
	String cityAreaCardsListCommaSeparated;
	String personalityCardListCommaSeparated;
	public Coins objGoldCoin = new Coins(Constants.GoldCoin());
	public Coins objSilverCoin = new Coins(Constants.SilverCoin());
	
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
}
