package lecture14.strategy;

interface RouteStrategy {
    void buildRoute(String startPoint, String endPoint);
}

class CarRouteStrategy implements RouteStrategy {
    @Override
    public void buildRoute(String startPoint, String endPoint) {
        System.out.println("Прокладання маршруту автомобілем від " + startPoint + " до " + endPoint);
    }
}

class WalkingRouteStrategy implements RouteStrategy {
    @Override
    public void buildRoute(String startPoint, String endPoint) {
        System.out.println("Прокладання пішохідного маршруту від " + startPoint + " до " + endPoint);
    }
}

class PublicTransportRouteStrategy implements RouteStrategy {
    @Override
    public void buildRoute(String startPoint, String endPoint) {
        System.out.println("Прокладання маршруту громадським транспортом від " + startPoint + " до " + endPoint);
    }
}

class Navigator {
    private RouteStrategy strategy;

    public void setStrategy(RouteStrategy strategy) {
        this.strategy = strategy;
    }

    public void buildRoute(String startPoint, String endPoint) {
        if (strategy != null) {
            strategy.buildRoute(startPoint, endPoint);
        } else {
            System.out.println("Не обрано стратегію для прокладання маршруту.");
        }
    }
}

public class StrategyExample {
    public static void main(String[] args) {
        Navigator navigator = new Navigator();

        navigator.setStrategy(new CarRouteStrategy());
        navigator.buildRoute("Київ", "Львів");

        navigator.setStrategy(new WalkingRouteStrategy());
        navigator.buildRoute("Київ", "Львів");

        navigator.setStrategy(new PublicTransportRouteStrategy());
        navigator.buildRoute("Київ", "Львів");
    }
}

