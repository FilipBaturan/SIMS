package Model;

public class Utakmica {
	private Stanje trenutnoStanje;
	private Klub domacin;
	private Klub gost;


	public Utakmica()
	{
		
	}
	
	public Utakmica(Klub d, Klub g)
	{
		domacin = d;
		gost = g;
	}
}