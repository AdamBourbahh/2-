/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package irrgarten;

/**
 *
 * @author adam
 */
public class Weapon { 
    private float power;
    private int uses;
    private Dice dado=new Dice();
    public Weapon (float power, int uses){
    this.power=power;
    this.uses=uses;
    }
    public float attack(){
        float ataque=0;
        if(uses>0){
            uses--;
            ataque=power;
        }
        return ataque;
    }
    public String toString(){
        return "W["+power+","+uses+"]";
    }
    public boolean discard(){
        return dado.discardElement(uses);
    }
}

