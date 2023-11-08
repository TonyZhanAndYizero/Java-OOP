package RUNOOB;

public class Employee {
    public static String FileDate = "2023.9.7";//仅一个副本，并发问题
    public String name;//子类均可见，多个副本，无并发问题
    private int age;//子类不可见，多个副本，无并发问题
    private String occupation;
    private double wage;

    public Employee(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setOccupation(String occupation) {
        this.occupation = occupation;
    }

    public void setWage(double wage) {
        this.wage = wage;
    }

    public void print() {
        System.out.println("name:" + this.name);
        System.out.println("age:" + this.age);
        System.out.println("occupation:" + this.occupation);
        System.out.println("wage:" + this.wage);
    }
}
