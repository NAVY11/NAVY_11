package ankhmorpork.GameObjects;

public class Troll {

	Integer troll_id;	
	Boolean active;
	Integer area_id;
	public Integer getTroll_id() {
		return troll_id;
	}
	public void setTroll_id(Integer troll_id) {
		this.troll_id = troll_id;
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
	
	public Troll(Integer Troll_ID)
	{
		this.setActive(true);
		this.setArea_id(0);
		this.setTroll_id(Troll_ID);
	}
	public Troll()
	{
		
	}
}
