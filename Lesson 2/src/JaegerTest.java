import java.util.ArrayList;
import java.util.List;

public class JaegerTest {
    public static void main(String[] args) {
        List<Jaeger> jaegerList = new ArrayList<>();
        Jaeger brawlerYukon = new Jaeger("Brawler Yukon", "Mark-1", "USA", 45.4f, 1.25f, 5, 9);
        Jaeger crimsonTyphoon = new Jaeger();
        crimsonTyphoon.setModelName("Crimson Typhoon");
        crimsonTyphoon.setMark("Mark-4");
        crimsonTyphoon.setOrigin("China");
        crimsonTyphoon.setHeight(76.2f);
        crimsonTyphoon.setWeight(1.722f);
        crimsonTyphoon.setArmor(6);
        crimsonTyphoon.setStrength(8);
        jaegerList.add(brawlerYukon);
        jaegerList.add(crimsonTyphoon);

        for(Jaeger jaeger: jaegerList) {
            System.out.println("Model name: " + jaeger.getModelName());
            System.out.println("Mark: " + jaeger.getMark());
            System.out.println("origin: " + jaeger.getOrigin());
            System.out.println("height: " + jaeger.getHeight());
            System.out.println("weight: " + jaeger.getWeight());
            System.out.println("armor: " + jaeger.getArmor());
            System.out.println("strength: " + jaeger.getStrength());
            System.out.println("");
        }
    }
}