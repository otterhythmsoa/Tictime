package ihm;

import javax.swing.JPanel;
import javax.swing.JTextField;

import java.awt.Dimension;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Color;

import controleur.additionPanelControleur;
import javax.swing.border.LineBorder;

public class additionPanel extends JPanel {

	private static final long serialVersionUID = 1L;
	private additionPanelControleur gestion;
	private JLabel lblResultat;
	private JTextField lblDuree1;
	private JTextField lblDuree2;

	/**
	 * Create the panel.
	 */
	public additionPanel() {
		this.gestion = new additionPanelControleur(this);
		setBackground(new Color(255, 238, 172));
		setMaximumSize(new Dimension(370, 380));
		setMinimumSize(new Dimension(370, 380));
		setPreferredSize(new Dimension(370, 380));
		setLayout(null);
		
		this.lblDuree1 = new JTextField("00:00:00");
		lblDuree1.setToolTipText("");
		lblDuree1.setOpaque(true);
		lblDuree1.setBackground(new Color(255, 255, 255));
		lblDuree1.setFont(new Font("Bookman Old Style", Font.BOLD, 55));
		lblDuree1.setHorizontalAlignment(SwingConstants.CENTER);
		lblDuree1.setBounds(47, 11, 280, 85);
		add(lblDuree1);
		
		this.lblDuree2 = new JTextField("00:00:00");
		lblDuree2.setToolTipText("");
		lblDuree2.setOpaque(true);
		lblDuree2.setBackground(Color.WHITE);
		lblDuree2.setHorizontalAlignment(SwingConstants.CENTER);
		lblDuree2.setFont(new Font("Bookman Old Style", Font.BOLD, 55));
		lblDuree2.setBounds(47, 107, 280, 85);
		add(lblDuree2);
		
		this.lblResultat = new JLabel("00:00:00");
		lblResultat.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblResultat.setOpaque(true);
		lblResultat.setBackground(Color.WHITE);
		lblResultat.setHorizontalAlignment(SwingConstants.CENTER);
		lblResultat.setFont(new Font("Bookman Old Style", Font.BOLD, 55));
		lblResultat.setBounds(47, 203, 280, 85);
		add(lblResultat);
		
		JLabel lblOperateur = new JLabel("+");
		lblOperateur.setFont(new Font("Bookman Old Style", Font.BOLD, 50));
		lblOperateur.setHorizontalAlignment(SwingConstants.CENTER);
		lblOperateur.setBounds(0, 130, 46, 42);
		add(lblOperateur);
		
		JLabel lblEgal = new JLabel("=");
		lblEgal.setHorizontalAlignment(SwingConstants.CENTER);
		lblEgal.setFont(new Font("Bookman Old Style", Font.BOLD, 50));
		lblEgal.setBounds(0, 226, 46, 42);
		add(lblEgal);
		
		JButton btnRetour = new JButton("Retour");
		btnRetour.setFont(new Font("Open Sans", Font.BOLD, 10));
		btnRetour.setBackground(new Color(250, 250, 210));
		btnRetour.addActionListener(gestion);
		btnRetour.setBounds(47, 299, 89, 23);
		add(btnRetour);
		
		JButton btnCalculer = new JButton("Calculer");
		btnCalculer.setBackground(new Color(255, 140, 0));
		btnCalculer.setFont(new Font("Open Sans", Font.BOLD, 10));
		btnCalculer.addActionListener(gestion);
		btnCalculer.setBounds(238, 299, 89, 23);
		add(btnCalculer);
		
		JButton btnRéinitialiser = new JButton("Réinitialiser");
		btnRéinitialiser.setBackground(new Color(255, 180, 100));
		btnRéinitialiser.setFont(new Font("Open Sans", Font.BOLD, 10));
		btnRéinitialiser.addActionListener(gestion);
		btnRéinitialiser.setBounds(139, 299, 96, 23);
		add(btnRéinitialiser);
	}
	
	public JLabel getLblResultat() {
		return this.lblResultat;
	}
	
	public JTextField getLblDuree1() {
		return this.lblDuree1;
	}
	
	public JTextField getLblDuree2() {
		return this.lblDuree2;
	}
}
