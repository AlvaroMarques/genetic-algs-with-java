
package genetic2;

import java.util.Arrays;


public class Population {
    float[] xs;double[] ys;
    Chromossome[] population;
    
    public Population(float[] xs,double ys[],int size,int range){
        this.xs = xs;
        this.ys = ys;
        float[] initial;initial = new float[]{0,0};
        population = new Chromossome[size];
        for (int i = 0; i < size; i++) {
            this.population[i] = new Chromossome(initial);
            this.population[i].randomize(range);
        }
        
    }
    void sort(){
        
        Arrays.sort(population, (Chromossome o1, Chromossome o2) -> Double.compare(o1.cost,o2.cost));
    }
    void gen(int NumberOfGenerations){
        while(NumberOfGenerations-->0){
            sort();
            Chromossome[] childs;childs = population[0].mate(population[1]);
            population[population.length-1] = childs[0];
            population[population.length-2] = childs[1];
            for(Chromossome individual: population){
                individual.mutate((float)0.01);
                individual.getCost(xs,ys);
                System.out.println(individual.cost);
            }
        }
    }
}
