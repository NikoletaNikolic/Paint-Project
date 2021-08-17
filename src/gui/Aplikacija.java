package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.GridBagLayout;
import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JComponent;

import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.border.LineBorder;
import java.net.MalformedURLException;
import javax.swing.JToggleButton;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import javax.swing.UIManager;
import javax.swing.ButtonGroup;

public class Aplikacija {

	private JFrame frmPaint; 
	public static String staRadim = "DEFAULT";
	private static Color bojaUnutrasnjosti = Color.WHITE;                                   //new Color(255, 255, 255, 0);
	private static Color bojaRama = Color.BLACK;
	private JToggleButton tglbtnTacka;
	private JToggleButton tglbtnLinija;
	private JToggleButton tglbtnKvadrat;
	private JToggleButton tglbtnPravougaonik;
	private JToggleButton tglbtnKrug;
	private static JButton btnBojaRama;
	private static JButton btnBojaUnutrasnjosti;
	private JToggleButton tglbtnSelektuj;
	private JToggleButton tglbtnModifikuj;
	private JToggleButton tglbtnObrisi;
	private JComponent pnlCrtez;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JLabel lblBojaOkvira;
	private JLabel lblBojaUnutrasnjosti;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {  		

		Aplikacija window = new Aplikacija();
		window.frmPaint.setVisible(true);
	}


