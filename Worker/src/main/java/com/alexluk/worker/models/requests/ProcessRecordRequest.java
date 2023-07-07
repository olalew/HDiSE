package com.alexluk.worker.models.requests;

import com.alexluk.worker.models.entities.ProcessRecord;
import lombok.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProcessRecordRequest {
    private List<ProcessRecord> records;
}
