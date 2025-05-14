package ihm;

import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controleur.menuControleur;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JButton;

import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Image;
import javax.swing.ImageIcon;
import java.awt.Color;

public class menu extends JPanel {

	private static final long serialVersionUID = 1L;
	private menuControleur gestion;
	/**
	 * Create the frame.
	 */
	public menu() {
		setBackground(new Color(255, 238, 172));
		this.gestion = new menuControleur(this);
		setBounds(100, 100, 450, 500);
		this.setSize(new Dimension(370, 380));
		this.setMinimumSize(new Dimension(370, 380));
		this.setMaximumSize(new Dimension(370, 380));
		this.setBorder(new EmptyBorder(5, 5, 5, 5));
		
		this.setLayout(new BorderLayout(0, 0));
		
		JLabel titre = new JLabel("Tictime");
		titre.setFont(new Font("Bookman Old Style", Font.BOLD, 50));
		titre.setHorizontalAlignment(SwingConstants.CENTER);
		this.add(titre, BorderLayout.NORTH);
		
		JLabel developer = new JLabel("realised by Tsinjo RANDRIANARISON");
		developer.setFont(new Font("Bookman Old Style", Font.ITALIC, 12));
		developer.setHorizontalAlignment(SwingConstants.CENTER);
		developer.setBorder(new EmptyBorder(0, 0, 20, 0));
		this.add(developer, BorderLayout.SOUTH);
		
		JPanel panelAddition = new JPanel();
		panelAddition.setBackground(new Color(255, 238, 172));
		panelAddition.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 0));
		panelAddition.setBorder(new EmptyBorder(75, 40, 0, 0));
		this.add(panelAddition, BorderLayout.WEST);
		
		JButton btnAddition = new JButton("");
		ImageIcon imgAddition = new ImageIcon(menu.class.getResource("/img/addition.png"));
		Image resizedImgAddition = imgAddition.getImage().getScaledInstance(
		    100, 
		    100, 
		    Image.SCALE_SMOOTH
		);
		ImageIcon resizedIconAddition = new ImageIcon(resizedImgAddition);		
		btnAddition.setIcon(resizedIconAddition);
		btnAddition.setActionCommand("Addition");
		btnAddition.addActionListener(gestion);
		btnAddition.setPreferredSize(new Dimension(100, 100));
		panelAddition.add(btnAddition);
		
		JPanel panelSoustraction = new JPanel();
		panelSoustraction.setBackground(new Color(255, 238, 172));
		panelSoustraction.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 0));
		panelSoustraction.setBorder(new EmptyBorder(75, 0, 0, 40));
		this.add(panelSoustraction, BorderLayout.EAST);
		
		JButton btnSoustraction = new JButton("");
		btnSoustraction.setActionCommand("Soustraction");
		ImageIcon imgSoustraction = new ImageIcon(menu.class.getResource("/img/soustraction.png"));
		Image resizedImgSoustraction = imgSoustraction.getImage().getScaledInstance(
		    100, 
		    100, 
		    Image.SCALE_SMOOTH
		);
		ImageIcon resizedIconSoustraction = new ImageIcon(resizedImgSoustraction);
		btnSoustraction.setIcon(resizedIconSoustraction);
		btnSoustraction.addActionListener(gestion);
		btnSoustraction.setPreferredSize(new Dimension(100, 100));
		panelSoustraction.add(btnSoustraction);
	}

}
