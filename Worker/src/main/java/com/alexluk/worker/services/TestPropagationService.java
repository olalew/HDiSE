package com.alexluk.worker.services;

import com.alexluk.worker.enums.WorkerMode;
import com.alexluk.worker.interfaces.IPropagationService;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;

public class TestPropagationService implements IPropagationService {
    @Override
    public void propagate(WorkerMode mode, String json) {
        OkHttpClient client = new OkHttpClient();

        Request request = new Request.Builder()
                .url("http://localhost:8080/api/ping")
                .build();

        try (Response response = client.newCall(request).execute()) {
            String responseBody = response.body().string();
            System.out.println(responseBody);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
