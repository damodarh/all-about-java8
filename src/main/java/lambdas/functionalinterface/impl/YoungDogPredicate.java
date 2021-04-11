package lambdas.functionalinterface.impl;

import lambdas.functionalinterface.intrface.DogPredicate;
import lambdas.functionalinterface.model.Dog;

public class YoungDogPredicate implements DogPredicate {


    @Override
    public boolean test(Dog d) {
        return d.getAge() < 5;
    }
}
