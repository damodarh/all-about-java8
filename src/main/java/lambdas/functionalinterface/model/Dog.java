package lambdas.functionalinterface.model;

public class Dog {

    private String breed;
    private int age;

    public Dog(String breed,int age){
        this.breed = breed;
        this.age = age;
    }

    public String getBreed(){
        return this.breed;
    }

    public int getAge(){
        return this.age;
    }

    public void setBreed(String breed){
        this.breed = breed;
    }

    public void setAge(int age){
        this.age = age;
    }

    public String toString() {
        return "Dog { breed = '"+breed+"', age = "+age+"}";
    }
}
