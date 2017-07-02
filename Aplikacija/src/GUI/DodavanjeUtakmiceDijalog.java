package GUI;

import java.awt.Color;
import java.awt.Font;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import Model.Aplikacija;

public class DodavanjeUtakmiceDijalog extends JFrame {
	
	public DodavanjeUtakmiceDijalog()
	{
		this.setTitle("Dodavanje utakmice");
		this.setVisible(true);
		this.setLocation(420, 180);
		this.setSize(500, 350);
		JPanel glavniPanel = new JPanel();
		this.postaviElemente(glavniPanel);
		this.setContentPane(glavniPanel);
		
		
	}

	private void postaviElemente(JPanel glavniPanel) {
		glavniPanel.setLayout(new BoxLayout(glavniPanel, BoxLayout.Y_AXIS));
		JPanel panel1 = new JPanel();
		
		//smestanje svih klubova u combo box
		String[] listaKlubova = Aplikacija.preuzmiKlubove();
		
		JComboBox<String> comboBox = new JComboBox<String>(listaKlubova);
		panel1.add(new Label("Izaberite domacina utakmice "));
		panel1.add(comboBox);
		
		JLabel prikazDomacina = new JLabel();
		prikazDomacina.setFont(new Font("Serif", Font.PLAIN, 19));
		prikazDomacina.setForeground(Color.RED);
		JPanel panel2 = new JPanel();
		panel2.add(prikazDomacina);
		
		JPanel panel3 = new JPanel();
		panel3.add(new Label("Izaberite gosta utakmice "));
		JComboBox<String> comboBox2 =  new JComboBox<String>(listaKlubova);
		panel3.add(comboBox2);
		
		
		JLabel prikazGosta = new JLabel();
		prikazGosta.setFont(new Font("Serif", Font.PLAIN, 19));
		prikazGosta.setForeground(Color.BLUE);
		JPanel panel4 = new JPanel();
		panel4.add(prikazGosta);
		
		glavniPanel.add(panel1);
		glavniPanel.add(Box.createVerticalStrut(25));
		glavniPanel.add(panel2);
		glavniPanel.add(Box.createVerticalStrut(25));
		glavniPanel.add(panel3);
		glavniPanel.add(Box.createVerticalStrut(25));
		glavniPanel.add(panel4);
		glavniPanel.add(Box.createVerticalStrut(25));
		JButton potvrda = new JButton("Potvrda");
		glavniPanel.add(potvrda);
		glavniPanel.add(Box.createVerticalStrut(25));
		
		comboBox.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String nazivDomacina = listaKlubova[comboBox.getSelectedIndex()];
				
				prikazDomacina.setText("Domacin koga ste izabrali je " + nazivDomacina);
				
			}
		});
		
		comboBox2.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String nazivGosta = listaKlubova[comboBox2.getSelectedIndex()];
				
				prikazGosta.setText("Gost koga ste izabrali je " + nazivGosta);
				
			}
		});
	}
}
