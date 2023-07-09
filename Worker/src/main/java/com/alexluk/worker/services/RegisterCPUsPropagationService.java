package com.alexluk.worker.services;

import com.alexluk.worker.infrastructure.JSONConverter;
import com.alexluk.worker.interfaces.IPropagationService;
import com.google.gson.*;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;

import java.util.Map;
import java.util.UUID;

public class RegisterCPUsPropagationService implements IPropagationService {
    @Override
    public void propagate(String json, UUID deviceId) {
        OkHttpClient client = new OkHttpClient();

        MediaType JSON = MediaType.parse("application/json; charset=utf-8");
        RequestBody body = RequestBody.create(JSON, json);

        Request request = new Request.Builder()
                .url("http://localhost:8080/api/cpuinfo/" + deviceId)
                .post(body)
                .build();

        RegisterDevicePropagationService.handleHttpResponse(client, request);
    }

    @Override
    public String prepareObject(String input) {
        JsonObject jsonObject = new Gson().fromJson(input, JsonObject.class);

        // Convert the keys to the desired format
        JsonObject convertedJson = new JsonObject();
        for (String key : jsonObject.keySet()) {
            String convertedKey = JSONConverter.convertToCamelCase(key);
            convertedJson.add(convertedKey, jsonObject.get(key));
        }

        // Convert the converted JSON to formatted output JSON
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        String outputJson = gson.toJson(convertedJson);

        System.out.println(outputJson);

        return outputJson;
    }
}
