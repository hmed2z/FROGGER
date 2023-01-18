package frog;

import gameCommons.Game;
import gameCommons.IFrog;
import util.Case;
import util.Direction;
import java.util.Random;

public class Frog implements IFrog {

	public static Case position;
	public static Direction direction;
	public static Game game;

	public Frog(Game game) {
		this.game=game;
		this.position= new Case(this.game.width/2,0) ;
		this.direction = direction ;
	}


	public Case getPosition() {

		return this.position;
	}


	public Direction getDirection() {

		return this.direction;
	}

	public void move(Direction key) {
		switch(key) {
			case up:
				if(this.position.ord<this.game.height-1)
					this.position.ord ++;
				break;
			case down:
				if(this.position.ord>0)
					this.getPosition().ord --;
				break;
			case left:
				if(this.getPosition().absc>0)
					this.getPosition().absc --;
				break;
			case right:
				if(this.getPosition().absc<this.game.width -1)
					this.getPosition().absc ++;
				break;
		}
		this.direction=key;
		this.game.testLose();
		this.game.testWin();
	}

}
