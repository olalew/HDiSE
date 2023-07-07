package com.alexluk.worker.services;

import com.alexluk.worker.enums.WorkerMode;
import com.alexluk.worker.interfaces.IPropagationService;
import com.alexluk.worker.models.requests.DeviceRequest;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import okhttp3.*;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class BaseInfoPropagationService implements IPropagationService {
    @Override
    public void propagate(WorkerMode mode, String json) {
        Gson gson = new GsonBuilder().create();
        DeviceRequest deviceRequest = gson.fromJson(json, DeviceRequest.class);

        // send request here
        OkHttpClient client = new OkHttpClient.Builder()
                .callTimeout(10, TimeUnit.SECONDS)  // Set the timeout
                .build();
        String jsonBody = gson.toJson(deviceRequest);

        // Create a MediaType for JSON
        MediaType JSON = MediaType.parse("application/json; charset=utf-8");

        // Create a RequestBody with the JSON data
        RequestBody body = RequestBody.create(JSON, jsonBody);

        // Create a Request with the desired URL, HTTP method, and request body
        Request request = new Request.Builder()
                .url("http://localhost:8080/api/devices")
                .post(body)
                .build();


        System.out.println("Sending http request");
        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onResponse(Call call, Response response) throws IOException {
                // Handle successful response
                if (response.isSuccessful()) {
                    String responseBody = response.body().string();
                    System.out.println("Response: " + responseBody);
                } else {
                    System.out.println("Something went wrong");
                }
            }

            @Override
            public void onFailure(Call call, IOException e) {
                System.out.println(e);
            }
        });

    }
}
