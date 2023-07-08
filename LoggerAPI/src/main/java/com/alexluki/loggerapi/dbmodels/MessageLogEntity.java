package com.alexluki.loggerapi.dbmodels;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Type;

@Entity
@Table(name = "logs")
@Data
@NoArgsConstructor
public class MessageLogEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "cursor")
    private String cursor;

    @NotBlank
    @Column(name = "realtime_timestamp")
    private String realtimeTimestamp;

    @NotBlank
    @Column(name = "monotonic_timestamp")
    private String monotonicTimestamp;

    @NotBlank
    @Column(name = "boot_id")
    private String bootId;

    @NotBlank
    @Column(name = "machine_id")
    private String machineId;

    @NotBlank
    @Column(name = "hostname")
    private String hostname;

    @NotBlank
    @Column(name = "transport")
    private String transport;

    @Column(name = "priority")
    private String priority;

    @Column(name = "syslog_facility")
    private String syslogFacility;

    @NotBlank
    @Column(name = "selinux_context")
    private String selinuxContext;

    @NotBlank
    @Column(name = "systemd_slice")
    private String systemdSlice;

    @Column(name = "systemd_cgroup")
    private String systemdCgroup;

    @NotBlank
    @Column(name = "systemd_unit")
    private String systemdUnit;

    @NotBlank
    @Column(name = "systemd_invocation_id")
    private String systemdInvocationId;

    @Column(name = "systemd_user_unit")
    private String systemdUserUnit;

    @Column(name = "systemd_user_slice")
    private String systemdUserSlice;

    @Column(name = "systemd_owner_uid")
    private String systemdOwnerUid;

    @NotBlank
    @Column(name = "uid")
    private String uid;

    @NotBlank
    @Column(name = "gid")
    private String gid;

    @Column(name = "audit_session")
    private String auditSession;

    @Column(name = "audit_login_uid")
    private String auditLoginUid;

    @NotBlank
    @Column(name = "cap_effective")
    private String capEffective;

    @Column(name = "systemd_scope")
    private String systemdScope;

    @Column(name = "runtime_scope")
    private String runtimeScope;

    @Column(name = "comm")
    private String comm;

    @NotBlank
    @Column(name = "exe")
    private String exe;

    @NotBlank
    @Column(name = "cmdline")
    private String cmdline;

    @NotBlank
    @Column(name = "syslog_identifier")
    private String syslogIdentifier;

    @NotBlank
    @Column(name = "message")
    private String message;

    @Column(name = "code_file")
    private String codeFile;

    @Column(name = "code_line")
    private String codeLine;

    @Column(name = "code_func")
    private String codeFunc;

    @Column(name = "realmd_operation")
    private String realmdOperation;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "device_id")
    private DeviceEntity device;

    // Constructors, methods, and additional annotations can be added as needed.
}
