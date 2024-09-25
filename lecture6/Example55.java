package lecture6;

public class Example55 {
    public static void main(String argv[]) {
        SalesPerson s1 = new SalesPerson("12345S");
        SalesPerson s2 = new SalesPerson("33221K");
        System.out.println(s1.getCount() + " salespersons have been created");
//        System.out.println(s1.count + " salespersons have been created"); error: no access to private member outside the class
    }
}

class SalesPerson {
    public String employeeId;
    private static int count = 0;

    SalesPerson(String aEmployeeId) {
        employeeId = aEmployeeId;
        count = count + 1;
    }

    public static int getCount() {
        return count;
    }
}

