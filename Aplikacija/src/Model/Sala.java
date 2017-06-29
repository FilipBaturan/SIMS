package Model;

public class Sala {
	private String nazivSale;
	private int id;

	public Sala() {
	}

	public Sala(String nazivSale, int id) {
		super();
		this.nazivSale = nazivSale;
		this.id = id;
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
