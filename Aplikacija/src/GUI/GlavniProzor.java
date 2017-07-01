package GUI;

import java.awt.Dimension;
import java.awt.Image;
import java.awt.Point;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class GlavniProzor extends JFrame{

	public GlavniProzor() {
		
		this.setTitle("Glavni prozor");
		this.setVisible(true);
		this.setLocation(470, 200);
		this.setSize(400, 300);
		PanelSlika glavniPanel = new PanelSlika();
		this.setResizable(false);
		this.setImage(glavniPanel);
		this.setButtons(glavniPanel);
		this.setContentPane( glavniPanel );
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	private void setButtons(JPanel glavniPanel) {
		
		glavniPanel.setLayout(new BoxLayout(glavniPanel, 2));
		
		JButton dugme1 = new JButton("Dodavanje utakmice");
		glavniPanel.add(Box.createHorizontalStrut(25));
		glavniPanel.add(dugme1);
		JButton dugme2 = new JButton("Izvestaji");
		glavniPanel.add(Box.createHorizontalStrut(75));
		glavniPanel.add(dugme2);
		
	}

	private void setImage(PanelSlika glavniPanel) {
		try {
			//BufferedImage slika =;
			Image slika = ImageIO.read(new File("./slike/Kosarka.jpg"));
			glavniPanel.postaviPozadinu(slika);
			
		} catch (IOException e) {
			System.out.println("Greska");
		}
		
	}
}

