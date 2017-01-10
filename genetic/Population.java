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

public class Population {
    char[] goalChar;
    String goalString;
    Chromossome[] population;
    //Chromossome pop;
    public Population(int size,String goal){
        int goalLength;
        goalLength = goal.length();
        this.goalChar = new char[goalLength];
        for(int i =0;i<goalLength;i++){
            this.goalChar[i] = goal.charAt(i);
        }
        this.population = new Chromossome[size];
        for(int i=0;i<size;i++){
            char[] j = new char[goalLength];
            this.population[i] = new Chromossome(j);
            this.population[i].randomize(goalLength);
        }
        this.goalString = new String(goalChar);
    }
    void sort(){
        for(Chromossome chromo: population){
            chromo.calcCost(goalChar);
        }
        Arrays.sort(population,new Comparator<Chromossome>(){

            @Override
            public int compare(Chromossome o1, Chromossome o2) {
                return Integer.compare(o1.cost,o2.cost); //To change body of generated methods, choose Tools | Templates.
            }
        
        });
    }
    void gen(int maxG){
        while(maxG-->0){
            sort();
            Chromossome p1 = population[0];
            Chromossome p2 = population[1];
            Chromossome[] childs;
            childs = p1.mate(p2);
            population[population.length-1] = childs[0];
            population[population.length-2] = childs[1];
            for(Chromossome individual: population){
                individual.mutate(0.1);
                System.out.println(individual.code_str);
                if(individual.cost ==0){
                    System.out.println(maxG);
                    maxG = 0;
                    break;
                } 
            }
        }
    }
    
}
