package com.github.egorovna26.obs_remote_control.logger;

public class EmptyLogger implements Logger {
    @Override
    public void info(String message) {
        System.out.println(message);
    }

    @Override
    public void warn(String message) {
        System.out.println(message);
    }

    @Override
    public void error(String message, Throwable e) {
        System.out.println(message);
    }
}
