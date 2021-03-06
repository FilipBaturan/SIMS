package UIPodsistem;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import Model.Aplikacija;
import Model.Korisnik;

public class KorisnikUI {
	private static class Korisnici {
		private ArrayList<Korisnik> korisnici;

		public Korisnici() {

		}

		@SuppressWarnings("unused")
		public ArrayList<Korisnik> getKorisnici() {
			return korisnici;
		}

		@JsonProperty("korisnici")
		public void setKorisnici(ArrayList<Korisnik> korisnici) {
			this.korisnici = korisnici;
		}

	}

	private Korisnici kor;

	public KorisnikUI() {
		this.kor = new Korisnici();
		this.kor.korisnici = Aplikacija.listaKorisnika;
	}

	public Korisnici getKor() {
		return kor;
	}

	@JsonProperty("kor")
	public void setKor(Korisnici kor) {
		this.kor = kor;
	}

	public void upisiKorisnike() throws JsonGenerationException, JsonMappingException, IOException {
		ObjectMapper mapper = new ObjectMapper();
		mapper.writeValue(new File("Korisnici.json"), this.kor);
	}
	
	public void iscitajKorisnike() throws JsonParseException, JsonMappingException, IOException{
		ObjectMapper mapper = new ObjectMapper();
		this.kor = mapper.readValue(new File("Korisnici.json"), this.kor.getClass());
		Aplikacija.listaKorisnika = this.kor.korisnici;
	}

}
