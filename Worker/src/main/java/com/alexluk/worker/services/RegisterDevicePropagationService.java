package com.alexluk.worker.services;

import com.alexluk.worker.infrastructure.DeviceIdStorage;
import com.alexluk.worker.interfaces.IPropagationService;
import com.alexluk.worker.models.entities.DeviceInfo;
import com.google.gson.Gson;
import okhttp3.*;

import java.io.IOException;
import java.util.UUID;

public class RegisterDevicePropagationService implements IPropagationService {
    @Override
    public void propagate(String json, UUID deviceId) {
        OkHttpClient client = new OkHttpClient();

        System.out.println("Registering the device");

        MediaType JSON = MediaType.parse("application/json; charset=utf-8");
        RequestBody body = RequestBody.create(JSON, json);

        Request request = new Request.Builder()
                .url("http://localhost:8080/api/devices")
                .post(body)
                .build();

        String responseBody = handleHttpResponse(client, request);

        Gson gson = new Gson();
        DeviceInfo deviceInfo = gson.fromJson(responseBody, DeviceInfo.class);
        DeviceIdStorage.storeDeviceId(deviceInfo.getDeviceId());
    }

    @Override
    public String prepareObject(String input) {
        return input;
    }

    static String handleHttpResponse(OkHttpClient client, Request request) {
        try (Response response = client.newCall(request).execute()) {
            if (response.isSuccessful()) {
                String responseBody = response.body().string();
                System.out.println(responseBody);

                return responseBody;
            } else {
                throw new RuntimeException("Response not successful");
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
