package GrimlockFramework.Utils;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClientBuilder;
import org.testng.ITestResult;

import static GrimlockInitialisation.CoreInitialisation.InitGrimlock.Grimlock;

public class SlackTestStatus {
    StringEntity params;


    public  void postTestStatus (ITestResult iTestResult, String testStatus) {

        String slackWebhookURL = "https://hooks.slack.com/services/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";
            String errorMessage = "";
            String testNumber = iTestResult.getMethod().getGroups()[0];
            long duration = iTestResult.getEndMillis() - iTestResult.getStartMillis();

            if (iTestResult.getThrowable() != null) {
                Throwable testResultThrowable = iTestResult.getThrowable();
                String throwable = testResultThrowable.toString();

                if (throwable.contains("Images")) {
                    String[] throwablesplited = throwable.split("/");
                    String[] imageName = throwablesplited[7].split("-");
                    errorMessage = "Can't find " + imageName[0];
                } else if (throwable.contains("Event")) {
                    String[] splits = throwable.split("expected|but found");
                    for (int i = 1; i <= splits.length - 1; i++) {
                        splits[i] = splits[i].substring(splits[i].indexOf("[") + 1, splits[i].lastIndexOf("]")).replaceAll(",", "\n"); // Starts from 5 and goes to 10
                    }
                    errorMessage = "Pixels Validation Failed\\n\\n Expected Results:\\n" + splits[1] + "\\n\\nActual Results:\\n" + splits[2];
                }
            }

            HttpClient httpClient = HttpClientBuilder.create().build();

            try {
                HttpPost request = new HttpPost(slackWebhookURL);
                request.addHeader("content-type", "application/json");

                if (Grimlock.params().IS_MOBILE) {
                    if (testStatus == "Failed") {
                        params = new StringEntity("{\n" +
                                "\"attachments\": [\n" +
                                "{\n" +
                                "\"fallback\": \"Test Failed:" + testNumber + ".\",\n" +
                                "\"color\": \"#FF0000\",\n" +
                                "\"pretext\": \"Test Failed:" + testNumber + "\",\n" +
                                "\"fields\": [\n" +
                                "{\n" +
                                "\"title\": \"In-App\",\n" +
                                "\"value\": \"" + Grimlock.params().Application.get("application_name").toString() + "\",\n" +
                                "\"short\": true\n" +
                                "}\n," +
                                "{\n" +
                                "\"title\": \"Platform\",\n" +
                                "\"value\": \"" + Grimlock.params().Device.get("platform").toString()+ "\",\n" +
                                "\"short\": true\n" +
                                "}\n," +
                                "{\n" +
                                "\"title\": \"Device Name\",\n" +
                                "\"value\": \"" + Grimlock.params().Device.get("device_name").toString() + "\",\n" +
                                "\"short\": true\n" +
                                "}\n," +
                                "{\n" +
                                "\"title\": \"Device Version\",\n" +
                                "\"value\": \"" + Grimlock.params().Device.get("device_version").toString() + "\",\n" +
                                "\"short\": true\n" +
                                "}\n," +
                                "{\n" +
                                "\"title\": \"Error\",\n" +
                                "\"value\": \"" + errorMessage + "\",\n" +
                                "\"short\": false\n" +
                                "}\n," +
                                "{\n" +
                                "\"title\": \"Test Duration\",\n" +
                                "\"value\": \"" + duration / 1000 + " sec\",\n" +
                                "\"short\": true\n" +
                                "}\n," +
                                "],\n" +
                                "\"footer\": \"Test Start Time\",\n" +
                                "\"ts\": " + iTestResult.getStartMillis() / 1000 + "\n" +
                                "}\n" +
                                "]\n" +
                                "}");
                    }
                } else {
                    if (testStatus == "Failed") {
                        params = new StringEntity("{\n" +
                                "\"attachments\": [\n" +
                                "{\n" +
                                "\"fallback\": \"Test Failed:" + testNumber + ".\",\n" +
                                "\"color\": \"#FF0000\",\n" +
                                "\"pretext\": \"Test Failed:" + testNumber + "\",\n" +
                                "\"fields\": [\n" +
                                "{\n" +
                                "\"title\": \"Web App\",\n" +
                                "\"value\": \"" + Grimlock.params().WEB_OBJECT_TO_TEST + "\",\n" +
                                "\"short\": true\n" +
                                "}\n," +
                                "{\n" +
                                "\"title\": \"OS\",\n" +
                                "\"value\": \"" + Grimlock.params().Website.get("os").toString() + "\",\n" +
                                "\"short\": true\n" +
                                "}\n," +
                                "{\n" +
                                "\"title\": \"Browser\",\n" +
                                "\"value\": \"" + Grimlock.params().Website.get("browser").toString() + "\",\n" +
                                "\"short\": true\n" +
                                "}\n," +
                                "{\n" +
                                "\"title\": \"OS Version\",\n" +
                                "\"value\": \"" + Grimlock.params().Website.get("os_version").toString()+ "\",\n" +
                                "\"short\": true\n" +
                                "}\n," +
                                "{\n" +
                                "\"title\": \"Browser Version\",\n" +
                                "\"value\": \"" + Grimlock.params().Website.get("browser_version").toString() + "\",\n" +
                                "\"short\": true\n" +
                                "}\n," +
                                "{\n" +
                                "\"title\": \"Test Duration\",\n" +
                                "\"value\": \"" + duration / 1000 + " sec\",\n" +
                                "\"short\": true\n" +
                                "}\n," +
                                "{\n" +
                                "\"title\": \"Error\",\n" +
                                "\"value\": \"" + errorMessage + "\",\n" +
                                "\"short\": false\n" +
                                "}\n," +
                                "],\n" +
                                "\"footer\": \"Test Start Time\",\n" +
                                "\"ts\": " + iTestResult.getStartMillis() / 1000 + "\n" +
                                "}\n" +
                                "]\n" +
                                "}");
                    }
                }

                if (testStatus == "Passed") {
                    params = new StringEntity("{\n" +
                            "\"attachments\": [\n" +
                            "{\n" +
                            "\"fallback\": \"Test " + testNumber + " successfully Completed.\",\n" +
                            "\"color\": \"#36a64f\",\n" +
                            "\"pretext\": \"Test " + testNumber + " successfully completed.\",\n" +
                            "}\n" +
                            "]\n" +
                            "}");

                }


                params.setContentType("application/json");
                request.setEntity(params);
                HttpResponse response = httpClient.execute(request);

            } catch (Exception ex) {

            }
        }
    }

