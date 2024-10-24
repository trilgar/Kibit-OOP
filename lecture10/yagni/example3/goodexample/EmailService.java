package lecture10.yagni.example3.goodexample;

public class EmailService {
    private String smtpServer;
    private int port;
    private boolean sslEnabled;

    public EmailService(String smtpServer, int port, boolean sslEnabled) {
        this.smtpServer = smtpServer;
        this.port = port;
        this.sslEnabled = sslEnabled;
    }

    public void sendEmail(String to, String subject, String body) {
        // Логіка відправки email через smtpServer
    }
}

