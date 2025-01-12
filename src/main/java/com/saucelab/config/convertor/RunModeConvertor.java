package com.saucelab.config.convertor;

import org.aeonbits.owner.Converter;
import com.saucelab.enums.RunMode;

import java.lang.reflect.Method;

public class RunModeConvertor implements Converter<RunMode> {
    @Override
    public RunMode convert(Method method, String runMode) {
        return RunMode.valueOf(runMode.toUpperCase());
    }
}
