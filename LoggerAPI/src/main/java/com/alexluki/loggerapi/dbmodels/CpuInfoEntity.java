package com.alexluki.loggerapi.dbmodels;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.util.UUID;

@Entity
@Getter
@Setter
public class CpuInfoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @ManyToOne
    @JoinColumn(name = "device_id", nullable = false, referencedColumnName = "device_id")
    private DeviceEntity device;

    @Column(name = "vulnerability_srbds")
    private String vulnerabilitySrbds;

    @Column(name = "stepping")
    private String stepping;

    @Column(name = "vulnerability_meltdown")
    private String vulnerabilityMeltdown;

    @Column(name = "l3_cache")
    private String l3Cache;

    @Column(name = "cpu_min_mhz")
    private String cpuMinMhz;

    @Column(name = "vendor_id")
    private String vendorId;

    @Column(name = "vulnerability_retbleed")
    private String vulnerabilityRetbleed;

    @Column(name = "vulnerability_spec_store_bypass")
    private String vulnerabilitySpecStoreBypass;

    @Column(name = "byte_order")
    private String byteOrder;

    @Column(name = "vulnerability_spectre_v1")
    private String vulnerabilitySpectreV1;

    @Column(name = "vulnerability_spectre_v2")
    private String vulnerabilitySpectreV2;

    @Column(name = "virtualization")
    private String virtualization;

    @Column(name = "address_sizes")
    private String addressSizes;

    @Column(name = "numa_nodes")
    private String numaNodes;

    @Column(name = "sockets")
    private String sockets;

    @Column(name = "numa_node0_cpus")
    private String numaNode0Cpus;

    @Column(name = "l2_cache")
    private String l2Cache;

    @Column(name = "vulnerability_itlb_multihit")
    private String vulnerabilityItlbMultihit;

    @Column(name = "model")
    private String model;

    @Column(name = "cpu_op_modes")
    private String cpuOpModes;

    @Column(name = "architecture")
    private String architecture;

    @Column(name = "cpus_scaling_mhz")
    private String cpusScalingMhz;

    @Column(name = "vulnerability_l1tf")
    private String vulnerabilityL1tf;

    @Column(name = "cpu_max_mhz")
    private String cpuMaxMhz;

    @Column(name = "l1d_cache")
    private String l1dCache;

    @Column(name = "l1i_cache")
    private String l1iCache;

    @Column(name = "cpu_family")
    private String cpuFamily;

    @Column(name = "cores_per_socket")
    private String coresPerSocket;

    @Column(name = "threads_per_core")
    private String threadsPerCore;

    @Column(name = "vulnerability_mmio_stale_data")
    private String vulnerabilityMmioStaleData;

    @Column(name = "model_name")
    private String modelName;

    @Column(name = "vulnerability_mds")
    private String vulnerabilityMds;

    @Column(name = "online_cpus_list")
    private String onlineCpusList;

    @Column(name = "cpus")
    private String cpus;

    @Column(name = "vulnerability_tsx_async_abort")
    private String vulnerabilityTsxAsyncAbort;

    @Column(name = "bogo_mips")
    private String bogoMips;
}
