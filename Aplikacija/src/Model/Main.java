package Model;

import java.applet.Applet;

import javax.swing.JFrame;

import GUI.PrijavljivanjeDijalog;

import Model.Aplikacija;

public class Main {

	public static void main(String[] args) {
		new Aplikacija();
		Aplikacija.dodajKorisnika("aa","aa");
		Aplikacija.dodajKorisnika("bb", "bb");
		Aplikacija.dodajKorisnika("cc", "cc");
		
		
	}

}
