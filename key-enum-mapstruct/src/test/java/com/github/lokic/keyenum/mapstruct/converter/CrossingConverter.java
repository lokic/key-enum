package com.github.lokic.keyenum.mapstruct.converter;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(uses = KeyEnumConverter.class)
public interface CrossingConverter {

    CrossingConverter INSTANCE = Mappers.getMapper(CrossingConverter.class);

    @Mapping(target = "light", source = "light")
    Crossing convert(CrossingDTO dto);

    @Mapping(target = "light", source = "light")
    CrossingDTO convert(Crossing crossing);
}
