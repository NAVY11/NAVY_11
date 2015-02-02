package ankhmorpork.GameObjects;

import java.util.ArrayList;
import java.util.HashMap;


public class Area {

	private Integer area_id = 0;
	private String area_name;
	private Integer area_cost;
	private Integer belongs_to;
	
	public Integer getAreaID()
	{
		return area_id;
	}
	public void setAreaID(Integer area_id)
	{
		this.area_id= area_id;
	}
	
	public Integer getAreaCost()
	{
		return area_cost;
	}
	public void setAreaCost(Integer area_cost)
	{
		this.area_cost= area_cost;
	}
	public String getAreaName()
	{
		return area_name;
	}
	public void setAreaName(String area_name)
	{
		this.area_name= area_name;
	}
	public Integer getAreaBelongsTo()
	{
		return belongs_to;
	}
	public void setAreaBelongsTo(Integer belongs_to)
	{
		this.belongs_to= belongs_to;
	}
	
	public Area(Integer AreaID, Integer AreaCost, String AreaName, Integer BelongsTo)
	{
		area_id=AreaID;
		area_cost=AreaCost;
		area_name=AreaName;
		belongs_to=BelongsTo;
	}
	
	public static ArrayList<Minion> lstMinions = new ArrayList<Minion>();
	public static ArrayList<TroubleMaker> lstTroubleMakers = new ArrayList<TroubleMaker>();
	public static ArrayList<Building> lstBuildings = new ArrayList<Building>();
	public static ArrayList<Demon> lstDemons = new ArrayList<Demon>();
	public static ArrayList<Troll> lstTrolls = new ArrayList<Troll>();
	
	public ArrayList<Area> getListOfMinionsByAreaIdArr(){
		ArrayList<Area> areaListArr = new ArrayList<Area>();
		
		for(int i = 1; i <= 12; i++){
			
		}
		return areaListArr;
	}
	
	public HashMap<Integer, String> getAreaIdAndStrOfMinions(){
		
		HashMap<Integer, String> mapOfAreaIdAndStrOfMinions = new HashMap<Integer, String>();  
		for(int i = 1; i < 12; i++){
			mapOfAreaIdAndStrOfMinions.put(i, getListOfMinionsByAreaId(i));
		}
		return mapOfAreaIdAndStrOfMinions;
	}
	
	public static String getListOfMinionsByAreaId(Integer cityAreaId){
		
		String listOfMinionsByColorId = "";
		for(Minion lstMinion : lstMinions){
			if(cityAreaId == lstMinion.getArea_id()){
				listOfMinionsByColorId += ""+lstMinion.getColor()+",";
			}
		}
		if (listOfMinionsByColorId.endsWith(",")) {
			listOfMinionsByColorId = listOfMinionsByColorId.substring(0, listOfMinionsByColorId.length() - 1);
		}else{
			listOfMinionsByColorId = "none";
		}
		
		return listOfMinionsByColorId; 
	}
	
	public HashMap<Integer, String> getAreaIdAndStrOfTroubleMakers(){
		
		HashMap<Integer, String> mapOfAreaIdAndStrOfTroubleMakers = new HashMap<Integer, String>();  
		for(int i = 1; i < 12; i++){
			mapOfAreaIdAndStrOfTroubleMakers.put(i, getListOfTroubleMakersByAreaId(i));
		}
		return mapOfAreaIdAndStrOfTroubleMakers;
	}
	
	public static String getListOfTroubleMakersByAreaId(Integer cityAreaId){
		
		String listOfTroubleMakersByColorId = "no";
		for(TroubleMaker lstTroubleMaker : lstTroubleMakers){
			if(cityAreaId == lstTroubleMaker.getArea_id()){
				listOfTroubleMakersByColorId ="yes";
				break;
			}
		}
		
		return listOfTroubleMakersByColorId; 
	}
	
	public HashMap<Integer, String> getAreaIdAndStrOfBuildings(){
		
		HashMap<Integer, String> mapOfAreaIdAndStrOfBuildings = new HashMap<Integer, String>();  
		for(int i = 1; i < 12; i++){
			mapOfAreaIdAndStrOfBuildings.put(i, getListOfBuildingsByAreaId(i));
		}
		return mapOfAreaIdAndStrOfBuildings;
	}
	
	public static String getListOfBuildingsByAreaId(Integer cityAreaId){
		
		String listOfBuildingsByColorId = "no";
		for(Building lstBuilding : lstBuildings){
			if(cityAreaId == lstBuilding.getArea_id()){
				listOfBuildingsByColorId ="yes";
				break;
			}
		}
		
		return listOfBuildingsByColorId; 
	}
	
	public HashMap<Integer, Integer> getAreaIdAndStrOfDemons(){
		
		HashMap<Integer, Integer> mapOfAreaIdAndStrOfDemons = new HashMap<Integer, Integer>();  
		for(int i = 1; i < 12; i++){
			mapOfAreaIdAndStrOfDemons.put(i, getListOfDemonsByAreaId(i));
		}
		return mapOfAreaIdAndStrOfDemons;
	}
	
	public static int getListOfDemonsByAreaId(Integer cityAreaId){
		
		int listOfDemonsByColorId = 0;
		for(Demon lstDemon : lstDemons){
			if(cityAreaId == lstDemon.getArea_id()){
				listOfDemonsByColorId = 1;
				break;
			}
		}
		
		return listOfDemonsByColorId; 
	}
	
	public HashMap<Integer, Integer> getAreaIdAndStrOfTrolls(){
		
		HashMap<Integer, Integer> mapOfAreaIdAndStrOfTrolls = new HashMap<Integer, Integer>();  
		for(int i = 1; i < 12; i++){
			mapOfAreaIdAndStrOfTrolls.put(i, getListOfTrollsByAreaId(i));
		}
		return mapOfAreaIdAndStrOfTrolls;
	}
	
	public static int getListOfTrollsByAreaId(Integer cityAreaId){
		
		int listOfTrollsByColorId = 0;
		for(Troll lstDemon : lstTrolls){
			if(cityAreaId == lstDemon.getArea_id()){
				listOfTrollsByColorId = 1;
				break;
			}
		}
		
		return listOfTrollsByColorId; 
	}
}

	
	

