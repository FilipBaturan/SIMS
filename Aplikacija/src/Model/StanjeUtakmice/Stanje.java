package Model.StanjeUtakmice;

import Model.Igrac;
import Model.Klub;
import Model.Osoba;
import Model.Utakmica;

public abstract class Stanje {
	public Utakmica utakmica;
	public abstract void entry();
	public abstract void tuca();
	public abstract void nastavak();
	public abstract void prekid();
	public abstract void zavrsetak();
	public abstract void dijalog(Osoba osoba);
	public abstract void dijalog(Klub klub);
	public abstract void selektcija(Igrac igrac);
	public abstract void azuriranje(Osoba osoba,int tip,int vrednost);
	public abstract void azuriranje(Klub klub,int tip,int vrednost);
	
}
