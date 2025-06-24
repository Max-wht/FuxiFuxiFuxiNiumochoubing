package tech.insight;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Max
 * @description
 * @date 2025/6/21 13:25
 */
public class City implements PopulationNode{

    private final String name;

    List<PopulationNode> districts = new ArrayList<>();

    public City(String name) {
        this.name = name;
    }

    public void addDistrict(District district){
        districts.add(district);
    }

    @Override
    public int computePopulation() {
        return districts.stream().mapToInt(PopulationNode::computePopulation).sum();
    }
}
