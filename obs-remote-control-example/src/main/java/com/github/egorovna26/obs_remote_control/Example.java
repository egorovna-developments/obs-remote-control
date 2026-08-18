package com.github.egorovna26.obs_remote_control;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Example {
    public static void main(String[] args) {
        OBSRemoteControl obsRemoteControl = new OBSRemoteControl();
        try {
            obsRemoteControl.connect();
            while (true) {
            }
        } catch (Exception e) {
            log.error("Error", e);
        } finally {
            obsRemoteControl.disconnect();
        }
    }
}
