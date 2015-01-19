/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fifa;

/**
 *
 * @author antoine
 */
public class Confrontation {
    private final Arbitre arbitre;
    private final Equipe equipeDom,equipeExt;
    private int scoreDom,scoreExt;

    public Confrontation(Equipe equipeDom, Equipe equipeExt,Arbitre arbitre) {
        this.equipeDom = equipeDom;
        this.equipeExt= equipeExt;
        this.scoreDom=scoreExt=-1;
        this.arbitre=arbitre;
    }

    public Equipe getEquipeDom() {
        return equipeDom;
    }
    
    /**
     * retourn resultat match
     *
     * @return 1 si equipe domicile a gagné,-1 sinon,2 si égalité;
     */
    public int domWin(){
        if(this.scoreDom>this.scoreExt){
            return 1;
        }else if(this.scoreDom<this.scoreExt)
            return -1;
        else 
            return 2;
    }

    public int getScoreDom() {
        return scoreDom;
    }

    public int getScoreExt() {
        return scoreExt;
    }
/**
 * 
 * @param dom score domicil
 * @param ext score exterieur
 */
    public void setScore(int dom,int ext){
        this.scoreDom=dom;
        this.scoreExt=ext;
    }
    public Equipe getEquipeExt() {
        return equipeExt;
    }

    public Arbitre getArbitre() {
        return arbitre;
    }

    @Override
    public String toString() {
        return "arbitre=" + arbitre + ", equipe dom=" + equipeDom + " VS " + equipeExt;
    }
    
}
