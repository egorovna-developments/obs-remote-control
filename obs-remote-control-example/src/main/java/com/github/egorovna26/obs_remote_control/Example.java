package com.github.egorovna26.obs_remote_control;

import com.github.egorovna26.obs_remote_control.logger.Logger;
import com.github.egorovna26.obs_remote_control.message.event.scenes.CurrentProgramSceneChanged;
import com.github.egorovna26.obs_remote_control.message.requestresponse.general.GetVersionResponse;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.TimeUnit;

@Slf4j
public class Example {
    public static void main(String[] args) {
        OBSRemoteControl obsRemoteControl = new OBSRemoteControl();
        try {
            obsRemoteControl.setLogger(new Logger() {
                @Override
                public void info(String message) {
                    log.info(message);
                }

                @Override
                public void warn(String message) {
                    log.warn(message);
                }

                @Override
                public void error(String message, Throwable e) {
                    log.error(message, e);
                }
            });
            obsRemoteControl.setPassword("hCGUksodhFE5J6Ox");
            obsRemoteControl.addEventListener(CurrentProgramSceneChanged.class, currentProgramSceneChanged -> {
                log.info(currentProgramSceneChanged.toString());
            });
            obsRemoteControl.setTimeout(1000);
            obsRemoteControl.connect();
            TimeUnit.SECONDS.sleep(5);
            GetVersionResponse version = obsRemoteControl.getVersion();
            log.info(version.toString());
        } catch (Exception e) {
            log.error("Error", e);
        } finally {
            obsRemoteControl.disconnect();
        }
    }
}
