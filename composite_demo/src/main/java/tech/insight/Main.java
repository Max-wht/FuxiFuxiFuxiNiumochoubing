package tech.insight;

/**
 * @author Max
 * @description
 * @date 2025/6/21 13:23
 */
public class Main {
    public static void main(String[] args) {
        // 创建几个区（District）
        District district1 = new District("朝阳区", 3000000);
        District district2 = new District("海淀区", 4000000);
        District district3 = new District("东城区", 2000000);

        // 创建城市（City），并添加区
        City beijingCity = new City("北京市");
        beijingCity.addDistrict(district1);
        beijingCity.addDistrict(district2);

        City shanghaiCity = new City("上海市");
        shanghaiCity.addDistrict(district3);

        // 创建省份（Province），并添加城市
        Province province = new Province("华北地区");
        province.addCity(beijingCity);
        province.addCity(shanghaiCity);

        // 计算总人口
        int totalPopulation = province.computePopulation();
        System.out.println("总人口：" + totalPopulation);
    }
}
