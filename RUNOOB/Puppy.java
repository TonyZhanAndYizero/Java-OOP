package RUNOOB;

public class Puppy {
    int puppyAge;
    public Puppy(String name){
        System.out.println("The dog's name is " + name);
    }

    public void setPuppyAge(int puppyAge) {
        this.puppyAge = puppyAge;
    }

    public int getPuppyAge(){
        System.out.println(this.puppyAge);
        return this.puppyAge;
    }

    public static void main(String[] args) {
        Puppy myPuppy=new Puppy("wyl");
        myPuppy.setPuppyAge(19);
        int age=myPuppy.getPuppyAge();
        System.out.println("Function gets " + age);
    }
}
