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
import Model.Klub;

public class KluboviUI {
	private static class Klubovi {
		private ArrayList<Klub> klubovi;

		public Klubovi() {

		}

		@SuppressWarnings("unused")
		public ArrayList<Klub> getKlubovi() {
			return klubovi;
		}

		@JsonProperty("klubovi")
		public void setKlubovi(ArrayList<Klub> klubovi) {
			this.klubovi = klubovi;
		}

	}

	private Klubovi k;

	public KluboviUI() {
		this.k = new Klubovi();
		this.k.klubovi = Aplikacija.listaKlubova;
	}

	public Klubovi getK() {
		return k;
	}

	@JsonProperty("k")
	public void setK(Klubovi k) {
		this.k = k;
	}

	public void upisiKlubove() throws JsonGenerationException, JsonMappingException, IOException {
		ObjectMapper mapper = new ObjectMapper();
		mapper.writeValue(new File("Klubovi.json"), this.k);
	}
	
	public void iscitajKlubove() throws JsonParseException, JsonMappingException, IOException{
		ObjectMapper mapper = new ObjectMapper();
		this.k = mapper.readValue(new File("Klubovi.json"), this.k.getClass());
		Aplikacija.listaKlubova = this.k.klubovi;
	}
}
