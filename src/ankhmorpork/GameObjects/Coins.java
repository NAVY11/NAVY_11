package ankhmorpork.GameObjects;
import ankhmorpork.GameConstants.Constants;
public class Coins {
		
		private String coin_type;
		private Integer coin_val;
		private Integer coin_available;
		
		public Integer getCoin_Available()
		{
			return this.coin_available;
		}
		public void setCoin_Available(Integer coin_available)
		{
			this.coin_available=coin_available;
		}
		public Integer getCoin_Val()
		{
			return this.coin_val;
		}
		public void setCoin_Val(Integer coin_val)
		{
			this.coin_val=coin_val;
		}
		public String getCoin_Type()
		{
			return this.coin_type;
		}
		public void setCoin_Type(String coin_type)
		{
			this.coin_type=coin_type;
		}
		
		//Constructor
		Coins(String CoinType)
		{
			if(CoinType==Constants.GoldCoin())
			{
				this.coin_type=Constants.GoldCoin();
				this.coin_val=Constants.GoldCoinValue();
				this.coin_available=Constants.GoldCoinAvail();
			}
			if(CoinType==Constants.SilverCoin())
			{
				this.coin_type=Constants.SilverCoin();
				this.coin_val=Constants.SilverCoinValue();
				this.coin_available=Constants.SilverCoinAvail();
			}
		}
		public Coins() {
			// TODO Auto-generated constructor stub
		}
}
