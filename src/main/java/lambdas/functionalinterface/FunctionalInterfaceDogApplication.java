package lambdas.functionalinterface;

import lambdas.functionalinterface.impl.YoungDogPredicate;
import lambdas.functionalinterface.intrface.DogPredicate;
import lambdas.functionalinterface.model.Dog;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FunctionalInterfaceDogApplication {

    private static void getOldDogs(List<Dog> dogs){
        //dogs with age > 5
        List<Dog> oldDogs = new ArrayList<>();
        for(Dog d : dogs){
            if(d.getAge() > 5)
                oldDogs.add(d);
        }
        System.out.println("Using Java 7 to get dogs with age > 5: "+oldDogs);
    }

    private static void getYoungDogsPredicate(List<Dog> dogs, DogPredicate dogPredicate){

        //dogs with age < 5
        List<Dog> youngDogs = new ArrayList<>();
        for(Dog d : dogs){
            if(dogPredicate.test(d))
                youngDogs.add(d);
        }
        System.out.println("Using predicates to get dogs with age < 5 : "+youngDogs);
    }

    private static void getYoungDogsAnonymousClass(List<Dog> dogs,DogPredicate dogPredicate){
        //get young huskys
        List<Dog> youngHuskys = new ArrayList<>();
        for(Dog d : dogs){
            if(dogPredicate.test(d))
                youngHuskys.add(d);
        }
        System.out.println("Using anonymous class to get young huskys (age < 5) : "+youngHuskys);
    }

    public static void main(String args[]){

        List<Dog> dogs = Arrays.asList(new Dog("German shepherd",1),new Dog("Doberman",5),
                new Dog("Pug",3),new Dog("Cockerspaniel",7),new Dog("Husky",9),
                new Dog("Chihua",4),new Dog("Doberman",11),new Dog("Husky",3));

        System.out.println("List of dogs avialable : "+dogs);
        FunctionalInterfaceDogApplication.getOldDogs(dogs);
        FunctionalInterfaceDogApplication.getYoungDogsPredicate(dogs,new YoungDogPredicate());
        FunctionalInterfaceDogApplication.getYoungDogsAnonymousClass(dogs, new YoungDogPredicate(){
            public boolean test(Dog d){
                return d.getAge() < 5 && d.getBreed().equalsIgnoreCase("husky");
            }
        });
    }

}
