package GUI;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.JPanel;

public class PanelSlika extends JPanel {

    Image image;

    public void postaviPozadinu(Image image) {
        this.image = image;
    }

    @Override
    public void paintComponent(Graphics G) {
        super.paintComponent(G);
        G.drawImage(image, 0, 0, this.getWidth(), this.getHeight(), null);
    }

}
