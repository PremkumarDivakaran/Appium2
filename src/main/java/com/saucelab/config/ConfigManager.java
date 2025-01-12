package com.saucelab.config;

import org.aeonbits.owner.ConfigCache;

public class ConfigManager {

    private ConfigManager(){}

    public static ConfigReader getConfig(){
        return ConfigCache.getOrCreate(ConfigReader.class);
    }

}
