package GUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Ellipse2D;
import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.util.Timer;
import java.util.TimerTask;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTable;

import Model.Igrac;
import Model.Klub;
import Model.Utakmica;

@SuppressWarnings("serial")
public class PrikazUtakmice extends JFrame {
	private Utakmica utakmica;
	private Timer timer;
	private JLabel vreme;
	public static PanelTima domaciTim;
	public static PanelTima gostojuciTim;

	public PrikazUtakmice(Utakmica utakmica) throws ParseException {
		this.utakmica = utakmica;
		timer = new Timer();
		this.setTitle("Prikaz utakmice");
		this.setVisible(true);
		this.setLocation(250, 50);
		this.setSize(1000, 700);
		JSplitPane glavniPanel = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT);
		glavniPanel.setEnabled(false);
		this.postaviElemente(glavniPanel, utakmica.domacin, utakmica.gost);
		this.setContentPane( glavniPanel);
		refresh();
		utakmica.pocetak();
	}

	private void postaviElemente(JSplitPane glavniPanel, Klub domacin, Klub gost) {
		
		
		JSplitPane desniPanel = new JSplitPane(JSplitPane.VERTICAL_SPLIT);
		desniPanel.setEnabled(false);
		desniPanel.setEnabled(false);
		desniPanel.setBorder(BorderFactory.createLineBorder(Color.black) );
		domaciTim = new PanelTima(domacin, utakmica);
		
		JSplitPane donjiPanel = new JSplitPane(JSplitPane.VERTICAL_SPLIT);
		donjiPanel.setEnabled(false);
		JPanel prelazstanja = new JPanel();
		JButton prekid = new JButton("Prekini");
		
		prekid.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					utakmica.prekid();
				} catch (ParseException e1) {
					e1.printStackTrace();
				}
				
			}
		});
		prelazstanja.add(prekid);
		
		
		gostojuciTim = new PanelTima(gost, utakmica);
		
		donjiPanel.setTopComponent(gostojuciTim);
		donjiPanel.setBottomComponent(prelazstanja);
		donjiPanel.setDividerLocation(this.getHeight() / 5 * 2);
		
		desniPanel.setTopComponent(domaciTim);
		desniPanel.setBottomComponent(donjiPanel);
		desniPanel.setDividerLocation(250);
		
		JSplitPane leviPanel = new JSplitPane(JSplitPane.VERTICAL_SPLIT);
		leviPanel.setEnabled(false);
		
		
		JPanel podaciTima = new JPanel();
		podaciTima.setLayout(new BoxLayout(podaciTima, BoxLayout.X_AXIS));
		JLabel nazivDomacina = new JLabel();
		nazivDomacina.setText(domacin.getNaziv());
		nazivDomacina.setFont(new Font("Serif", Font.PLAIN, 19));
		vreme = new JLabel("0:00");
		JLabel nazivGosta = new JLabel();
		nazivGosta.setText(gost.getNaziv());
		nazivGosta.setFont(new Font("Serif", Font.PLAIN, 19));
		
		podaciTima.add(Box.createVerticalStrut(5));
		podaciTima.add(nazivDomacina);
		podaciTima.add(Box.createVerticalStrut(5));
		podaciTima.add(vreme);
		podaciTima.add(Box.createVerticalStrut(5));
		podaciTima.add(nazivGosta);
		podaciTima.add(Box.createVerticalStrut(5));
		
		Teren panelZaSliku = new Teren(utakmica);
		
		int i1 = 0;
		int i2 = 0;
		for (Igrac igrac : utakmica.aktivni) {
			
			/*System.out.println("ime ovde: " + igrac.getIme());
			System.out.println("prezime ovde: " + igrac.getPrezime());*/
			if (utakmica.domacin == igrac.klub)
			{
				panelZaSliku.listaKruzica.add(new PrikazIgraca(igrac, 1, i1));
				i1 += 1;
			}
				
			else
			{
				panelZaSliku.listaKruzica.add(new PrikazIgraca(igrac, 2, i2));
				i2++;
			}
				
		}
		
		postaviSliku(panelZaSliku);
		
		
		
		leviPanel.setTopComponent(podaciTima);
		leviPanel.setBottomComponent(panelZaSliku);
		leviPanel.setDividerLocation(this.getHeight() / 10 );
		
		
		
		glavniPanel.setTopComponent(leviPanel);
		glavniPanel.setBottomComponent(desniPanel);
		glavniPanel.setDividerLocation(this.getWidth() / 3 * 2);
		
	}
	
	

	private void postaviSliku(Teren panelZaSliku) {
		try {
			Image slika = ImageIO.read(new File("./slike/Teren.jpg"));
			panelZaSliku.postaviPozadinu(slika);
			
		} catch (IOException e) {
			
		}
		
	}
	
	private void refresh(){
		timer.schedule(new TimerTask() {

			@Override
			public void run() {
				
				vreme.setText(utakmica.getVreme()/60 + ":"+
				(utakmica.getVreme()%60 + ""));

			}
		}, 0, 100);
	}


	
	
}


