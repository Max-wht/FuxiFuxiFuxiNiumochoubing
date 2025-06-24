package tech.insight.observe;

/**
 * @author Max
 * @description
 * @date 2025/6/23 17:21
 */
public class Main {
    //观察者模式 --> 事件产生者直接连接监听器，需要内部维护监听器的List
    //发布订阅 --> 事件产生者 -> 总线 -> 监听器
    public static void main(String[] args) {
        Publisher publisher = new Publisher();
        WeatherStation station = new WeatherStation(publisher);
        User tom = new User("Tom", info -> {
            if (info.equals("晴天"))
                System.out.println("Sunny Day, Tom goes out");
            else
                System.out.println("Rainy Day, Tom stays at home");
        });
        User jerry = new User("Jerry", info -> {
            if (info.equals("阴天"))
                System.out.println("Rainy Day, Jerry sleeps");
            else
                System.out.println("Sunny Day, Jerry jungles");
        });
        publisher.subscribe(tom, WeatherUpdateEvent.class);
        publisher.subscribe(jerry, WeatherUpdateEvent.class);
        station.run();
    }
}
