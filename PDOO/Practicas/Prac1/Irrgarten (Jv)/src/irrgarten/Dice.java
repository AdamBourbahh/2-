/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package irrgarten;
import java.util.Random;
/**
 *
 * @author adam
 */
public class Dice {
private static final int MAX_USES=5;
    private static final float MAX_INTELLIGENCE=10;
    private static final int MAX_INT=11;
    private static final float MAX_STRENGTH = 10;
    private static final float RESURRECT_PROB=0.3f;
    private static final int WEAPONS_REWARD=2;
    private static final int SHIELDS_REWARD=3;
    private static final int HEALTH_REWARD=5;
    private static final int MAX_ATTACK=3;
    private static final int MAX_SHIELD=2;  
    private static final Random GENERATOR = new Random();
    
    public int randomPos(int max){
        return GENERATOR.nextInt(max);
    }
    public int whoStarts(int nplayers){
        return GENERATOR.nextInt(nplayers);
    }
    public float randomIntelligence(){
        return GENERATOR.nextFloat()*MAX_INTELLIGENCE;
    }
    public float randomStrength(){
        return GENERATOR.nextInt(MAX_FRZ)*MAX_STRENGTH;
    }
    public boolean resurrectPlayer(){
        boolean salida=false;
        if(GENERATOR.nextFloat()<=RESURRECT_PROB){
         salida=true;   
        Irrgarten}
        return salida;
    }
    public int weaponsReward(){
        return GENERATOR.nextInt(WEAPONS_REWARD);
    }
    public int shieldsReward(){
        return GENERATOR.nextInt(SHIELDS_REWARD);
    }
    public int healthReward(){
        return GENERATOR.nextInt(HEALTH_REWARD);        
    }
    public float weaponPower(){
        return GENERATOR.nextInt(MAX_ATTACK);        
    }
    public float shieldPower(){
        return GENERATOR.nextInt(MAX_SHIELD);     
    }
    public int usesLeft(){
        return GENERATOR.nextInt(MAX_USES);
    }
    public float intensity(float competence){
        return GENERATOR.nextFloat()*competence;
    }
    public boolean discardElement(int usesLeft){
        boolean salida=false;
        float prob_descarte=1-(1.0f*usesLeft/MAX_USES);
        if(GENERATOR.nextFloat()<=prob_descarte) salida=true;
        return salida;
    }
    
        }
