package Model.StanjeUtakmice;

import java.text.ParseException;

import GUI.PrekinutDijalog;
import Model.Igrac;
import Model.Klub;
import Model.Osoba;
import Model.Utakmica;

public class Prekinuta extends Stanje {

	public Prekinuta() {}
	
	public Prekinuta(Utakmica utakmica){
		this.utakmica = utakmica;
	}
	
	@Override
	public void entry() {
		utakmica.setPokrenut(false);
		new PrekinutDijalog(utakmica);
		
	}

	@Override
<<<<<<< HEAD
	public void tuca() throws ParseException {
		for(StatistikaKluba it:utakmica.domacin.statistikaKluba){
			if(it.utakmica == utakmica){
				it.licneGreske.add(VrstaLicneGreske.tuca);
				break;
			}
		}
		for(StatistikaKluba it:utakmica.gost.statistikaKluba){
			if(it.utakmica == utakmica){
				it.licneGreske.add(VrstaLicneGreske.tuca);
				break;
			}
		}
=======
	public void tuca() {
		utakmica.evidentirajTucu();
>>>>>>> e28a7b5c783406b09c822461dc364409126fb519
		utakmica.promeniStanje(new Zavrsena(utakmica));
		
	}

	@Override
	public void nastavak() throws ParseException{
		utakmica.setPokrenut(true);
		utakmica.promeniStanje(new Odigravanje(utakmica));
		
	}

	@Override
	public void prekid() {
		
		
	}

	@Override
	public void zavrsetak() {
		
		
	}

	@Override
	public void dijalog(Osoba osoba) {
		
		
	}

	@Override
	public void dijalog(Klub klub) {
		
		
	}

	@Override
	public void selektcija(Igrac igrac) {
		
		
	}

	@Override
	public void azuriranje( int tip, int vrednost,int zona) {
		
		
	}

	@Override
	public void azuriranje( int tip, int vrednost) {
		
		
	}

	@Override
	public void do_() {
		
		
	}

}
