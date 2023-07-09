package com.alexluk.worker.services;

import com.alexluk.worker.interfaces.IPropagationService;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;

import java.util.UUID;

public class InvalidateDockerImageInfoPropagationService implements IPropagationService {
    @Override
    public void propagate(String json, UUID deviceId) {
        OkHttpClient client = new OkHttpClient();

        MediaType JSON = MediaType.parse("application/json; charset=utf-8");
        RequestBody body = RequestBody.create(JSON, json);

        Request request = new Request.Builder()
                .url("http://localhost:8080/api/dockerImages/status/batch/" + deviceId)
                .put(body)
                .build();

        RegisterDevicePropagationService.handleHttpResponse(client, request);
    }

    @Override
    public String prepareObject(String input) {
        return input;
    }
}
