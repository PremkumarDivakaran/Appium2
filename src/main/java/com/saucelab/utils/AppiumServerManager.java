package com.saucelab.utils;

import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;

import java.io.BufferedReader;
import java.io.File;
import java.io.InputStreamReader;

public class AppiumServerManager {

    private static AppiumServerManager appiumServerManager;
    private static AppiumDriverLocalService service;

    private AppiumServerManager(){
        service = new AppiumServiceBuilder()
                .withAppiumJS(new File("/opt/homebrew/lib/node_modules/appium/build/lib/main.js"))
                .withIPAddress("127.0.0.1")
                .usingPort(4723)
                .withArgument(() -> "--log-level", "error")
                .withArgument(() -> "--use-plugins", "element-wait")
                .withLogFile(new File(System.getProperty("user.dir") + "/appium.log"))
                .build();
    }

    public static AppiumServerManager getInstance(){
        if(appiumServerManager == null){
            appiumServerManager = new AppiumServerManager();
        }
        return appiumServerManager;
    }

    private void killAppiumProcessIfPresent(){
        try {
            ProcessBuilder findPidsProcessBuilder = new ProcessBuilder("lsof", "-ti:4723");
            Process findPidsProcess = findPidsProcessBuilder.start();
            BufferedReader reader = new BufferedReader(new InputStreamReader(findPidsProcess.getInputStream()));
            String pid;
            while ((pid = reader.readLine()) != null) {
                ProcessBuilder killProcessBuilder = new ProcessBuilder("kill", "-9", pid);
                Process killProcess = killProcessBuilder.start();
                killProcess.waitFor();
                FrameworkLogger.info("Killed PID: " + pid);
            }
        } catch (Exception e) {
            throw new RuntimeException("Not able to read PIDs");
        }
    }

    public void startAppiumServer(){
        if(!service.isRunning()){
            killAppiumProcessIfPresent();
            service.start();
        }
    }

    public void stopAppiumServer(){
        if(service.isRunning()){
            service.stop();
        }
    }

}
