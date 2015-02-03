package ankhmorpork.GameLoad;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import org.json.JSONException;
import org.json.simple.parser.ParseException;

import ankhmorpork.Game.Game;
import ankhmorpork.GameObjects.*;

public class GameStart {

	//Start New Game
	public static Game StartNewGame(String Players[], String Colors[], int iNoOfPlayers)
		{
			Area[] AreaList = new Area[13];	
			AreaList[0]=new Area(0,0,"Not on Board",0);
			AreaList[1]=new Area(1,6,"Dolly Sisters",0);
			AreaList[2]=new Area(2,18,"Unreal Estate",0);
			AreaList[3]=new Area(3,12,"Dragon's Landing",0);
			AreaList[4]=new Area(4,18,"Small Gods",0);
			AreaList[5]=new Area(5,6,"The Scours",0);
			AreaList[6]=new Area(6,12,"The Hippo",0);
			AreaList[7]=new Area(7,6,"The Shades",0);
			AreaList[8]=new Area(8,6,"Dimwel",0);
			AreaList[9]=new Area(9,12,"Longwall",0);
			AreaList[10]=new Area(10,12,"Isle of Gods",0);
			AreaList[11]=new Area(11,18,"Seven Sleepers",0);
			AreaList[12]=new Area(12,12,"Nap Hill",0);
			
			//New Game
			Game AnkhMorpork = new Game();
			//Initialize Trolls and Players
			for(int i=1; i<4; i++)
			{
				Troll objTroll = new Troll(i);
				AnkhMorpork.lstTrolls.add(objTroll);
			}
			
			//Initialize Demons
			for(int i=1; i<5; i++)
			{
				Demon objDemon = new Demon(i);
				AnkhMorpork.lstDemons.add(objDemon);
			}
			
			//Below line can be deleted**
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		    //**
			
			
		    //Initialize Players			    
			for(int i=1;i<=iNoOfPlayers;i++)
			{				
				String Name = Players[i];
				String Color = Colors[i];
				Player objPlayer = new Player(i,Name,Color);
				AnkhMorpork.lstPlayers.add(objPlayer);	
			}
			
			//To display Output in console
			int i=1;
			for(Player objPlayer: AnkhMorpork.lstPlayers)
			{		
				System.out.println("Player "+ i + " Details");
				System.out.println("Player ID: "+objPlayer.getPlayer_id()+" Player Name:"+objPlayer.getPlayer_name()+" Player Color:"+objPlayer.getPlayer_color());
				System.out.println("Minion Details of Player "+i);
				for(Minion objMinion:objPlayer.lstMinions)
				{
					System.out.println("MinionID:"+objMinion.getMinion_id()+" MinionArea: "+objMinion.getArea_id()+" MinionColor: "+objMinion.getColor()+" PlayerID: "+objMinion.getPlayer_id());
				}
				i++;
			}
			
			return AnkhMorpork;
		}
	
//	public static void Set_Players_details(String Players[], String Colors[], int input)
//	{
//	
//	Area[] AreaList = new Area[13];	
//	AreaList[0]=new Area(0,0,"Not on Board",0);
//	AreaList[1]=new Area(1,6,"Dolly Sisters",0);
//	AreaList[2]=new Area(2,18,"Unreal Estate",0);
//	AreaList[3]=new Area(3,12,"Dragon's Landing",0);
//	AreaList[4]=new Area(4,18,"Small Gods",0);
//	AreaList[5]=new Area(5,6,"The Scours",0);
//	AreaList[6]=new Area(6,12,"The Hippo",0);
//	AreaList[7]=new Area(7,6,"The Shades",0);
//	AreaList[8]=new Area(8,6,"Dimwel",0);
//	AreaList[9]=new Area(9,12,"Longwall",0);
//	AreaList[10]=new Area(10,12,"Isle of Gods",0);
//	AreaList[11]=new Area(11,18,"Seven Sleepers",0);
//	AreaList[12]=new Area(12,12,"Nap Hill",0);
//	
//	//New Game
//	Game Ankh = new Game();
//	//Initialize Trolls and Players
//	for(int i=1; i<4; i++)
//	{
//		Troll objTroll = new Troll(i);
//		Ankh.lstTrolls.add(objTroll);
//	}
//	
//	//Initialize Demons
//	for(int i=1; i<5; i++)
//	{
//		Demon objDemon = new Demon(i);
//		Ankh.lstDemons.add(objDemon);
//	}
//	
//	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//    
//	
//	
//    //Initialize Players
//	//System.out.println("Welcome to Ankh-Morpork");	
//	//System.out.println("Enter number of Players:");
//	//Integer input=0;
//    //try {
//	//	input = Integer.parseInt(br.readLine());
//		
//	//} catch (IOException e) {
//	//	// TODO Auto-generated catch block
//	//	e.printStackTrace();
//	//}	
//    
//	for(int i=1;i<=input;i++)
//	{
//		//System.out.println("Enter Name for Player "+i);
//		//String Name = br.readLine();
//		//System.out.println("Enter Color for Player "+i);
//		//String Color = br.readLine();
//		String Name = Players[i];
//		String Color = Colors[i];
//		Player objPlayer = new Player(i,Name,Color);
//		Ankh.lstPlayers.add(objPlayer);	
//	}
//	
//	
//	int i=1;
//	for(Player objPlayer: Ankh.lstPlayers)
//	{		
//		System.out.println("Player "+ i + " Details");
//		System.out.println("Player ID: "+objPlayer.getPlayer_id()+" Player Name:"+objPlayer.getPlayer_name()+" Player Color:"+objPlayer.getPlayer_color());
//		System.out.println("Minion Details of Player "+i);
//		for(Minion objMinion:objPlayer.lstMinions)
//		{
//			System.out.println("MinionID:"+objMinion.getMinion_id()+" MinionArea: "+objMinion.getArea_id()+" MinionColor: "+objMinion.getColor()+" PlayerID: "+objMinion.getPlayer_id());
//		}
//		i++;		
//	}
//	System.out.println("Similar for rest");
//	//Know working directory
//	String current = System.getProperty("user.dir");
//    System.out.println("Current working directory in Java : " + current);
//	System.out.println("Saving to jason file");
//	try {
//		GameSave.SaveGame("Ankh11",Ankh);
//		System.out.println("Load Test");
//		//ReLoading Ankh
//		Ankh = GameLoad.LoadGame("Ankh11");
//		i=1;
//		for(Player objPlayer: Ankh.lstPlayers)
//		{		
//			System.out.println("Player "+ i + " Details");
//			System.out.println("Player ID: "+objPlayer.getPlayer_id()+" Player Name:"+objPlayer.getPlayer_name()+" Player Color:"+objPlayer.getPlayer_color());
//			i++;
//		}
//	} catch (IOException e) {
//		// TODO Auto-generated catch block
//		e.printStackTrace();
//	}
//	 catch (JSONException e) {
//		// TODO Auto-generated catch block
//		e.printStackTrace();
//	} 
//	catch (ParseException e) {
//		// TODO Auto-generated catch block
//		e.printStackTrace();
//	}
//	}
}
