import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class GeminiAPI {

    private static final String API_KEY = "YOUR_GEMINI_API_KEY";

    public static ScreeningResult analyzeResume(String resumeText,
                                                String jobDescription) {

        try {

            String prompt =
                    "Compare the following resume with the job description."
                  + " Give only JSON in this format:"
                  + "{\"score\":90,\"recommendation\":\"Selected\",\"remarks\":\"Reason\"}\n\n"
                  + "Job Description:\n"
                  + jobDescription
                  + "\n\nResume:\n"
                  + resumeText;

            JsonObject part = new JsonObject();
            part.addProperty("text", prompt);

            JsonArray parts = new JsonArray();
            parts.add(part);

            JsonObject content = new JsonObject();
            content.add("parts", parts);

            JsonArray contents = new JsonArray();
            contents.add(content);

            JsonObject body = new JsonObject();
            body.add("contents", contents);

            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(
                            "https://generativelanguage.googleapis.com/v1beta/models/gemini-2.5-flash:generateContent?key="
                                    + API_KEY))
                    .header("Content-Type", "application/json")
                    .POST(HttpRequest.BodyPublishers.ofString(body.toString()))
                    .build();

            HttpClient client = HttpClient.newHttpClient();

            HttpResponse<String> response =
                    client.send(request,
                            HttpResponse.BodyHandlers.ofString());

            JsonObject root =
                    JsonParser.parseString(response.body()).getAsJsonObject();

            String aiText =
                    root.getAsJsonArray("candidates")
                            .get(0).getAsJsonObject()
                            .getAsJsonObject("content")
                            .getAsJsonArray("parts")
                            .get(0).getAsJsonObject()
                            .get("text").getAsString();

            JsonObject result =
                    JsonParser.parseString(aiText).getAsJsonObject();

            return new ScreeningResult(
                    result.get("score").getAsDouble(),
                    result.get("recommendation").getAsString(),
                    result.get("remarks").getAsString());

        } catch (IOException | InterruptedException e) {

            e.printStackTrace();

        }

        return new ScreeningResult(0, "Rejected", "AI Error");
    }

}