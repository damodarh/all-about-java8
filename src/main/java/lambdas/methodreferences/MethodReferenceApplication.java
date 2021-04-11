package lambdas.methodreferences;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static java.util.Comparator.comparing;

public class MethodReferenceApplication {

    public static void main(String... args){

        List<Apple> inventory = new ArrayList<>();
        inventory.addAll(Arrays.asList(new Apple(80,"green"), new Apple(155, "green"), new Apple(120, "red")));
        inventory.sort(new AppleComparator());

        System.out.println("Using classic comparator : " + inventory);

        inventory.add(1,new Apple(65,"red"));

        inventory.sort(new AppleComparator(){
            public int compare(Apple a1, Apple a2){
                return a1.getWeight().compareTo(a2.getWeight());
            }
        });

        System.out.println("Using anonymous class comparator : " + inventory);

        inventory.add(1,new Apple(30,"green"));

        inventory.sort((a1, a2) -> a1.getWeight().compareTo(a2.getWeight()));

        System.out.println("Using lambda function ((a1,a2) -> a1.getWeight().compareTo(a2.getWeight())) : " + inventory);

        inventory.add(1,new Apple(85,"red"));

        inventory.sort(comparing(Apple::getWeight));

        System.out.println("Using method reference (Apple::getWeight) : " + inventory);

    }
}
