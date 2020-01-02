package GrimlockFramework.Utils;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClientBuilder;

public class SlackSuiteStatus {
    StringEntity params;


    public  void postSuiteStatus (String testName, String testStatus) {

            String slackWebhookURL = "https://hooks.slack.com/services/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";
            HttpClient httpClient = HttpClientBuilder.create().build();

            try {
                HttpPost request = new HttpPost(slackWebhookURL);
                request.addHeader("content-type", "application/json");


                params = new StringEntity("{\n" +
                        "\"attachments\": [\n" +
                        "{\n" +
                        "\"fallback\": \"" + testName + "\",\n" +
                        "\"color\": \"#36a64f\",\n" +
                        "\"pretext\": \"" + testName + "\",\n" +
                        "\"fields\": [\n" +
                        "{\n" +
                        "\"title\": \"Status: " + testStatus + "\",\n" +
                        "}\n," +
                        "]\n" +
                        "}\n" +
                        "]\n" +
                        "}");


                params.setContentType("application/json");
                request.setEntity(params);
                HttpResponse response = httpClient.execute(request);

            } catch (Exception ex) {

            }
        }
    }

