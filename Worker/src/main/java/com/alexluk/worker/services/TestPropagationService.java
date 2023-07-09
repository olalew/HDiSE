package com.alexluk.worker.services;

import com.alexluk.worker.interfaces.IPropagationService;
import okhttp3.*;

import java.util.UUID;

public class TestPropagationService implements IPropagationService {
    @Override
    public void propagate(String json, UUID deviceId) {
        OkHttpClient client = new OkHttpClient();

        MediaType JSON = MediaType.parse("application/json; charset=utf-8");
        RequestBody body = RequestBody.create(JSON, json);

        Request request = new Request.Builder()
                .url("http://localhost:8080/api/test")
                .post(body)
                .build();

        RegisterDevicePropagationService.handleHttpResponse(client, request);
    }

    @Override
    public String prepareObject(String input) {
        return input;
    }
}
