package Model;

public class Utakmica {
	private int id;
	private Stanje trenutnoStanje;
	private int vreme;
	public Sala sala;
	public StatistikaKluba statistikaDomacegKluba;
	public StatistikaKluba statistikaGostujucegKluba;
	public Klub domacin;
	public Klub gost;

	public Utakmica() {
	}
	
	public Utakmica(int id,Klub d, Klub g)
	{
		this.id = id;
		domacin = d;
		gost = g;
	}
	

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Utakmica(Klub d, Klub g)
	{
		domacin = d;
		gost = g;
	}
	
	public Stanje getTrenutnoStanje() {
		return trenutnoStanje;
	}

	public void setTrenutnoStanje(Stanje trenutnoStanje) {
		this.trenutnoStanje = trenutnoStanje;
	}

	public int getVreme() {
		return vreme;
	}

	public void setVreme(int vreme) {
		this.vreme = vreme;
	}

	public void promeniStanje(Stanje stanje) {
		this.trenutnoStanje = stanje;
	}

	private void otkucavanjeVremena() {
	}

	public void postaviStartere() {
	}

	public void zaustaviVreme() {

	}

	public void pokreniVreme() {

	}

	public void prikazStatistike() {

	}

	public void prikazTerena() {

	}

	public void izmena(Igrac ulazi, Igrac izlazi) {

	}
}

<<<<<<< HEAD
=======
	


>>>>>>> cc56cc9d982ee2615412bac1a212454ed1c39fb6
