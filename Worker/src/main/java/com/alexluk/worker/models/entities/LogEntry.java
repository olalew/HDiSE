package com.alexluk.worker.models.entities;

import com.google.gson.annotations.SerializedName;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.annotations.SerializedName;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class LogEntry {
    @SerializedName("_SYSTEMD_CGROUP")
    private String systemdCgroup;

    @SerializedName("__REALTIME_TIMESTAMP")
    private String realtimeTimestamp;

    @SerializedName("_CAP_EFFECTIVE")
    private String capEffective;

    @SerializedName("__CURSOR")
    private String cursor;

    @SerializedName("_RUNTIME_SCOPE")
    private String runtimeScope;

    @SerializedName("_MACHINE_ID")
    private String machineId;

    @SerializedName("PRIORITY")
    private String priority;

    @SerializedName("_SYSTEMD_UNIT")
    private String systemdUnit;

    @SerializedName("_SYSTEMD_INVOCATION_ID")
    private String systemdInvocationId;

    @SerializedName("_UID")
    private String uid;

    @SerializedName("CODE_FUNC")
    private String codeFunc;

    @SerializedName("__MONOTONIC_TIMESTAMP")
    private String monotonicTimestamp;

    @SerializedName("_SYSTEMD_SLICE")
    private String systemdSlice;

    @SerializedName("_SOURCE_REALTIME_TIMESTAMP")
    private String sourceRealtimeTimestamp;

    @SerializedName("MESSAGE")
    private String message;

    @SerializedName("CODE_FILE")
    private String codeFile;

    @SerializedName("SYSLOG_FACILITY")
    private String syslogFacility;

    @SerializedName("_BOOT_ID")
    private String bootId;

    @SerializedName("_COMM")
    private String comm;

    @SerializedName("_PID")
    private String pid;

    @SerializedName("SYSLOG_IDENTIFIER")
    private String syslogIdentifier;

    @SerializedName("_SELINUX_CONTEXT")
    private String selinuxContext;

    @SerializedName("_EXE")
    private String exe;

    @SerializedName("CODE_LINE")
    private String codeLine;

    @SerializedName("_CMDLINE")
    private String cmdline;

    @SerializedName("REALMD_OPERATION")
    private String realmdOperation;

    @SerializedName("_HOSTNAME")
    private String hostname;

    @SerializedName("_TRANSPORT")
    private String transport;

    @SerializedName("_GID")
    private String gid;
}