package ankhmorpork.GameObjects;

public class Bank {
	Float player_amount;
	Integer player_personality_card_id;	
	String cityAreaCardsListCommaSeparated;
	String personalityCardListCommaSeparated;
			
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
