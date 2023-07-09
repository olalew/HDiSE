package com.alexluk.worker;

public class Main {
    private static boolean IS_DEVELOPMENT = false;
    public static void main(String[] args) {
        if (IS_DEVELOPMENT) {
            MainTestRun.main(args);
        } else {
            MainDefaultRun.main(args);
        }
    }
}
