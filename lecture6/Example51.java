package lecture6;

public class Example51 {
    public static void main(String arg[]) {
        int count = 0;
        SalesPerson s1 = new SalesPerson("12345S");
        count = count + 1;
        SalesPerson s2 = new SalesPerson("33221K");
        count = count + 1;
        System.out.println(count + " salespersons have been created");
    }
    static class SalesPerson {
        String employeeId;

        SalesPerson(String aEmployeeId) {
            employeeId = aEmployeeId;
        }

    }
}
