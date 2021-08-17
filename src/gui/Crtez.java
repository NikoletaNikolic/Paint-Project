package gui;

import geometrija.*;
import java.awt.Graphics;
import javax.swing.JComponent;
import javax.swing.JPanel;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.util.ArrayList;
import java.awt.Color;
import java.awt.Font;

public class Crtez extends JPanel {

	int xEnd, xStart;
	int yEnd, yStart;
	int linijaFlag = 0;
	int temp;

	int tX, tY;

	// Lista nacrtanih objekata
	public ArrayList<Oblik> lista = new ArrayList<Oblik>();
	public Oblik selektovani;


	public Crtez() {

		// Setovanje da JPanel bude potpuno ne transparentan
		// JComponent metode setOpaque, setBackground koju je nasledio JPanel
		setOpaque(true);
		setBackground(Color.WHITE);

		addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {

				tX = e.getX();
				tY = e.getY();


				if (Aplikacija.staRadim == "TACKA") {
					lista.add(new Tacka(e.getX(), e.getY(), Aplikacija.getBojaRama()));
				} 
				else if (Aplikacija.staRadim == "LINIJA") {
					if (linijaFlag == 0) {
						// Unos prve tacke
						xStart = e.getX();
						yStart = e.getY();
						linijaFlag = 1;
					} else {
						// Kordinate druge tacke e.getX(), e.getY()
						xEnd = e.getX();
						yEnd = e.getY();
						lista.add(
								new Linija(new Tacka(xStart, yStart), new Tacka(xEnd, yEnd),
								Aplikacija.getBojaRama())
								);
						// resetovanje flag-a da bi mogla linija ponovo da se nacrta i unese prva i druga tacka
						linijaFlag = 0;
					}
				} 
				else if (Aplikacija.staRadim == "KVADRAT") {
					DlgKvadrat d1 = new DlgKvadrat();
					d1.setVisible(true);
					if (DlgKvadrat.isDaLiCrtati()) {
						Kvadrat kv1 = new Kvadrat(new Tacka(e.getX(), e.getY()), DlgKvadrat.getDuzinaStranice(),
								Aplikacija.getBojaRama());
						kv1.setBojaUnutrasnjosti(Aplikacija.getBojaUnutrasnjosti());
						lista.add(kv1);
					}
				} 
				else if (Aplikacija.staRadim == "PRAVOUGAONIK") {
					DlgPravougaonik d2 = new DlgPravougaonik();
					d2.setVisible(true);
					if (DlgPravougaonik.isDaLiCrtati()) {
						Pravougaonik pr1 = new Pravougaonik(new Tacka(e.getX(), e.getY()),
								DlgPravougaonik.getDuzinaStranice(), DlgPravougaonik.getVisina(),
								Aplikacija.getBojaRama());
						pr1.setBojaUnutrasnjosti(Aplikacija.getBojaUnutrasnjosti());
						lista.add(pr1);
					}
				} 
				else if (Aplikacija.staRadim == "KRUG") {
					DlgKrug d3 = new DlgKrug();
					d3.setVisible(true);
					if (DlgKrug.isDaLiCrtati()) {
						Krug kr1 = new Krug(new Tacka(e.getX(), e.getY()), DlgKrug.getPoluprecnik(),
								Aplikacija.getBojaRama());
						kr1.setBojaUnutrasnjosti(Aplikacija.getBojaUnutrasnjosti());
						lista.add(kr1);
					}
				} 
				else if (Aplikacija.staRadim == "SELEKTUJ") {
					selektovanje(e.getX(), e.getY());
				} 
				else if(Aplikacija.staRadim == "MODIFIKUJ") {
					selektovanje(e.getX(), e.getY());
					modifikacija();
				}else if(Aplikacija.staRadim == "OBRISI")
				{
					selektovanje(e.getX(), e.getY());
					DlgBrisanje d3 = new DlgBrisanje();
					d3.setBrisi(new DlgBrisanje.Brisi() {
						
						@Override
						public void brisi() {
							// TODO Auto-generated method stub
							brisanje();
						}
					});
					d3.setVisible(true);
				}
			}
		});
	}

	public void paint(Graphics g) {
		
		g.setColor(Color.WHITE);
		g.fillRect(0, 0, getWidth(), getHeight());

		lista.forEach((a) -> {
			a.popuni(g);
			a.crtajSe(g);
		});
		getRootPane().validate();
		getRootPane().repaint();
	}

	public void selektovanje(int x, int y) {

		selektovani = null;

		lista.forEach((a) -> {
			a.setSelektovan(false);
			if (a.sadrzi(x, y))
				selektovani = a;
		});

		if (selektovani != null) {
			selektovani.setSelektovan(true);
		} 

	}

	public void modifikacija(){

		if (selektovani != null) {
			
			if (selektovani instanceof Krug) {
				DlgIzmena dg = new DlgIzmena();
				dg.postaviTabove(4);
				dg.postaviPolja(selektovani);
				dg.setVisible(true);
				if(dg.isProvera()){
					dg.izmeni(selektovani);
				}
			}
			else if (selektovani instanceof Pravougaonik) {
				DlgIzmena dp = new DlgIzmena();
				dp.postaviTabove(3);
				dp.postaviPolja(selektovani);
				dp.setVisible(true);
				if(dp.isProvera()){
					dp.izmeni(selektovani);
				}

			} 
			else if (selektovani instanceof Kvadrat ) {
				DlgIzmena dk = new DlgIzmena();
				dk.postaviTabove(2);
				dk.postaviPolja(selektovani);
				dk.setVisible(true);
				if (dk.isProvera()) {
					dk.izmeni(selektovani);
				}
			} 
			else if(selektovani instanceof Linija){
				DlgIzmena dl = new DlgIzmena();
				dl.postaviTabove(1);
				dl.postaviPolja(selektovani);
				dl.setVisible(true);
				if(dl.isProvera()){
					dl.izmeni(selektovani);
				}
			}
			else if(selektovani instanceof Tacka){
				DlgIzmena dt = new DlgIzmena();
				dt.postaviTabove(0);
				dt.postaviPolja(selektovani);
				dt.setVisible(true);
				if(dt.isProvera()){
					dt.izmeni(selektovani);
				}
			}
			Aplikacija.staRadim = "DEFAULT";
		}
	}
	
	public void brisanje(){
		if (selektovani != null) {
			lista.remove(selektovani);
			selektovani = null;

			Aplikacija.staRadim = "DEFAULT";
		} 
	}
}
