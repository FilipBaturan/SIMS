package GUI;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.JPanel;

import Model.Utakmica;

@SuppressWarnings("serial")
public class Teren extends JPanel {

	Image image;
	ArrayList<PrikazIgraca> listaKruzica;
	
	public Teren(Utakmica utakmica)
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
							if(prikaz.getEl().contains(e.getX(), e.getY()))
							{
								utakmica.getTrenutnoStanje().dijalog(prikaz.getIgrac());
							}
								
						}
					}
				} catch (Exception e2) {
					System.out.println("Greksa");
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
			String prikazIgraca =  el.getIgrac().getIme()+ " " + el.getIgrac().getPrezime();
			g.drawString( prikazIgraca, (int)el.getEl().getCenterX()-50, (int)el.getEl().getCenterY());
		}
		
		
    }
}
