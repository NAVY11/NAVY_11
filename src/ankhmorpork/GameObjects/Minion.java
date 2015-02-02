package ankhmorpork.GameObjects;

public class Minion {

	Integer minion_id;
	Integer player_id;
	String color;
	Boolean active;	
	Integer area_id;
	public Integer getMinion_id() {
		return minion_id;
	}
	public void setMinion_id(Integer minion_id) {
		this.minion_id = minion_id;
	}
	public Integer getPlayer_id() {
		return player_id;
	}
	public void setPlayer_id(Integer player_id) {
		this.player_id = player_id;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public Boolean getActive() {
		return active;
	}
	public void setActive(Boolean active) {
		this.active = active;
	}
	
	public Integer getArea_id() {
		return area_id;
	}
	public void setArea_id(Integer area_id) {
		this.area_id = area_id;
	}
	
	public Minion(Integer MinionID, String Colour, Integer AreaID, Integer PlayerID)
	{
		this.setActive(true);
		this.setMinion_id(MinionID);
		this.setColor(Colour);
		this.setArea_id(AreaID);
		this.setPlayer_id(PlayerID);
	}
	public Minion() {
		// TODO Auto-generated constructor stub
	}
}
