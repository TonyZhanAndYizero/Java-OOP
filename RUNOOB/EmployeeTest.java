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

        employee2.FileDate="2023.9.1";//��Ȼ�޸����������
        //�ʶ�Ҫע���ʵ�������޸�static��Ա�Ĳ�������
        System.out.println("Create Date:"+employee2.FileDate);//ʵ�����Ķ�������˴������ͳһ�����ڣ�����
        employee2.setOccupation("None");
        employee2.setAge(19);
        employee2.setWage(3000.00);
        employee2.print();

        System.out.println(Employee.FileDate);
    }
}
