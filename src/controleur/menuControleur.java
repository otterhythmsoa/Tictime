package controleur;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import ihm.additionPanel;
import ihm.menu;
import ihm.soustractionPanel;

public class menuControleur implements ActionListener {
	
	private menu menuPanel;
	
	public menuControleur(menu menuPanel) {
		this.menuPanel = menuPanel;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		switch(e.getActionCommand()) {
			case "Addition": {
				Container parent = menuPanel.getParent();
				parent.removeAll();
				additionPanel addPanel = new additionPanel();
				parent.add(addPanel, BorderLayout.CENTER);
				parent.revalidate();
				parent.repaint();
				break;
			}
			case "Soustraction": {
				Container parent = menuPanel.getParent();
				parent.removeAll();
				soustractionPanel addPanel = new soustractionPanel();
				parent.add(addPanel, BorderLayout.CENTER);
				parent.revalidate();
				parent.repaint();
				break;
			}
		}
	}

}
