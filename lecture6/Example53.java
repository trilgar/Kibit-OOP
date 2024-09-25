package lecture6;

public class Example53 {
    public static void main(String argv[]) {
        SalesPerson s1 = new SalesPerson("12345S");
        SalesPerson s2 = new SalesPerson("33221K");
        System.out.println(s1.getCount() + " salespersons have been created");
    }

    static class SalesPerson {
        String employeeId;
        static int count = 0;

        SalesPerson(String aEmployeeId) {
            employeeId = aEmployeeId;
            count = count + 1;
        }

        int getCount() {
            return count;
        }

    }
}

