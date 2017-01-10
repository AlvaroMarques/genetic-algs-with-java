/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package genetic;

import java.util.Arrays;
import java.util.Comparator;
/**
 *
 * @author Álvaro
 */
public class Genetic {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String goal = "The Dirk Gently Holistic Agency";
        int size = 10;
        Population pop = new Population(size,goal);
        pop.gen(200000);
        //Chromossome test = pop.population[-1];
        //System.out.println(test.code_str);
    }
    
}
