package ankhmorpork.GameObjects;

public class Demon {

	Integer demon_id;	
	Boolean active;	
	Integer area_id;
	public Integer getDemon_id() {
		return demon_id;
	}
	public void setDemon_id(Integer demon_id) {
		this.demon_id = demon_id;
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
	
	public Demon(Integer Demon_ID)
	{
		this.setActive(true);
		this.setArea_id(0);
		this.setDemon_id(Demon_ID);
	}
	public Demon()
	{
		
	}
}
