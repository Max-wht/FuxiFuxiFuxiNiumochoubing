package tech.insight;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Max
 * @description
 * @date 2025/6/21 13:32
 */
public class Province implements PopulationNode{

    List<PopulationNode> cities = new ArrayList<>();

    private final String name;

    public Province(String name) {
        this.name = name;
    }

    public void addCity(City city) {
        cities.add(city);
    }

    @Override
    public int computePopulation() {
        return cities.stream().mapToInt(PopulationNode::computePopulation).sum();
    }
}
