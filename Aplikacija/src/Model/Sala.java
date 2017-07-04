package Model;

public class Sala {
	private String nazivSale;
	private int id;
	public Mesto mesto;

	public Sala() {
	}

	public Sala(String nazivSale, int id) {
		this.nazivSale = nazivSale;
		this.id = id;
	}

	public Sala(String nazivSale, int id, Mesto mesto) {
		super();
		this.nazivSale = nazivSale;
		this.id = id;
		this.mesto = mesto;
	}

	public String getNazivSale() {
		return nazivSale;
	}

	public void setNazivSale(String nazivSale) {
		this.nazivSale = nazivSale;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

}
