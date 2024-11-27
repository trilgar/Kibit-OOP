package lecture15.templatemethod;

abstract class DataMiner {

    public final void mineData() {
        openFile();
        extractData();
        parseData();
        closeFile();
    }

    protected abstract void openFile();

    protected abstract void closeFile();

    protected void extractData() {
        System.out.println("Видобування даних з файлу");
    }

    protected void parseData() {
        System.out.println("Парсинг даних у стандартний формат");
    }
}

class DocDataMiner extends DataMiner {

    @Override
    protected void openFile() {
        System.out.println("Відкриття DOC файлу");
    }

    @Override
    protected void closeFile() {
        System.out.println("Закриття DOC файлу");
    }
}

class CsvDataMiner extends DataMiner {

    @Override
    protected void openFile() {
        System.out.println("Відкриття CSV файлу");
    }

    @Override
    protected void closeFile() {
        System.out.println("Закриття CSV файлу");
    }
}

class PdfDataMiner extends DataMiner {

    @Override
    protected void openFile() {
        System.out.println("Відкриття PDF файлу");
    }

    @Override
    protected void closeFile() {
        System.out.println("Закриття PDF файлу");
    }
}

public class TemplateMethodExample {
    public static void main(String[] args) {
        DataMiner docMiner = new DocDataMiner();
        System.out.println("Обробка DOC файлу:");
        docMiner.mineData();

        System.out.println("\nОбробка CSV файлу:");
        DataMiner csvMiner = new CsvDataMiner();
        csvMiner.mineData();

        System.out.println("\nОбробка PDF файлу:");
        DataMiner pdfMiner = new PdfDataMiner();
        pdfMiner.mineData();
    }
}

