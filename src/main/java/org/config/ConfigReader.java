package org.config;

import org.aeonbits.owner.Config;
import org.config.convertor.PlatformTypeConvertor;
import org.config.convertor.RunModeConvertor;
import org.enums.PlatformType;
import org.enums.RunMode;

@Config.LoadPolicy(Config.LoadType.MERGE)
@Config.Sources(
        {
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
