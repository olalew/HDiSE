package com.alexluk.worker.infrastructure;

import java.io.*;
import java.nio.file.Paths;
import java.util.UUID;

public class DeviceIdStorage {
    private static final String FILE_NAME = "deviceId.txt";

    public static void storeDeviceId(UUID deviceId) {
        String filePath = getFilePath();
        System.out.println(String.format("Device id path: %s", filePath));
        try (Writer writer = new FileWriter(filePath)) {
            writer.write(deviceId.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static UUID readDeviceId() throws IOException {
        String filePath = getFilePath();
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String deviceIdString = reader.readLine();
            return UUID.fromString(deviceIdString);
        } catch (IOException e) {
            e.printStackTrace();
            throw e;
        }
    }

    private static String getFilePath() {
        String classPath = DeviceIdStorage.class.getProtectionDomain().getCodeSource().getLocation().getPath();
        return Paths.get(classPath).getParent().getParent().resolve(FILE_NAME).toString();
    }
}
