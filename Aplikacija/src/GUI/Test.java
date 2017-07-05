package GUI;

import java.awt.BorderLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.Closeable;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.plaf.synth.SynthSeparatorUI;

import Model.Utakmica;

@SuppressWarnings("serial")
public class Test extends JFrame {

	Utakmica u;
	JTextField vreme = new JTextField();
	Timer timer;
	
	public Test(Utakmica u) {
		this.u = u;
		timer = new Timer();
		this.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent WinEvt){
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
	
	void init(){
		JLabel labela = new JLabel("Proteklo vreme ");
		
		vreme.setText(u.getVreme()+"");
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

		JPanel glavniPanel = new JPanel();
		glavniPanel.setLayout(new GridBagLayout());

		gbc.gridx = 0;
		gbc.gridy = 0;
		glavniPanel.add(panel1, gbc);

		gbc.gridx = 0;
		gbc.gridy = 1;
		glavniPanel.add(panel2, gbc);
		
		this.getContentPane().add(glavniPanel, BorderLayout.CENTER);
		
		prekid.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				u.getTrenutnoStanje().prekid();
				
			}
		});
		
		nastavak.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("Nastavak");
				u.getTrenutnoStanje().nastavak();
				
			}
		});
		
		zavrsetak.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				u.getTrenutnoStanje().tuca();
				
			}
		});
	}
	
	
	
	void refresh(){
		timer.schedule(new TimerTask() {
			
			@Override
			public void run() {
				vreme.setText(u.getVreme()+"");
				
			}
		},0,100);
	}
	
}