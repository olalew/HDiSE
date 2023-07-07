package com.alexluk.worker.services;

import com.alexluk.worker.enums.WorkerMode;
import com.alexluk.worker.interfaces.IPropagationService;
import com.alexluk.worker.models.entities.ProcessRecord;
import com.alexluk.worker.models.requests.ProcessRecordRequest;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import okhttp3.*;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class ProcessListPropagationService implements IPropagationService {
    @Override
    public void propagate(WorkerMode mode, String json) {

    }
}
