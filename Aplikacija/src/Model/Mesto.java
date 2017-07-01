package Model;

public class Mesto {
	private int postanskiBroj;
	private String naziv;

	public Mesto() {
	}

	public Mesto(int postanskiBroj, String naziv) {
		super();
		this.postanskiBroj = postanskiBroj;
		this.naziv = naziv;
	}

	public int getPostanskiBroj() {
		return postanskiBroj;
	}

	public void setPostanskiBroj(int postanskiBroj) {
		this.postanskiBroj = postanskiBroj;
	}

	public String getNaziv() {
		return naziv;
	}

	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}

}
