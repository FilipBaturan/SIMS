package GUI;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.JPanel;

public class Teren extends JPanel {

	Image image;
	ArrayList<PrikazIgraca> listaKruzica;
	
	public Teren()
	{
		listaKruzica = new ArrayList<>();
		addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				super.mouseClicked(e);
				try {
					for (PrikazIgraca prikaz : listaKruzica) {
						
						if (e.getClickCount() == 1) {
							if (prikaz.getEl().contains(e.getX(), e.getY())) {
								System.out.println(prikaz.getEl().getCenterX());
							}
						}
						else if(e.getClickCount() == 2){
							System.out.println("Kliko dva puta");
						}
					}
				} catch (Exception e2) {
					System.out.println("ASDASDASD");
				}
			
			}
		});
	}
	
	

    public void postaviPozadinu(Image image) {
        this.image = image;
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(image, 0, 0, this.getWidth(), this.getHeight(), null);
        
		Graphics2D gr = (Graphics2D) g;
		
		for (PrikazIgraca el : listaKruzica) {
			gr.draw(el.getEl());
			g.drawString(el.getIgrac().getIme()+ " "+ el.getIgrac().getPrezime(),
					(int)el.getEl().getCenterX()-40, (int)el.getEl().getCenterY());
		}
		
		
    }
}
