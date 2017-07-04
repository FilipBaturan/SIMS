package Model;

public abstract class Stanje {
	public Utakmica utakmica;
	protected abstract void entry();
	protected abstract void tuca();
	protected abstract void nastavak();
	protected abstract void prekid();
	protected abstract void zavrsetak();
	protected abstract void dijalog(Osoba osoba);
	protected abstract void dijalog(Klub klub);
	protected abstract void selektcija(Igrac igrac);
	protected abstract void azuriranje(Osoba osoba,int tip,int vrednost);
	protected abstract void azuriranje(Klub klub,int tip,int vrednost);
	
}
