package org.config.convertor;

import org.aeonbits.owner.Converter;
import org.enums.RunMode;

import java.lang.reflect.Method;

public class RunModeConvertor implements Converter<RunMode> {
    @Override
    public RunMode convert(Method method, String runMode) {
        return RunMode.valueOf(runMode.toUpperCase());
    }
}
