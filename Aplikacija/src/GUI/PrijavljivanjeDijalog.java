package GUI;

import java.awt.BorderLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class PrijavljivanjeDijalog extends JFrame{

	public PrijavljivanjeDijalog()
	{
		this.setTitle("Dijalog za prijavljivanje");
		this.setButtons();
		this.setVisible(true);
		this.setLocation(500, 250);
		this.setSize(400, 200);
		
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
	}

	private void setButtons() {

		
		JLabel ime = new JLabel("Unesite korisnicko ime");
		JTextField poljeZaIme = new JTextField();
		
		poljeZaIme.setColumns(15);
		JLabel prezime = new JLabel("Unesite lozinku");
		
		JTextField poljePrezimena = new JTextField();
		poljePrezimena.setColumns(15);
		
		JButton okButton = new JButton("OK");
		JButton cancleButton = new JButton("Cancel");
		
		JButton registracija = new JButton("Registracija");
		
		
		
		JPanel p1 = new JPanel();
		p1.setLayout(new GridLayout(1,1));
		p1.add(ime);
		p1.add(poljeZaIme);
		
		JPanel p2 = new JPanel();
		p2.setLayout(new GridLayout(1,1));
		p2.add(prezime);
		p2.add(poljePrezimena);
		
		JPanel p3 = new JPanel();
		p3.setLayout(new GridLayout(1,1));
		p3.add(okButton);
		p3.add(cancleButton);
		

		JPanel p4 = new JPanel();
		p4.setLayout(new GridLayout(1,1));
		p4.add(registracija);

		GridBagConstraints gbc = new GridBagConstraints();
		gbc.insets=new Insets(5, 5, 5, 5);
		
		JPanel glavniPanel =new JPanel();
		glavniPanel.setLayout(new GridBagLayout());
		
		gbc.gridx=0;
		gbc.gridy=0;
		glavniPanel.add(p1,gbc);
		
		gbc.gridx=0;
		gbc.gridy=1;
		glavniPanel.add(p2,gbc);
		
		gbc.gridx = 0;
		gbc.gridy = 2;
		glavniPanel.add(p3, gbc);
		
		gbc.gridx = 0;
		gbc.gridy = 3;
		glavniPanel.add(p4, gbc);
		
		this.getContentPane().add(glavniPanel, BorderLayout.CENTER);
		
	}
	
	
	
}