	/**
	 * Create the application.
	 */
	public Aplikacija() {
		// podesavanje UIa
		inicijalizacija();
		
		akcije();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void inicijalizacija() {
		// Glavni prozor sa x dugmtom
		frmPaint = new JFrame();
		frmPaint.setTitle("Nikoli\u0107 Nikoleta MH 69/2015");
		// 100,100 koordinte gornjeg levog ugla 
		frmPaint.setBounds(100, 100, 1200, 600);
		frmPaint.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		pnlCrtez = new Crtez();
		// da bude netransparetan
		pnlCrtez.setOpaque(true);
		pnlCrtez.setBackground(Color.WHITE);
		pnlCrtez.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		frmPaint.getContentPane().add(pnlCrtez, BorderLayout.CENTER);
		pnlCrtez.setLayout(null);

		JPanel pnlOdabir = new JPanel();
		pnlOdabir.setBackground(UIManager.getColor("MenuItem.background"));
		frmPaint.getContentPane().add(pnlOdabir, BorderLayout.NORTH);
		GridBagLayout gbl_pnlOdabir = new GridBagLayout();
		gbl_pnlOdabir.columnWidths = new int[]{32, 32, 32, 32, 0, 0, 133, 33, 32, 32, 32, 32, 0, 57, 32, 36, 33, 60, 0};
		gbl_pnlOdabir.rowHeights = new int[]{25, 0, 33, 0};
		gbl_pnlOdabir.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_pnlOdabir.rowWeights = new double[]{0.0, 0.0, 0.0, Double.MIN_VALUE};
		pnlOdabir.setLayout(gbl_pnlOdabir);
		
		tglbtnModifikuj = new JToggleButton("");
		tglbtnModifikuj.setText("MODIFIKUJ");
		buttonGroup.add(tglbtnModifikuj);
		tglbtnModifikuj.setToolTipText("Modifikacija \r\nselektovanog \r\noblika");
		GridBagConstraints gbc_tglbtnModifikuj = new GridBagConstraints();
		gbc_tglbtnModifikuj.anchor = GridBagConstraints.WEST;
		gbc_tglbtnModifikuj.insets = new Insets(0, 0, 5, 5);
		gbc_tglbtnModifikuj.gridx = 1;
		gbc_tglbtnModifikuj.gridy = 1;
		pnlOdabir.add(tglbtnModifikuj, gbc_tglbtnModifikuj);
		
		tglbtnTacka = new JToggleButton("");
		tglbtnTacka.setText("TA\u010CKA");
		tglbtnTacka.setToolTipText("Crtanje ta\u010Dke");
		buttonGroup.add(tglbtnTacka);
		GridBagConstraints gbc_tglbtnTacka = new GridBagConstraints();
		gbc_tglbtnTacka.anchor = GridBagConstraints.WEST;
		gbc_tglbtnTacka.fill = GridBagConstraints.HORIZONTAL;
		gbc_tglbtnTacka.insets = new Insets(0, 0, 5, 5);
		gbc_tglbtnTacka.gridx = 0;
		gbc_tglbtnTacka.gridy = 0;
		pnlOdabir.add(tglbtnTacka, gbc_tglbtnTacka);
		tglbtnLinija = new JToggleButton("");
		tglbtnLinija.setText("LINIJA");
		tglbtnLinija.setToolTipText("Crtanje linije");
		buttonGroup.add(tglbtnLinija);
		GridBagConstraints gbc_tglbtnLinija = new GridBagConstraints();
		gbc_tglbtnLinija.fill = GridBagConstraints.HORIZONTAL;
		gbc_tglbtnLinija.insets = new Insets(0, 0, 5, 5);
		gbc_tglbtnLinija.gridx = 1;
		gbc_tglbtnLinija.gridy = 0;
		pnlOdabir.add(tglbtnLinija, gbc_tglbtnLinija);
		tglbtnKvadrat = new JToggleButton("");
		tglbtnKvadrat.setText("KVADRAT");
		tglbtnKvadrat.setToolTipText("Crtanje kvadrata putem dijaloga");
		buttonGroup.add(tglbtnKvadrat);
		GridBagConstraints gbc_tglbtnKvadrat = new GridBagConstraints();
		gbc_tglbtnKvadrat.fill = GridBagConstraints.HORIZONTAL;
		gbc_tglbtnKvadrat.insets = new Insets(0, 0, 5, 5);
		gbc_tglbtnKvadrat.gridx = 2;
		gbc_tglbtnKvadrat.gridy = 0;
		pnlOdabir.add(tglbtnKvadrat, gbc_tglbtnKvadrat);
		tglbtnPravougaonik = new JToggleButton("");
		tglbtnPravougaonik.setText("PRAVOUGAONIK");
		tglbtnPravougaonik.setToolTipText("Crtanje pravougaonika putem dijaloga");
		buttonGroup.add(tglbtnPravougaonik);
		GridBagConstraints gbc_tglbtnPravougaonik = new GridBagConstraints();
		gbc_tglbtnPravougaonik.fill = GridBagConstraints.HORIZONTAL;
		gbc_tglbtnPravougaonik.insets = new Insets(0, 0, 5, 5);
		gbc_tglbtnPravougaonik.gridx = 3;
		gbc_tglbtnPravougaonik.gridy = 0;
		pnlOdabir.add(tglbtnPravougaonik, gbc_tglbtnPravougaonik);
		tglbtnKrug = new JToggleButton("");
		tglbtnKrug.setText("KRUG");
		tglbtnKrug.setToolTipText("Crtanje kruga putem dijaloga");
		buttonGroup.add(tglbtnKrug);
		GridBagConstraints gbc_tglbtnKrug = new GridBagConstraints();
		gbc_tglbtnKrug.fill = GridBagConstraints.HORIZONTAL;
		gbc_tglbtnKrug.insets = new Insets(0, 0, 5, 5);
		gbc_tglbtnKrug.gridx = 4;
		gbc_tglbtnKrug.gridy = 0;
		pnlOdabir.add(tglbtnKrug, gbc_tglbtnKrug);

		btnBojaRama = new JButton("");				
		btnBojaRama.setBackground(Color.BLACK);
		btnBojaRama.setToolTipText("Biranje boje okvira objekta i boje tacke i linije");
		GridBagConstraints gbc_btnBojaRama = new GridBagConstraints();
		gbc_btnBojaRama.fill = GridBagConstraints.BOTH;
		gbc_btnBojaRama.insets = new Insets(0, 0, 0, 5);
		gbc_btnBojaRama.gridx = 5;
		gbc_btnBojaRama.gridy = 0;
		pnlOdabir.add(btnBojaRama, gbc_btnBojaRama);

		lblBojaOkvira = new JLabel("Okvir");
		GridBagConstraints gbc_lblBojaOkvira = new GridBagConstraints();
		gbc_lblBojaOkvira.anchor = GridBagConstraints.WEST;
		gbc_lblBojaOkvira.insets = new Insets(0, 0, 0, 5);
		gbc_lblBojaOkvira.gridx = 6;
		gbc_lblBojaOkvira.gridy = 0;
		pnlOdabir.add(lblBojaOkvira, gbc_lblBojaOkvira);
	
		tglbtnSelektuj = new JToggleButton("");
		tglbtnSelektuj.setText("SELEKTUJ");
		buttonGroup.add(tglbtnSelektuj);
		tglbtnSelektuj.setToolTipText("Selektovanje iscrtanih oblika");
		GridBagConstraints gbc_tglbtnSelektuj = new GridBagConstraints();
		gbc_tglbtnSelektuj.anchor = GridBagConstraints.NORTHWEST;
		gbc_tglbtnSelektuj.insets = new Insets(0, 0, 0, 5);
		gbc_tglbtnSelektuj.gridx = 2;
		gbc_tglbtnSelektuj.gridy = 1;
		pnlOdabir.add(tglbtnSelektuj, gbc_tglbtnSelektuj);
		tglbtnObrisi = new JToggleButton("");
		tglbtnObrisi.setText("BRI\u0160I");
		buttonGroup.add(tglbtnObrisi);
		tglbtnObrisi.setToolTipText("Brisanje selektovanog oblika");
		GridBagConstraints gbc_tglbtnObrisi = new GridBagConstraints();
		gbc_tglbtnObrisi.anchor = GridBagConstraints.NORTHWEST;
		gbc_tglbtnObrisi.insets = new Insets(0, 0, 0, 5);
		gbc_tglbtnObrisi.gridx = 3;
		gbc_tglbtnObrisi.gridy = 1;
		pnlOdabir.add(tglbtnObrisi, gbc_tglbtnObrisi);

		btnBojaUnutrasnjosti = new JButton("");				
		btnBojaUnutrasnjosti.setBackground(Color.WHITE);
		btnBojaUnutrasnjosti.setToolTipText("Biranje boje unutra\u0161njosti objekta");
		GridBagConstraints gbc_btnBojaUnutrasnjosti = new GridBagConstraints();
		gbc_btnBojaUnutrasnjosti.fill = GridBagConstraints.BOTH;
		gbc_btnBojaUnutrasnjosti.insets = new Insets(0, 0, 0, 5);
		gbc_btnBojaUnutrasnjosti.gridx = 5;
		gbc_btnBojaUnutrasnjosti.gridy = 1;
		pnlOdabir.add(btnBojaUnutrasnjosti, gbc_btnBojaUnutrasnjosti);

		lblBojaUnutrasnjosti = new JLabel("Popuna");
		GridBagConstraints gbc_lblBojaUnutrasnjosti = new GridBagConstraints();
		gbc_lblBojaUnutrasnjosti.anchor = GridBagConstraints.WEST;
		gbc_lblBojaUnutrasnjosti.insets = new Insets(0, 0, 0, 5);
		gbc_lblBojaUnutrasnjosti.gridx = 6;
		gbc_lblBojaUnutrasnjosti.gridy = 1;
		pnlOdabir.add(lblBojaUnutrasnjosti, gbc_lblBojaUnutrasnjosti);
	}

	private void akcije(){
		tglbtnTacka.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent arg0) {
				staRadim = "TACKA";
			}
		});

		tglbtnLinija.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent arg0) {
				staRadim = "LINIJA";
			}
		});

		tglbtnKvadrat.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent arg0) {
				staRadim = "KVADRAT";
			}
		});

		tglbtnPravougaonik.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent arg0) {
				staRadim = "PRAVOUGAONIK";
			}
		});

		tglbtnKrug.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent arg0) {
				staRadim = "KRUG";
			}
		});

		tglbtnSelektuj.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent arg0) {
				staRadim = "SELEKTUJ";
			}
		});

		tglbtnModifikuj.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent arg0) {
				staRadim = "MODIFIKUJ";
			}
		});

		tglbtnObrisi.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent arg0) {
				staRadim = "OBRISI";
			}
		});

		btnBojaRama.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				bojaRama = JColorChooser.showDialog(null, "Boja rama", bojaRama);
				if(bojaRama!=null){
					btnBojaRama.setBackground(bojaRama);
				}
			}
		});

		btnBojaUnutrasnjosti.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				bojaUnutrasnjosti = JColorChooser.showDialog(null, "Unutrasnjosti", bojaUnutrasnjosti);
				if(bojaUnutrasnjosti!=null){
					btnBojaUnutrasnjosti.setBackground(bojaUnutrasnjosti);
				}
			}
		});
	}

	public static Color getBojaUnutrasnjosti() {
		return bojaUnutrasnjosti;
	}

	public static Color getBojaRama() {
		return bojaRama;
	}
	
	public static void setBojaUnutrasnjosti(Color bojaUnutrasnjosti) {
		Aplikacija.bojaUnutrasnjosti = bojaUnutrasnjosti;
	}


	public static void setBojaRama(Color bojaRama) {
		Aplikacija.bojaRama = bojaRama;
	}
	public static JButton getBtnBojaRama() {
		return btnBojaRama;
	}

	public static JButton getBtnBojaUnutrasnjosti() {
		return btnBojaUnutrasnjosti;
	}
}
