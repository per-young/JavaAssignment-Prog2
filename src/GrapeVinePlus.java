/**
 * @author Porter Youngman
 * Java Assignment GrapeVineContinuation - GrapeVinePlus.java
 * Apr 28, 2022
 */

public class GrapeVinePlus {
	private String woodType[] = {"Pine","Oak","Mahogany","Cedar","Bocote","Sandalwood"};
	private int tableCost[] = {100,225,1210,975,6975,2600};
	private int chairCost[] = {50,110,605,485,3485,1300};
	private Product Table = new Product("Table", woodType, tableCost);
	private Product Chair = new Product("Chair", woodType, chairCost);
	public GrapeVinePlus(){
		Table.promptUser("Grape Vine", true);
		Chair.promptUser("Grape Vine", true);
	}
	public String toString() {
		return "Tables:\n" + Table + "\n--------------------------------------------------\nChairs:\n" + Chair;

	}
}
