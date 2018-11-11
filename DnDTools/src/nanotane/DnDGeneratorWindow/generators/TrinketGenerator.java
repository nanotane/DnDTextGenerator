package nanotane.DnDGeneratorWindow.generators;

import java.util.List;
import java.util.Random;

public class TrinketGenerator {
	
	public static String genTrinket()
	{
		Random rand = new Random();
		int itemPlace = rand.nextInt(sTrinkets.size());
		return "TRINKET: " + sTrinkets.get(itemPlace);
	}
	
	public static String genUniqueTrinket()
	{
		Random rand = new Random();
		int itemPlace = rand.nextInt(sTrinkets.size());
		return "M-TRINKET: " + sTrinkets.get(itemPlace);
	}

	public static List<String> sTrinkets = ReadFileUtil.getList("Master_Trinket_List.txt");
	public static List<String> sUniqueTrinkets = ReadFileUtil.getList("Unique_Trinket.txt");
}
