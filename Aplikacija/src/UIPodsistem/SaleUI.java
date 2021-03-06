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
import Model.Sala;

public class SaleUI {

	private static class Sale {
		private ArrayList<Sala> sale;

		public Sale() {

		}

		@SuppressWarnings("unused")
		public ArrayList<Sala> getSale() {
			return sale;
		}

		@JsonProperty("sale")
		public void setSale(ArrayList<Sala> sale) {
			this.sale = sale;
		}

	}

	private Sale s;

	public SaleUI() {
		this.s = new Sale();
		this.s.sale = Aplikacija.listaSala;
	}

	public Sale getS() {
		return s;
	}
	
	@JsonProperty("s")
	public void setS(Sale s) {
		this.s = s;
	}

	public void upisiSale() throws JsonGenerationException, JsonMappingException, IOException {
		ObjectMapper mapper = new ObjectMapper();
		mapper.writeValue(new File("Sale.json"), this.s);
	}
	
	public void iscitajSale() throws JsonParseException, JsonMappingException, IOException{
		ObjectMapper mapper = new ObjectMapper();
		this.s = mapper.readValue(new File("Sale.json"), this.s.getClass());
		Aplikacija.listaSala = this.s.sale;
	}
}
