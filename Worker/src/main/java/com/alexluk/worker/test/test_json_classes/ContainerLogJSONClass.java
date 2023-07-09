package com.alexluk.worker.test.test_json_classes;

public class ContainerLogJSONClass {
    public static String JSON = """
            [
                {
                    "containerId": "9f7c43452e45",
                    "logs": [
                        "2023-07-06T17:33:34.039935916Z The files belonging to this database system will be owned by user 'postgres'.",
                        "2023-07-06T17:33:34.039952716Z This user must also own the server process.",
                        "2023-07-06T17:33:34.039956861Z ",
                        "2023-07-06T17:33:34.040665922Z The database cluster will be initialized with locale \\"en_US.utf8\\".",
                        "2023-07-06T17:33:34.040675764Z The default database encoding has accordingly been set to \\"UTF8\\".",
                        "2023-07-06T17:33:34.040677794Z The default text search configuration will be set to \\"english\\".",
                        "2023-07-06T17:33:34.040679245Z ",
                        "2023-07-06T17:33:34.040680636Z Data page checksums are disabled.",
                        "2023-07-06T17:33:34.040682054Z ",
                        "2023-07-06T17:33:34.040683302Z fixing permissions on existing directory /var/lib/postgresql/data ... ok",
                        "2023-07-06T17:33:34.040745765Z creating subdirectories ... ok",
                        "2023-07-06T17:33:34.040823633Z selecting dynamic shared memory implementation ... posix",
                        "2023-07-06T17:33:34.048381123Z selecting default max_connections ... 100",
                        "2023-07-06T17:33:34.057304020Z selecting default shared_buffers ... 128MB",
                        "2023-07-06T17:33:34.065517677Z selecting default time zone ... Etc/UTC",
                        "2023-07-06T17:33:34.066536875Z creating configuration files ... ok",
                        "2023-07-06T17:33:34.121427244Z running bootstrap script ... ok",
                        "2023-07-06T17:33:34.300217426Z performing post-bootstrap initialization ... ok",
                        "2023-07-06T17:33:41.056358503Z syncing data to disk ... ok",
                        "2023-07-06T17:33:41.056747803Z ",
                        "2023-07-06T17:33:41.056774506Z ",
                        "2023-07-06T17:33:41.056785021Z Success. You can now start the database server using:",
                        "2023-07-06T17:33:41.056794662Z ",
                        "2023-07-06T17:33:41.056803473Z     pg_ctl -D /var/lib/postgresql/data -l logfile start",
                        "2023-07-06T17:33:41.056812777Z ",
                        "2023-07-06T17:33:41.113541414Z waiting for server to start....2023-07-06 17:33:41.113 UTC [48] LOG:  starting PostgreSQL 15.3, (Debian 15.3-1.pgdg110+1) on x86_64-pc-linux-gnu, compiled by gcc (Debian 10.2.1-6) 10.2.1 20210110, 64-bit",
                        "2023-07-06T17:33:41.120628746Z 2023-07-06 17:33:41.120 UTC [48] LOG:  listening on Unix socket \\"/var/run/postgresql/.s.PGSQL.5432\\"",
                        "2023-07-06T17:33:41.149626297Z 2023-07-06 17:33:41.149 UTC [51] LOG:  database system was shut down at 2023-07-06 17:33:34 UTC",
                        "2023-07-06T17:33:41.166227700Z 2023-07-06 17:33:41.165 UTC [48] LOG:  database system is ready to accept connections",
                        "2023-07-06T17:33:41.182623586Z  done",
                        "2023-07-06T17:33:41.182680935Z server started",
                        "2023-07-06T17:33:41.228004732Z ",
                        "2023-07-06T17:33:41.228015733Z /usr/local/bin/docker-entrypoint.sh: ignoring /docker-entrypoint-initdb.d/*",
                        "2023-07-06T17:33:41.228024780Z ",
                        "2023-07-06T17:33:41.228729285Z waiting for server to shut down....2023-07-06 17:33:41.228 UTC [48] LOG:  received fast shutdown request",
                        "2023-07-06T17:33:41.235299779Z 2023-07-06 17:33:41.235 UTC [48] LOG:  aborting any active transactions",
                        "2023-07-06T17:33:41.236036408Z 2023-07-06 17:33:41.235 UTC [48] LOG:  background worker \\"logical replication launcher\\" (PID 54) exited with exit code 1",
                        "2023-07-06T17:33:41.236047611Z 2023-07-06 17:33:41.235 UTC [49] LOG:  shutting down",
                        "2023-07-06T17:33:41.242709075Z 2023-07-06 17:33:41.242 UTC [49] LOG:  checkpoint starting: shutdown immediate",
                        "2023-07-06T17:33:41.309337196Z 2023-07-06 17:33:41.309 UTC [49] LOG:  checkpoint complete: wrote 3 buffers (0.0%); 0 WAL file(s) added, 0 removed, 0 recycled; write=0.002 s, sync=0.017 s, total=0.074 s; sync files=2, longest=0.010 s, average=0.009 s; distance=0 kB, estimate=0 kB",
                        "2023-07-06T17:33:41.314969073Z 2023-07-06 17:33:41.314 UTC [48] LOG:  database system is shut down",
                        "2023-07-06T17:33:41.328999845Z  done",
                        "2023-07-06T17:33:41.329030887Z server stopped",
                        "2023-07-06T17:33:41.331135173Z ",
                        "2023-07-06T17:33:41.331166156Z PostgreSQL init process complete; ready for start up.",
                        "2023-07-06T17:33:41.331172813Z "
                    ]
                }
            ]
            """;
}
