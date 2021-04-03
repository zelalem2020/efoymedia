package com.abzgroup.efoymedia.utilities;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SingleMapper {
    @Autowired
    public ModelMapper modelMapper;

    public <S, T> T mapSingle(S source, Class<T> targetClass) {
        System.out.println(source);
        return modelMapper.map(source, targetClass);

    }
}
