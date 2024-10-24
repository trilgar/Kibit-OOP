package lecture10.yagni.example3.badexample;


public class EmailService {
    private String smtpServer;
    private int port;
    private boolean sslEnabled;
    private String backupSmtpServer;

    public EmailService(String smtpServer, int port, boolean sslEnabled, String backupSmtpServer) {
        this.smtpServer = smtpServer;
        this.port = port;
        this.sslEnabled = sslEnabled;
        this.backupSmtpServer = backupSmtpServer;
    }

    public void sendEmail(String to, String subject, String body) {
        // Логіка відправки email через smtpServer
        // Якщо smtpServer недоступний, використовувати backupSmtpServer (використання якого не вимагається але ми вирішили написати цю логіку)
    }
}

