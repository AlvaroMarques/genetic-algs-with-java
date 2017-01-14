/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package genetic2;

public class Chromossome {
    float[] constants;
    double cost = 9999;
    public Chromossome(float[] k){
        this.constants = k.clone();
    }
    double function(double n){
        return (constants[0]*n)+constants[1];
    }
    void randomize(int range){
        for(int i =0;i<constants.length;i++){
            constants[i] = (float) Math.random()*range;
            if(Math.random()>0.5){
                constants[i] *= -1;
            }
        }
    }
    void getCost(float[] x, double[] y){
        double t = 0;
        for (int i = 0; i < x.length; i++) {
            t += Math.pow((y[i] - function((double)x[i])),2); 
        }
        cost = t/x.length;
    }
    void mutate(float pm){
        
        if(Math.random()<pm){
            
            int index = (int) (Math.random()*constants.length);
            constants[index] += (Math.random()>0.5)?0.01:-0.01;
            
        }
    }
    Chromossome[] mate(Chromossome other){
        int index = (int) (Math.random()*constants.length);
        float constants1[],constants2[];
        constants1 = new float[constants.length];
        constants2 = new float[constants.length];
        for (int i = 0; i < constants.length; i++) {
            if(i < index){
                constants1[i] = constants[i];
                constants2[i] = other.constants[i];
            }else{
                constants1[i] = other.constants[i];
                constants2[i] = constants[i];
            }
        }
        Chromossome child1 = new Chromossome(constants1);
        Chromossome child2 = new Chromossome(constants2);
        Chromossome childs[] = new Chromossome[]{child1,child2};
        return childs;
    }
}
