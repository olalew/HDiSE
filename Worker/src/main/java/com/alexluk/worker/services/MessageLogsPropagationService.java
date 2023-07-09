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

public class MessageLogsPropagationService implements IPropagationService {
    @Override
    public void propagate(String json, UUID deviceId) {
        OkHttpClient client = new OkHttpClient();

        MediaType JSON = MediaType.parse("application/json; charset=utf-8");
        RequestBody body = RequestBody.create(JSON, json);

        Request request = new Request.Builder()
                .url("http://localhost:8080/api/message-logs/batch/" + deviceId)
                .post(body)
                .build();

        RegisterDevicePropagationService.handleHttpResponse(client, request);
    }

    @Override
    public String prepareObject(String input) {
        JsonElement jsonElement = JsonParser.parseString(input);

        JsonElement convertedJsonElement = convert(jsonElement, true);

        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        String outputJson = gson.toJson(convertedJsonElement);

        System.out.println(outputJson);
        return outputJson;
    }

    public static JsonElement convert(JsonElement jsonElement, boolean fromAllUpper) {
        if (jsonElement.isJsonObject()) {
            JsonObject jsonObject = jsonElement.getAsJsonObject();
            JsonObject convertedJson = new JsonObject();

            for (Map.Entry<String, JsonElement> entry : jsonObject.entrySet()) {
                String convertedKey = "";
                if (fromAllUpper) {
                    convertedKey = JSONConverter.convertToCamelCase(entry.getKey());
                } else {
                    convertedKey = JSONConverter.convertFirstLetterToCamelCase(entry.getKey());
                }

                convertedJson.add(convertedKey, convert(entry.getValue(), fromAllUpper));
            }

            return convertedJson;
        } else if (jsonElement.isJsonArray()) {
            JsonArray jsonArray = jsonElement.getAsJsonArray();
            JsonArray convertedArray = new JsonArray();

            for (JsonElement element : jsonArray) {
                convertedArray.add(convert(element, fromAllUpper));
            }

            return convertedArray;
        }

        return jsonElement;
    }

}