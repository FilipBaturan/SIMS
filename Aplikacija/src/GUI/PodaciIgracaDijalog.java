package GUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

import Model.Igrac;
import Model.Osoba;
import Model.Utakmica;
import Model.Evidentiranje.UcinakIgraca;
import Model.Evidentiranje.UcinakTrenera;
import Model.StanjeUtakmice.Odigravanje;

public class PodaciIgracaDijalog extends JFrame {
	
	private UcinakIgraca ucinak;
	private int zona;

	public PodaciIgracaDijalog(UcinakIgraca ucinakIgraca)
	{
		ucinak = ucinakIgraca;
		this.setTitle("Azuriranje podataka igraca");
		this.setVisible(true);
		this.setLocation(420, 180);
		this.setSize(500, 500);
		JPanel glavniPanel = new JPanel();
		glavniPanel.setLayout(new BoxLayout(glavniPanel, BoxLayout.Y_AXIS));
		this.postaviElemente(glavniPanel);
		this.setContentPane(glavniPanel);
		
	}

	private void postaviElemente(JPanel glavniPanel) {
		
		JPanel zone = new JPanel();
		
		JRadioButton zona1 = new JRadioButton("Zona 1", true);
		JRadioButton zona2 = new JRadioButton("Zona 2");
		JRadioButton zona3 = new JRadioButton("Zona 3");
		JRadioButton zona4 = new JRadioButton("Zona 4");
		JRadioButton zona5 = new JRadioButton("Zona 5");
		JRadioButton zona6 = new JRadioButton("Zona 6");
		
		
		ButtonGroup grupaZona = new ButtonGroup();
		grupaZona.add(zona1);
		grupaZona.add(zona2);
		grupaZona.add(zona3);
		grupaZona.add(zona4);
		grupaZona.add(zona5);
		grupaZona.add(zona6);
		
		zone.add(zona1);
		zone.add(zona2);
		zone.add(zona3);
		zone.add(zona4);
		zone.add(zona5);
		zone.add(zona6);
		
		JButton potvrdaZone = new JButton("Potvrdi zonu");
		zone.add(potvrdaZone);
		
		JPanel panel1 = new JPanel();
		panel1.setLayout(new BoxLayout(panel1, BoxLayout.X_AXIS));
		JButton skok = new JButton("Dodaj skok");
		
		JRadioButton napad = new JRadioButton("Skok u napadu", true);
		JRadioButton odbrana = new JRadioButton("Skok u odbrani");
		
		ButtonGroup grupa = new ButtonGroup();
		grupa.add(napad);
		grupa.add(odbrana);
		
		panel1.add(napad);
		panel1.add(odbrana);
		panel1.add(skok);
		
		
		JPanel panel2 = new JPanel();
		JButton asistencija = new JButton("Dodaj asistenciju");
		panel2.add(asistencija);
		
		JPanel panel3 = new JPanel();
		JButton osvojenaLopta = new JButton("Dodaj osvojenu loptu");
		panel3.add(osvojenaLopta);
		
		JPanel panel4 = new JPanel();
		JButton blokada = new JButton("Dodaj blokadu");
		panel4.add(blokada);
		
		
		JPanel panel5 = new JPanel();
		panel5.setLayout(new BoxLayout(panel5, BoxLayout.X_AXIS));
		JRadioButton jedanPoen = new JRadioButton("Jedan poen", true);
		JRadioButton dvaPoena = new JRadioButton("Dva poena");
		JRadioButton triPoena = new JRadioButton("Tri poena");
		JButton dodajPoen = new JButton("Dodaj poen");
		JButton dodajPromasaj = new JButton("Dodaj promasaj");
		
		panel5.add(jedanPoen);
		panel5.add(dvaPoena);
		panel5.add(triPoena);
		

		ButtonGroup grupaPoena = new ButtonGroup();
		grupaPoena.add(jedanPoen);
		grupaPoena.add(dvaPoena);
		grupaPoena.add(triPoena);
		
		panel5.add(dodajPoen);
		panel5.add(dodajPromasaj);
		
		glavniPanel.add(zone);
		glavniPanel.add(panel1);
		glavniPanel.add(panel2);
		glavniPanel.add(panel3);
		glavniPanel.add(panel4);
		glavniPanel.add(panel5);
		
		
		potvrdaZone.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(zona1.isSelected())
					zona = 1;
				else if(zona2.isSelected())
					zona = 2;
				else if(zona3.isSelected())
					zona = 3;
				else if(zona4.isSelected())
					zona = 4;
				else if(zona5.isSelected())
					zona = 5;
				else 
					zona = 6;
				
			}
		});
		
		
		skok.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if (napad.isSelected())
				{
					ucinak.utakmica.getTrenutnoStanje().azuriranje(0, 0, zona);	
					JOptionPane.showMessageDialog(null, "Unet skok u napadu", "Unos skoka",
							JOptionPane.INFORMATION_MESSAGE);
				}
					
				else
				{
					ucinak.utakmica.getTrenutnoStanje().azuriranje(1, 0, zona);	
					JOptionPane.showMessageDialog(null, "Unet skok u odbrani", "Unos skoka",
							JOptionPane.INFORMATION_MESSAGE);
				}
					
				
			}
		});
		
		asistencija.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				ucinak.utakmica.getTrenutnoStanje().azuriranje(2, 0, zona);	
				JOptionPane.showMessageDialog(null, "Uneteta asistencija", "Unos asistecije",
						JOptionPane.INFORMATION_MESSAGE);
				
			}
		});
		
		
		osvojenaLopta.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				ucinak.utakmica.getTrenutnoStanje().azuriranje(3, 0, zona);	
				JOptionPane.showMessageDialog(null, "Igrac osvojio loptu", "Osvojena lopta",
						JOptionPane.INFORMATION_MESSAGE);
				
			}
		});
		
		
		blokada.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				ucinak.utakmica.getTrenutnoStanje().azuriranje(4, 0, zona);	
				JOptionPane.showMessageDialog(null, "Igrac napravio blokadu", "Blokada",
						JOptionPane.INFORMATION_MESSAGE);
				
			}
		});
		
		dodajPoen.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if (jedanPoen.isSelected())
				{
					ucinak.utakmica.getTrenutnoStanje().azuriranje(7, 1, zona);	
					JOptionPane.showMessageDialog(null, "Igrac postigao jedan poen", "Unos poena",
							JOptionPane.INFORMATION_MESSAGE);
				}
					
				else if (dvaPoena.isSelected())
				{
					ucinak.utakmica.getTrenutnoStanje().azuriranje(7, 2, zona);	
					JOptionPane.showMessageDialog(null, "Igrac postigao dva poena", "Unos poena",
							JOptionPane.INFORMATION_MESSAGE);
				}
					
				else
				{
					ucinak.utakmica.getTrenutnoStanje().azuriranje(7, 3, zona);	
					JOptionPane.showMessageDialog(null, "Igrac postigao tri poena", "Unos poena",
							JOptionPane.INFORMATION_MESSAGE);
				}
					
				
					
			}
		});
		
		
		dodajPromasaj.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if (jedanPoen.isSelected())
				{
					ucinak.utakmica.getTrenutnoStanje().azuriranje(8, 1, zona);	
					JOptionPane.showMessageDialog(null, "Igrac postigao jedan poen", "Unos poena",
							JOptionPane.INFORMATION_MESSAGE);
				}
					
				else if (dvaPoena.isSelected())
				{
					ucinak.utakmica.getTrenutnoStanje().azuriranje(8, 2, zona);	
					JOptionPane.showMessageDialog(null, "Igrac postigao dva poena", "Unos poena",
							JOptionPane.INFORMATION_MESSAGE);
				}
					
				else
				{
					ucinak.utakmica.getTrenutnoStanje().azuriranje(8, 3, zona);	
					JOptionPane.showMessageDialog(null, "Igrac postigao tri poena", "Unos poena",
							JOptionPane.INFORMATION_MESSAGE);
				}
				
			}
		});
		
	}
	
	
	
}