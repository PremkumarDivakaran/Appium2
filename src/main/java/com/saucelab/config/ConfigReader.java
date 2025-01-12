package com.saucelab.config;

import org.aeonbits.owner.Config;
import com.saucelab.config.convertor.PlatformTypeConvertor;
import com.saucelab.config.convertor.RunModeConvertor;
import com.saucelab.enums.PlatformType;
import com.saucelab.enums.RunMode;

@Config.LoadPolicy(Config.LoadType.MERGE)
@Config.Sources(
        {
                "system:properties",
                "file:${user.dir}/src/test/resources/config.properties"
        }
)
public interface ConfigReader extends Config {

    @Key("runmode")
    @ConverterClass(RunModeConvertor.class)
    RunMode runmode();

    @Key("platform")
    @ConverterClass(PlatformTypeConvertor.class)
    PlatformType platform();

}
