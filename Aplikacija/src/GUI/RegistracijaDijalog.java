package GUI;

import java.awt.BorderLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import Model.Aplikacija;
import java.io.LineNumberInputStream;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import Model.Aplikacija;

public class RegistracijaDijalog extends JFrame {

	public RegistracijaDijalog() {
		this.setTitle("Registracija");
		this.setVisible(true);
		this.setLocation(400, 200);
		this.setSize(600, 400);
		this.setButtons();
	}

	private void setButtons() {

		JLabel ime = new JLabel("Unesite zeljeno korisnicko ime  ");
		JTextField poljeZaIme = new JTextField();
		poljeZaIme.setColumns(15);

		JLabel lozinka = new JLabel("Unesite lozinku  ");
		JTextField poljeLozinke = new JTextField();
		poljeLozinke.setColumns(15);

		JLabel potvrdaLozinke = new JLabel("Potvrdite unesenu lozinku  ");
		JTextField poljePotvrdeLozinke = new JTextField();
		poljePotvrdeLozinke.setColumns(15);

		JButton okButton = new JButton("OK");
		JButton cancleButton = new JButton("Cancel");

		JPanel p1 = new JPanel();
		p1.setLayout(new GridLayout(1, 1));
		p1.add(ime);
		p1.add(poljeZaIme);

		JPanel p2 = new JPanel();
		p2.setLayout(new GridLayout(1, 1));
		p2.add(lozinka);
		p2.add(poljeLozinke);

		JPanel p3 = new JPanel();
		p3.setLayout(new GridLayout(1, 1));
		p3.add(potvrdaLozinke);
		p3.add(poljePotvrdeLozinke);

		JPanel p4 = new JPanel();
		p4.setLayout(new GridLayout(1, 2));
		p4.add(okButton);
		p4.add(cancleButton);

		GridBagConstraints gbc = new GridBagConstraints();
		gbc.insets = new Insets(5, 5, 5, 5);

		JPanel glavniPanel = new JPanel();
		glavniPanel.setLayout(new GridBagLayout());

		gbc.gridx = 0;
		gbc.gridy = 0;

		glavniPanel.add(new Label(""), gbc);

		gbc.gridx = 0;
		gbc.gridy = 1;

		glavniPanel.add(new Label(""), gbc);

		gbc.gridx = 0;
		gbc.gridy = 2;

		glavniPanel.add(p1, gbc);

		gbc.gridx = 0;
		gbc.gridy = 3;
		glavniPanel.add(p2, gbc);

		gbc.gridx = 0;
		gbc.gridy = 4;
		gbc.gridheight = 2;
		gbc.weighty = 0.5;
		glavniPanel.add(p3, gbc);

		gbc.gridx = 0;
		gbc.gridy = 6;
		glavniPanel.add(p4, gbc);

		this.getContentPane().add(glavniPanel, BorderLayout.CENTER);

		cancleButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});

		okButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				String korisnickoImeTekst = poljeZaIme.getText();
				String lozinkaTekst = poljeLozinke.getText();
				String potvrdaTekst = poljePotvrdeLozinke.getText();

				if (!Aplikacija.pronadjiKorisnika(korisnickoImeTekst, lozinkaTekst)) {
					if (lozinkaTekst.compareTo(potvrdaTekst) == 0) {
						Aplikacija.dodajKorisnika(korisnickoImeTekst, lozinkaTekst);
						dispose();
						System.out.println(Aplikacija.listaKorisnika.size());
					} else {
						JOptionPane.showMessageDialog(null, "Vase lozinke se ne poklapaju", "Razlicite lozinke",
								JOptionPane.INFORMATION_MESSAGE);
					}

				} else {
					JOptionPane.showMessageDialog(null, "Uneti korinisk vec postoji", "Postojeci Korosnik",
							JOptionPane.INFORMATION_MESSAGE);
				}
			}

		});
	}
}
