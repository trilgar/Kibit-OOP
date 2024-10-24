package lecture10.yagni.example1;

public class GoodExample {
    public class ReportGenerator {
        public void generateReport(String type, String format) {
            if (type.equals("summary")) {
                // Генерація зведеного звіту
            } else if (type.equals("detailed")) {
                // Генерація детального звіту
            }

            if (format.equals("PDF")) {
                // Експорт у PDF
            } else if (format.equals("Excel")) {
                // Експорт у Excel
            }
        }
    }

}
