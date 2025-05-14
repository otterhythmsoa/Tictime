package controleur;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import ihm.menu;
import ihm.soustractionPanel;
import modele.Duree;

public class soustractionPanelControleur implements ActionListener {

	private soustractionPanel minusPanel;
	
	public soustractionPanelControleur(soustractionPanel minusPanel) {
		this.minusPanel = minusPanel;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		switch(e.getActionCommand()) {
			case "Retour": {
				Container parent = minusPanel.getParent();
				parent.removeAll();
				menu menuPanel = new menu();
				parent.add(menuPanel, BorderLayout.CENTER);
				parent.revalidate();
				parent.repaint();
				break;
			}
			case "Réinitialiser": {
				minusPanel.getLblDuree1().setText("00:00:00");
				minusPanel.getLblDuree2().setText("00:00:00");
				minusPanel.getLblResultat().setText("00:00:00");
				break;
			}
			case "Calculer": {
				String t1 = minusPanel.getLblDuree1().getText();
				String[] parties1 = t1.split(":");
				int h1 = Integer.parseInt(parties1[0]);
				int min1 = Integer.parseInt(parties1[1]);
				int s1 = Integer.parseInt(parties1[2]);
				Duree d1 = new Duree(h1,min1,s1);
				
				String t2 = minusPanel.getLblDuree2().getText();
				String[] parties2 = t2.split(":");
				int h2 = Integer.parseInt(parties2[0]);
				int min2 = Integer.parseInt(parties2[1]);
				int s2 = Integer.parseInt(parties2[2]);
				Duree d2 = new Duree(h2,min2,s2);
				try {
					Duree res = d1.soustraction(d2);
					minusPanel.getLblResultat().setText(res.toString());
				} catch (IllegalArgumentException exception){
					JOptionPane.showMessageDialog(
					        null,
					        "Erreur : " + exception.getMessage(),
					        "Erreur",
					        JOptionPane.ERROR_MESSAGE
					    );
				}
				break;
			}
		}
	}
}
