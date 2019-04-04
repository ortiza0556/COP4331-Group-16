enum Rank
	{
		BRONZE,SILVER,GOLD;
	}


abstract class badge{
	
	int point;
	String text;
	boolean state;//0 not gain// 1 gain
	Enum rank;
	
	
	private void checkState()
	{
		if(rank==null)
		{
			return;
		}		
		if(rank==Rank.BRONZE)
		{
			point=1;			
		}
		if(rank==Rank.SILVER)
		{
			point=10;			
		}
		if(rank==Rank.GOLD)
		{
			point=50;			
		}
		return;
	}
	
	
	
	
	
	
	
}