import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

public class responseCheck {
    public static void main(String[] args) throws IOException {

        String urlString = "https://uat.example.com/";
        int wrongResponseCounter = 0;
        int numbersOfChecks = 20;
        int timeBetWeenChecks = 100;

        URL url = new URL(urlString);

        for (int i = 0; i < numbersOfChecks; i++) {

            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            connection.connect();

            String responseHeader = connection.getHeaderField("Content-Type");

            if (responseHeader.equals("text/html")) {
                System.out.println("Response header is correct: " + responseHeader);
            } else {
                System.out.println("Response header is incorrect: " + responseHeader);
                wrongResponseCounter++;
            }

            try {
                Thread.sleep(timeBetWeenChecks);
            } catch (InterruptedException e) {

            }
        }
        System.out.println("\nNumber of wrong reponses: " + wrongResponseCounter);
    }
}
