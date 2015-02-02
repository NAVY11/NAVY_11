package ankhmorpork.GameConstants;

public class Constants {

	Constants()
	{
		
	}
	//Constants declaration
	
	//Constants for Coins////////////////////////////////
	private static String GoldCoin="GC";
	private static Integer GoldCoinVal=5;
	private static String SilverCoin="SC";
	private static Integer SilverCoinVal=1;
	private static Integer GoldCoinAvail=1;
	private static Integer SilverCoinAvail=5;
	
	//Methods to get Constants
	public static String GoldCoin()
	{
		return GoldCoin;
	}
	public static String SilverCoin()
	{
		return SilverCoin;
	}
	public static Integer GoldCoinValue()
	{
		return GoldCoinVal;
	}
	public static Integer SilverCoinValue()
	{
		return SilverCoinVal;
	}
	public static Integer GoldCoinAvail()
	{
		return GoldCoinAvail;
	}
	public static Integer SilverCoinAvail()
	{
		return SilverCoinAvail;
	}
	///////End of Coins////////////////////////////////////////////
	
	//Constants for Pieces//////////////////////////////////////////
	
	private static Integer MinionsPerPlayer=12;
	private static Integer BuildingsPerPlayer=6;
	
	public static Integer MinionsPerPlayer()
	{
		return MinionsPerPlayer;
	}
	public static Integer BuildingsPerPlayer()
	{
		return BuildingsPerPlayer;
	}
	
	//End of Pieces////////////////////////////////////////////////
}
