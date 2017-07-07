package UIPodsistem;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import Model.Aplikacija;
import Model.Trener;

public class TreneriUI {
	private static class Treneri {
		private ArrayList<Trener> treneri;

		@SuppressWarnings("unused")
		public Treneri() {
		}

		public ArrayList<Trener> getT() {
			return treneri;
		}

		@JsonProperty("treneri")
		public void setT(ArrayList<Trener> t) {
			this.treneri = t;
		}
	}
	private Treneri tren;

	public Treneri getTren() {
		return tren;
	}

	@JsonProperty("tren")
	public void setTren(Treneri tren) {
		this.tren = tren;
	}

	public TreneriUI() {
		this.tren = new Treneri();
		this.tren.treneri = Aplikacija.listaTrenera;
	}

	public void iscitajTrenere() throws JsonGenerationException, JsonMappingException, IOException {
		ObjectMapper mapper = new ObjectMapper();
		this.tren = mapper.readValue(new File("Treneri.json"), this.tren.getClass());
		Aplikacija.listaTrenera = this.tren.treneri;
	}
	
	public void upisiTrenere() throws JsonGenerationException, JsonMappingException, IOException{
		ObjectMapper mapper = new ObjectMapper();
		mapper.writeValue(new File("Treneri.json"), this.tren);
	}
}
