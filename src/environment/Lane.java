package environment;

import java.util.ArrayList;

import util.Case;
import gameCommons.Game;

public class Lane {
	private Game game;
	private int ord;
	private int speed;
	private ArrayList<Car> cars = new ArrayList<>();
	private boolean leftToRight;
	private double density;

	public Lane(Game game,int i,double densite) {
		this.cars= new ArrayList<Car>();
		this.ord=i;
		this.game=game;
		this.density=densite;
		this.speed=game.randomGen.nextInt(15);
		this.leftToRight=game.randomGen.nextBoolean();
	}

	public void update() {
		mayAddCar();
		removeCar();
		for(Car car:this.cars) {
			car.move();
			car.carUpdate();
		}


		// Toutes les voitures se d�placent d'une case au bout d'un nombre "tic
		// d'horloge" �gal � leur vitesse
		// Notez que cette m�thode est appel�e � chaque tic d'horloge

		// Les voitures doivent etre ajoutes a l interface graphique meme quand
		// elle ne bougent pas

		// A chaque tic d'horloge, une voiture peut �tre ajout�e

	}

	public boolean isSafe(Case c) {
		if( c.ord == this.ord  ) {
			for(Car car : this.cars) {
				for(int i=0; i<car.carLength(); i++) {
					if(car.firstCase().absc+i==c.absc){
						return false;
					}
				}
			}
		}
		return true;
	}

	public boolean outOfScreen(int i) {
		return (this.cars.get(i).lastCase().absc>this.game.width+3) || (this.cars.get(i).lastCase().absc<-3);
	}

	public void removeCar() {
		int i=0;
		while (i<this.cars.size()) {
			if(outOfScreen(i))
				this.cars.remove(i);
			else
				i++;

		}
	}


	/*
	 * Fourni : mayAddCar(), getFirstCase() et getBeforeFirstCase() 
	 */

	/**
	 * Ajoute une voiture au d�but de la voie avec probabilit� �gale � la
	 * densit�, si la premi�re case de la voie est vide
	 */
	private void mayAddCar() {
		if (isSafe(getFirstCase()) && isSafe(getBeforeFirstCase())) {
			if (game.randomGen.nextDouble() < density) {
				cars.add(new Car(game, getBeforeFirstCase(), leftToRight));
			}
		}
	}

	private Case getFirstCase() {
		if (leftToRight) {
			return new Case(0, ord);
		} else
			return new Case(game.width - 1, ord);
	}

	private Case getBeforeFirstCase() {
		if (leftToRight) {
			return new Case(-1, ord);
		} else
			return new Case(game.width, ord);
	}

}
