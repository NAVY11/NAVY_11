package ankhmorpork.GameObjects;

public class Building {
	Integer building_id;
	Integer player_id;
	String color;
	Boolean active;
	int area_id;
	
	public Integer getBuilding_id() {
		return building_id;
	}
	public void setBuilding_id(Integer building_id) {
		this.building_id = building_id;
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
	
	public int getArea_id() {
		return area_id;
	}
	public void setArea_id(int area_id) {
		this.area_id = area_id;
	}	
	
	public Building(Integer BuildingID, String Colour, Integer AreaID, Integer PlayerID)
	{
		this.setActive(true);
		this.setBuilding_id(BuildingID);
		this.setColor(Colour);
		this.setArea_id(AreaID);
		this.setPlayer_id(PlayerID);
	}
	public Building() {
		// TODO Auto-generated constructor stub
	}
}
