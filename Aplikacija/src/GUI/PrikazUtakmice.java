package GUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.geom.Ellipse2D;
import java.io.File;
import java.io.IOException;
import java.io.LineNumberInputStream;
import java.util.Date;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSplitPane;
import javax.swing.JTextArea;

import Model.Igrac;
import Model.Klub;

public class PrikazUtakmice extends JFrame {
	
	public PrikazUtakmice(Klub domacin, Klub gost) {
		this.setTitle("Prikaz utakmice");
		this.setVisible(true);
		this.setLocation(250, 50);
		this.setSize(1000, 700);
		JSplitPane glavniPanel = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT);
		glavniPanel.setEnabled(false);
		this.postaviElemente(glavniPanel, domacin, gost);
		this.setContentPane( glavniPanel);
	}

	private void postaviElemente(JSplitPane glavniPanel, Klub domacin, Klub gost) {
		
		
		JSplitPane desniPanel = new JSplitPane(JSplitPane.VERTICAL_SPLIT);
		desniPanel.setEnabled(false);
		desniPanel.setEnabled(false);
		desniPanel.setBorder(BorderFactory.createLineBorder(Color.black) );
		JPanel domaciTim = new PanelTima(domacin);
		
		JSplitPane donjiPanel = new JSplitPane(JSplitPane.VERTICAL_SPLIT);
		donjiPanel.setEnabled(false);
		JPanel prelazstanja = new JPanel();
		JButton prekid = new JButton("Prekini");
		prelazstanja.add(prekid);
		
		
		JPanel gostojuciTim = new PanelTima(gost);
		
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
		JLabel vreme = new JLabel("0:00");
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

		Teren panelZaSliku = new Teren();
		for (int i = 0; i < 5; i++) {
			panelZaSliku.listaKruzica.add(new PrikazIgraca(1, i));
		}
		for (int i = 0; i < 5; i++) {
			panelZaSliku.listaKruzica.add(new PrikazIgraca(2, i));
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
			System.out.println("Greska");
		}
		
	}

}


class PanelTima extends JPanel
{
	public PanelTima(Klub klub)
	{
		
		this.setLayout(new BorderLayout());
		
		JPanel rezervniIgraci = new JPanel();
		
		JTextArea praznaLabela = new JTextArea("OVDE CE DA STOJE KRUZICI ZA IGRACE NA KLUPI");
		//praznaLabela.setSize(new Dimension(desniPanel.getWidth() - 50, desniPanel.getHeight() / 3));
		this.add(praznaLabela);
		
		JPanel panelLabelaDom = new JPanel();
		panelLabelaDom.setLayout(new BoxLayout(panelLabelaDom, BoxLayout.Y_AXIS));
		JLabel labela1 = new JLabel("Broj poJena tima");
		labela1.setFont(new Font("Serif", Font.PLAIN, 15));
		labela1.setAlignmentX(CENTER_ALIGNMENT);
		panelLabelaDom.add(labela1);
		panelLabelaDom.add(Box.createVerticalStrut(25));
		
		JLabel labela2 = new JLabel("Broj napada");
		labela2.setFont(new Font("Serif", Font.PLAIN, 15));
		labela2.setAlignmentX(CENTER_ALIGNMENT);
		panelLabelaDom.add(labela2);
		panelLabelaDom.add(Box.createVerticalStrut(25));
		
		JLabel labela3 = new JLabel("Nesto jos, zaboravio sam sta");
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
	public PrikazIgraca(int strana, int broj) {
		if (strana == 1)
		{
			el = new Ellipse2D.Double(500, 20 + broj * 100, 90, 90);
		}
		else if (strana == 2)
			el = new Ellipse2D.Double(130, 20 + broj * 100, 90, 90);
		igrac = new Igrac(7, "Nikola", "Markovic", new Date(), 10, 207);
		
	}

	

}
