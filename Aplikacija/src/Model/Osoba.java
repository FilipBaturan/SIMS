package Model;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Osoba {
	
	private int id;
	protected String ime;
	protected String prezime;
	private Date datumRodjenja;
	public Korisnik korisnik;
	
	
	public Osoba() {}
	
	

	public Osoba(int id, String ime, String prezime, String datumRodjenja) throws ParseException {
		super();
		this.id = id;
		this.ime = ime;
		this.prezime = prezime;
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		this.datumRodjenja = sdf.parse(datumRodjenja);
	}



	public int getId() {
		return id;
	}

	@JsonProperty("id")
	public void setId(int id) {
		this.id = id;
	}

	public String getIme() {
		return ime;
	}
	
	@JsonProperty("ime")
	public void setIme(String ime) {
		this.ime = ime;
	}

	public String getPrezime() {
		return prezime;
	}
	
	@JsonProperty("prezime")
	public void setPrezime(String prezime) {
		this.prezime = prezime;
	}

	public Date getDatumRodjenja() {
		return datumRodjenja;
	}

	@JsonProperty("datumRodjenja")
	public void setDatumRodjenja(Date datumRodjenja) {
		this.datumRodjenja = datumRodjenja;
	}

}
