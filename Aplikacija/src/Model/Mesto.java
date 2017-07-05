package Model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Mesto {
	private String postanskiBroj;
	private String naziv;

	public Mesto() {
	}

	public Mesto(String postanskiBroj, String naziv) {
		super();
		this.postanskiBroj = postanskiBroj;
		this.naziv = naziv;
	}

	public String getPostanskiBroj() {
		return postanskiBroj;
	}

	@JsonProperty("postanskiBroj")
	public void setPostanskiBroj(String postanskiBroj) {
		this.postanskiBroj = postanskiBroj;
	}

	public String getNaziv() {
		return naziv;
	}

	@JsonProperty("naziv")
	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}

}
