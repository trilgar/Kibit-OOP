package lecture4.example32;

public class Main {
    public static void main(String argv[]) {
        Manager m = new Manager("Simon", "01234M", 9000.0f, 2000.0f);
        Secretary s = new Secretary("Selene", "98765S", 2500.0f);

        System.out.print("The Manager " + m.getName() + " (employee number " + m.getEmployeeNumber() + ")");
        System.out.println(" has a salary of " + m.getBasicSalary());
        System.out.print("The Manager " + m.getName());
        System.out.println(" also has an allowance of " + m.getAllowance());

        System.out.print("The Secretary " + s.getName() + "(employee number " + s.getEmployeeNumber() + ")");
        System.out.println(" has a salary of " + s.getBasicSalary());

        System.out.print("The Manager " + m.getName() + " (employee number " + m.getEmployeeNumber() + ")");
        System.out.println(" is paid total of " + m.getPay());
        System.out.print("The Secretary " + s.getName() + "(employee number " + s.getEmployeeNumber() + ")");
        System.out.println(" is paid total of " + s.getPay());
    }
}

class Person {
    private String name;

    Person(String aName) {
        name = aName;
    }

    public String getName() {
        return name;
    }
}

class Employee extends Person {
    private float basicSalary;
    private String employeeNumber;

    Employee(String aName, String aEmployeeNumber, float aBasicSalary) {
        super(aName);
        employeeNumber = aEmployeeNumber;
        basicSalary = aBasicSalary;
    }

    public String getEmployeeNumber() {
        return employeeNumber;
    }

    public float getBasicSalary() {
        return basicSalary;
    }

    public float getPay() {
        return basicSalary;
    }
}

class Manager extends Employee {
    private float allowance;

    Manager(String aName, String aEmployeeNumber, float aBasicSalary, float aAllowanceAmt) {
        super(aName, aEmployeeNumber, aBasicSalary);
        allowance = aAllowanceAmt;
    }

    public float getAllowance() {
        return allowance;
    }

    @Override
    public float getPay() {
        return (super.getPay() + allowance);
    }
}

class Secretary extends Employee {
    Secretary(String aName, String aEmployeeNumber,
              float aBasicSalary) {
        super(aName, aEmployeeNumber, aBasicSalary);
    }
}