package com.saucelab.config.convertor;

import org.aeonbits.owner.Converter;
import com.saucelab.enums.PlatformType;

import java.lang.reflect.Method;

public class PlatformTypeConvertor implements Converter<PlatformType> {
    @Override
    public PlatformType convert(Method method, String platformName) {
        return PlatformType.valueOf(platformName.toUpperCase());
    }
}
