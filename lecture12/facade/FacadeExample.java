package lecture12.facade;

public class FacadeExample {
    public static void main(String[] args) {
        VideoConverter converter = new VideoConverter();
        File mp4 = converter.convert("funny-cats-video.ogg", "mp4");
        mp4.save();
    }
}

// Складні класи сторонньої підсистеми для відео конвертації
class VideoFile {
    private String filename;

    public VideoFile(String filename) {
        this.filename = filename;
    }
}

class OggCompressionCodec {
}

class MPEG4CompressionCodec {
}

class CodecFactory {
    public Object extract(VideoFile file) {
        // Логіка вибору кодеку
        return new Object();
    }
}

class BitrateReader {
    public static Object read(String filename, Object sourceCodec) {
        // Читання файлу та створення буферу
        return new Object();
    }

    public static Object convert(Object buffer, Object destinationCodec) {
        // Конвертація файлу
        return new Object();
    }
}

class AudioMixer {
    public Object fix(Object result) {
        // Аудіо обробка
        return new Object();
    }
}

// Фасад, який спрощує роботу зі складною підсистемою
class VideoConverter {
    public File convert(String filename, String format) {
        VideoFile file = new VideoFile(filename);
        CodecFactory codecFactory = new CodecFactory();
        Object sourceCodec = codecFactory.extract(file);
        Object destinationCodec;

        if (format.equals("mp4")) {
            destinationCodec = new MPEG4CompressionCodec();
        } else {
            destinationCodec = new OggCompressionCodec();
        }

        Object buffer = BitrateReader.read(filename, sourceCodec);
        Object result = BitrateReader.convert(buffer, destinationCodec);
        AudioMixer audioMixer = new AudioMixer();
        result = audioMixer.fix(result);

        return new File(result.toString()); // Створення файлу на основі результату
    }
}

// Допоміжний клас для представлення файлів
class File {
    private String data;

    public File(String data) {
        this.data = data;
    }

    public void save() {
        System.out.println("Saving file with data: " + data);
    }
}

