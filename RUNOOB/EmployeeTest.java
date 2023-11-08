package RUNOOB;

public class EmployeeTest {
    public static void main(String[] args) {
        Employee employee1=new Employee("zjb");
        Employee employee2=new Employee("wyl");

        System.out.println("Create Date:"+Employee.FileDate);
        employee1.setOccupation("Engineer");
        employee1.setAge(19);
        employee1.setWage(30000.00);
        employee1.print();

        employee2.FileDate="2023.9.1";//仍然修改了类的日期
        //故而要注意多实例对象修改static成员的并发问题
        System.out.println("Create Date:"+employee2.FileDate);//实例化的对象访问了大类抽象统一的日期，报警
        employee2.setOccupation("None");
        employee2.setAge(19);
        employee2.setWage(3000.00);
        employee2.print();

        System.out.println(Employee.FileDate);
    }
}
