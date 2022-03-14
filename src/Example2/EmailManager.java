package Example2;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

class EmailManager {
    public static void main(String[] args) {
        List<Email> emailList = createEmailList();
        Predicate<Email> adresser = email -> checkAdress(email,"barbara@example.com");
        List<Email> emailsFromAdresser = filterList(emailList,adresser);
        System.out.println("Maile przefiltrowane na podstawie nadawcy lub odbiorcy");
        System.out.println(emailsFromAdresser);
        List<Email> sentEmails = filterList(emailList,email -> email.isSent());
        System.out.println("Wysłane maile");
        System.out.println(sentEmails);
    }

    private static <T> List<T> filterList (List<T> list, Predicate<T> predicate){
        ArrayList<T> result = new ArrayList<>();
        for (T t : list) {
            if (predicate.test(t))
                result.add(t);
        }
        return result;
    }

    private static boolean checkAdress (Email email, String emailAddress){
        return email.getSender().equals(emailAddress) ||
                email.getRecipient().equals(emailAddress);
    }


    private static List<Email> createEmailList() {
        List<Email> emails = new ArrayList<>();
        emails.add(new Email(
                "joe@example.com",
                "barbara@example.com",
                "Kup bułki",
                "Cześć!, Kup proszę bułki, gdy będziesz wracać z pracy.",
                false)
        );
        emails.add(new Email(
                "carl@example.com",
                "joe@example.com",
                "Nowa inwestycja",
                "Siema! Musimy omówić temat nowej inwestycji, pasuje Ci jutro?",
                true)
        );
        emails.add(new Email(
                "joe@example.com",
                "bart@example.com",
                "Wypad na miasto",
                "Cześć. Idziemy dzisiaj wieczorem z chłopakami " +
                        "na miasto. Dołączasz do nas?",
                true)
        );
        return emails;
    }
}