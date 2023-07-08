package com.alexluki.loggerapi.controllers;

import com.alexluki.loggerapi.dbmodels.MessageLogEntity;
import com.alexluki.loggerapi.services.MessageLogService;
import org.aspectj.bridge.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/message-logs")
public class MessageLogController {

    private final MessageLogService logEntryService;

    @Autowired
    public MessageLogController(MessageLogService logEntryService) {
        this.logEntryService = logEntryService;
    }

        @PostMapping("/{deviceId}")
        public ResponseEntity<MessageLogEntity> saveLogEntry(@RequestBody MessageLogEntity logEntry, @PathVariable UUID deviceId) {
            return new ResponseEntity<>(logEntryService.saveLogEntry(logEntry, deviceId),
                    HttpStatus.CREATED);
        }

    @PostMapping("/batch/{deviceId}")
    public ResponseEntity<List<MessageLogEntity>> saveLogs(@RequestBody List<MessageLogEntity> logs, @PathVariable UUID deviceId) {
        return ResponseEntity.ok(logEntryService.saveLogs(logs, deviceId));
    }
    @GetMapping("/{deviceId}")
    public ResponseEntity<List<MessageLogEntity>> getLogsByDeviceId(@PathVariable UUID deviceId) {
        List<MessageLogEntity> logs = logEntryService.getLogsByDeviceId(deviceId);
        return ResponseEntity.ok(logs);
    }

    @GetMapping("/{deviceId}/paged")
    public ResponseEntity<Page<MessageLogEntity>> getLogsByDeviceIdPaged(@PathVariable UUID deviceId, Pageable pageable) {
        Page<MessageLogEntity> logs = logEntryService.getLogsByDeviceId(deviceId, pageable);
        return ResponseEntity.ok(logs);
    }
}
