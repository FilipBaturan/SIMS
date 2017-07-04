package Model;

public class Prekinuta extends Stanje {

	public Prekinuta() {}
	
	@Override
	protected void entry() {
		utakmica.zaustaviVreme();
		
	}

	@Override
	protected void tuca() {
		utakmica.tuca();
		utakmica.promeniStanje(new Zavrsena());
		
	}

	@Override
	protected void nastavak() {
		utakmica.pokreniVreme();
		utakmica.promeniStanje(new Odigravanje());
		
	}

	@Override
	protected void prekid() {
		
		
	}

	@Override
	protected void zavrsetak() {
		
		
	}

	@Override
	protected void dijalog(Osoba osoba) {
		
		
	}

	@Override
	protected void dijalog(Klub klub) {
		
		
	}

	@Override
	protected void selektcija(Igrac igrac) {
		
		
	}

	@Override
	protected void azuriranje(Osoba osoba, int tip, int vrednost) {
		
		
	}

	@Override
	protected void azuriranje(Klub klub, int tip, int vrednost) {
		
		
	}

}
