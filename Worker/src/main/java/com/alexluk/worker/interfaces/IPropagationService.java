package com.alexluk.worker.interfaces;

import com.alexluk.worker.enums.WorkerMode;

public interface IPropagationService {

    void propagate(WorkerMode mode, String json);

}
