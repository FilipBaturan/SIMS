package GUI;

import java.awt.BorderLayout;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.geom.Ellipse2D;
import java.text.ParseException;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import Model.Igrac;
import Model.Utakmica;

@SuppressWarnings("serial")
public class Test extends JFrame {

	Utakmica u;
	JTextField vreme = new JTextField();
	PrikazIgraca teren;
	Timer timer;

	public Test(Utakmica u) {
		this.u = u;
		teren = new PrikazIgraca();
		timer = new Timer();
		this.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent WinEvt) {
				System.out.println("Izasao");
				timer.cancel();
				timer.purge();
				System.exit(0);
			}
		});
		this.setTitle("Simuliranje utakmice");
		init();
		this.setVisible(true);
		this.setLocation(350, 150);
		this.setSize(700, 400);
		refresh();

	}

	void init() {
		JLabel labela = new JLabel("Proteklo vreme ");

		vreme.setText(u.getVreme() + "");
		vreme.setColumns(5);
		vreme.setEnabled(false);

		JButton prekid = new JButton("Prekid");
		JButton nastavak = new JButton("Nastavak");
		JButton zavrsetak = new JButton("Zavrsetak");

		JPanel panel1 = new JPanel();
		panel1.setLayout(new GridLayout(1, 1));
		panel1.add(labela);
		panel1.add(vreme);

		JPanel panel2 = new JPanel();
		panel2.setLayout(new GridLayout(1, 1));
		panel2.add(prekid);
		panel2.add(nastavak);
		panel2.add(zavrsetak);

		GridBagConstraints gbc = new GridBagConstraints();
		gbc.insets = new Insets(5, 5, 5, 5);

		// JPanel teren = new JPanel();

		//add(teren);

		
		  JPanel glavniPanel = new JPanel(); glavniPanel.setLayout(new
		  GridBagLayout());
		  
		  gbc.gridx = 0; gbc.gridy = 0; glavniPanel.add(panel1, gbc);
		  
		  gbc.gridx = 0; gbc.gridy = 1; glavniPanel.add(panel2, gbc);
//		
		  gbc.gridx = 0; gbc.gridy = 1; glavniPanel.add(teren, gbc);
		 

		  this.getContentPane().add(glavniPanel, BorderLayout.CENTER);

		prekid.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					u.prekid();
				} catch (ParseException e1) {
					e1.printStackTrace();
				}

			}
		});

		nastavak.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("Nastavak");
				try {
					u.nastavak();
				} catch (ParseException e1) {
					e1.printStackTrace();
				}

			}
		});

		zavrsetak.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					u.tuca();
				} catch (ParseException e1) {
					e1.printStackTrace();
				}

			}
		});

	}

	void refresh() {
		timer.schedule(new TimerTask() {

			@Override
			public void run() {
				vreme.setText(u.getVreme() + "");

			}
		}, 0, 100);
	}

	public class PrikazIgraca extends JPanel {

		private Ellipse2D el;
		private Igrac igrac;

		public PrikazIgraca() {
			el = new Ellipse2D.Double(170, 150, 100, 100);
			//igrac = new Igrac(7, "Nikola", "Markovic", new Date(), 10, 207);
			addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					super.mouseClicked(e);
					if (e.getClickCount() == 1) {
						if (el.contains(e.getX(), e.getY())) {
							System.out.println(el.getCenterX());
						}
					}
					else if(e.getClickCount() == 2){
						System.out.println("Kliko dva puta");
					}
					// System.out.println("Kliknut");
				}
			});
		}

		@Override
		public void paintComponent(Graphics g) {
			super.paintComponent(g);
			Ellipse2D krug = new Ellipse2D.Double(300, 150, 100, 100);
			Graphics2D gr = (Graphics2D) g;
			gr.draw(krug);
			gr.draw(el);
			g.drawString(igrac.getIme()+ " "+ igrac.getPrezime(), (int)el.getCenterX()-40, (int)el.getCenterY());
			// g.drawOval(150, 150, 100, 100);
			// g.fillOval(200, 200, 20, 20);
			// g.drawString("Nesto", 100, 100);
		}

	}

}
