package modele;
public class Duree {
	
	private int heures;
	private int minutes;
	private int secondes;
	
	public Duree(int heures, int minutes, int secondes) throws IllegalArgumentException {
		if (secondes < 0) {
			throw new IllegalArgumentException("La valeur des secondes doit être positive.");
		}
		if (minutes < 0) {
			throw new IllegalArgumentException("La valeur des minutes doit être positive.");
		}
		this.heures = heures;
		this.minutes = minutes;
		this.secondes = secondes;
	}

	public int getHeures() {
		return heures;
	}

	public void setHeures(int heures) {
		this.heures = heures;
	}

	public int getMinutes() {
		return minutes;
	}

	public void setMinutes(int minutes) {
		this.minutes = minutes;
	}

	public int getSecondes() {
		return secondes;
	}

	public void setSecondes(int secondes) {
		this.secondes = secondes;
	}
	
	public String toString() {
		String heures = "";
		if (this.getHeures() < 10 && this.getHeures() >= 0) {
			heures = "0" + this.getHeures();
		} else {
			heures = Integer.toString(this.getHeures());
		}
		

		String minutes = "";
		if (this.getMinutes() < 10 && this.getMinutes() >= 0) {
			minutes = "0" + this.getMinutes();
		} else {
			minutes = Integer.toString(this.getMinutes());
		}
		
		String secondes = "";
		if (this.getSecondes() < 10 && this.getSecondes() >= 0) {
			secondes = "0" + this.getSecondes();
		} else {
			secondes = Integer.toString(this.getSecondes());
		}
		
		return heures + ":" + minutes + ":" + secondes;
	}
	
	public Duree addition(Duree d) {
		int s = this.secondes + d.getSecondes();
		int min = this.minutes + d.getMinutes();
		int h = this.heures + d.getHeures();
		
		while (s >= 60) {
			min += 1;
			s -= 60;
		}
		
		while (min >= 60) {
			h += 1;
			min -= 60;
		}
		
		Duree duree = new Duree(h,min,s);
		return duree;
	}
	
	public Duree soustraction(Duree d) throws IllegalArgumentException {
		if ((d.getHeures() > this.heures) || (d.getMinutes() > this.minutes && d.getHeures() == 0 && this.heures == 0) ||
		(d.getSecondes() > this.secondes && d.getHeures() == 0 && this.heures == 0 && d.getMinutes() == 0 && this.minutes == 0)) {
			throw new IllegalArgumentException("La deuxième durée doit être inférieure à la première.");
		}
		
		int s = 0;
		int min = 0;
		int h = 0;

		while (this.secondes < d.getSecondes()) {
			this.secondes += 60;
			this.minutes -= 1;
		}
		
		while (this.minutes < d.getMinutes()) {
			this.minutes += 60;
			this.heures -= 1;
		}
		
		s = this.secondes - d.getSecondes();
		min = this.minutes - d.getMinutes();
		h = this.heures - d.getHeures();
		
		Duree duree = new Duree(h,min,s);
		return duree;
	}
}