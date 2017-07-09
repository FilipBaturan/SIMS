package GUI;

import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTable;

import Model.Aplikacija;
import Model.Klub;
import Model.Osoba;
import Model.Utakmica;

@SuppressWarnings("serial")
public class IzvestajStatistike extends JFrame {
	JTable tabela;

	public IzvestajStatistike() {
		this.setSize(400, 150);
		this.setVisible(true);
		this.setLocation(420, 180);
		this.setTitle("Izvestaj izabrane utakmice");
		JPanel panel = new JPanel();
		this.postaviElemente(panel);
		this.setContentPane(panel);
	}

	public void postaviElemente(JPanel panel) {
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

		JPanel panel1 = new JPanel();
		String[] utakmice = Aplikacija.preuzmiUtakmice();
		panel1.add(new Label("Izaberite utakmicu za koju se trazi izvestaj: "));
		JComboBox<String> izbor = new JComboBox<String>(utakmice);
		panel1.add(izbor);

		panel.add(panel1);
		panel.add(Box.createVerticalStrut(25));

		JButton dugme = new JButton("Potvrdi");
		panel.add(dugme);
		panel.add(Box.createVerticalStrut(25));

		dugme.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String u = utakmice[izbor.getSelectedIndex()];
				String[] args = u.split("\\s+");
				int id = Integer.parseInt(args[1]);
				String zaglavlje = new String();
				try {
					zaglavlje = napraviZaglavlje(id);
				} catch (ParseException e1) {
					e1.printStackTrace();
				}
				;
				dispose();
				String[] klubovi = args[0].split("-");
				Klub domacin = new Klub();
				Klub gost = new Klub();
				for(Klub k : Aplikacija.listaKlubova){
					if (klubovi[0].compareTo(k.getNaziv()) == 0){
						domacin = k;
						continue;
					}
					else if(klubovi[1].compareTo(k.getNaziv())== 0){
						gost = k;
						continue;
					}
				}
				prikaziIzvestaj(zaglavlje, domacin, gost, id);

			}
		});
	}

	public void prikaziIzvestaj(String zaglavlje, Klub domacin, Klub gost, int id) {
		new PrikazStatistike(zaglavlje, domacin, gost, id);
	}

	public static String napraviZaglavlje(int id) throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy.");
		
		Utakmica ut = new Utakmica();

		for (Utakmica utakmica : Aplikacija.listaUtakmica) {
			if (id == utakmica.getId()) {
				ut = utakmica;
				break;
			}
		}
		StringBuilder strb = new StringBuilder();
		strb.append(ut.getSala().getNazivSale() + ", " + ut.getSala().mesto.getNaziv() + ", "
				+ sdf.format(ut.getDatum()) + ", ");
		strb.append("Sudije: ");
		for (Osoba sudija : ut.getSudije()) {
			strb.append(sudija.getIme() + " " + sudija.getPrezime() + ", ");
		}
		strb.append("Delegat: ");
		strb.append(ut.getDelegat().getIme() + " " + ut.getDelegat().getPrezime());
		String zaglavlje = strb.toString();
		return zaglavlje;
	}

}
