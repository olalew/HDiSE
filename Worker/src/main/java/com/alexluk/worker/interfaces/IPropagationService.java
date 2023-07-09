package com.alexluk.worker.interfaces;

import java.util.UUID;

public interface IPropagationService {

    void propagate(String json, UUID deviceId) throws Exception;

    String prepareObject(String input);

}
