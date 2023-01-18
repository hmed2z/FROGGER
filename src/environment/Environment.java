package environment;

import java.util.ArrayList;
import java.util.Random;

import gameCommons.Game;
import gameCommons.IEnvironment;
import util.Case;

public class Environment implements IEnvironment {

    private Game game;
    private ArrayList<Lane> lanes = new ArrayList<>();
    public static Random randomGen = new Random();
    private double densite;

    private final int density = 10;


    public Environment(Game game) {
        this.game = game;
        this.lanes.add(new Lane(game, 0, 0));
        for (int i = 1; i < this.game.height - 1; i++) {
            densite = this.game.randomGen.nextDouble() / density;
            this.lanes.add(new Lane(game, i, densite));
        }
        this.lanes.add(new Lane(game, game.height - 1, 0));



        for (int i = 0; i < 5 / 2 * this.game.width; i++) {
            for (Lane lane : this.lanes)
                lane.update();
        }
    }

    public boolean isSafe(Case c) {
        for (Lane lane : this.lanes) {
            if (!(lane.isSafe(c)))
                return false;
        }
        return true;

    }


    public boolean isWinningPosition(Case c) {
        return (c.ord == this.game.height - 1);
    }

    public ArrayList<Lane> getLanes() {
        return this.lanes;
    }

    public void update() {
        for (Lane lane : this.lanes)
            lane.update();
    }

}
