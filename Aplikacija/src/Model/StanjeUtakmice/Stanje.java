package Model.StanjeUtakmice;

import java.text.ParseException;

import Model.Igrac;
import Model.Klub;
import Model.Osoba;
import Model.Utakmica;

public abstract class Stanje {
	public Utakmica utakmica;
	public abstract void entry();
	public abstract void tuca() throws ParseException;
	public abstract void do_();
	public abstract void nastavak() throws ParseException;
	public abstract void prekid() throws ParseException;
	public abstract void zavrsetak() throws ParseException;
	public abstract void dijalog(Osoba osoba);
	public abstract void dijalog(Klub klub);
	public abstract void selektcija(Igrac igrac);
	public abstract void azuriranje(int tip,int vrednost,int zona);
	public abstract void azuriranje(int tip,int vrednost);
	
}
