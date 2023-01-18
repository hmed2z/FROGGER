package environment;

import gameCommons.Game;
import java.util.ArrayList;
import java.util.Random;

import util.Case;
import util.Direction;
import gameCommons.IEnvironment;

public class EnvInf extends Environment {

    private Game game;
    private ArrayList<Lane> lanes= new ArrayList<>();
    public static Random randomGen = new Random();
    private double dens;



    public EnvInf(Game game) {
        super(game);
    }

    /*
     * Faut qu'on ai la case actuel du frog,
     * Si cette case est audessus d'un certaine lane
     * (milieu) on "d�cale" les lanes, cad on supprime
     * la derni�re lane puis on ajoute une audessus
     */
    public void update() {
        for(Lane lane:this.getLanes())
            lane.update();
    }

    //PARTIE 3

    public void laneAdd() {

        this.lanes.add(new Lane(this.game,this.game.height,this.game.randomGen.nextDouble()/5));


        /*
         * Score= Variable qui compte le nb de lignes franchies,( le nombre max ?) a impl�menter si on le fait comme �a
         */
    }

    public void laneDel() {
        this.lanes.remove(0);// L'arrayList supprimera au fur et � mesure donc forc�ment premi�re position qu'on supprime

        //Pas encore utilis�e
    }
/*
    public void tabLaneUpdate(){
        if(this.game.getFrog().getDirection()==Direction.up) {
            for(Lane lane : this.lanes ) {
                lane.updatePosLane();
            }
            this.game.setFrogNull();
        }


    }*/

}
