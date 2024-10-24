package lecture10.yagni.example1;

public class BadExample {
    public class ReportGenerator {
        public void generateReport(String type, String format, String locale) {
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

            if (locale.equals("uk_UA")) {
                // Локалізація для української
            }
        }
    }

}
