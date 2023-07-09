package com.alexluk.worker.services;

import com.alexluk.worker.interfaces.IPropagationService;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;

import java.util.UUID;

public class SaveDockerContainerLogsPropagationService implements IPropagationService {
    @Override
    public void propagate(String json, UUID deviceId) throws Exception {
        OkHttpClient client = new OkHttpClient();

        String cleanedJson = json.replaceAll("\\s*\\n\\s*", "");

        // Create the request body with the cleaned JSON
        MediaType mediaType = MediaType.parse("application/json; charset=utf-8");
        RequestBody body = RequestBody.create(mediaType, cleanedJson);

        System.out.println("JSON:");
        System.out.println(json);
        System.out.println("CLEANED");
        System.out.println(cleanedJson);

        Request request = new Request.Builder()
                .url("http://localhost:8080/api/containerLogs/" + deviceId)
                .post(body)
                .build();

        RegisterDevicePropagationService.handleHttpResponse(client, request);
    }

    @Override
    public String prepareObject(String input) {
        return input.replace("\n", "");
    }
}
