/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package irrgarten;

/**
 *
 * @author adam
 */
public class Shield {
    private float protection;
    private int uses;
    Dice dado=new Dice();
    
    Shield(float protection, int uses){
        this.protection=protection;
        this.uses=uses;
    }
    
    public float protection(){
        float proteccion=0;
        if(uses>0){
            uses--;
            proteccion=protection;
        }
        return proteccion;
    }
    
    public String toString(){
        return "S[" + protection + "," + uses + "]";
    }
    
    public boolean discard(){
        return dado.discardElement(uses);
    }
}