@SuppressWarnings("serial")
class PanelTima extends JPanel
{
	public JLabel labela1;
	public int poeni;
	
	public PanelTima(Klub klub, Utakmica utakmica)
	{
		poeni = 0;
		
		this.setLayout(new BorderLayout());
		
		//JPanel rezervniIgraci = new JPanel();
		
		//JTextArea praznaLabela = new JTextArea("OVDE CE DA STOJE KRUZICI ZA IGRACE NA KLUPI");
		//praznaLabela.setSize(new Dimension(desniPanel.getWidth() - 50, desniPanel.getHeight() / 3));
		
		
		String[] zaglavlje = {"Ime", "Prezime"};
		int brojRezervi = klub.igraci.size() - 5;
		String[][] podaci = new String[brojRezervi][];
		
		int i = 0;
		for (Igrac igrac : klub.igraci) {
			if (!utakmica.aktivni.contains(igrac))
			{
				String ime = igrac.getIme();
				String prezime = igrac.getPrezime();
				podaci[i] = new String[] {ime, prezime};
				i++;
			}
		}
		
		JTable tabelaRezervnihIgraca = new JTable(podaci, zaglavlje);
		JScrollPane skrol = new JScrollPane(tabelaRezervnihIgraca);
		this.add(skrol);
		
		JPanel panelLabelaDom = new JPanel();
		panelLabelaDom.setLayout(new BoxLayout(panelLabelaDom, BoxLayout.Y_AXIS));
		labela1 = new JLabel("Poeni tima " + 0);
		labela1.setFont(new Font("Serif", Font.PLAIN, 15));
		labela1.setAlignmentX(CENTER_ALIGNMENT);
		panelLabelaDom.add(labela1);
		panelLabelaDom.add(Box.createVerticalStrut(25));
		
		JLabel labela2 = new JLabel("Broj napada tima " + 0);
		labela2.setFont(new Font("Serif", Font.PLAIN, 15));
		labela2.setAlignmentX(CENTER_ALIGNMENT);
		panelLabelaDom.add(labela2);
		panelLabelaDom.add(Box.createVerticalStrut(25));
		
		JLabel labela3 = new JLabel("Broj izmena tima " + 0);
		labela3.setFont(new Font("Serif", Font.PLAIN, 15));
		labela3.setAlignmentX(CENTER_ALIGNMENT);
		panelLabelaDom.add(labela3);
		panelLabelaDom.add(Box.createVerticalStrut(25));
		
		this.add(panelLabelaDom, BorderLayout.SOUTH);
		
	}	
	
}

class PrikazIgraca  {

	private Ellipse2D el;
	private Igrac igrac;

	public Ellipse2D getEl() {
		return el;
	}

	public void setEl(Ellipse2D el) {
		this.el = el;
	}

	public Igrac getIgrac() {
		return igrac;
	}

	public void setIgrac(Igrac igrac) {
		this.igrac = igrac;
	}

	//parametri strana i broj su stavljeni da bi prilikom crtanja krug znao gde da se iscrta (broj - redni broj igraca)
	public PrikazIgraca(Igrac i, int strana, int broj) {
		if (strana == 1)
		{
			el = new Ellipse2D.Double(480, 30 + broj * 100, 110, 90);
		}
		else if (strana == 2)
			el = new Ellipse2D.Double(70, 30 + broj * 100, 110, 90);
		igrac = i;
		
	}
	
	

}
