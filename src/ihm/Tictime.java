package ihm;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;

public class Tictime extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel cardPanel;

	/**
	 * Create the frame.
	 */
	public Tictime() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(Tictime.class.getResource("/img/icone.png")));
		setPreferredSize(new Dimension(370, 355));
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 355, 380);
		setLocationRelativeTo(null);
		cardPanel = new JPanel();
		cardPanel.setBackground(new Color(255, 238, 172));
		cardPanel.setSize(new Dimension(370, 380));
		cardPanel.setMinimumSize(new Dimension(370, 380));
		cardPanel.setMaximumSize(new Dimension(370, 380));
		cardPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		
		setContentPane(cardPanel);
		cardPanel.setLayout(new BorderLayout());
		
		menu menuPanel = new menu();
		cardPanel.add(menuPanel, BorderLayout.CENTER);
		revalidate();
		repaint();
	}
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Tictime frame = new Tictime();
					frame.setTitle("Tictime");
					frame.setSize(new Dimension(390, 400));
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
