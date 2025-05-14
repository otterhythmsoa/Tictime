package controleur;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import ihm.additionPanel;
import ihm.menu;
import modele.Duree;

public class additionPanelControleur implements ActionListener {

	private additionPanel addPanel;
	
	public additionPanelControleur(additionPanel addPanel) {
		this.addPanel = addPanel;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		switch(e.getActionCommand()) {
			case "Retour": {
				Container parent = addPanel.getParent();
				parent.removeAll();
				menu menuPanel = new menu();
				parent.add(menuPanel, BorderLayout.CENTER);
				parent.revalidate();
				parent.repaint();
				break;
			}
			case "Réinitialiser": {
				addPanel.getLblDuree1().setText("00:00:00");
				addPanel.getLblDuree2().setText("00:00:00");
				addPanel.getLblResultat().setText("00:00:00");
			}
			case "Calculer": {
				String t1 = addPanel.getLblDuree1().getText();
				String[] parties1 = t1.split(":");
				int h1 = Integer.parseInt(parties1[0]);
				int min1 = Integer.parseInt(parties1[1]);
				int s1 = Integer.parseInt(parties1[2]);
				Duree d1 = new Duree(h1,min1,s1);
				
				String t2 = addPanel.getLblDuree2().getText();
				String[] parties2 = t2.split(":");
				int h2 = Integer.parseInt(parties2[0]);
				int min2 = Integer.parseInt(parties2[1]);
				int s2 = Integer.parseInt(parties2[2]);
				Duree d2 = new Duree(h2,min2,s2);
				
				Duree res = d1.addition(d2);
				addPanel.getLblResultat().setText(res.toString());
			}
		}
	}

}
