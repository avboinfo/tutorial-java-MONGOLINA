package APP;

import java.util.ArrayList;
import java.util.List;

public class Mailbox {
    private List<Email> emails;

    public Mailbox() {
        emails = new ArrayList<>();
    }

    public void addEmail(Email email) {
        emails.add(email);
    }

    public void deleteEmail(int index) {
        if (index >= 0 && index < emails.size()) {
            emails.remove(index);
        } else {
            throw new IllegalArgumentException("Invalid email index");
        }
    }

    public List<Email> searchBySubject(String searchText) {
        List<Email> result = new ArrayList<>();
        for (Email email : emails) {
            if (email.getSubject().contains(searchText)) {
                result.add(email);
            }
        }
        return result;
    }

    public static class Email {
        private String sender;
        private String subject;
        private String dateTime;
        private String text;
        
        // Costruttore
        public Email(String sender, String subject, String dateTime, String text) {
            this.sender = sender;
            this.subject = subject;
            this.dateTime = dateTime;
            this.text = text;
        }

        // Getter 
        public String getSender() {
            return sender;
        }

        public String getSubject() {
            return subject;
        }

        public String getDateTime() {
            return dateTime;
        }

        public String getText() {
            return text;
        }
    }
}
