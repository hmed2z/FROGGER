package environment;

import java.awt.Color;

import util.Case;
import gameCommons.Game;
import graphicalElements.Element;

public class Car {
	private Game game;
	private Case leftPosition;
	private boolean leftToRight;
	private int length;
	private final Color colorLtR = Color.RED;
	private final Color colorRtL = Color.BLUE;

	public Car (Game game, Case firstCase, boolean leftToRight){
		this.game=game ;
		this.leftToRight=leftToRight;
		this.length=game.randomGen.nextInt(3);
		this.leftPosition=firstCase;
		Color colorCar ;
		if(leftToRight) {
			colorCar = colorLtR ;
		} else {
			colorCar = colorRtL ;

		}
	}

	public void move() {
		if(this.leftToRight)
			this.leftPosition.absc = this.leftPosition.absc + 1 ;
		else
			this.leftPosition.absc = this.leftPosition.absc - 1 ;
		this.addToGraphics();
	}

	public Case leftPos() {
		if(this.leftToRight)
			return new Case(this.leftPosition.absc-(length-1),this.leftPosition.ord);
		else
			return new Case(this.leftPosition.absc,this.leftPosition.ord);
	}


	public int carLength() {
		return this.length;
	}


	public Case firstCase() {
		return this.leftPosition;
	}


	public Case lastCase() {
		if(this.leftToRight)
			return new Case(this.leftPosition.absc-(length-1),this.leftPosition.ord);
		else
			return new Case(this.leftPosition.absc+(length-1),this.leftPosition.ord);
	}

	public boolean leftToRight() {
		return this.leftToRight;
	}

	public void carUpdate() {
		this.addToGraphics();

	}
	
	/* Fourni : addToGraphics() permettant d'ajouter un element graphique correspondant a la voiture*/
	private void addToGraphics() {
		for (int i = 0; i < length; i++) {
			Color color = colorRtL;
			if (this.leftToRight){
				color = colorLtR;
			}
			game.getGraphic()
					.add(new Element(leftPosition.absc + i, leftPosition.ord, color));
		}
	}

}
