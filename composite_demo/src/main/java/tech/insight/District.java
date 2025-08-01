package tech.insight;

/**
 * @author Max
 * @description
 * @date 2025/6/21 13:25
 */
public class District implements PopulationNode{

    private final String name;

    private int population;

    public District(String name, int population) {
        this.name = name;
        this.population = population;
    }

    @Override
    public int computePopulation() {
        return population;
    }
}
