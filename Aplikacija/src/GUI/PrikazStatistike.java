package GUI;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.text.DecimalFormat;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import Model.Igrac;
import Model.Klub;
import Model.Evidentiranje.Pokusaj;
import Model.Evidentiranje.UcinakIgraca;
import Model.Evidentiranje.Enumeracije.VrstaLicneGreske;

@SuppressWarnings("serial")
public class PrikazStatistike extends JFrame {

	public Klub domacin;
	public Klub gost;

	public PrikazStatistike(String zaglavlje, Klub domacin, Klub gost, int id) {
		this.domacin = domacin;
		this.gost = gost;
		this.setSize(900, 600);
		this.setVisible(true);
		this.setTitle("Statistika igraca");
		JPanel panel = new JPanel();
		this.postaviElemente(panel, zaglavlje, id);
		this.setContentPane(panel);
	}

	public void postaviElemente(JPanel panel, String zaglavlje, int id) {
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
		panel.add(new JLabel(zaglavlje), BorderLayout.PAGE_START);
		panel.add(Box.createVerticalStrut(25));
		String[][] podaciDomacina = izvuciPodatke(domacin, id);
		String[] kolone = { "Ime", "Prezime", "1P", "1P%", "2P", "2P%", "3P", "3P%", "SN", "SO", "Ast", "Blk", "LG",
				"Osv", "Izg" };
		JPanel panel1 = new JPanel();
		panel1.setLayout(new BoxLayout(panel1, BoxLayout.Y_AXIS));
		panel1.add(new JLabel(domacin.getNaziv()));
		JTable tabelaDomacin = new JTable(podaciDomacina, kolone);
		tabelaDomacin.setPreferredScrollableViewportSize(new Dimension(600, 50));
		tabelaDomacin.setFillsViewportHeight(true);
		JScrollPane jsp = new JScrollPane(tabelaDomacin);
		this.add(jsp);
		panel1.add(tabelaDomacin.getTableHeader(), BorderLayout.PAGE_START);
		panel1.add(tabelaDomacin);

		JPanel panel2 = new JPanel();
		panel2.setLayout(new BoxLayout(panel2, BoxLayout.Y_AXIS));
		panel2.add(new JLabel(gost.getNaziv()));
		String[][] podaciGosta = izvuciPodatke(gost, id);
		JTable tabelaGost = new JTable(podaciGosta, kolone);
		tabelaGost.setPreferredScrollableViewportSize(new Dimension(600, 50));
		tabelaGost.setFillsViewportHeight(true);
		JScrollPane jsp1 = new JScrollPane(tabelaGost);
		this.add(jsp1);
		panel2.add(tabelaGost.getTableHeader(), BorderLayout.PAGE_START);
		panel2.add(tabelaGost);
		JPanel panel3 = new JPanel();
		panel3.add(new JLabel("SN - skokovi u napadu; SO - skokovi u odbrani; Ast - asistencije"
				+ "Blk - blokade; LG - licne greske; Osv - osvojene lopte" + "Izg - izgubljene lopte"));
		panel.add(panel1);
		panel.add(Box.createVerticalStrut(25));
		panel.add(panel2);
		panel.add(Box.createVerticalStrut(25));
		panel.add(panel3);
	}

	public String[][] izvuciPodatke(Klub k, int id) {
		int brIgraca = k.igraci.size();
		String[][] podaci = new String[brIgraca][15];
		int brojac = 0;
		for (Igrac i : k.igraci) {
			String[] igracPodaci = new String[15];
			igracPodaci[0] = i.getIme();
			igracPodaci[1] = i.getPrezime();
			for (UcinakIgraca uc : i.ucinak) {
				if (uc.utakmica.getId() == id) {
					igracPodaci[8] = Integer.toString(uc.getSkokoviUNapadu());
					igracPodaci[9] = Integer.toString(uc.getSkokoviUOdbrani());
					igracPodaci[10] = Integer.toString(uc.getAsistencije());
					igracPodaci[11] = Integer.toString(uc.getBlokade());
					igracPodaci[13] = Integer.toString(uc.getOsvojeneLopte());
					igracPodaci[14] = Integer.toString(uc.izgubljeneLopteIgraca.size());
					int lg = 0, p1 = 0, p2 = 0, p3 = 0, pp1 = 0, pp2 = 0, pp3 = 0;
					for (VrstaLicneGreske vlg : uc.licneGreske) {
						if (vlg == VrstaLicneGreske.nesportskaSa1Bacanjem
								|| vlg == VrstaLicneGreske.nesportskaSa2Bacanja
								|| vlg == VrstaLicneGreske.nesportskaSa3Bacanja) {
							lg += 2;
						} else {
							lg++;
						}
					}
					igracPodaci[12] = Integer.toString(lg);
					for (Pokusaj p : uc.pokusaji) {
						if (p.getBrojPoena() == 1) {
							pp1++;
							if (p.isPogodjen()) {
								p1++;
							}
						} else if (p.getBrojPoena() == 2) {
							pp2++;
							if (p.isPogodjen()) {
								p2++;
							}
						} else if (p.getBrojPoena() == 3) {
							pp3++;
							if (p.isPogodjen()) {
								p3++;
							}
						}
					}
					igracPodaci[2] = Integer.toString(p1) + "/" + Integer.toString(pp1);
					if (pp1 != 0) {
						DecimalFormat df = new DecimalFormat("0.00");
						String procenti = df.format(p1 / (pp1 * 1.0) * 100);
						igracPodaci[3] = procenti + "%";
					} else {
						igracPodaci[3] = "0%";
					}
					igracPodaci[4] = Integer.toString(p2) + "/" + Integer.toString(pp2);
					if (pp1 != 0) {
						DecimalFormat df = new DecimalFormat("0.00");
						String procenti = df.format(p2 / (pp2 * 1.0) * 100);
						igracPodaci[5] = procenti + "%";
					} else {
						igracPodaci[5] = "0%";
					}
					igracPodaci[6] = Integer.toString(p3) + "/" + Integer.toString(pp3);
					if (pp1 != 0) {
						DecimalFormat df = new DecimalFormat("0.00");
						String procenti = df.format(p3 / (pp3 * 1.0) * 100);
						igracPodaci[7] = procenti + "%";
					} else {
						igracPodaci[7] = "0%";
					}
				}
			}
			podaci[brojac++] = igracPodaci;
		}
		return podaci;
	}
}
