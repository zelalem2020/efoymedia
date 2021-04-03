package com.abzgroup.efoymedia.dal.serializers;

import com.abzgroup.efoymedia.dal.dtos.entitiyDtos.VideoDTO;
import com.abzgroup.efoymedia.utilities.DeserilizationHelper;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;


import java.io.IOException;

public class VideoDeserilizer extends StdDeserializer<VideoDTO> {

    @Autowired
    private DeserilizationHelper deserilizationHelper;

    protected VideoDeserilizer(Class<?> vc) {
        super(vc);
    }

    public VideoDeserilizer() {
        this(null);
    }

    @SneakyThrows
    @Override
    public VideoDTO deserialize(JsonParser jp, DeserializationContext ctxt) throws IOException, JsonProcessingException {
        JsonNode node = jp.getCodec().readTree(jp);
        VideoDTO videoDTO = deserilizationHelper.deserialize(node,new VideoDTO(),VideoDTO.class);
        return videoDTO;
    }
}