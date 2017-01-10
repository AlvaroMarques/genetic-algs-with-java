/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package genetic;

import java.util.Random;

/**
 *
 * @author Álvaro
 */
public class Chromossome {

    char[] code;
    String code_str;
    int cost = 9999;
    public Chromossome(char[] code){
        this.code = code;
        this.code_str = new String(code);
    }
    void randomize(int len){
        Random r = new Random();
        
        for(int i=0;i<len;i++){
            code[i] = (char)(r.nextInt(127));
        }
        code_str = new String(code);
    }
    void mutate(double p){
        Random r = new Random();
        if(r.nextDouble()<p){
            int index = r.nextInt(code.length);
            code[index] = (r.nextDouble()>0.5)?(char)(code[index]+1):(char)(code[index]-1);
            code_str = new String(code);
        }
    }
    void calcCost(char[] goal){
        int total = 0;
        for(int i =0;i<goal.length;i++){
            total += (int)(Math.pow((code[i]-goal[i]),2));
        }
        cost = total;
    }
    Chromossome[] mate(Chromossome other){
        Random r = new Random();
        int index = r.nextInt(code.length);
        char[] child1,child2;
        child1 = new char[code.length];
        child2 = new char[code.length];
        for(int i = 0;i<code.length;i++){
            if(i<index){
                child1[i] = code[i];
                child2[i] = other.code[i];
            }else{
                child1[i] = other.code[i];
                child2[i] = code[i];
            }
        }
        Chromossome c1 = new Chromossome(child1);
        Chromossome c2 = new Chromossome(child2);
        Chromossome[] arr = new Chromossome[]{c1,c2};
        return arr;
    }
}
