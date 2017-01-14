/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package genetic2;

/**
 *
 * @author Álvaro
 */
public class Genetic2 {

    /**
     * @param args the command line arguments
     */
    static void printArray(float[] array){
        for(float i: array){
            System.out.println(i);
        }
    }
    public static void main(String[] args) {
       Population newPop;
       float[] xs;
       double[] ys;
       xs = new float[]{1,2};
       ys = new double[]{5,7};
       newPop = new Population(xs,ys,10,10);
       newPop.gen(10000000);
       printArray(newPop.population[0].constants);
        
        
        
    }
    
}
