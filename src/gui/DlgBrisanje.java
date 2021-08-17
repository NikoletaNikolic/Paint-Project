package gui;


import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class DlgBrisanje extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JLabel txtDaLiSteSigurni;
	private Brisi brisi;

	/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	/////////////////////////////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		DlgBrisanje dialog = new DlgBrisanje();
		dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		dialog.setVisible(true);
	}

	/**
	 * Create the dialog.
	 */
	public DlgBrisanje() {
		setTitle("Brisanje");
		setResizable(false);
		setModalityType(ModalityType.APPLICATION_MODAL);
		setBounds(100, 100, 300, 114);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		
		txtDaLiSteSigurni = new JLabel("Da li set sigurni da \u017Eelite da obri\u0161ete objekat?");
		GroupLayout gl_contentPanel = new GroupLayout(contentPanel);
		gl_contentPanel.setHorizontalGroup(
			gl_contentPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPanel.createSequentialGroup()
					.addContainerGap()
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(txtDaLiSteSigurni, GroupLayout.DEFAULT_SIZE, 111, Short.MAX_VALUE)
					.addContainerGap())
		);
		gl_contentPanel.setVerticalGroup(
			gl_contentPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPanel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(txtDaLiSteSigurni, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(12, Short.MAX_VALUE))
		);
		contentPanel.setLayout(gl_contentPanel);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("Potvrdi");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						brisi.brisi();
						dispose();
					}
				});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Poni\u0161ti");
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						dispose();
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
		///////////////akcije////////////////////////////////////////
		
		///////////////////////////////////////////////////////////////
	}
	
	public interface Brisi {
		void brisi();
	}

	public void setBrisi(Brisi brisi) {
		this.brisi = brisi;
	}
	
}
